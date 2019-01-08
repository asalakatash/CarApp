package com.example.CarApp;

import java.util.HashSet;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.CarApp.domain.Car;
import com.example.CarApp.domain.CarRepository;
import com.example.CarApp.domain.Owner;
import com.example.CarApp.domain.OwnerRepository;
import com.example.CarApp.domain.Trip;
import com.example.CarApp.domain.TripRepository;

      @SpringBootApplication
      public class CarAppApplication {
    	  @Autowired 
          private OwnerRepository orepository;
    	  
        @Autowired 
        private CarRepository repository;
        
        @Autowired 
        private TripRepository trepository;

        

        public static void main(String[] args) {
          SpringApplication.run(CarAppApplication.class, args);
        }

        @Bean
        CommandLineRunner runner(){
          return args -> {
            // Save demo data to database
        	  // Add owner objects and save these to db.
            Owner owner1 = new Owner("John" , "Johnson");
            Owner owner2 = new Owner("Mary" , "Robinson");
            orepository.save(owner1);
            orepository.save(owner2);
            
            // Add car object with link to owners and save these to db.
            Car car1 = new Car("Ford", "Mustang", "Red","ADF-1121", 2017, 59000, owner1);
            repository.save(car1);
           Car car2 = new Car("Nissan", "Leaf", "White","SSJ-3002", 2014, 29000, owner2);
            repository.save(car2);
           Car car3 = new Car("Toyota", "Prius", "Silver","KKO-0212", 2018, 39000, owner2);
            repository.save(car3);
             Set<Car> cars = new HashSet<Car>(0); 
            cars.add(car1);
            cars.add(car2);
            cars.add(car3);
            
            Trip trip1=new Trip("London",cars);
            
            trepository.save(trip1);
          };
        } 
      }
