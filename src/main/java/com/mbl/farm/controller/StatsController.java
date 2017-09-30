package com.mbl.farm.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbl.farm.dto.AnimalWinsDTO;
import com.mbl.farm.dto.UserWinsDTO;
import com.mbl.farm.model.Animal;
import com.mbl.farm.model.User;
import com.mbl.farm.service.AnimalStatsService;
import com.mbl.farm.service.UserStatsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/stats")
public class StatsController {

	@Autowired
	private AnimalStatsService animalStatsService;
	
	@Autowired
	private UserStatsService userStatsService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/animal")
	public List<AnimalWinsDTO> topAnimals(@RequestParam(name = "size") Integer size){
		log.info("Vamos a recuperar el top ".concat(size.toString().concat(" de animales.")));
		final List<Animal> animals = animalStatsService.getTopAnimals(size);
		return animalStatsService.transform(animals);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/user")
	public List<UserWinsDTO> userWins(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size, 
									@RequestParam(name = "startDate") Date startDate, @RequestParam(name = "endDate") Date endDate){
		
		log.info("Vamos a recuperar el dinero ganado por usuario desde ".concat(startDate.toString().concat(" hasta ").concat(endDate.toString())));
		final List<User> users = userStatsService.getUserWins(page, size, startDate, endDate);
		return userStatsService.transform(users);
	}
}
