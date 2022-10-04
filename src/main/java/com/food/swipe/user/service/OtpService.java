package com.food.swipe.user.service;

import com.food.swipe.user.dto.request.OtpRequest;
import com.food.swipe.user.dto.response.OtpResponse;

public interface OtpService {

	public OtpResponse sendOtp(OtpRequest otpRequest);
	public OtpResponse verifyOtp(OtpRequest otpRequest);
}
