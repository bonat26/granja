package com.mbl.farm.service;

import java.util.List;

import com.mbl.farm.dto.CowDTO;
import com.mbl.farm.model.Cow;

public interface CowService {
	CowDTO transform (Cow c);
	
	Cow transform (CowDTO c);

	List<Cow> getAll(Integer page, Integer size);
}
