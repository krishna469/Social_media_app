package com.krishna.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDto {

	
	private Integer categoryId;
	
	@NotBlank
	@Size(min=3, message="minimum size of title is 3 Charactor")
	private String categoryTitle;
	
	@NotBlank
	@Size(min=5,message="minimum size of description is 5")
	private String categoryDescription;
}
