package com.example.CarApp.domain;

import org.springframework.data.repository.CrudRepository;

import com.example.CarApp.domain.Car;

public interface CarRepository extends CrudRepository <Car, Long> {

}
