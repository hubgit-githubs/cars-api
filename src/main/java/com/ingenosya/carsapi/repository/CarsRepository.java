package com.ingenosya.carsapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ingenosya.carsapi.model.Cars;

@Repository
public interface CarsRepository extends CrudRepository <Cars, Integer>{

}
