package com.krishna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.payloads.PostDto;
import com.krishna.services.PostService;
 
@ResponseBody
@Controller
@RestController
@RequestMapping("/")
public class PostController {

	@Autowired
	private PostService postService;
	
	//Create
	
	@PostMapping("/user/{userId}/categories/{categoryId}/post")
	public ResponseEntity<PostDto> createPost(
			@RequestBody PostDto postDto,
			@PathVariable Integer userId,
			@PathVariable Integer categoryId
			){		
				PostDto createdPost=this.postService.createPost(postDto, userId, categoryId);
				return new ResponseEntity<PostDto>(createdPost,HttpStatus.CREATED);
	}
	
	//get by user
	
	@GetMapping("/user/{userId}/post")
	public ResponseEntity<List<PostDto>> getPostsByUser( @PathVariable Integer userId){
				List<PostDto> posts= this.postService.getPostsByUser(userId);
		
				return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	
	//get by Category
	@GetMapping("/categories/{categoryId}/post")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
				
		List<PostDto> posts= this.postService.getPostsByCategory(categoryId);
		
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	
	//Get  All Post
	
	@GetMapping("/post")
	public ResponseEntity<List<PostDto>> getAllPost(){
		
		List<PostDto> allPost=this.postService.getAllPost();
		return new ResponseEntity<List<PostDto>>(allPost,HttpStatus.OK);
	}
	
	//Get Single Post
	@GetMapping("/post/{postId}")
	public ResponseEntity<PostDto> getPostByd(@PathVariable Integer postId){
		
		PostDto postDto=this.postService.getPostById(postId);
		
		return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
	}
	
	
	
}
