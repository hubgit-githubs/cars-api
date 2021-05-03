package com.ingenosya.carsapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.ingenosya.carsapi.model.Users;

public interface UsersRepository extends CrudRepository <Users, Integer> {
	public Users findByName(String name);

}
