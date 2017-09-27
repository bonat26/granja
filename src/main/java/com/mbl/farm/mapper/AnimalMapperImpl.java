package com.mbl.farm.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mbl.farm.dto.AnimalDTO;
import com.mbl.farm.model.Animal;
import com.mbl.farm.model.Production;

@Component
public class AnimalMapperImpl extends AbstractMapper<Animal, AnimalDTO> implements AnimalMapper{

	@Autowired
	private ListMapper listMapper;

	@Override
	public Animal toModel(AnimalDTO animalDTO) {
		final Animal animal = super.toModel(animalDTO);
		List<Production> prods = listMapper.toProdList(animalDTO.getProductionsIDs());
		animal.setProductions(prods);
		return animal;
	}
	
	
	@Override
	public AnimalDTO toDTO(Animal model) {
		final AnimalDTO animalDTO = super.toDTO(model);
		final List<Integer> prodIDs = listMapper.toIntList(model.getProductions());
		animalDTO.setProductionsIDs(prodIDs);
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
