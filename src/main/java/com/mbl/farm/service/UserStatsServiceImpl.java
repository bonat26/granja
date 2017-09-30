package com.mbl.farm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mbl.farm.dao.UserStatsDao;
import com.mbl.farm.dto.UserWinsDTO;
import com.mbl.farm.mapper.UserWinsMapper;
import com.mbl.farm.model.User;

@Service
public class UserStatsServiceImpl implements UserStatsService{

	@Autowired
	private UserStatsDao userStatsDao;
	
	@Autowired
	private UserWinsMapper userWinsMapper;
	
	@Override
	public UserWinsDTO transform(User u) {
		return userWinsMapper.toDTO(u);
	}
	
	@Override
	public List<User> getUserWins(Integer page, Integer size, Date startDate, Date endDate) {
		List<User> users = new ArrayList<>();
		userStatsDao.findUserWins(new PageRequest(page, size), startDate, endDate).forEach(u -> users.add(u));
		return users;
	}
	
	@Override
	public List<UserWinsDTO> transform(List<User> users) {
		final List<UserWinsDTO> userWinsDTO = new ArrayList<>();
		users.forEach(u -> userWinsDTO.add(transform(u)));
		return userWinsDTO;
	}
}
