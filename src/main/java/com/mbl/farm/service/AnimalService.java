package com.mbl.farm.service;

import java.util.List;

import com.mbl.farm.dto.AnimalDTO;
import com.mbl.farm.model.Animal;

public interface AnimalService {

	AnimalDTO transform(Animal a);

	//Animal transform(AnimalDTO a);

	List<Animal> getAll(Integer page, Integer size);

	Animal findById(Integer id);
	
	List<Animal> getTopAnimals(Integer size);

	List<AnimalDTO> transform(List<Animal> animals);
}
