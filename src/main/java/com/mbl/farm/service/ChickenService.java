package com.mbl.farm.service;

import java.util.List;

import com.mbl.farm.dto.ChickenDTO;
import com.mbl.farm.model.Chicken;

public interface ChickenService{
	
	ChickenDTO transform (Chicken ch);
	
	Chicken transform (ChickenDTO ch);
	
	Chicken create (Chicken c);
	
	void update (Chicken c);
	
	Chicken findOne(Integer id);

	List<Chicken> getAll(Integer page, Integer size);
	
	List<Chicken> getAllByUserId(Integer page, Integer size, Integer id);

	List<ChickenDTO> transform(List<Chicken> chickens);
}
