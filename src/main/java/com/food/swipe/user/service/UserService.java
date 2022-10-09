package com.food.swipe.user.service;

import com.food.swipe.user.dto.request.LoginRequest;
import com.food.swipe.user.dto.request.RegisterUserRequest;
import com.food.swipe.user.dto.response.RegisterUserResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

	RegisterUserResponse registerUser(RegisterUserRequest customerRequest);

	HttpHeaders loginUser(LoginRequest loginRequest);

}
