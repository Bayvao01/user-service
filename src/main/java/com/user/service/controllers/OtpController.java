package com.user.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.dto.request.OtpRequest;
import com.user.service.dto.response.OtpResponse;
import com.user.service.service.OtpService;

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
