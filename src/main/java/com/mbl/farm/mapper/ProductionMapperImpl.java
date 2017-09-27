package com.mbl.farm.mapper;

import org.springframework.stereotype.Component;

import com.mbl.farm.dto.ProductionDTO;
import com.mbl.farm.model.Production;

@Component
public class ProductionMapperImpl extends AbstractMapper<Production, ProductionDTO> implements ProductionMapper{

	@Override
	protected Class<? extends Production> getModelClazz() {
		return Production.class;
	}

	@Override
	protected Class<? extends ProductionDTO> getDTOClazz() {
		return ProductionDTO.class;
	}

}
