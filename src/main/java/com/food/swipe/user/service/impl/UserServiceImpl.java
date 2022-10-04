package com.food.swipe.user.service.impl;

import java.util.Optional;


import com.core.libraries.exceptionhandler.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.food.swipe.user.constants.CommonConstants;
import com.food.swipe.user.dto.request.RegisterUserRequest;
import com.food.swipe.user.dto.response.RegisterUserResponse;
import com.food.swipe.user.entities.User;
import com.food.swipe.user.mapper.UserMapper;
import com.food.swipe.user.repository.UserRepository;
import com.food.swipe.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder bcryptPasswordEncoder;

	@Override
	public RegisterUserResponse registerUser(RegisterUserRequest userRequest) {
		
		Optional<User> userExists = userRepository.findByEmail(userRequest.getEmail());
		
		if(userExists.isPresent()) {
			throw new CustomException(1000, "User already exists");
		}
		
		User user = UserMapper.INSTANCE.mapUserRegistrationRequest(userRequest);
		String encodedPassword = bcryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepository.save(user);
		
		RegisterUserResponse userResponse = new RegisterUserResponse();
		userResponse.setMessage(CommonConstants.SUCCESS);
		userResponse.setStatus(CommonConstants.SUCCESS);
		userResponse.setEmail(userRequest.getEmail());
		
		return userResponse;
	}

}
