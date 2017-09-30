package com.mbl.farm.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mbl.farm.model.Animal;
import com.mbl.farm.model.Production;

@Repository
public interface ProducerDao extends PagingAndSortingRepository<Production, Integer>{

	List<Production> findByAnimal(Animal animal);
	
}
