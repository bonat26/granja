package com.mbl.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mbl.farm.dao.UserDao;
import com.mbl.farm.dto.UserDTO;
import com.mbl.farm.mapper.UserMapper;
import com.mbl.farm.model.Chicken;
import com.mbl.farm.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserMapper mapper;

	@Override
	public UserDTO transform(User u) {
		return mapper.toDTO(u);
	}

	@Override
	public User transform(UserDTO u) {
		return mapper.toModel(u);
	}

	@Override
	public User create(User u) {
		return userDao.save(u);
	}

	@Override
	public void update(User u) {
		userDao.save(u);
		
	}

	@Override
	public void delete(User u) {
		userDao.delete(u);
		
	}

	@Override
	public List<User> getAll(Integer page, Integer size) {
		List<User> users = new ArrayList<>();
		userDao.findAll(new PageRequest(page, size)).forEach(u -> users.add(u));
		return users;
	}

	@Override
	public User findById(Integer id) {
		return userDao.findOne(id);
	}

	@Override
	public List<UserDTO> transform(List<User> users) {
		final List<UserDTO> userDTOs = new ArrayList<>();
		users.forEach(c -> userDTOs.add(transform(c)));
		return userDTOs;
	}

	@Override
	public List<Chicken> getChickens(Integer page, Integer size) {
		return userDao.findByAnimals(page, size);
	}

	

	

}
