package org.ibm.rateservice.service;

import java.util.List;

import org.ibm.rateservice.model.RateModel;

public interface RateService {

  List<RateModel> getRates();

  RateModel getRate(String from, String to);

  RateModel save(String string, String string2, double d);

  List<String> getCurrencies();

}
