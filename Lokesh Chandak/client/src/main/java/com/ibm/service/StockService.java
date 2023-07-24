package com.ibm.service;

import java.util.List;

import com.ibm.model.Stock;

public interface StockService {

  List<Stock> listAllStocks();

  List<String> listAllStockNames();

  Double getPrice(String symbol);

  Stock getStock(String symbol);

  void createStock(String string, double d);

}
