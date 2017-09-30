package com.mbl.farm.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mbl.farm.model.Animal;
import com.mbl.farm.model.User;

@Repository
public interface FarmerDao extends PagingAndSortingRepository<Animal, Integer>{
	List<Animal> findByUser(User user);
}
