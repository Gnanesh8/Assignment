package com.practical.assignment.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.practical.assignment.service.AssignmentService;
import com.practical.assignment.webModel.AssignmentWebModel;

@SpringBootTest
public class AssignmentServiceImplTest {
	
	@Autowired
	AssignmentService assignmentService;
	
	@Test
	void addAssignmentTestSuccess() throws Exception{
		AssignmentWebModel assignmentWebModel = new AssignmentWebModel(1, "AssignmentName", true, 1);
		ResponseEntity<?> response = assignmentService.addAssignment(assignmentWebModel);
		assertNotNull(response);
		assertEquals("Success", response.getBody());
	}
	
	@Test
	void addAssignmentTestFail() throws Exception{
		AssignmentWebModel assignmentWebModel = null;
		ResponseEntity<?> response = assignmentService.addAssignment(assignmentWebModel);
		assertNotNull(response);
		assertEquals("Success", response.getBody());
	}

}
