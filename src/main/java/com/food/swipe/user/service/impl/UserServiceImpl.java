package com.food.swipe.user.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public RegisterUserResponse registerUser(RegisterUserRequest userRequest) {
		
		Optional<User> userExists = userRepository.findByEmail(userRequest.getEmail());
		
		if(userExists.isPresent()) {
			throw new RuntimeException("User Already exists with given email");
		}
		
		User user = UserMapper.INSTANCE.mapUserRegistrationRequest(userRequest);
		
		userRepository.save(user);
		
		RegisterUserResponse userResponse = new RegisterUserResponse();
		userResponse.setMessage("SUCCESS");
		userResponse.setStatus("SUCCESS");
		userResponse.setEmail(userRequest.getEmail());
		
		return userResponse;
	}

}
