package com.example.service;

public interface CarService {

  int createCar(String model, String color);

  void listCars();

  void findCarById(int id);

  void updateCar(int id, String model, String color);

  void deleteCar(int id);

}