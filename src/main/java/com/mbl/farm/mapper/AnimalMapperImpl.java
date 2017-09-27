package com.mbl.farm.mapper;

import org.springframework.stereotype.Component;

import com.mbl.farm.dto.AnimalDTO;
import com.mbl.farm.model.Animal;

@Component
public class AnimalMapperImpl extends AbstractMapper<Animal, AnimalDTO> implements AnimalMapper{

	@Override
	protected Class<? extends Animal> getModelClazz() {
		return Animal.class;
	}

	@Override
	protected Class<? extends AnimalDTO> getDTOClazz() {
		return AnimalDTO.class;
	}

}
