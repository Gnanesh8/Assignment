package com.practical.assignment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practical.assignment.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	@Query("select u from User u where u.userName=:username")
	Optional<User>  findByUsername(String username);

}
