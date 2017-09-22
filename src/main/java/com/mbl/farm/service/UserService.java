package com.mbl.farm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbl.farm.dto.UserDTO;
import com.mbl.farm.model.User;

public interface UserService {
	UserDTO transform (User u);
	
	User transform (UserDTO u);
	
	UserDTO create(UserDTO u);

	void update(UserDTO u);
	
	void delete(UserDTO u);
	
	Page<UserDTO> getAll(Pageable pageable);

	UserDTO findById(Integer id);
}
