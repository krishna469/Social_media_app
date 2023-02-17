package com.krishna.services;

import java.util.List;

import com.krishna.model.Post;
import com.krishna.payloads.PostDto;

public interface PostService {
	
	//Create Post
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//Update Post
	Post updatePost(PostDto postDto, Integer postId);
	
	//Delete Post
	void deletePost(Integer postId);
	
	//Get All Post
	List<PostDto> getAllPost();
	
	//Get Post By Id
	PostDto getPostById(Integer postId);
	
	//Get all post By Category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//Get all post By User
	List<PostDto> getPostsByUser(Integer userId);
	
	//Search Post
	List<Post> searchPosts(String keyword);

}
