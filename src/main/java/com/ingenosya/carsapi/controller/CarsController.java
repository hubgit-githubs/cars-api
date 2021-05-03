package com.ingenosya.carsapi.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ingenosya.carsapi.model.Cars;
import com.ingenosya.carsapi.service.CarsService;

@RestController
public class CarsController {
	
	@Autowired
	private CarsService carService;
	
	@GetMapping("/cars")
	public Iterable<Cars> getCars(){
		return carService.getCars();
	}
	
	@GetMapping("/car/{id}")
	public Optional<Cars> getCar(@PathVariable final Integer id){
		return carService.getCar(id);
		
	}
	@PostMapping("/car")
	public Cars saveCar(@RequestBody Cars car) {
		return carService.saveCar(car);
	}
	
	@PutMapping("/car/{id}")
	public Cars updateCar(@PathVariable("id") Integer id, @RequestBody Cars car){
		Optional<Cars> c = carService.getCar(id);
		if(c.isPresent()) {
			Cars currentCar = c.get();
			
			String name = car.getName();
			if(name != null) 
				currentCar.setName(name);

			String description = car.getDescription();
			if(description != null)
				currentCar.setDescription(description);
			
			Date creationDate = car.getCreationDate();
			if (creationDate != null)
				currentCar.setCreationDate(creationDate);
			
			Date updateDate = car.getUpdateDate();
			if (updateDate != null)
				currentCar.setUpdateDate(updateDate);
			
			carService.saveCar(currentCar);
			
			return currentCar;
		}else
			return null;
		
	}
	
	@DeleteMapping("/car/{id}")
	public void deleteCar(@PathVariable Integer id) {
		carService.deleteCar(id);
	}

}
