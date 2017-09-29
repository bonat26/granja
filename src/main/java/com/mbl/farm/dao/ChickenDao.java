package com.mbl.farm.dao;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mbl.farm.model.Chicken;

@Repository
public interface ChickenDao extends PagingAndSortingRepository<Chicken, Integer>{
	
	//@Query(value = "select c from Chicken c where c.idAnimal = (select b.animals_id_animal from users_animals b)")
	//List<Chicken> findByIdUser(Integer id, PageRequest pageRequest);
}
