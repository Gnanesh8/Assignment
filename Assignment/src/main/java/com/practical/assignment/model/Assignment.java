package com.practical.assignment.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="assignment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {
	
	@Column	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer assignmentId;
	@Column
	private String assignmentName;
	@Column
	private Date assignmentCreatedOn;
	@Column
	private Date assignmentUpdatedOn;
	@Column
	private Boolean assignmentIsActive;
	@Column
	private Integer userId;

}
