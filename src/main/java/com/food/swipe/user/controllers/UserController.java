package com.food.swipe.user.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.swipe.user.dto.request.RegisterCustomerRequest;

@RestController
@RequestMapping("/v1/users")
public class UserController {

	@PostMapping("/register")
	public ResponseEntity<String> registerNewUser(
			@Valid @RequestBody RegisterCustomerRequest customerRequest) {
		
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
}
