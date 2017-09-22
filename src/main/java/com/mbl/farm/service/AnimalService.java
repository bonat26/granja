package com.mbl.farm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbl.farm.dto.AnimalDTO;
import com.mbl.farm.model.Animal;

public interface AnimalService {
	
	AnimalDTO transform (Animal a);
	
	Animal transform (AnimalDTO animalDTO);
	
	AnimalDTO create(AnimalDTO animalDTO);

	void update(AnimalDTO animalDTO);
	
	Page<AnimalDTO> getAll(Pageable pageable);
	
	Page<AnimalDTO> getTopFive(Pageable pageable);

	AnimalDTO findById(Integer id);
}
