package com.mbl.farm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbl.farm.dto.AnimalWinsDTO;
import com.mbl.farm.model.Animal;
import com.mbl.farm.service.StatsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/stats")
public class StatsController {

	@Autowired
	private StatsService statsService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<AnimalWinsDTO> topAnimals(Integer size){
		log.info("Vamos a recuperar el top ".concat(size.toString().concat("de animales.")));
		final List<Animal> animals = statsService.getTopAnimals(size);
		return statsService.transform(animals);
	}
}
