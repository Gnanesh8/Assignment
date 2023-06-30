package com.practical.assignment.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.practical.assignment.Response;
import com.practical.assignment.model.User;
import com.practical.assignment.repository.UserRepository;
import com.practical.assignment.service.UserService;
import com.practical.assignment.webModel.UserWebModel;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public ResponseEntity<?> register(UserWebModel userWebModel) {
		try {
			Optional<User> userData = userRepository.findById(userWebModel.getUserId());
			if(!userData.isPresent()) {
				User user = new User();
				BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
				String encryptPwd = bcrypt.encode(userWebModel.getUserPassword());
				user.setUserName(userWebModel.getUserName());
				user.setUserPassword(encryptPwd);
				user.setUserIsActive(true);
				user = userRepository.save(user);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(-1, "Fail", "error"));
		}
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK).body(new Response(1,"Success","User Registered Successful"));
	}

}
