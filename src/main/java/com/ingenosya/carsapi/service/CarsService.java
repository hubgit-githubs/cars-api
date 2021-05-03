package com.ingenosya.carsapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingenosya.carsapi.model.Cars;
import com.ingenosya.carsapi.repository.CarsRepository;

import lombok.Data;

@Data
@Service
public class CarsService {
	
	@Autowired
	private CarsRepository carRepository;
	
	public Optional<Cars> getCar(final Integer id){
		return carRepository.findById(id);
	}
	
	public Iterable<Cars> getCars(){
		return carRepository.findAll();
	}
	
	public void deleteCar(final Integer id) {
		carRepository.deleteById(id);
	}
	
	public Cars saveCar(Cars car) {
		Cars savedCar = carRepository.save(car);
		return savedCar;
	}
	
}
