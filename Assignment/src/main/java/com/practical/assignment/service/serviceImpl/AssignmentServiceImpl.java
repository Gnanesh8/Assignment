package com.practical.assignment.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.practical.assignment.Response;
import com.practical.assignment.model.Assignment;
import com.practical.assignment.model.User;
import com.practical.assignment.repository.AssignmentRepository;
import com.practical.assignment.repository.UserRepository;
import com.practical.assignment.service.AssignmentService;
import com.practical.assignment.webModel.AssignmentWebModel;

@Service
public class AssignmentServiceImpl implements AssignmentService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AssignmentRepository assignmentRepository;

	@Override
	public ResponseEntity<?> addAssignment(AssignmentWebModel assignmentWebModel) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			Assignment assignment = new Assignment();
			assignment.setAssignmentName(assignmentWebModel.getAssignmentName());
			assignment.setAssignmentIsActive(true);
			assignment.setUserId(assignmentWebModel.getUserId());
			assignment = assignmentRepository.save(assignment);
			response.put("assignment", assignment);
		}catch(Exception e) {
			e.printStackTrace();
			return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(-1,"Fail",""));
		}
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK).body(new Response(1,"Success",response));
	}

	@Override
	public ResponseEntity<?> getAllAssignment(AssignmentWebModel assignmentWebModel) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			List<Assignment> assignmentData = assignmentRepository.findAll();
			response.put("assignments", assignmentData);
		}catch(Exception e) {
			e.printStackTrace();
			return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(-1,"Fail",""));
		}
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK).body(new Response(1,"Success",response));
	}

	@Override
	public ResponseEntity<Assignment> getUserAssignment(Integer userId) {
			Assignment data = assignmentRepository.findByUserId(userId);
			return ResponseEntity.ok(data);
	}
	
	

}
