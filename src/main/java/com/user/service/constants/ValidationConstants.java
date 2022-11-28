package com.user.service.constants;

public class ValidationConstants {

	public static final String FIRST_NAME_SHOULD_BE_PRESENT = "First name cannot be empty";
	public static final String LAST_NAME_SHOULD_BE_PRESENT = "Last name cannot be empty";
	public static final String EMAIL_SHOULD_BE_PRESENT = "Email cannot be empty";
	public static final String EMAIL_SHOULD_BE_VALID = "Enter a valid email";
	public static final String PHONE_NUMBER_SHOULD_BE_PRESENT = "Phone Number cannot be empty";
	public static final String PHONE_NUMBER_SHOULD_BE_VALID = "Enter a valid phone number";
	public static final String PASSWORD_SHOULD_BE_PRESENT = "Password cannot be empty";
	public static final String PASSWORD_LENGTH_VALIDATION = "Password length should be minimum 8 and maximum 16 characters";
	public static final String EMAIL_REGEX = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
}
