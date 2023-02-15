package com.krishna.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krishna.exception.ResourceNotFoundException;
import com.krishna.model.Category;
import com.krishna.payloads.CategoryDto;
import com.krishna.repository.CategoryRepository;
import com.krishna.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CategoryRepository repo;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category cat=this.modelMapper.map(categoryDto, Category.class);
		Category addedCat= this.categoryRepository.save(cat);	
		
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		Category cat= this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category ", "Category Id", categoryId));
		
//		Category updatedCat=this.modelMapper.map(cat, CategoryDto);
		
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedCat=this.categoryRepository.save(cat);
		return this.modelMapper.map(updatedCat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		
		Category cat= this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category ", "Category Id", categoryId));
		this.categoryRepository.delete(cat);

	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		
		Category cat= this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category ", "Category Id", categoryId));
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}



	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub

		List<Category> categories= repo.findAll();
		System.err.println("cat"+categories);
		
//		List<CategoryDto> catDtos=categories.stream().map((cat)->this.modelMapper.map(categories, CategoryDto.class)).collect(Collectors.toList());
		
		return categories;
		
		
//		@Override
//		public List<CategoryDto> getCategories() {
//			// TODO Auto-generated method stub
//
//			List<Category> categories= this.categoryRepository.findAll();
//			List<CategoryDto> catDtos=categories.stream().map((cat)->this.modelMapper.map(categories, CategoryDto.class)).collect(Collectors.toList());
//			
//			return catDtos;
//		}

	}

}
