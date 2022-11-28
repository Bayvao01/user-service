package com.user.service.service.impl;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import com.user.service.constants.CommonConstants;
import org.springframework.stereotype.Service;

import com.user.service.dto.request.OtpRequest;
import com.user.service.dto.response.OtpResponse;
import com.user.service.service.OtpService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class OtpServiceImpl implements OtpService{
	
	Map<Integer, String> otpMap = new HashMap<>();

	@Override
	public OtpResponse sendOtp(OtpRequest otpRequest) {
		
		SecureRandom random = new SecureRandom();
		int otp = random.nextInt(1000000);
		otpMap.put(otp, null);
		
		log.info("otp == " + otp);
		
		OtpResponse otpResponse = new OtpResponse();
		otpResponse.setMessage(CommonConstants.SUCCESS);
		otpResponse.setStatus(CommonConstants.SUCCESS);
		return otpResponse;
	}

	@Override
	public OtpResponse verifyOtp(OtpRequest otpRequest) {
		OtpResponse otpResponse = new OtpResponse();
		
		int otp = otpRequest.getOtp();
		
		if(otpMap.containsKey(otp)) {
			otpResponse.setMessage(CommonConstants.SUCCESS);
			otpResponse.setStatus(CommonConstants.VERIFIED);
			
			return otpResponse;
		}
		otpResponse.setMessage(CommonConstants.FAILURE);
		otpResponse.setStatus(CommonConstants.NOT_VERIFIED);
		return otpResponse;
	}

}
