package org.ibm.rateservice.controller;

import java.util.List;

import org.ibm.rateservice.model.RateModel;
import org.ibm.rateservice.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateController {

  @Autowired
  private RateService rateService;

  @Autowired
  private Environment environment;

  @GetMapping("/status")
  public ResponseEntity<String> status() {
    return ResponseEntity.ok("Service is up and running at port " + environment.getProperty("local.server.port"));
  }

  @GetMapping
  public ResponseEntity<List<RateModel>> getRates() {
    return ResponseEntity.ok(rateService.getRates());
  }

  @GetMapping("/currencies")
  public ResponseEntity<List<String>> getCurrencies() {
    return ResponseEntity.ok(rateService.getCurrencies());
  }

  @GetMapping("/{from}/{to}")
  public ResponseEntity<RateModel> getRate(
      @PathVariable("from") String from,
      @PathVariable("to") String to) {
    return ResponseEntity.ok(rateService.getRate(from, to));
  }
}
