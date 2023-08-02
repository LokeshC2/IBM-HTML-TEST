package org.example.userservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.example.userservice.dto.UserDto;
import org.example.userservice.exception.InvalidCredentialsExcetion;
import org.example.userservice.exception.UserNotFoundException;
import org.example.userservice.model.UserEntity;
import org.example.userservice.service.UserService;
import org.example.userservice.ui.UserRequestModel;
import org.example.userservice.ui.UserResponseModel;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

	private final ModelMapper modelMapper;

	private final UserService userService;

	private Environment environment;

	@GetMapping("/status")
	public ResponseEntity<?> getStatus()
	{
		return ResponseEntity.ok("service is runing on port: "+environment.getProperty("local.server.port"));
	}

	@PostMapping
	public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel userRequestModel) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(userRequestModel, UserDto.class);
		userDto.setUserId(UUID.randomUUID().toString());
		UserEntity userEntity = userService.createUser(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(userEntity, UserResponseModel.class));
	}

	@GetMapping
	public ResponseEntity<List<UserResponseModel>> listAllUsers() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<UserEntity> list = userService.listUsers();
		List<UserResponseModel> userResponseModels = new ArrayList<UserResponseModel>();
		for (UserEntity u : list) {
			userResponseModels.add(modelMapper.map(u, UserResponseModel.class));
		}
		return ResponseEntity.status(HttpStatus.OK).body(userResponseModels);
	}

	// userId:
	// password:

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserRequestModel userRequestModel)
			throws UserNotFoundException, InvalidCredentialsExcetion {
		UserEntity userEntity = userService.findByUserId(userRequestModel.getUserId());
		if (userEntity == null) {
			throw new InvalidCredentialsExcetion("User not found with userId: " + userRequestModel.getUserId());
		}
		if (!userEntity.getPassword().equals(userRequestModel.getPassword())) {
			throw new InvalidCredentialsExcetion("Password not matched with userId: " + userRequestModel.getUserId());
		}
		return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(userEntity, UserResponseModel.class));
	}

}