package com.food.swipe.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.swipe.user.dto.request.OtpRequest;
import com.food.swipe.user.dto.response.OtpResponse;
import com.food.swipe.user.service.OtpService;

@RestController
@RequestMapping("/v1/otp")
public class OtpController {
	
	@Autowired
	private OtpService otpService;
	
	@PostMapping("/send")
	public ResponseEntity<OtpResponse> sendOtp(@RequestBody OtpRequest otpRequest){
		
		
		return new ResponseEntity<>(otpService.sendOtp(otpRequest), HttpStatus.OK);
	}
	
	@PostMapping("/verify")
	public ResponseEntity<OtpResponse> verifyOtp(@RequestBody OtpRequest otpRequest){
		
		return new ResponseEntity<>(otpService.verifyOtp(otpRequest), HttpStatus.OK);
	}
	

}
