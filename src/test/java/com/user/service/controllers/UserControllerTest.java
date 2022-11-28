package com.user.service.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.user.service.dto.request.RegisterUserRequest;
import com.user.service.dto.request.UserRequest;
import com.user.service.dto.response.RegisterUserResponse;
import com.user.service.service.UserService;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
class UserControllerTest {
	
	@Mock
	private UserService userService;
	
	@InjectMocks
	private UserController userController = new UserController();
	

	@Test
	void registerNewUser_Success() {
		
		RegisterUserRequest registerRequest = UserRequest.regiseRequest();
		RegisterUserResponse expectedResponse = UserRequest.userRegisterResponse();
		
		when(userService.registerUser(any(RegisterUserRequest.class))).thenReturn(expectedResponse);
		
		ResponseEntity<RegisterUserResponse> actualResponse = userController.registerNewUser(registerRequest);
		
		assertEquals(expectedResponse.getStatus(), actualResponse.getBody().getStatus());
	}

}
