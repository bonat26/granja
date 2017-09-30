package com.mbl.farm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbl.farm.dto.ProductionDTO;
import com.mbl.farm.model.Production;
import com.mbl.farm.service.ProducerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/animal")
public class ProducerController {
	
	@Autowired
	private ProducerService producerService;
	
	@RequestMapping(value ="/{id}/production", method = RequestMethod.POST)
	public ProductionDTO createProduction(@PathVariable Integer id, @RequestBody ProductionDTO productionDTO) {
		log.info("Vamos a crear una producción para el animal ".concat(id.toString()));
		Production production = producerService.transform(productionDTO);
		production = producerService.create(id, production);
		return producerService.transform(production);
	}
	
	@RequestMapping(value = "/{id}/production", method = RequestMethod.GET)
	public List<ProductionDTO> getProductions(@PathVariable Integer id){
		log.info("Vamos a recuperar las producciones del animal ".concat(id.toString()));
		List<Production> productions = producerService.getAll(id);
		return producerService.transform(productions);
	}
}
