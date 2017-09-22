package com.mbl.farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbl.farm.model.User;
import com.mbl.farm.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController implements CRUD<User, Integer> {

	@Autowired
	private UserService userService;

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User t) {
		log.info("Intentando crear un usuario");
		return userService.create(t);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody User t) {
		log.info("Vamos a borrar un usuario");
		userService.delete(t);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody User t) {
		log.info("Vamos a actualizar un usuario");
		userService.update(t);
	}

	@Override
	@RequestMapping(method = RequestMethod.GET)
	public Page<User> getAll(Pageable pageable) {
		log.info("Vamos a recuperar todos los usuarios");
		return userService.getAll(pageable);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") Integer id) {
		log.info("Vamos a recuperar un usuario con id " + id);
		return userService.findById(id);
	}

}
