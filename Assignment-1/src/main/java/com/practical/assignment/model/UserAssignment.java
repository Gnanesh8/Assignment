package com.practical.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "user_assignment")
public class UserAssignment {
	
	@Column	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userAssignmentId;
	@Column
	private String UserAssignmentName;
	public Integer getUserAssignmentId() {
		return userAssignmentId;
	}
	public void setUserAssignmentId(Integer userAssignmentId) {
		this.userAssignmentId = userAssignmentId;
	}
	public String getUserAssignmentName() {
		return UserAssignmentName;
	}
	public void setUserAssignmentName(String userAssignmentName) {
		UserAssignmentName = userAssignmentName;
	}

}
