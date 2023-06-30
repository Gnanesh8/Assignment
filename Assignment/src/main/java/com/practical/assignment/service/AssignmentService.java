package com.practical.assignment.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.practical.assignment.model.Assignment;
import com.practical.assignment.webModel.AssignmentWebModel;

public interface AssignmentService {
	
	public ResponseEntity<?> addAssignment(AssignmentWebModel assignmentWebModel);
	
	public ResponseEntity<?> getAllAssignment(AssignmentWebModel assignmentWebModel);
	
	public ResponseEntity<Assignment> getUserAssignment(Integer userId);

}
