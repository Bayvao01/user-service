package com.food.swipe.user.validator;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.food.swipe.user.dto.request.RegisterUserRequest;

public class RegisterCustomerValidator
		implements ConstraintValidator<CustomerValidatorConstraint, RegisterUserRequest> {

	@Override
	public boolean isValid(RegisterUserRequest request, ConstraintValidatorContext context) {
		boolean isValid = true;

		if (Objects.isNull(request)) {
			isValid = false;
			addConstraintViolation("customer", "Customer Request cannot be empty", context);
		}
		
		return false;
	}

	private void addConstraintViolation(String propertyName, String message, ConstraintValidatorContext context) {

		context.buildConstraintViolationWithTemplate(message).addPropertyNode(propertyName).addConstraintViolation()
				.disableDefaultConstraintViolation();
	}

}
