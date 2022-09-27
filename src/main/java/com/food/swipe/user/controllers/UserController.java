package com.food.swipe.user.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.swipe.user.dto.request.RegisterUserRequest;
import com.food.swipe.user.dto.response.RegisterUserResponse;
import com.food.swipe.user.service.UserService;

@RestController
@RequestMapping("/v1/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<RegisterUserResponse> registerNewUser(
			@Valid @RequestBody RegisterUserRequest userRequest) {
		
		
		return new ResponseEntity<>(userService.registerUser(userRequest), HttpStatus.OK);
	}
}
