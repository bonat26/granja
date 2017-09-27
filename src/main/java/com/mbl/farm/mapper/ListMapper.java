package com.mbl.farm.mapper;

import java.util.List;

import com.mbl.farm.model.Animal;
import com.mbl.farm.model.Production;

public interface ListMapper {
	
	public List<Integer> productionListToIntList(List<Production> prods);
	
	public List<Production> toProdList(List<Integer> ids);
	
	public List<Integer> animalListToIntList(List<Animal> animals);
	
	public List<Animal> toAnimalList(List<Integer> ids);
	
}
