package com.mbl.farm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mbl.farm.model.Animal;

public interface AnimalStatsDao extends PagingAndSortingRepository<Animal, Integer>{
	
	@Query(value = "Select a from Animal a join fetch a.productions p order by p.sellPrice - p.buyPrice")
	List<Animal> findTopAnimals();

	
}
