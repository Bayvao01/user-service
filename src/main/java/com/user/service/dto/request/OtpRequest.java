package com.user.service.dto.request;

import com.user.service.enums.OtpType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OtpRequest {

	private OtpType type;
	private String phoneNumber;
	private String email;
	private int otp;
}
