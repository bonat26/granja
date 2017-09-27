package com.mbl.farm.mapper;

import org.springframework.stereotype.Component;

import com.mbl.farm.dto.ChickenDTO;
import com.mbl.farm.model.Chicken;

@Component
public class ChickenMapperImpl extends AbstractMapper<Chicken, ChickenDTO> implements ChickenMapper{

	@Override
	protected Class<? extends Chicken> getModelClazz() {
		return Chicken.class;
	}

	@Override
	protected Class<? extends ChickenDTO> getDTOClazz() {
		return ChickenDTO.class;
	}

}
