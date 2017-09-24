package com.mbl.farm.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mbl.farm.model.Cow;

@Repository
public interface CowDao extends PagingAndSortingRepository<Cow, Integer>{

}
