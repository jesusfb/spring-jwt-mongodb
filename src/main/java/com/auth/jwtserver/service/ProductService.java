package com.auth.jwtserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth.jwtserver.document.User;
import com.auth.jwtserver.exception.UserNotFoundException;
import com.auth.jwtserver.repository.ProductRepository;

@Service
public class ProductService implements ProductDetailsService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public User loadProductByUsername(String username) throws UsernameNotFoundException {
		return productRepository.findByUsername(username)
				.orElseThrow(() -> new UserNotFoundException());
	}
	
	public User findById(String id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException());
	}
	
	public void deleteUserById(String id) {
		productRepository.deleteById(id);
	}
	
}
