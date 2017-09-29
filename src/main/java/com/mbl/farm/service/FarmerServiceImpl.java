package com.mbl.farm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbl.farm.dto.ChickenDTO;
import com.mbl.farm.model.Chicken;

@Service
public class FarmerServiceImpl implements FarmerService{

	@Autowired
	private ChickenService chickenService;
	
	@Override
	public List<Chicken> findAllChickensOfUser(Integer page, Integer size, Integer id) {
		return chickenService.getAllByUserId(page, size, id);
	}

	@Override
	public List<ChickenDTO> transform(List<Chicken> chickens) {
		return chickenService.transform(chickens);
	}

}
