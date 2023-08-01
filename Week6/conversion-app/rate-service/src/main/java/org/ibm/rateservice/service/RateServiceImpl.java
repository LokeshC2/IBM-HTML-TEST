package org.ibm.rateservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ibm.rateservice.model.RateModel;
import org.ibm.rateservice.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateServiceImpl implements RateService {

  @Autowired
  private RateRepository rateRepository;

  @Override
  public List<RateModel> getRates() {
    return rateRepository.findAll();
  }

  @Override
  public RateModel getRate(String from, String to) {
    RateModel rateModel = rateRepository.findByFromAndTo(from, to);
    if (rateModel != null) {
      return rateModel;
    }

    // Check if the reverse rate exists
    rateModel = rateRepository.findByFromAndTo(to, from);
    if (rateModel != null) {
      Double reverseRate = 1 / rateModel.getConversionMultiple();
      return new RateModel(from, to, reverseRate, rateModel.getDate());
    }
    
    return null;
  }

  @Override
  public RateModel save(String from, String to, double rate) {
    RateModel rateModel = rateRepository.findByFromAndTo(from, to);
    if (rateModel == null) {
      rateModel = new RateModel(from, to, rate, new Date());
    } else {
      rateModel.setConversionMultiple(rate);
    }
    return rateRepository.save(rateModel);
  }

  @Override
  public List<String> getCurrencies() {
    List<RateModel> rates = rateRepository.findAll();
    List<String> currencies = new ArrayList<String>();
    for (RateModel rate : rates) {
      currencies.add(rate.getFrom() + " -> " + rate.getTo());
    }
    return currencies;
  }
  
}
