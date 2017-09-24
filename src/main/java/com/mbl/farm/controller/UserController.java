package com.mbl.farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbl.farm.dto.UserDTO;
import com.mbl.farm.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController{

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public UserDTO create(@RequestBody UserDTO t) {
		log.info("Intentando crear un usuario");
		return userService.create(t);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody UserDTO t) {
		log.info("Vamos a borrar un usuario");
		userService.delete(t);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody UserDTO t) {
		log.info("Vamos a actualizar un usuario");
		userService.update(t);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Page<UserDTO> getAll(Pageable pageable) {
		log.info("Vamos a recuperar todos los usuarios");
		return userService.getAll(pageable);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserDTO findById(@PathVariable("id") Integer id) {
		log.info("Vamos a recuperar un usuario con id " + id);
		return userService.findById(id);
	}

}
