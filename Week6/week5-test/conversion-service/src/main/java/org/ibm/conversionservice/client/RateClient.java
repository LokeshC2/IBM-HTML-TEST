package org.ibm.conversionservice.client;

import java.util.List;

import org.ibm.conversionservice.dto.ConversionModelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "rate-service")
public interface RateClient {
  @GetMapping("/currencies")
  List<String> getCurrencies();

  @GetMapping("/{from}/{to}")
  ConversionModelDto getRate(@PathVariable("from") String from, @PathVariable("to") String to);
}
