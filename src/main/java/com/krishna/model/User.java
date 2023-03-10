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

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter

public class User {
	
//	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen", sequenceName="my_entity_seq", allocationSize=1, initialValue=1020)
	private int id;
	
	@Column(name="username",nullable = false,length = 100)
	private String name;
	private String email;
	private String password;
	private String about;
	
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Post> posts=new ArrayList<>();
	
}
