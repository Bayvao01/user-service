package com.food.swipe.user.controllers;

import javax.validation.Valid;

import com.core.libraries.logging.annotation.LogControllerEntryExit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.swipe.user.dto.request.RegisterUserRequest;
import com.food.swipe.user.dto.response.RegisterUserResponse;
import com.food.swipe.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/users")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

	@LogControllerEntryExit
	@PostMapping("/register")
	public ResponseEntity<RegisterUserResponse> registerNewUser(
			@Valid @RequestBody RegisterUserRequest userRequest) {

		return new ResponseEntity<>(userService.registerUser(userRequest), HttpStatus.OK);
	}
}
