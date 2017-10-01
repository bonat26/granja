package com.mbl.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.mbl.farm.dao.AnimalStatsDao;
import com.mbl.farm.dto.AnimalWinsDTO;
import com.mbl.farm.mapper.AnimalWinsMapper;
import com.mbl.farm.model.Animal;
import com.mbl.farm.model.Chicken;
import com.mbl.farm.model.Cow;

@RunWith(MockitoJUnitRunner.class)
public class TestAnimalStatsService {
	
	private static final String TYPE = "s";
	private static final String WRONGTYPE = "m";
	private static final Integer SIZE = 5;
	private static final Integer WRONGSIZE = 3;
	
	
	@InjectMocks
	private AnimalStatsService service = new AnimalStatsServiceImpl();
	
	@Mock
	private AnimalStatsDao dao;
	
	@Mock
	private AnimalWinsMapper mapper;
	
	@Test
	public void testTransformOk() {
		final Animal model = new Chicken();
		model.setType(TYPE);
		final AnimalWinsDTO dtoMock = new AnimalWinsDTO();
		dtoMock.setType(TYPE);
		Mockito.when(mapper.toDTO(model)).thenReturn(dtoMock);
		
		final AnimalWinsDTO dto = service.transform(model);
		Assert.assertNotNull(dto);
		Assert.assertEquals(dto.getType(), TYPE);
	}
	
	@Test
	public void testTransformKo() {
		final Animal model = new Chicken();
		model.setType(TYPE);
		final AnimalWinsDTO dtoMock = new AnimalWinsDTO();
		dtoMock.setType(WRONGTYPE);
		Mockito.when(mapper.toDTO(model)).thenReturn(dtoMock);
		
		final AnimalWinsDTO dto = service.transform(model);
		Assert.assertNotNull(dto);
		Assert.assertNotEquals(dto.getType(), TYPE);
	}
	
	@Test
	public void testGetTopAnimalsOk() {
		List <Animal> modelsMocks = createListOfAnimals();
		Mockito.when(dao.findTopAnimals()).thenReturn(modelsMocks);
		
		List<Animal> models = service.getTopAnimals(SIZE);
		Assert.assertNotNull(models);
		Assert.assertEquals((Integer)models.size(), SIZE);
	}
	
	@Test
	public void testGetTopAnimalsKo() {
		List <Animal> modelsMocks = createListOfAnimals();
		Mockito.when(dao.findTopAnimals()).thenReturn(modelsMocks);
		
		List<Animal> models = service.getTopAnimals(WRONGSIZE);
		Assert.assertNotNull(models);
		Assert.assertNotEquals((Integer)models.size(), SIZE);
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
	
	public List<AnimalWinsDTO> createListOfAnimalWinsDTO(){
		final AnimalWinsDTO animal1 = new AnimalWinsDTO();
		final AnimalWinsDTO animal2 = new AnimalWinsDTO();
		final AnimalWinsDTO animal3 = new AnimalWinsDTO();
		final AnimalWinsDTO animal4 = new AnimalWinsDTO();
		final AnimalWinsDTO animal5 = new AnimalWinsDTO();
		final List<AnimalWinsDTO> animals = new ArrayList<>();
		animals.add(animal1);
		animals.add(animal2);
		animals.add(animal3);
		animals.add(animal4);
		animals.add(animal5);
		
		return animals;
	}
}
