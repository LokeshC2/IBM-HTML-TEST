package org.example.userservice.service;

import java.util.List;

import org.example.userservice.dto.UserDto;
import org.example.userservice.model.UserEntity;

public interface UserService {

	UserEntity findByUserId(String userId);

  List<UserEntity> listUsers();

  UserEntity createUser(UserDto userDto);

}
