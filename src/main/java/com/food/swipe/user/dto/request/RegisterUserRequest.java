package com.food.swipe.user.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.food.swipe.user.constants.ValidationConstants;
import java.util.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class RegisterUserRequest {

	@NotBlank(message = ValidationConstants.FIRST_NAME_SHOULD_BE_PRESENT)
	private String firstName;
	
	@NotBlank(message = ValidationConstants.LAST_NAME_SHOULD_BE_PRESENT)
	private String lastName;
	
	@Email(regexp = ValidationConstants.EMAIL_REGEX, 
			message = ValidationConstants.EMAIL_SHOULD_BE_VALID)
	@NotBlank(message = ValidationConstants.EMAIL_SHOULD_BE_PRESENT)
	private String email;
	
	
	@NotBlank(message = ValidationConstants.PHONE_NUMBER_SHOULD_BE_PRESENT)
	private String contactNumber;
	
	@NotBlank(message = ValidationConstants.PASSWORD_SHOULD_BE_PRESENT)
	@Size(min = 8, max = 16, message = ValidationConstants.PASSWORD_LENGTH_VALIDATION)
	private String password;

	private List<String> roles;
	
}
