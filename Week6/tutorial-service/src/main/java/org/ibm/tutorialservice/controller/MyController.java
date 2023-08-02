package org.ibm.tutorialservice.controller;

import org.ibm.tutorialservice.dao.TutorialRepository;
import org.ibm.tutorialservice.dto.UserRequest;
import org.ibm.tutorialservice.dto.UserResponse;
import org.ibm.tutorialservice.model.Tutorial;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RepositoryRestController
public class MyController {

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  ModelMapper modelMapper;

  @Autowired
  TutorialRepository repository;

  @PostMapping("/tutorials")
  public ResponseEntity<?> getUser(@RequestBody UserRequest userRequest) {

    if (userRequest.getUserId() == null || userRequest.getPassword() == null) {
      return ResponseEntity.status(400).body("userId and password are required");
    }

    UserResponse response;
    try {
      response = restTemplate.postForObject("http://localhost:8081/login", userRequest, UserResponse.class);
      Tutorial tutorial = modelMapper.map(userRequest, Tutorial.class);
      tutorial = repository.save(tutorial);
      return ResponseEntity.ok(tutorial);
    } catch (RestClientException e) {
      return ResponseEntity.badRequest().body("Bad Credentials");
    }

  }
}