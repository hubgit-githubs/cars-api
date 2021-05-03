package com.ingenosya.carsapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ingenosya.carsapi.model.Users;
import com.ingenosya.carsapi.repository.UsersRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersRepository.findByName(username);
		if(user == null)
			throw new UsernameNotFoundException("User 404");
		return new ImplUserDetails(user);
	}

}
