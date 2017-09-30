package com.mbl.farm.service;

import java.util.List;

import com.mbl.farm.dto.UserDTO;
import com.mbl.farm.model.User;

public interface UserService {
	UserDTO transform (User u);
	
	User transform (UserDTO u);
	
	User create(User u);

	void update(User u);
	
	void delete(User u);
	
	List<User> getAll(Integer page, Integer size);

	User findById(Integer id);

	List<UserDTO> transform(List<User> users);
}
