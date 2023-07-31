package com.example.locationservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.locationservice.model.Location;

@RestController
public class LocationController {
  
  @GetMapping("/locations")
  public List<String> getLocations() {
    return List.of(Location.values()).stream().map(location -> location.name()).collect(Collectors.toList());
  }
}
