package org.ibm.employeeservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "location-service")
public interface LocationClient {
  
  @GetMapping("/locations")
  List<String> getLocations();
}
