package com.mbl.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mbl.farm.dao.StatsDao;
import com.mbl.farm.dto.AnimalWinsDTO;
import com.mbl.farm.mapper.StatsMapper;
import com.mbl.farm.model.Animal;

public class StatsServiceImpl implements StatsService{
	
	@Autowired
	private StatsDao statsDao;
	
	@Autowired
	private StatsMapper mapper;

	@Override
	public AnimalWinsDTO transform(Animal a) {
		return mapper.toDTO(a);
	}
	
	@Override
	public List<Animal> getTopAnimals(Integer size) {
		return null;
	}

	@Override
	public List<AnimalWinsDTO> transform(List<Animal> animals) {
		final List<AnimalWinsDTO> animalsWinsDto = new ArrayList<>();
		animals.forEach(a -> animalsWinsDto.add(transform(a)));
		return animalsWinsDto;
	}


}
