package com.practical.assignment.webModel;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentWebModel {
	
	
	private Integer assignmentId;
	private String assignmentName;
	private Boolean assignmentIsActive;
	private Integer userId;

}
