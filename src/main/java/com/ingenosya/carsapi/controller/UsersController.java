package com.ingenosya.carsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ingenosya.carsapi.service.UserService;

@RestController
public class UsersController {
	
	@Autowired
	private UserService userService;	
	
	@GetMapping("/userCarLogin")
	public UserDetails findLogin(String username) throws UsernameNotFoundException {
		UserDetails userDetails = userService.loadUserByUsername(username);
		
		return userDetails;
	}
}
