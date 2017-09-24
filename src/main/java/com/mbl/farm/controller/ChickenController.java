package com.mbl.farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbl.farm.dto.ChickenDTO;
import com.mbl.farm.service.ChickenService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/chicken")
public class ChickenController{

	@Autowired
	private ChickenService chickenService;

	@RequestMapping(method = RequestMethod.GET)
	public Page<ChickenDTO> getAll(Pageable pageable) {
		log.info("Vamos a recuperar todos los pollos");
		return chickenService.getAll(pageable);
	}

}
