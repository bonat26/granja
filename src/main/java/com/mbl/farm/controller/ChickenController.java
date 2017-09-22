package com.mbl.farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbl.farm.model.Chicken;
import com.mbl.farm.service.ChickenService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/chicken")
public class ChickenController implements CRUD<Chicken, Integer> {

	@Autowired
	private ChickenService chickenService;
	
	@Override
	@RequestMapping(method = RequestMethod.POST)
	public Chicken create(@RequestBody Chicken t) {
		log.info("Intentando crear un pollo");
		return chickenService.create(t);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody Chicken t) {
		log.info("Vamos a borrar un pollo");
		chickenService.delete(t);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody Chicken t) {
		log.info("Vamos a actualizar un pollo");
		chickenService.update(t);
		
	}

	/*@Override
	@RequestMapping(method = RequestMethod.GET)
	public List<Chicken> getAll() {
		log.info("Vamos a recuperar todos los pollos");
		return chickenService.getAll();
	}*/
	
	@Override
	@RequestMapping(method = RequestMethod.GET)
	public Page<Chicken> getAll(Pageable pageable) {
		log.info("Vamos a recuperar todos los pollos");
		return chickenService.getAll(pageable);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Chicken findById(@PathVariable("id") Integer id) {
		log.info("Vamos a recuperar un pollo con id " + id);
		return chickenService.findById(id);
	}

}
