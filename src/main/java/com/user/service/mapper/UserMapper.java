package com.user.service.mapper;

import com.user.service.entities.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.user.service.dto.request.RegisterUserRequest;

@Mapper
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User mapUserRegistrationRequest(RegisterUserRequest userRequest);
	
	@AfterMapping
	public default void setRegistrationDataAfterMapping(@MappingTarget User target) {
	     
		target.setCreatedBy(target.getEmail());
		target.setEnabled(true);
	 }
}
