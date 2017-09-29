package com.mbl.farm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbl.farm.dto.ChickenDTO;
import com.mbl.farm.model.Chicken;
import com.mbl.farm.service.FarmerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/user/{id}")
public class FarmerController {

	@Autowired
	private FarmerService farmerService;
	
	@RequestMapping(value = "/chicken", method = RequestMethod.GET)
	public List<ChickenDTO> getAllChickens(Integer page, Integer size, @PathVariable Integer id){
		log.info("Vamos a recuperar los pollos del user con id ".concat(id.toString()));
		final List<Chicken> chickens = farmerService.findAllChickensOfUser(page, size, id);
		return farmerService.transform(chickens);
	}
}
