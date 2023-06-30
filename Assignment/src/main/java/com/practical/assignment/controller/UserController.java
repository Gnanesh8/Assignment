package com.practical.assignment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practical.assignment.Response;
import com.practical.assignment.model.User;
import com.practical.assignment.repository.UserRepository;
import com.practical.assignment.security.UserDetailsImpl;
import com.practical.assignment.security.jwt.JwtResponse;
import com.practical.assignment.security.jwt.JwtUtils;
import com.practical.assignment.service.UserService;
import com.practical.assignment.webModel.UserWebModel;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	UserService userService;
	
	@GetMapping("login")
	public ResponseEntity<?> login(@RequestBody UserWebModel userWebModel) {
		Optional<User> checkUsername = userRepository.findByUsername(userWebModel.getUserName());
		if (checkUsername.isPresent()) {
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					userWebModel.getUserName(), userWebModel.getUserPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication);
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
			return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername()));
		}
		return (ResponseEntity<?>) ResponseEntity.badRequest().body(new Response(-1, "Invalid EmailId", ""));
	}
	
	@PostMapping("register")
	public ResponseEntity<?> userRegister(@RequestBody UserWebModel userWebModel) {
		try {
			return userService.register(userWebModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(new Response(-1, "Fail", ""));
	}

}
