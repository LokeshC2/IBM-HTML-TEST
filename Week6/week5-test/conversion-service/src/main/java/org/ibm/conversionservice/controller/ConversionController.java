package org.ibm.conversionservice.controller;

import java.util.List;

import org.ibm.conversionservice.service.ConversionService;
import org.ibm.conversionservice.ui.ConversionRequestModel;
import org.ibm.conversionservice.ui.ConversionResponseModel;
import org.ibm.conversionservice.ui.ExceptionResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConversionController {

  @Autowired
  private ConversionService conversionService;

  @GetMapping("/status")
  @ResponseBody
  public ResponseEntity<String> status() {
    return ResponseEntity.ok("Service is up and running");
  }

  @GetMapping
  public String getConversion(Model model) {
    List<String> currencies = conversionService.getSupportedCurrencies();

    model.addAttribute("conversion", new ConversionRequestModel());
    model.addAttribute("currencies", currencies);
    model.addAttribute("result", null);
    return "index";
  }

  @PostMapping("/convert")
  public String postConversion(ConversionRequestModel conversion, Model model) {

    conversionService.saveConversion(conversion);

    ConversionResponseModel response = conversionService.getConversion(conversion);
    
    model.addAttribute("result", response);
    return "result";
  }

  @ExceptionHandler(Exception.class)
  public String handleException(RuntimeException ex, Model model) {
    ExceptionResponseModel response = new ExceptionResponseModel(ex.getMessage(), "Please try again later");
    model.addAttribute("result", response);
    return "errorPage";
  }

}
