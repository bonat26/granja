package com.mbl.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mbl.farm.dao.AnimalDao;
import com.mbl.farm.dto.AnimalDTO;
import com.mbl.farm.model.Animal;

@Service
public class AnimalServiceImpl implements AnimalService{
	
	@Autowired
	private AnimalDao animalDao;
	
	@Autowired
	private DozerBeanMapper dozer;
	
	@Override
	public AnimalDTO transform(Animal a) {
		return dozer.map(a, AnimalDTO.class);
	}

	@Override
	public Animal transform(AnimalDTO a) {
		return dozer.map(a, Animal.class);
	}

	@Override
	public AnimalDTO create(AnimalDTO animalDTO) {
		final Animal a = transform(animalDTO);
		return transform(animalDao.save(a));
	}

	@Override
	public void update(AnimalDTO animalDTO) {
		final Animal a = transform(animalDTO);
		animalDao.save(a);
	}

	@Override
	public Page<AnimalDTO> getAll(Pageable pageable) {
		final Iterable<Animal> animals = animalDao.findAll();
		final List<AnimalDTO> animalDTOs = new ArrayList<>();
		animals.forEach(a -> {
			final AnimalDTO animalDTO = transform(a);
			animalDTOs.add(animalDTO);
		});
		final Page<AnimalDTO> res = new PageImpl<AnimalDTO>(animalDTOs, pageable, animalDTOs.size());
		return res;
	}

	@Override
	public AnimalDTO findById(Integer id) {
		final AnimalDTO a = transform(animalDao.findOne(id));
		return a;
	}
	
	@Override
	public Page<AnimalDTO> getTopAnimals(Pageable pageable, Integer size) {
		return null;
	}

	
	public void Delete(Animal a) {
		animalDao.delete(a);
	}

}
