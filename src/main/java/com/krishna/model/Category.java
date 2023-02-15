package com.krishna.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="categories")
public class Category {

	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="cat_seq_gen")
    @SequenceGenerator(name="cat_seq_gen", sequenceName="seq", allocationSize=1, initialValue=1020)
	@Column(name="id")
	private Integer categoryId;

	
	@Column(name="title" , length=100,nullable = false)
	private String categoryTitle;
	
	@Column(name="description",nullable = false)
	private String categoryDescription;
	
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	private List<Post> posts=new ArrayList<>();
	
}
	