package com.mbl.farm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mbl.farm.model.Animal;

public interface StatsDao extends PagingAndSortingRepository<Animal, Integer>{
	
	@Query(value = "Select a from Animal a order by")
	List<Animal> findTopAnimals();
}
