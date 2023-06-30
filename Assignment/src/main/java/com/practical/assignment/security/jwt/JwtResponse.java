package com.practical.assignment.security.jwt;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
	
	private String jwt;
	private Integer id;
	private String username;
	
}
