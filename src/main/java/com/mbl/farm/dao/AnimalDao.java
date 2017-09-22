package com.mbl.farm.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mbl.farm.model.Animal;

@Repository
public interface AnimalDao extends PagingAndSortingRepository<Animal, Integer>{

}
