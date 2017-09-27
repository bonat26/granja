package com.mbl.farm.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mbl.farm.model.Animal;
import com.mbl.farm.model.Production;
import com.mbl.farm.service.AnimalService;
import com.mbl.farm.service.ProductionService;

@Component
public class ListMapperImpl implements ListMapper{
	
	@Autowired
	ProductionService productionService;
	
	@Autowired
	AnimalService animalService;
	
	@Override
	public List<Integer> productionListToIntList(List<Production> prods) {
		List<Integer> prodIDs = new ArrayList<>();
		prods.forEach(a -> prodIDs.add(a.getIdProduction()));
		return prodIDs;
	}
	
	@Override
	public List<Production> toProdList(List<Integer> ids){
		List<Production> prodIDs = new ArrayList<>();
		ids.forEach(a -> prodIDs.add(productionService.findById(a)));
		return prodIDs;
	}

	@Override
	public List<Integer> animalListToIntList(List<Animal> animals) {
		List<Integer> animalIDs = new ArrayList<>();
		animals.forEach(a -> animalIDs.add(a.getIdAnimal()));
		return animalIDs;
	}

	@Override
	public List<Animal> toAnimalList(List<Integer> ids) {
		List<Animal> animalIDs = new ArrayList<>();
		ids.forEach(a -> animalIDs.add(animalService.findById(a)));
		return animalIDs;
	}
	
}
