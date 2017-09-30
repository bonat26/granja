package com.mbl.farm.service;

import com.mbl.farm.dto.ChickenDTO;
import com.mbl.farm.dto.CowDTO;
import com.mbl.farm.model.Chicken;
import com.mbl.farm.model.Cow;

public interface FarmerService {

	Chicken transform(ChickenDTO chickenDTO);
	
	ChickenDTO transform(Chicken chicken);

	Chicken create(Integer id, Chicken chicken);

	Cow transform(CowDTO cowDTO);

	CowDTO transform(Cow cow);

	Cow create(Integer id, Cow cow);

}
