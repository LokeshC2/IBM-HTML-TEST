package org.ibm.rateservice.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "rates")
public class RateModel {

  @Id
  private String id;

  private String from;
  private String to;
  private double conversionMultiple;
  private Date date;

  public RateModel(String from, String to, double conversionMultiple, Date date) {
    this.from = from;
    this.to = to;
    this.conversionMultiple = conversionMultiple;
    this.date = date;
  }

}
