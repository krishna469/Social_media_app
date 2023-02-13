package com.krishna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krishna.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	

}
