package com.food.swipe.user.service;

import com.food.swipe.user.dto.request.RegisterUserRequest;
import com.food.swipe.user.dto.response.RegisterUserResponse;

public interface UserService {

	RegisterUserResponse registerUser(RegisterUserRequest customerRequest);
}
