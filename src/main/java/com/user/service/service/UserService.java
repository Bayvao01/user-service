package com.user.service.service;

import com.user.service.dto.request.LoginRequest;
import com.user.service.dto.request.RegisterUserRequest;
import com.user.service.dto.response.RegisterUserResponse;
import org.springframework.http.HttpHeaders;

public interface UserService {

	RegisterUserResponse registerUser(RegisterUserRequest customerRequest);

	HttpHeaders loginUser(LoginRequest loginRequest);

}
