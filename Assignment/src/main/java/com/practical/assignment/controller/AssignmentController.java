package com.practical.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practical.assignment.Response;
import com.practical.assignment.service.AssignmentService;
import com.practical.assignment.webModel.AssignmentWebModel;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {
	
	@Autowired
	AssignmentService assignmentService;
	
	@PostMapping("addAssignment")
	public ResponseEntity<?> addAssignment(@RequestBody AssignmentWebModel assignmentWebModel) {
		try {
			return assignmentService.addAssignment(assignmentWebModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(new Response(-1, "Fail", ""));
	}
	
	@GetMapping("getAllAssignment")
	public ResponseEntity<?> getAllAssignment(@RequestBody AssignmentWebModel assignmentWebModel) {
		try {
			return assignmentService.getAllAssignment(assignmentWebModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(new Response(-1, "Fail", ""));
	}
	
	@GetMapping("userAssignment/{id}")
	public ResponseEntity<?> userAssignment(@PathVariable("id") Integer userId) {
		try {
			return assignmentService.getUserAssignment(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(new Response(-1, "Fail", ""));
	}

}
