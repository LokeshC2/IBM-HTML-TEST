package org.example.userservice.service;

import java.util.List;

import org.example.userservice.dto.UserDto;
import org.example.userservice.entity.UserEntity;

public interface UserService {

	List<UserEntity> listAll();

	UserEntity findByUserId(String userId);
	
	UserEntity createUserId(UserDto userDto);

}
