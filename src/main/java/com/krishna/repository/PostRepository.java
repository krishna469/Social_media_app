package com.krishna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krishna.model.Category;
import com.krishna.model.Post;
import com.krishna.model.User;

public interface PostRepository extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	List<Post>findByCategory(Category category);
	
}
