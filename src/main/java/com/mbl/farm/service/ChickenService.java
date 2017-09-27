package com.mbl.farm.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbl.farm.dto.ChickenDTO;
import com.mbl.farm.model.Chicken;

public interface ChickenService{
	
	ChickenDTO transform (Chicken ch);
	
	Chicken transform (ChickenDTO ch);

	List<Chicken> getAll(Integer page, Integer size);
}
