package org.ibm.conversionservice.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "conversionRequests")
@Data
public class ConversionRequest {
  @Id
  private String id;
  private String from;
  private String to;
  private double quantity;
  private Date date;
}
