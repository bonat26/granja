package com.mbl.farm.dao;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mbl.farm.model.Chicken;

@Repository
public interface ChickenDao extends PagingAndSortingRepository<Chicken, Integer>{
	List<Chicken> findByIdUser(Integer id, PageRequest pageRequest);
}
