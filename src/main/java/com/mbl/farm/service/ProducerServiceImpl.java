package com.mbl.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbl.farm.dao.ProducerDao;
import com.mbl.farm.dto.ProductionDTO;
import com.mbl.farm.mapper.ProductionMapper;
import com.mbl.farm.model.Animal;
import com.mbl.farm.model.Production;

@Service
public class ProducerServiceImpl implements ProducerService{

	@Autowired
	private ProducerDao producerDao;
	
	@Autowired
	private ProductionService productionService;
	
	@Autowired
	private AnimalService animalService;
	
	@Autowired
	private ProductionMapper productionMapper;
	
	@Override
	public Production transform(ProductionDTO productionDTO) {
		return productionMapper.toModel(productionDTO);
	}

	@Override
	public ProductionDTO transform(Production production) {
		return productionMapper.toDTO(production);
	}

	@Override
	public List<ProductionDTO> transform(List<Production> productions) {
		return productionService.transform(productions);
	}

	@Override
	public Production create(Integer id, Production production) {
		final Animal animal = animalService.findById(id);
		production.setAnimal(animal);
		productionService.create(production);
		animal.getProductions().add(production);
		animalService.update(animal);
		return productionService.findById(production.getIdProduction());
	}

	@Override
	public List<Production> getAll(Integer id) {
		final Animal animal = animalService.findById(id);
		List<Production> productions = new ArrayList<>();
		producerDao.findByAnimal(animal).forEach(p -> productions.add(p));
		return productions;
	}

}
