package com.mbl.farm.mapper;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractMapper<M, DTO> implements Mapper<M, DTO> {

	@Autowired
	protected DozerBeanMapper mapper;
	
	@Override
	public M toModel(DTO dto) {
		return mapper.map(dto, getModelClazz());
	}

	@Override
	public DTO toDTO(M model) {
		return mapper.map(model, getDTOClazz());
	}

	protected abstract Class<? extends M> getModelClazz();

	protected abstract Class<? extends DTO> getDTOClazz() ;

}
