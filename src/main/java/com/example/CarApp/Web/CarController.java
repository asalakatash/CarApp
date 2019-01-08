package com.example.CarApp.Web;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.CarApp.domain.Car;
import com.example.CarApp.domain.CarRepository;


@RestController
public class CarController {
	 @Autowired
     private CarRepository repository;

	@RequestMapping("/cars")
	public Iterable<Car> getCars(){
		 return repository.findAll();
	}

}
