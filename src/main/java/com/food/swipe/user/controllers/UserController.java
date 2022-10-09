package com.food.swipe.user.controllers;

import javax.validation.Valid;

import com.core.libraries.logging.annotation.LogControllerEntryExit;
import com.food.swipe.user.dto.request.LoginRequest;
import com.food.swipe.user.dto.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import com.food.swipe.user.dto.request.RegisterUserRequest;
import com.food.swipe.user.dto.response.RegisterUserResponse;
import com.food.swipe.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static com.food.swipe.user.constants.CommonConstants.SUCCESS;

@Slf4j
@RestController
@RequestMapping("/v1/users")
public class UserController {
	@Autowired
	private UserService userService;

	@LogControllerEntryExit
	@PostMapping("/register")
	public ResponseEntity<RegisterUserResponse> registerNewUser(
			@Valid @RequestBody RegisterUserRequest userRequest) {

		userRequest.setRoles(Arrays.asList("Customer"));
		return new ResponseEntity<>(userService.registerUser(userRequest), HttpStatus.OK);
	}

	@LogControllerEntryExit
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest){

		HttpHeaders headers = userService.loginUser(loginRequest);
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setLoginStatus(SUCCESS);

		return new ResponseEntity<>(loginResponse, headers, HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('Customer')")
	@PostMapping
	public String getUsers(@RequestBody LoginRequest loginRequest){
		return "Success";
	}
}
