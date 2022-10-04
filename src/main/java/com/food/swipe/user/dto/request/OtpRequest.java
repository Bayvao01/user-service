package com.food.swipe.user.dto.request;

import com.food.swipe.user.enums.OtpType;

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
