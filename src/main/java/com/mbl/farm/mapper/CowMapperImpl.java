package com.mbl.farm.mapper;

import org.springframework.stereotype.Component;

import com.mbl.farm.dto.CowDTO;
import com.mbl.farm.model.Cow;

@Component
public class CowMapperImpl extends AbstractMapper<Cow, CowDTO> implements CowMapper{

	@Override
	protected Class<? extends Cow> getModelClazz() {
		return Cow.class;
	}

	@Override
	protected Class<? extends CowDTO> getDTOClazz() {
		return CowDTO.class;
	}

}
