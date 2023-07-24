package com.ibm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.model.Stock;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Component
public class StockDaoImpl implements StockDao{

  @Autowired
  SessionFactory sessionFactory;

  @Override
  public List<Stock> listAllStocks() {
    Session session = sessionFactory.openSession();
    List<Stock> stocks = session.createQuery("from Stock", Stock.class).list();
    session.close();
    return stocks;
  }

  @Override
  public Stock getStock(String symbol) {
    Session session = sessionFactory.openSession();
    Stock stock = session.get(Stock.class, symbol);
    session.close();
    return stock;
  }

  @Override
  public void createStock(String string, String string2, double d) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    Stock stock = new Stock(string, string2, d);
    session.save(stock);
    session.getTransaction().commit();
    session.close();
  }


  
}
