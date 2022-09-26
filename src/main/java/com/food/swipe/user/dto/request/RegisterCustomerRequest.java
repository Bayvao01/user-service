package com.food.swipe.user.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.food.swipe.user.constants.ValidationConstants;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterCustomerRequest {

	@NotBlank(message = ValidationConstants.FIRST_NAME_SHOULD_BE_PRESENT)
	private String firstName;
	
	@NotBlank(message = ValidationConstants.LAST_NAME_SHOULD_BE_PRESENT)
	private String lastName;
	
	@Email(regexp = ValidationConstants.EMAIL_REGEX, 
			message = ValidationConstants.EMAIL_SHOULD_BE_VALID)
	@NotBlank(message = ValidationConstants.EMAIL_SHOULD_BE_PRESENT)
	private String email;
	
	
	@NotNull(message = ValidationConstants.PHONE_NUMBER_SHOULD_BE_PRESENT)
	private long phoneNumber;
	
	@NotBlank(message = ValidationConstants.PASSWORD_SHOULD_BE_PRESENT)
	@Size(min = 8, max = 16, message = ValidationConstants.PASSWORD_LENGTH_VALIDATION)
	private String password;
	
}
