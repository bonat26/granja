package com.mbl.farm.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mbl.farm.model.Chicken;

@Repository
public interface ChickenDao extends PagingAndSortingRepository<Chicken, Integer>{
	
}
