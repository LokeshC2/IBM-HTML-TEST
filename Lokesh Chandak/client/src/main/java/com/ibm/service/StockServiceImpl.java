package com.ibm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.dao.StockDao;
import com.ibm.model.Stock;

@Component
public class StockServiceImpl implements StockService {

  @Autowired
  StockDao stockDao;

  @Override
  public List<Stock> listAllStocks() {
    return stockDao.listAllStocks();
  }

  @Override
  public List<String> listAllStockNames() {
    List<Stock> stocks = stockDao.listAllStocks();
    List<String> stockNames = new ArrayList<String>();
    for (Stock stock : stocks) {
      stockNames.add(stock.getSymbol());
    }
    return stockNames;
  }

  @Override
  public Double getPrice(String symbol) {
    Stock stock = stockDao.getStock(symbol);
    return stock.getPrice();
  }

  @Override
  public Stock getStock(String symbol) {
    return stockDao.getStock(symbol);
  }

  @Override
  public void createStock(String string, double d) {
    stockDao.createStock(string, string, d);
  }

}
