package com.food.swipe.user.dto.request;

import com.food.swipe.user.constants.ValidationConstants;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class LoginRequest {

    @Email(regexp = ValidationConstants.EMAIL_REGEX,
            message = ValidationConstants.EMAIL_SHOULD_BE_VALID)
    @NotBlank(message = ValidationConstants.EMAIL_SHOULD_BE_PRESENT)
    private String email;

    @NotBlank(message = ValidationConstants.PASSWORD_SHOULD_BE_PRESENT)
    @Size(min = 8, max = 16, message = ValidationConstants.PASSWORD_LENGTH_VALIDATION)
    private String password;
}
