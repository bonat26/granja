package com.mbl.farm.mapper;

public interface Mapper<M, DTO> {

		M toModel(DTO dto);
		
		DTO toDTO(M model);
}
