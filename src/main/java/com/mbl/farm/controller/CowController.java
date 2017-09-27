package com.mbl.farm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbl.farm.dto.CowDTO;
import com.mbl.farm.model.Cow;
import com.mbl.farm.service.CowService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/cow")
public class CowController {
	
	@Autowired
	private CowService cowService;

	@RequestMapping(method = RequestMethod.GET)
	public List<CowDTO> getAll(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size) {
		log.info("Vamos a recuperar todos los pollos");
		final List<Cow> cows = cowService.getAll(page, size);
		return cowService.transform(cows);
	}

}
