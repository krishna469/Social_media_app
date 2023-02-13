package com.krishna.services;

import java.util.List;
import com.krishna.payloads.UserDto;

public interface UserService {
	
	UserDto createUser (UserDto user);
	UserDto updateUser(UserDto user, Integer userId);
	UserDto getsUserById(Integer userId);
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);
	
}
