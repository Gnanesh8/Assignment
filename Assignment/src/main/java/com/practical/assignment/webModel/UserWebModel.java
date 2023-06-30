package com.practical.assignment.webModel;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWebModel {
	
	private Integer userId;
	private String userName;
	private Boolean userIsActive;
	private String userPassword;
	private Date userCreatedOn;
	private Date userUpdatedOn;

}
