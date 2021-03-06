package com.mbl.farm.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mbl.farm.model.Production;

@Repository
public interface ProductionDao extends PagingAndSortingRepository<Production, Integer> {

}
