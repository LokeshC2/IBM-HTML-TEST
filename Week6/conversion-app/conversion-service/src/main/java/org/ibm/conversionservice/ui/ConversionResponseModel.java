package org.ibm.conversionservice.ui;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConversionResponseModel {
  private String from;
  private String to;
  private double quantity;
  private double rate;
  private double totalAmount;
}