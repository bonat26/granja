package com.mbl.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbl.farm.dao.AnimalStatsDao;
import com.mbl.farm.dto.AnimalWinsDTO;
import com.mbl.farm.mapper.AnimalWinsMapper;
import com.mbl.farm.model.Animal;

@Service
public class AnimalStatsServiceImpl implements AnimalStatsService{
	
	@Autowired
	private AnimalStatsDao statsDao;
	
	@Autowired
	private AnimalWinsMapper animalWinsMapper;

	@Override
	public AnimalWinsDTO transform(Animal a) {
		return animalWinsMapper.toDTO(a);
	}
	
	@Override
	public List<Animal> getTopAnimals(Integer size) {
		final List<Animal> allAnimals = statsDao.findTopAnimals();
		final List<Animal> topAnimals = allAnimals.subList(0, size);
		return topAnimals;
	}



	@Override
	public List<AnimalWinsDTO> transform(List<Animal> animals) {
		final List<AnimalWinsDTO> animalsWinsDto = new ArrayList<>();
		animals.forEach(a -> animalsWinsDto.add(transform(a)));
		return animalsWinsDto;
	}

}
