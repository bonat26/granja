package com.mbl.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mbl.farm.dao.AnimalDao;
import com.mbl.farm.dto.AnimalDTO;
import com.mbl.farm.mapper.AnimalMapper;
import com.mbl.farm.model.Animal;

@Service
public class AnimalServiceImpl implements AnimalService{
	
	@Autowired
	private AnimalDao animalDao;
	
	@Autowired
	private AnimalMapper mapper;
	
	@Override
	public AnimalDTO transform(Animal a) {
		return mapper.toDTO(a);
	}

	public Animal transform(AnimalDTO a) {
		return mapper.toModel(a);
	}

	@Override
	public List<Animal> getAll(Integer page, Integer size) {
		final List<Animal> animals = new ArrayList<>();
		animalDao.findAll(new PageRequest(page, size)).forEach(a -> animals.add(a));
		return animals;
	}

	@Override
	public Animal findById(Integer id) {
		return animalDao.findOne(id);
	}
	
	@Override
	public List<Animal> getTopAnimals(Integer size) {
		return null;
	}

	@Override
	public List<AnimalDTO> transform(List<Animal> animals) {
		final List<AnimalDTO> animalDTOs = new ArrayList<>();
		animals.forEach(c -> animalDTOs.add(transform(c)));
		return animalDTOs;
	}

	@Override
	public void update(Animal a) {
		animalDao.save(a);
	}
	
	public Animal create(Animal a) {
		return animalDao.save(a);
	}
	
	
	public void Delete(Animal a) {
		animalDao.delete(a);
	}
}
