package com.mbl.farm.mapper;

import org.springframework.stereotype.Component;

import com.mbl.farm.dto.AnimalDTO;
import com.mbl.farm.model.Animal;

@Component
public class AnimalMapperImpl extends AbstractMapper<Animal, AnimalDTO> implements AnimalMapper{
	
	@Override
	public AnimalDTO toDTO(Animal model) {
		final AnimalDTO animalDTO = super.toDTO(model);
		animalDTO.setSpecies(model.getClass().getSimpleName());
		return animalDTO;
	}
	
	@Override
	protected Class<? extends Animal> getModelClazz() {
		return Animal.class;
	}

	@Override
	protected Class<? extends AnimalDTO> getDTOClazz() {
		return AnimalDTO.class;
	}

}
