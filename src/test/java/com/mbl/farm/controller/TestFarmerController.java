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

import com.mbl.farm.dto.AnimalDTO;
import com.mbl.farm.dto.ChickenDTO;
import com.mbl.farm.dto.CowDTO;
import com.mbl.farm.model.Animal;
import com.mbl.farm.model.Chicken;
import com.mbl.farm.model.Cow;
import com.mbl.farm.service.FarmerService;

@RunWith(MockitoJUnitRunner.class)
public class TestFarmerController {
	
	private static final Integer ID = 1;
	private static final String TYPE = "s";
	
	@InjectMocks
	private FarmerController controller = new FarmerController();
	
	@Mock
	private FarmerService service;
	
	@Test
	public void testCreateChickenOk() {
		final Chicken model = new Chicken();
		model.setType(TYPE);
		Mockito.when(service.create(ID, model)).thenReturn(model);
		final ChickenDTO dtoMock = new ChickenDTO();
		dtoMock.setType(TYPE);
		Mockito.when(service.transform(model)).thenReturn(dtoMock);
		Mockito.when(service.transform(dtoMock)).thenReturn(model);
		
		final ChickenDTO dto = controller.createChicken(ID, dtoMock);
		Assert.assertNotNull(dto);
		Assert.assertEquals(dto, dtoMock);
	}
	
	@Test
	public void testCreateChickenKo() {
		final Chicken model = new Chicken();
		model.setType(TYPE);
		Mockito.when(service.create(ID, model)).thenReturn(model);
		final ChickenDTO dtoMock = null;
		Mockito.when(service.transform(model)).thenReturn(dtoMock);
		Mockito.when(service.transform(dtoMock)).thenReturn(model);
		
		final ChickenDTO chickenDTO = controller.createChicken(ID,dtoMock);
		Assert.assertNull(chickenDTO);
	}
	
	@Test
	public void testCreateCowOk() {
		final Cow model = new Cow();
		model.setType(TYPE);
		Mockito.when(service.create(ID, model)).thenReturn(model);
		final CowDTO dtoMock = new CowDTO();
		dtoMock.setType(TYPE);
		Mockito.when(service.transform(model)).thenReturn(dtoMock);
		Mockito.when(service.transform(dtoMock)).thenReturn(model);
		
		final CowDTO dto = controller.createCow(ID, dtoMock);
		Assert.assertNotNull(dto);
		Assert.assertEquals(dto, dtoMock);
	}
	
	@Test
	public void testCreateCowKo() {
		final Cow model = new Cow();
		model.setType(TYPE);
		Mockito.when(service.create(ID, model)).thenReturn(model);
		final CowDTO dtoMock = null;
		Mockito.when(service.transform(model)).thenReturn(dtoMock);
		Mockito.when(service.transform(dtoMock)).thenReturn(model);
		
		final CowDTO chickenDTO = controller.createCow(ID,dtoMock);
		Assert.assertNull(chickenDTO);
	}
	
	@Test
	public void testGetAllOk() {
		final List<Animal> models = createListOfAnimals();
		final List<AnimalDTO> dtosMocks = createListOfAnimalsDTOs();
		
		Mockito.when(service.getAll(ID)).thenReturn(models);
		Mockito.when(service.transform(models)).thenReturn(dtosMocks);
		
		final List<AnimalDTO> dtos = controller.getAnimals(ID);
		Assert.assertNotNull(dtos);
		Assert.assertEquals(dtos, dtosMocks);
		
	}
	
	@Test
	public void testGetAllKo() {
		final List<Animal> models = null;
		final List<AnimalDTO> dtosMocks = null;
		
		Mockito.when(service.getAll(ID)).thenReturn(models);
		Mockito.when(service.transform(models)).thenReturn(dtosMocks);
		
		final List<AnimalDTO> dtos = controller.getAnimals(ID);
		Assert.assertNull(dtos);
		
	}
	
	public List<Animal> createListOfAnimals(){
		final Animal animal1 = new Chicken();
		final Animal animal2 = new Chicken();
		final Animal animal3 = new Cow();
		final Animal animal4 = new Chicken();
		final Animal animal5 = new Cow();
		final List<Animal> animals = new ArrayList<>();
		animals.add(animal1);
		animals.add(animal2);
		animals.add(animal3);
		animals.add(animal4);
		animals.add(animal5);
		
		return animals;
	}
	
	public List<AnimalDTO> createListOfAnimalsDTOs(){
		final AnimalDTO animal1 = new AnimalDTO();
		final AnimalDTO animal2 = new AnimalDTO();
		final AnimalDTO animal3 = new AnimalDTO();
		final AnimalDTO animal4 = new AnimalDTO();
		final AnimalDTO animal5 = new AnimalDTO();
		final List<AnimalDTO> animals = new ArrayList<>();
		animals.add(animal1);
		animals.add(animal2);
		animals.add(animal3);
		animals.add(animal4);
		animals.add(animal5);
		
		return animals;
	}
	
	
}
