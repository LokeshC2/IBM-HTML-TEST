package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.Car;

@Component("carDao")
public class CarDaoImpl implements CarDao {

  private SessionFactory sessionFactory;

  @Autowired
  public CarDaoImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public Car createCar(String model, String color) {
    Car car = new Car();
    car.setModel(model);
    car.setColor(color);
    return car;
  }

  @Override
  public void saveCar(Car car) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.save(car);
    session.getTransaction().commit();
    session.close();
  }

  @Override
  public List<Car> listCars() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<Car> cars = session.createQuery("from Car", Car.class).list();
    session.getTransaction().commit();
    session.close();
    return cars;
  }

  @Override
  public Car getCarById(int id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    Car car = session.get(Car.class, id);
    session.getTransaction().commit();
    session.close();
    return car;
  }

  @Override
  public void updateCar(Car car) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.update(car);
    session.getTransaction().commit();
    session.close();
  }

  @Override
  public void deleteCar(Car car) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.delete(car);
    session.getTransaction().commit();
    session.close();
  }
}
