package com.mbl.farm.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.mbl.farm.dto.UserDTO;
import com.mbl.farm.model.User;
import com.mbl.farm.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class TestUserController {
	
	private static final Integer PAGE = 0;
	private static final Integer SIZE = 5;
	private static final Integer ID = 1;
	private static final String NAME = "name";
	
	@InjectMocks
	private UserController controller = new UserController();
	
	@Mock
	private UserService service;
	
	@Test
	public void testCreateOk() {
		final User model = new User();
		model.setName(NAME);
		Mockito.when(service.create(model)).thenReturn(model);
		final UserDTO dtoMock = new UserDTO();
		dtoMock.setName(NAME);
		Mockito.when(service.transform(model)).thenReturn(dtoMock);
		Mockito.when(service.transform(dtoMock)).thenReturn(model);
		
		final UserDTO dto = controller.create(dtoMock);
		Assert.assertNotNull(dto);
		Assert.assertEquals(dto.getName(), NAME);
	}
	
	@Test
	public void testCreateKo() {
		final User model = new User();
		model.setName(NAME);
		Mockito.when(service.create(model)).thenReturn(model);
		final UserDTO dtoMock = null;
		Mockito.when(service.transform(model)).thenReturn(dtoMock);
		Mockito.when(service.transform(dtoMock)).thenReturn(model);
		
		final UserDTO dto = controller.create(dtoMock);
		Assert.assertNull(dto);
	}
	
	@Test
	public void testGetAllOk() {
		final List<User> models = createListOfUsers();
		final List<UserDTO> dtosMock = createListOfUsersDTOs();
		
		Mockito.when(service.getAll(PAGE, SIZE)).thenReturn(models);
		Mockito.when(service.transform(models)).thenReturn(dtosMock);
		
		final List<UserDTO> dtos = controller.getAll(PAGE, SIZE);
		Assert.assertNotNull(dtos);
		Assert.assertEquals(dtos, dtosMock);
		
	}
	
	@Test
	public void testGetAllKo() {
		final List<User> models = null;
		final List<UserDTO> dtosMock = null;
		
		Mockito.when(service.getAll(PAGE, SIZE)).thenReturn(models);
		Mockito.when(service.transform(models)).thenReturn(dtosMock);
		
		final List<UserDTO> dtos = controller.getAll(PAGE, SIZE);
		Assert.assertNull(dtos);
		
	}
	
	@Test
	public void testFindByIdOk() {
		final User model = new User();
		model.setName(NAME);
		Mockito.when(service.findById(ID)).thenReturn(model);
		final UserDTO dtoMock = new UserDTO();
		dtoMock.setName(NAME);
		Mockito.when(service.transform(model)).thenReturn(dtoMock);
		
		final UserDTO dto = controller.findById(ID);
		Assert.assertNotNull(dto);
		Assert.assertEquals(dto.getName(), NAME);
	}
	
	@Test
	public void testFindByIdKo() {
		final User model = null;
		Mockito.when(service.findById(ID)).thenReturn(model);
		final UserDTO dtoMock = null;
		Mockito.when(service.transform(model)).thenReturn(dtoMock);
		
		final UserDTO dto = controller.findById(ID);
		Assert.assertNull(dto);
	}
	
	@Test
	public void testUpdate() {
		final UserDTO dto = new UserDTO();
		//For coverage
		controller.update(dto);
	}
	
	@Test
	public void testDelete() {
		final UserDTO dto = new UserDTO();
		//For coverage
		controller.delete(dto);
	}
	
	public List<User> createListOfUsers(){
		final User model1 = new User();
		final User model2 = new User();
		final User model3 = new User();
		final User model4 = new User();
		final User model5 = new User();
		final List<User> models = new ArrayList<>();
		models.add(model1);
		models.add(model2);
		models.add(model3);
		models.add(model4);
		models.add(model5);
		
		return models;
	}
	
	public List<UserDTO> createListOfUsersDTOs(){
		final UserDTO dto1 = new UserDTO();
		final UserDTO dto2 = new UserDTO();
		final UserDTO dto3 = new UserDTO();
		final UserDTO dto4 = new UserDTO();
		final UserDTO dto5 = new UserDTO();
		final List<UserDTO> dtos = new ArrayList<>();
		dtos.add(dto1);
		dtos.add(dto2);
		dtos.add(dto3);
		dtos.add(dto4);
		dtos.add(dto5);
		
		return dtos;
	}


}
