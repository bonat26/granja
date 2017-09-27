package com.mbl.farm.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mbl.farm.dto.AnimalDTO;
import com.mbl.farm.model.Animal;
import com.mbl.farm.model.Production;
import com.mbl.farm.service.ProductionService;

@Component
public class AnimalMapperImpl extends AbstractMapper<Animal, AnimalDTO> implements AnimalMapper{

	@Autowired
	private ProductionService productionService;

	@Override
	public Animal toModel(AnimalDTO animalDTO) {
		final Animal animal = super.toModel(animalDTO);
		List<Production> prods = toProdList(animalDTO.getProductionsIDs());
		animal.setProductions(prods);
		return animal;
	}
	
	
	@Override
	public AnimalDTO toDTO(Animal model) {
		final AnimalDTO animalDTO = super.toDTO(model);
		final List<Integer> prodIDs = toIntList(model.getProductions());
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
	
	private List<Integer> toIntList(List<Production> prods) {
		List<Integer> prodIDs = new ArrayList<>();
		prods.forEach(a -> prodIDs.add(a.getIdProduction()));
		return prodIDs;
	}
	
	private List<Production> toProdList(List<Integer> ids){
		List<Production> prodIDs = new ArrayList<>();
		ids.forEach(a -> prodIDs.add(productionService.findById(a)));
		return prodIDs;
	}

}
