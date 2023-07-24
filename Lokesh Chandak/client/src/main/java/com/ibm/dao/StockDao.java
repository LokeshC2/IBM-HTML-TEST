package com.ibm.dao;

import java.util.List;

import com.ibm.model.Stock;

public interface StockDao {

  List<Stock> listAllStocks();

  Stock getStock(String symbol);

  void createStock(String string, String string2, double d);
}
