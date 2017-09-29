package com.mbl.farm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbl.farm.dto.AnimalDTO;
import com.mbl.farm.model.Animal;
import com.mbl.farm.service.AnimalService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/animal")
public class AnimalController {
	
	@Autowired
	private AnimalService animalService;

	@RequestMapping(method = RequestMethod.GET)
	public List<AnimalDTO> getAll(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size) {
		log.info("Vamos a recuperar todos los animales");
		final List<Animal> animals = animalService.getAll(page, size);
		return animalService.transform(animals);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public AnimalDTO findById(@PathVariable("id") Integer id) {
		log.info("Vamos a recuperar un animal con id " + id);
		final Animal animal = animalService.findById(id);
		return animalService.transform(animal);
	}
}
