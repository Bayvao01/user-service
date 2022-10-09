package com.food.swipe.user.dto.request;

import com.food.swipe.user.dto.response.RegisterUserResponse;

public class UserRequest {

	public static RegisterUserRequest regiseRequest() {
		RegisterUserRequest userRequest = new RegisterUserRequest();
		userRequest.setEmail("johndoe@gmail.com");
		userRequest.setContactNumber("8759207596");
		userRequest.setFirstName("John");
		userRequest.setLastName("Doe");
		userRequest.setPassword("Welcome");
	
		return userRequest;
	}
	
	public static RegisterUserResponse userRegisterResponse() {
		RegisterUserResponse userResponse = new RegisterUserResponse();
		userResponse.setEmail("johndoe@gmail.com");
		userResponse.setStatus("Success");
		userResponse.setMessage("Success");
		
		return userResponse;
	}
}
