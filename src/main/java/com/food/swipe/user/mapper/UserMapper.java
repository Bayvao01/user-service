package com.food.swipe.user.mapper;

import java.sql.Timestamp;
import java.time.Instant;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.food.swipe.user.dto.request.RegisterUserRequest;
import com.food.swipe.user.entities.User;

@Mapper
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User mapUserRegistrationRequest(RegisterUserRequest userRequest);
	
	@AfterMapping
	public default void setRegistrationDataAfterMapping(@MappingTarget User target) {
	     
		target.setCreatedBy(target.getEmail());
		target.setCreationTime(Timestamp.from(Instant.now()));
		target.setEnabled(true);
	 }
}
