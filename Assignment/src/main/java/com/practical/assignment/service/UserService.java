package com.practical.assignment.service;

import org.springframework.http.ResponseEntity;

import com.practical.assignment.webModel.UserWebModel;

public interface UserService {
	
	public ResponseEntity<?> register(UserWebModel userWebModel);

}
