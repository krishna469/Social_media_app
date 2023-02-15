package com.krishna.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {

	private int id;
	
	@Size(min=3,message="Name Atleast 3 charactor")
	@NotEmpty
	private String name;
	
	@NotEmpty
	@Email
	private String email;
	
	@Size(min=3,max=9,message="Password must be Greater than 3 and Lessthan 9")
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String about;
}
