package org.ibm.conversionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConversionModelDto {
  private String from;
  private String to;
  private double conversionMultiple;
  private double quantity;
  private double totalAmount;
}
