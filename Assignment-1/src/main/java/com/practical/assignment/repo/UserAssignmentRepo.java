package com.practical.assignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practical.assignment.model.UserAssignment;

@Repository
public interface UserAssignmentRepo extends JpaRepository<UserAssignment, Integer>{

}
