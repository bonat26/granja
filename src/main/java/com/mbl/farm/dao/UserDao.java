package com.mbl.farm.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mbl.farm.model.Chicken;
import com.mbl.farm.model.User;

@Repository
public interface UserDao extends PagingAndSortingRepository<User, Integer> {
	
	List<Chicken> findByAnimals (Integer page, Integer size);
}
