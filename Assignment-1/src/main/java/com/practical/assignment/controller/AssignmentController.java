package com.practical.assignment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.practical.assignment.Response;
import com.practical.assignment.model.UserAssignment;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {
	
	private RestTemplate restTemplate;
	
	public Response userAssignment(@PathVariable("id") Integer userId) {
		ResponseEntity<UserAssignment> responseEntity = restTemplate
                .getForEntity("http://localhost:8081/assignment/userAssignment/" + userId,UserAssignment.class);
		UserAssignment assignment = responseEntity.getBody();
		Response response = new Response();
		response.setAssignment(assignment);
		return response;
	}

}
