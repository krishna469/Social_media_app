package com.krishna.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krishna.model.User;
import com.krishna.exception.*;
import com.krishna.payloads.UserDto;
import com.krishna.repository.UserRepository;
import com.krishna.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user= this.dtoToUser(userDto);
		
		User savedUser=this.userRepository.save(user);
		
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user"," id ",userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser=this.userRepository.save(user);
		UserDto userDto1=this.userToDto(updatedUser);
		
		
		
		return userDto1;
	}

	@Override
	public UserDto getsUserById(Integer userId) {
				
		User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user"," id ",userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users= this.userRepository.findAll();
		List<UserDto> userDetos=users.stream().map(user->userToDto(user)).collect(Collectors.toList());
		return userDetos;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user"," id ",userId));
		this.userRepository.delete(user);
	}
	
	
	private User dtoToUser(UserDto userdto) {
		
		//User user=new User();
		
		User user=this.modelMapper.map(userdto,User.class);
		
		
//		user.setId(userdto.getId());
//		user.setName(userdto.getName());
//		user.setEmail(userdto.getEmail());
//		user.setPassword(userdto.getPassword());
//		user.setAbout(userdto.getAbout());
		return user;
		
		
	}
	
		private UserDto userToDto(User user) {
		
//			UserDto userDto=new UserDto();
			UserDto userDto=this.modelMapper.map(user, UserDto.class);
			
//			userDto.setId(user.getId());
//			userDto.setName(user.getName());
//			userDto.setEmail(user.getEmail());
//			userDto.setPassword(user.getPassword());
//			userDto.setAbout(user.getAbout());
			return userDto;
		
		
	}

}
