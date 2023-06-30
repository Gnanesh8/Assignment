package com.practical.assignment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.practical.assignment.model.Assignment;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Integer>{

	Assignment findByUserId(Integer userId);

}
