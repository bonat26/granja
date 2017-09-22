package com.mbl.farm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mbl.farm.dao.UserDao;
import com.mbl.farm.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public User create(User t) {
		return dao.save(t);
	}

	@Override
	public void delete(User t) {
		dao.delete(t);
	}

	@Override
	public void update(User t) {
		dao.save(t);
	}

	@Override
	public Page<User> getAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public User findById(Integer id) {
		return dao.findOne(id);
	}

}
