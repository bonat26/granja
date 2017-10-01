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
import com.mbl.farm.dao.AnimalDao;
import com.mbl.farm.dto.AnimalDTO;
import com.mbl.farm.mapper.AnimalMapper;
import com.mbl.farm.model.Animal;
import com.mbl.farm.model.Chicken;
import com.mbl.farm.model.Cow;

@RunWith(MockitoJUnitRunner.class)
public class TestAnimalService {
	
	private static final Integer PAGE = 0;
	private static final Integer SIZE = 5;
	private static final Integer ID = 1;
	private static final Integer WRONGID = 2;
	private static final String TYPE = "s";
	private static final String WRONGTYPE = "m";
	
	@InjectMocks
	private AnimalService service = new AnimalServiceImpl();
	
	@Mock
	private AnimalDao dao;
	
	@Mock
	private AnimalMapper mapper;
	
	@Test
	public void testTransformToDtoOk() {
		final Animal model = new Chicken();
		model.setType(TYPE);
		final AnimalDTO dtoMock = new AnimalDTO();
		dtoMock.setType(TYPE);
		Mockito.when(mapper.toDTO(model)).thenReturn(dtoMock);
		
		final AnimalDTO dto = service.transform(model);
		Assert.assertNotNull(dto);
		Assert.assertEquals(dto.getType(), TYPE);
	}
	
	@Test
	public void testTransformToDtoKo() {
		final Animal model = new Chicken();
		model.setType(TYPE);
		final AnimalDTO dtoMock = new AnimalDTO();
		dtoMock.setType(WRONGTYPE);
		Mockito.when(mapper.toDTO(model)).thenReturn(dtoMock);
		
		final AnimalDTO dto = service.transform(model);
		Assert.assertNotNull(dto);
		Assert.assertNotEquals(dto.getType(), TYPE);
	}
	
	@Test
	public void testTransformToModelOk() {
		final Animal modelMock = new Chicken();
		modelMock.setType(TYPE);
		final AnimalDTO dtoMock = new AnimalDTO();
		dtoMock.setType(TYPE);
		Mockito.when(mapper.toModel(dtoMock)).thenReturn(modelMock);
		
		final Animal model = service.transform(dtoMock);
		Assert.assertNotNull(model);
		Assert.assertEquals(model.getType(), TYPE);
	}
	
	@Test
	public void testTransformToModelKo() {
		final Animal modelMock = new Chicken();
		modelMock.setType(WRONGTYPE);
		final AnimalDTO dtoMock = new AnimalDTO();
		dtoMock.setType(TYPE);
		Mockito.when(mapper.toModel(dtoMock)).thenReturn(modelMock);
		
		final Animal model = service.transform(dtoMock);
		Assert.assertNotNull(model);
		Assert.assertNotEquals(model.getType(), TYPE);
	}
	
	@Test
	public void testFindByIdOk() {
		final Animal modelMock = new Chicken();
		modelMock.setType(TYPE);
		Mockito.when(dao.findOne(ID)).thenReturn(modelMock);
		
		final Animal model = service.findById(ID);
		Assert.assertNotNull(model);
		Assert.assertEquals(model.getType(), TYPE);
	}
	
	@Test
	public void testFindByIdKo() {
		final Animal modelMock = new Chicken();
		modelMock.setIdAnimal(WRONGID);
		Mockito.when(dao.findOne(ID)).thenReturn(modelMock);
		
		final Animal model = service.findById(ID);
		Assert.assertNotNull(model);
		Assert.assertNotEquals(model.getIdAnimal(), ID);
	}
	
	@Test
	public void testGetTopAnimals() {
		//For coverage
		service.getTopAnimals(SIZE);
	}
	
	@Test
	public void testTransformListOk() {
		final Animal model = new Chicken();
		final AnimalDTO dtoMock = new AnimalDTO();
		final List<Animal> models = createListOfAnimals();
		final List<AnimalDTO> dtosMocks = createListOfAnimalsDTOs();
		Mockito.when(service.transform(model)).thenReturn(dtoMock);
		
		final List<AnimalDTO> dtos = service.transform(models);
		Assert.assertNotNull(dtos);
		Assert.assertEquals(dtos, dtosMocks);
	}
	
	@Test
	public void testTransformListKo() {
		final Animal model = new Chicken();
		final AnimalDTO dtoMock = new AnimalDTO();
		final List<Animal> models = createListOfAnimals();
		final List<AnimalDTO> dtosMocks = createListOfAnimalsDTOs();
		dtosMocks.remove(0);
		Mockito.when(service.transform(model)).thenReturn(dtoMock);
		
		final List<AnimalDTO> dtos = service.transform(models);
		Assert.assertNotNull(dtos);
		Assert.assertNotEquals(dtos, dtosMocks);
	}
	
	@Test
	public void testUpdate() {
		//For coverage
		final Animal model = new Chicken();
		service.update(model);
	}
	
	
	public List<Animal> createListOfAnimals(){
		final Animal animal1 = new Chicken();
		final Animal animal2 = new Chicken();
		final Animal animal3 = new Chicken();
		final Animal animal4 = new Chicken();
		final Animal animal5 = new Chicken();
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
