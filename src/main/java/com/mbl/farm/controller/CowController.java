package com.mbl.farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbl.farm.dto.CowDTO;
import com.mbl.farm.service.CowService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/cow")
public class CowController {
	
	@Autowired
	private CowService cowService;

	@RequestMapping(method = RequestMethod.GET)
	public Page<CowDTO> getAll(Pageable pageable) {
		log.info("Vamos a recuperar todos los pollos");
		return cowService.getAll(pageable);
	}

}
