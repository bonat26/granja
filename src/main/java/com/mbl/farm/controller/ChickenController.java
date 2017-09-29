package com.mbl.farm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbl.farm.dto.AnimalDTO;
import com.mbl.farm.dto.ChickenDTO;
import com.mbl.farm.model.Animal;
import com.mbl.farm.model.Chicken;
import com.mbl.farm.service.ChickenService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/chicken")
public class ChickenController{

	@Autowired
	private ChickenService chickenService;
	
	@RequestMapping(method = RequestMethod.POST)
	public AnimalDTO create(@RequestBody AnimalDTO a) {
		log.info("Intentando crear un pollo");
		final Animal animal = animalService.transform(a);
		animalService.create(animal);
		return animalService.transform(animal);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody AnimalDTO a) {
		log.info("Vamos a actualizar un pollo");
		final Animal animal = animalService.transform(a);
		animalService.update(animal);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<ChickenDTO> getAll(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size) {
		log.info("Vamos a recuperar todos los pollos");
		final List<Chicken> chickens = chickenService.getAll(page, size);
		return chickenService.transform(chickens);
	}

}
