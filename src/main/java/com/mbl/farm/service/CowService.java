package com.mbl.farm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbl.farm.dto.CowDTO;
import com.mbl.farm.model.Cow;

public interface CowService {
	CowDTO transform (Cow c);
	
	Cow transform (CowDTO c);

	Page<CowDTO> getAll(Pageable pageable);
}
