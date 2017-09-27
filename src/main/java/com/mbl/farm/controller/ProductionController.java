package com.mbl.farm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbl.farm.dto.ProductionDTO;
import com.mbl.farm.model.Production;
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
		final Production prod = prodService.transform(p);
		prodService.create(prod);
		return prodService.transform(prod);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ProductionDTO> getAll(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
		log.info("Vamos a recuperar todas las producciones");
		final List<Production> prods = prodService.getAll(page, size);
		return prodService.transform(prods);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ProductionDTO findById(Integer id) {
		log.info("Vamos a recuperar una produccion con id".concat(id.toString()));
		final Production prod = prodService.findById(id);
		return prodService.transform(prod);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody ProductionDTO p) {
		log.info("Vamos a actualizar una produccion");
		final Production prod = prodService.transform(p);
		prodService.update(prod);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody ProductionDTO p) {
		log.info("Vamos a borrar una produccion");
		final Production prod = prodService.transform(p);
		prodService.delete(prod);
	}
	

}
