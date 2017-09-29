package com.mbl.farm.service;

import java.util.List;

import com.mbl.farm.dto.ChickenDTO;
import com.mbl.farm.model.Chicken;

public interface FarmerService {
	List<Chicken> findAllChickensOfUser(Integer page, Integer size, Integer id);
	
	List<ChickenDTO> transform(List<Chicken> chickens);
}
