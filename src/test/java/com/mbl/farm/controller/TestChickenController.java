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

import com.mbl.farm.dto.ChickenDTO;
import com.mbl.farm.model.Chicken;
import com.mbl.farm.service.ChickenService;

@RunWith(MockitoJUnitRunner.class)
public class TestChickenController {
	
	private static final Integer PAGE = 0;
	private static final Integer SIZE = 5;
	private static final Integer ID = 1;
	private static final String TYPE = "s";

	@InjectMocks
	private ChickenController chickenController = new ChickenController();

	@Mock
	private ChickenService chickenService;
	
	@Test
	public void testCreateOk() {
		final Chicken chicken = new Chicken();
		chicken.setType(TYPE);
		Mockito.when(chickenService.create(chicken)).thenReturn(chicken);
		final ChickenDTO chickenDTOMock = new ChickenDTO();
		chickenDTOMock.setType(TYPE);
		Mockito.when(chickenService.transform(chicken)).thenReturn(chickenDTOMock);
		Mockito.when(chickenService.transform(chickenDTOMock)).thenReturn(chicken);
		
		final ChickenDTO chickenDTO = chickenController.create(chickenDTOMock);
		Assert.assertNotNull(chickenDTO);
		Assert.assertEquals(chickenDTO, chickenDTOMock);
	}
	
	@Test
	public void testCreateKo() {
		final Chicken chicken = new Chicken();
		chicken.setType(TYPE);
		Mockito.when(chickenService.create(chicken)).thenReturn(chicken);
		final ChickenDTO chickenDTOMock = null;
		Mockito.when(chickenService.transform(chicken)).thenReturn(chickenDTOMock);
		Mockito.when(chickenService.transform(chickenDTOMock)).thenReturn(chicken);
		
		final ChickenDTO chickenDTO = chickenController.create(chickenDTOMock);
		Assert.assertNull(chickenDTO);
	}
	
	@Test
	public void testGetAllOk() {
		final List<Chicken> chickensMock = createListOfChickens();
		final List<ChickenDTO> chickenDTOsMock = createListOfChickenDTOs();
		
		Mockito.when(chickenService.getAll(PAGE, SIZE)).thenReturn(chickensMock);
		Mockito.when(chickenService.transform(chickensMock)).thenReturn(chickenDTOsMock);
		
		final List<ChickenDTO> chickensDTOs = chickenController.getAll(PAGE, SIZE);
		Assert.assertNotNull(chickensDTOs);
		Assert.assertEquals(chickensDTOs, chickenDTOsMock);
		
	}
	
	@Test
	public void testGetAllKo() {
		final List<Chicken> chickensMock = null;
		final List<ChickenDTO> chickensDTOsMock = null;
		
		Mockito.when(chickenService.getAll(PAGE, SIZE)).thenReturn(chickensMock);
		Mockito.when(chickenService.transform(chickensMock)).thenReturn(chickensDTOsMock);
		
		final List<ChickenDTO> animalsDTOs = chickenController.getAll(PAGE, SIZE);
		Assert.assertNull(animalsDTOs);
		
	}
	
	@Test
	public void testFindByIdOk() {
		final Chicken chicken = new Chicken();
		chicken.setIdAnimal(ID);
		Mockito.when(chickenService.findOne(ID)).thenReturn(chicken);
		final ChickenDTO chickenDTOMock = new ChickenDTO();
		chickenDTOMock.setType(TYPE);
		Mockito.when(chickenService.transform(chicken)).thenReturn(chickenDTOMock);
		
		final ChickenDTO chickenDTO = chickenController.findById(ID);
		Assert.assertNotNull(chickenDTO);
		Assert.assertEquals(chickenDTO, chickenDTOMock);
	}
	
	@Test
	public void testFindByIdKo() {
		final Chicken chicken = null;
		Mockito.when(chickenService.findOne(ID)).thenReturn(chicken);
		final ChickenDTO animalDTOMock = null;
		Mockito.when(chickenService.transform(chicken)).thenReturn(animalDTOMock);
		
		final ChickenDTO chickenDTO = chickenController.findById(ID);
		Assert.assertNull(chickenDTO);
	}
	
	@Test
	public void testUpdate() {
		final ChickenDTO dto = new ChickenDTO();
		//For coverage
		chickenController.update(dto);
	}
	
	public List<Chicken> createListOfChickens(){
		final Chicken animal1 = new Chicken();
		final Chicken animal2 = new Chicken();
		final Chicken animal3 = new Chicken();
		final Chicken animal4 = new Chicken();
		final Chicken animal5 = new Chicken();
		final List<Chicken> animals = new ArrayList<>();
		animals.add(animal1);
		animals.add(animal2);
		animals.add(animal3);
		animals.add(animal4);
		animals.add(animal5);
		
		return animals;
	}
	
	public List<ChickenDTO> createListOfChickenDTOs(){
		final ChickenDTO animal1 = new ChickenDTO();
		final ChickenDTO animal2 = new ChickenDTO();
		final ChickenDTO animal3 = new ChickenDTO();
		final ChickenDTO animal4 = new ChickenDTO();
		final ChickenDTO animal5 = new ChickenDTO();
		final List<ChickenDTO> animals = new ArrayList<>();
		animals.add(animal1);
		animals.add(animal2);
		animals.add(animal3);
		animals.add(animal4);
		animals.add(animal5);
		
		return animals;
	}
	
}
