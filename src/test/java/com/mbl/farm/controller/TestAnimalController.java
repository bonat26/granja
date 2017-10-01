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
import com.mbl.farm.model.Animal;
import com.mbl.farm.model.Chicken;
import com.mbl.farm.model.Cow;
import com.mbl.farm.service.AnimalService;

@RunWith(MockitoJUnitRunner.class)
public class TestAnimalController {
	
	private static final Integer PAGE = 0;
	private static final Integer SIZE = 5;
	private static final Integer ID = 1;
	private static final String TYPE = "s";
	private static final String SPECIES = Chicken.class.getSimpleName();
	private static final String WRONGSPECIES = Cow.class.getSimpleName();
	
	@InjectMocks
	private AnimalController animalController = new AnimalController();
	
	@Mock
	private AnimalService animalService;
	
	@Test
	public void testGetAllOk() {
		final List<Animal> animalsMock = createListOfAnimals();
		final List<AnimalDTO> animalsDTOsMock = createListOfAnimalsDTOs();
		
		Mockito.when(animalService.getAll(PAGE, SIZE)).thenReturn(animalsMock);
		Mockito.when(animalService.transform(animalsMock)).thenReturn(animalsDTOsMock);
		
		final List<AnimalDTO> animalsDTOs = animalController.getAll(PAGE, SIZE);
		Assert.assertNotNull(animalsDTOs);
		Assert.assertEquals(animalsDTOs, animalsDTOsMock);
		
	}
	
	@Test
	public void testGetAllKo() {
		final List<Animal> animalsMock = null;
		final List<AnimalDTO> animalsDTOsMock = null;
		
		Mockito.when(animalService.getAll(PAGE, SIZE)).thenReturn(animalsMock);
		Mockito.when(animalService.transform(animalsMock)).thenReturn(animalsDTOsMock);
		
		final List<AnimalDTO> animalsDTOs = animalController.getAll(PAGE, SIZE);
		Assert.assertNull(animalsDTOs);
		
	}
	
	@Test
	public void testFindByIdOk() {
		final Animal animal = new Chicken();
		animal.setIdAnimal(ID);
		Mockito.when(animalService.findById(ID)).thenReturn(animal);
		final AnimalDTO animalDTOMock = new AnimalDTO();
		animalDTOMock.setType(TYPE);
		animalDTOMock.setSpecies(SPECIES);
		Mockito.when(animalService.transform(animal)).thenReturn(animalDTOMock);
		
		final AnimalDTO animalDTO = animalController.findById(ID);
		Assert.assertNotNull(animalDTO);
		Assert.assertEquals(animalDTO, animalDTOMock);
	}
	
	@Test
	public void testFindByIdKo() {
		final Animal animal = null;
		Mockito.when(animalService.findById(ID)).thenReturn(animal);
		final AnimalDTO animalDTOMock = null;
		Mockito.when(animalService.transform(animal)).thenReturn(animalDTOMock);
		
		final AnimalDTO animalDTO = animalController.findById(ID);
		Assert.assertNull(animalDTO);
	}
	
	@Test
	public void testFindByIdWrongSpecies() {
		final Animal animal = new Chicken();
		animal.setIdAnimal(ID);
		Mockito.when(animalService.findById(ID)).thenReturn(animal);
		final AnimalDTO animalDTOMock = new AnimalDTO();
		animalDTOMock.setType(TYPE);
		animalDTOMock.setSpecies(WRONGSPECIES);
		Mockito.when(animalService.transform(animal)).thenReturn(animalDTOMock);
		
		final AnimalDTO animalDTO = animalController.findById(ID);
		Assert.assertNotNull(animalDTO);
		Assert.assertEquals(animalDTO, animalDTOMock);
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
