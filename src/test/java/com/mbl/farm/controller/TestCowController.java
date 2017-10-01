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

import com.mbl.farm.dto.CowDTO;
import com.mbl.farm.model.Cow;
import com.mbl.farm.service.CowService;

@RunWith(MockitoJUnitRunner.class)
public class TestCowController {
	
	private static final Integer PAGE = 0;
	private static final Integer SIZE = 5;
	private static final Integer ID = 1;
	private static final String TYPE = "s";
	
	@InjectMocks
	private CowController controller = new CowController();
	
	@Mock
	private CowService service;
	
	@Test
	public void testCreateOk() {
		final Cow model = new Cow();
		model.setType(TYPE);
		Mockito.when(service.create(model)).thenReturn(model);
		final CowDTO dtoMock = new CowDTO();
		dtoMock.setType(TYPE);
		Mockito.when(service.transform(model)).thenReturn(dtoMock);
		Mockito.when(service.transform(dtoMock)).thenReturn(model);
		
		final CowDTO dto = controller.create(dtoMock);
		Assert.assertNotNull(dto);
		Assert.assertEquals(dto, dtoMock);
	}
	
	@Test
	public void testCreateKo() {
		final Cow model = new Cow();
		model.setType(TYPE);
		Mockito.when(service.create(model)).thenReturn(model);
		final CowDTO dtoMock = null;
		Mockito.when(service.transform(model)).thenReturn(dtoMock);
		Mockito.when(service.transform(dtoMock)).thenReturn(model);
		
		final CowDTO dto = controller.create(dtoMock);
		Assert.assertNull(dto);
	}
	
	@Test
	public void testGetAllOk() {
		final List<Cow> chickensMock = createListOfCows();
		final List<CowDTO> dtosMock = createListOfCowsDTOs();
		
		Mockito.when(service.getAll(PAGE, SIZE)).thenReturn(chickensMock);
		Mockito.when(service.transform(chickensMock)).thenReturn(dtosMock);
		
		final List<CowDTO> dtos = controller.getAll(PAGE, SIZE);
		Assert.assertNotNull(dtos);
		Assert.assertEquals(dtos, dtosMock);
		
	}
	
	@Test
	public void testGetAllKo() {
		final List<Cow> chickensMock = null;
		final List<CowDTO> chickensDTOsMock = null;
		
		Mockito.when(service.getAll(PAGE, SIZE)).thenReturn(chickensMock);
		Mockito.when(service.transform(chickensMock)).thenReturn(chickensDTOsMock);
		
		final List<CowDTO> dtos = controller.getAll(PAGE, SIZE);
		Assert.assertNull(dtos);
		
	}
	
	@Test
	public void testFindByIdOk() {
		final Cow model = new Cow();
		model.setIdAnimal(ID);
		Mockito.when(service.findOne(ID)).thenReturn(model);
		final CowDTO dtoMock = new CowDTO();
		dtoMock.setType(TYPE);
		Mockito.when(service.transform(model)).thenReturn(dtoMock);
		
		final CowDTO dto = controller.findById(ID);
		Assert.assertNotNull(dto);
		Assert.assertEquals(dto, dtoMock);
	}
	
	@Test
	public void testFindByIdKo() {
		final Cow model = null;
		Mockito.when(service.findOne(ID)).thenReturn(model);
		final CowDTO dtoMock = null;
		Mockito.when(service.transform(model)).thenReturn(dtoMock);
		
		final CowDTO dto = controller.findById(ID);
		Assert.assertNull(dto);
	}
	
	@Test
	public void testUpdate() {
		final CowDTO dto = new CowDTO();
		//For coverage
		controller.update(dto);
	}
	
	public List<Cow> createListOfCows(){
		final Cow animal1 = new Cow();
		final Cow animal2 = new Cow();
		final Cow animal3 = new Cow();
		final Cow animal4 = new Cow();
		final Cow animal5 = new Cow();
		final List<Cow> animals = new ArrayList<>();
		animals.add(animal1);
		animals.add(animal2);
		animals.add(animal3);
		animals.add(animal4);
		animals.add(animal5);
		
		return animals;
	}
	
	public List<CowDTO> createListOfCowsDTOs(){
		final CowDTO animal1 = new CowDTO();
		final CowDTO animal2 = new CowDTO();
		final CowDTO animal3 = new CowDTO();
		final CowDTO animal4 = new CowDTO();
		final CowDTO animal5 = new CowDTO();
		final List<CowDTO> animals = new ArrayList<>();
		animals.add(animal1);
		animals.add(animal2);
		animals.add(animal3);
		animals.add(animal4);
		animals.add(animal5);
		
		return animals;
	}
}
