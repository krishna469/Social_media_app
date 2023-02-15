package com.krishna.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	
	@NotNull
	@Size(min=3)
	private String title;
	
	@NotNull
	@Size(max=10000)
	private String content;
	private String imageName;
	private Date addedDate;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Category category;
	
	
}
