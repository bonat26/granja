package com.mbl.farm.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mbl.farm.model.User;

public interface UserStatsDao extends PagingAndSortingRepository<User, Integer>{
	
	//No encuentro la manera de obtener la información...
	@Query(value = "Select u from User u join u.animals a join a.productions p order by p.sellPrice - p.buyPrice")
	List<User> findUserWins(PageRequest pageRequest, Date startDate, Date endDate);
}
