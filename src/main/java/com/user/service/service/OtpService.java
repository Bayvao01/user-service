package com.user.service.service;

import com.user.service.dto.request.OtpRequest;
import com.user.service.dto.response.OtpResponse;

public interface OtpService {

	public OtpResponse sendOtp(OtpRequest otpRequest);
	public OtpResponse verifyOtp(OtpRequest otpRequest);
}
