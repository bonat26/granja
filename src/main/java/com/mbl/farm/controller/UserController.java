package com.mbl.farm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbl.farm.dto.UserDTO;
import com.mbl.farm.model.User;
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
		final User user = userService.transform(t);
		userService.create(user);
		return userService.transform(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@RequestBody UserDTO t) {
		log.info("Vamos a borrar un usuario");
		final User user = userService.transform(t);
		userService.delete(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody UserDTO t) {
		log.info("Vamos a actualizar un usuario");
		final User user = userService.transform(t);
		userService.update(user);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<UserDTO> getAll(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size) {
		log.info("Vamos a recuperar todos los usuarios");
		final List<User> users = userService.getAll(page, size);
		return userService.transform(users);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserDTO findById(@PathVariable("id") Integer id) {
		log.info("Vamos a recuperar un usuario con id " + id);
		final User user = userService.findById(id);
		return userService.transform(user);
	}

}
