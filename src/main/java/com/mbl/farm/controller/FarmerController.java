package com.mbl.farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbl.farm.dto.ChickenDTO;
import com.mbl.farm.dto.CowDTO;
import com.mbl.farm.model.Chicken;
import com.mbl.farm.model.Cow;
import com.mbl.farm.service.FarmerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class FarmerController {

	@Autowired
	private FarmerService farmerService;
	
	@RequestMapping(value ="/{id}/chicken", method = RequestMethod.POST)
	public ChickenDTO createChicken(@PathVariable Integer id, @RequestBody ChickenDTO chickenDTO) {
		log.info("Vamos a crear un pollo para el usuario ".concat(id.toString()));
		Chicken chicken = farmerService.transform(chickenDTO);
		chicken = farmerService.create(id, chicken);
		return farmerService.transform(chicken);
	}
	
	@RequestMapping(value ="/{id}/cow", method = RequestMethod.POST)
	public CowDTO createCow(@PathVariable Integer id, @RequestBody CowDTO cowDTO) {
		log.info("Vamos a crear una vaca para el usuario ".concat(id.toString()));
		Cow cow = farmerService.transform(cowDTO);
		cow = farmerService.create(id, cow);
		return farmerService.transform(cow);
	}
	
}
