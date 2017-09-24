package com.mbl.farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbl.farm.dto.ProductionDTO;
import com.mbl.farm.service.ProductionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/production")
public class ProductionController {
	
	@Autowired
	private ProductionService prodService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ProductionDTO create(@RequestBody ProductionDTO p) {
		log.info("Intentando crear una produccion");
		return prodService.create(p);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<ProductionDTO> getAll(Pageable pageable){
		log.info("Vamos a recuperar todas las producciones");
		return prodService.getAll(pageable);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ProductionDTO findById(Integer id) {
		log.info("Vamos a recuperar una produccion con id".concat(id.toString()));
		return prodService.findById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody ProductionDTO p) {
		log.info("Vamos a actualizar una produccion");
		prodService.update(p);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody ProductionDTO p) {
		log.info("Vamos a borrar una produccion");
		prodService.delete(p);
	}
	

}
