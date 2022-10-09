package com.food.swipe.user.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


import com.core.libraries.exceptionhandler.CustomException;
import com.core.libraries.logging.annotation.LogEntryExit;
import com.core.libraries.security.util.EncryptionUtil;
import com.core.libraries.security.util.JwtTokenUtil;
import com.food.swipe.user.dto.request.LoginRequest;
import com.food.swipe.user.entities.Role;
import com.food.swipe.user.entities.UserPermissionTable;
import com.food.swipe.user.repository.UserPermissionRepository;
import com.food.swipe.user.repository.UserRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.food.swipe.user.constants.CommonConstants;
import com.food.swipe.user.dto.request.RegisterUserRequest;
import com.food.swipe.user.dto.response.RegisterUserResponse;
import com.food.swipe.user.entities.User;
import com.food.swipe.user.mapper.UserMapper;
import com.food.swipe.user.repository.UserRepository;
import com.food.swipe.user.service.UserService;

import javax.transaction.Transactional;

@Slf4j
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder bcryptPasswordEncoder;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private UserPermissionRepository userPermissionRepository;

	@LogEntryExit
	@Transactional
	@Override
	public RegisterUserResponse registerUser(RegisterUserRequest userRequest) {

		if(existingUser(userRequest.getEmail())) {
			throw new CustomException(1000, "User already exists");
		}

		List<UserPermissionTable> userPermissions = new ArrayList<>();
		
		User user = UserMapper.INSTANCE.mapUserRegistrationRequest(userRequest);
		String encodedPassword = bcryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);


		User savedUser = userRepository.save(user);

		userRequest.getRoles().forEach(role -> {

			Optional<Role> roleOptional = userRoleRepository.findByRoleName(role);

			if (roleOptional.isPresent()) {
			  	Role userRole = roleOptional.get();
				UserPermissionTable userPermission = new UserPermissionTable();
				userPermission.setUserId(savedUser.getUserId());
				userPermission.setEnabled(true);
				userPermission.setRoleId(userRole.getRoleId());
				userPermissions.add(userPermission);
			} else {
				log.info("Role not found in table :: " + role + " while registering user " + userRequest.getEmail());
				throw new CustomException(1002, "Incorrect role assigned");
			}
		});

		userPermissionRepository.saveAll(userPermissions);

		RegisterUserResponse userResponse = new RegisterUserResponse();
		userResponse.setMessage(CommonConstants.SUCCESS);
		userResponse.setStatus(CommonConstants.SUCCESS);
		userResponse.setEmail(userRequest.getEmail());
		
		return userResponse;
	}

	@Override
	@Transactional
	public HttpHeaders loginUser(LoginRequest loginRequest) {

		HttpHeaders headers = new HttpHeaders();
		UserDetails userDetails = this.loadUserByUsername(loginRequest.getEmail());
		if(bcryptPasswordEncoder.matches(loginRequest.getPassword(), userDetails.getPassword())) {

			String jwtToken = jwtTokenUtil.generateToken(userDetails);
			String encryptedToken = EncryptionUtil.encrypt(jwtToken);
			headers.add("Authorization", encryptedToken);

			return headers;
		} else {
			throw new CustomException(1001, "Email/Password is incorrect.");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		log.debug("---loadUserByUsername called.---");
		Optional<User> appUser = userRepository.findByEmail(username);
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		if(appUser.isPresent()){
			User user = appUser.get();
			if(user.getEmail().equals(username)){
				List<UserPermissionTable> userPermissions = userPermissionRepository.findAllByUserId(user.getUserId());

				userPermissions.stream().forEach(permission -> {
				 	Optional<Role> roleOptional = userRoleRepository.findById(permission.getRoleId());
					 if (roleOptional.isPresent()) {
						 Role role = roleOptional.get();
						 authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
					 }
				});

				user.setLastLoginTime(Timestamp.from(Instant.now()));
				userRepository.save(user);

				return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
						user.isEnabled(),true,true, false, authorities);

			} else {
				throw new CustomException(1001, "Email/Password is incorrect.");
			}
		} else {
			throw new CustomException(1001, "Email/Password is incorrect.");
		}

	}

	public boolean existingUser(String email) {
		return userRepository.existsByEmail(email);
	}

}
