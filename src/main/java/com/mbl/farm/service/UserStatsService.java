package com.mbl.farm.service;

import java.util.Date;
import java.util.List;

import com.mbl.farm.dto.UserWinsDTO;
import com.mbl.farm.model.User;

public interface UserStatsService {
	
	UserWinsDTO transform(User u);
	
	List<UserWinsDTO> transform(List<User> users);

	List<User> getUserWins(Integer page, Integer size, Date startDate, Date endDate);
}
