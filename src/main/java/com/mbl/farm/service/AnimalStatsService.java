package com.mbl.farm.service;

import java.util.List;

import com.mbl.farm.dto.AnimalWinsDTO;
import com.mbl.farm.model.Animal;

public interface AnimalStatsService {
	
	AnimalWinsDTO transform(Animal a);

	List<Animal> getTopAnimals(Integer size);

	List<AnimalWinsDTO> transform(List<Animal> animals);

}
