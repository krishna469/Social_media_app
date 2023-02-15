package com.krishna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krishna.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	

}
