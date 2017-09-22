package com.mbl.farm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mbl.farm.dao.UserDao;
import com.mbl.farm.dto.UserDTO;
import com.mbl.farm.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public UserDTO transform(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User transform(UserDTO u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO create(UserDTO u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UserDTO u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserDTO u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<UserDTO> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UserDTO> getTopFive(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
