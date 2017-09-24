package com.mbl.farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbl.farm.dto.AnimalDTO;
import com.mbl.farm.service.AnimalService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/animal")
public class AnimalController {
	
	@Autowired
	private AnimalService animalService;
	
	@RequestMapping(method = RequestMethod.POST)
	public AnimalDTO create(@RequestBody AnimalDTO a) {
		log.info("Intentando crear un animal");
		return animalService.create(a);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody AnimalDTO a) {
		log.info("Vamos a actualizar un pollo");
		animalService.update(a);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Page<AnimalDTO> getAll(Pageable pageable) {
		log.info("Vamos a recuperar todos los pollos");
		return animalService.getAll(pageable);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public AnimalDTO findById(@PathVariable("id") Integer id) {
		log.info("Vamos a recuperar un pollo con id " + id);
		return animalService.findById(id);
	}
}
