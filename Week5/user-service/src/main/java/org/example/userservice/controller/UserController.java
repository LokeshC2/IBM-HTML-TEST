package org.example.userservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.example.userservice.dto.UserDto;
import org.example.userservice.entity.UserEntity;
import org.example.userservice.service.UserService;
import org.example.userservice.ui.UserRequestModel;
import org.example.userservice.ui.UserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

	private UserService userService;
	private ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<List<UserResponseModel>> getAllUsers() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<UserEntity> users = userService.listAll();
		List<UserResponseModel> responses = new ArrayList<UserResponseModel>();
		for (UserEntity user : users) {
			UserResponseModel response = modelMapper.map(user, UserResponseModel.class);
			responses.add(response);
		}
		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserResponseModel> getByUserid(@PathVariable("userId") String userId) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity user = userService.findByUserId(userId);
		UserResponseModel response = modelMapper.map(user, UserResponseModel.class);
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<UserResponseModel> create(@RequestBody UserRequestModel request) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(request, UserDto.class);
		userDto.setUserId(UUID.randomUUID().toString());
		UserEntity createdUser = userService.createUserById(userDto);
		UserResponseModel response = modelMapper.map(createdUser, UserResponseModel.class);
		return ResponseEntity.ok(response);
	}
}