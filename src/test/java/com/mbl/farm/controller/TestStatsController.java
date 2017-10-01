package com.mbl.farm.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.mbl.farm.dto.AnimalWinsDTO;
import com.mbl.farm.dto.UserWinsDTO;
import com.mbl.farm.model.Animal;
import com.mbl.farm.model.Chicken;
import com.mbl.farm.model.Cow;
import com.mbl.farm.model.User;
import com.mbl.farm.service.AnimalStatsService;
import com.mbl.farm.service.UserStatsService;

@RunWith(MockitoJUnitRunner.class)
public class TestStatsController {
	
	private static final Integer PAGE = 0;
	private static final Integer SIZE = 5;
	private static final Date STARTDATE = new Date(0);
	private static final Date ENDDATE = new Date(10000000);
	
	@InjectMocks
	private StatsController controller = new StatsController();
	
	@Mock
	private AnimalStatsService animalStatsService;
	
	@Mock
	private UserStatsService userStatsService;
	
	@Test
	public void testTopAnimalsOk() {
		final List<Animal> models = createListOfAnimals();
		final List<AnimalWinsDTO> dtosMock = createListOfAnimalsWinsDTOs();
		
		Mockito.when(animalStatsService.getTopAnimals(SIZE)).thenReturn(models);
		Mockito.when(animalStatsService.transform(models)).thenReturn(dtosMock);
		
		final List<AnimalWinsDTO> dtos = controller.topAnimals(SIZE);
		Assert.assertNotNull(dtos);
		Assert.assertEquals(dtos, dtosMock);
		
	}
	
	@Test
	public void testTopAnimalsKo() {
		final List<Animal> models = null;
		final List<AnimalWinsDTO> dtosMock = null;
		
		Mockito.when(animalStatsService.getTopAnimals(SIZE)).thenReturn(models);
		Mockito.when(animalStatsService.transform(models)).thenReturn(dtosMock);
		
		final List<AnimalWinsDTO> dtos = controller.topAnimals(SIZE);
		Assert.assertNull(dtos);
		
	}
	
	@Test
	public void testUserWinsOk() {
		final List<User> models = createListOfUsers();
		final List<UserWinsDTO> dtosMock = createListOfUsersWinsDTOs();
		
		Mockito.when(userStatsService.getUserWins(PAGE, SIZE, STARTDATE, ENDDATE)).thenReturn(models);
		Mockito.when(userStatsService.transform(models)).thenReturn(dtosMock);
		
		final List<UserWinsDTO> dtos = controller.userWins(PAGE, SIZE, STARTDATE, ENDDATE);
		Assert.assertNotNull(dtos);
		Assert.assertEquals(dtos, dtosMock);
		
	}
	
	@Test
	public void testUserWinsKo() {
		final List<User> models = null;
		final List<UserWinsDTO> dtosMock = null;
		
		Mockito.when(userStatsService.getUserWins(PAGE, SIZE, STARTDATE, ENDDATE)).thenReturn(models);
		Mockito.when(userStatsService.transform(models)).thenReturn(dtosMock);
		
		final List<UserWinsDTO> dtos = controller.userWins(PAGE, SIZE, STARTDATE, ENDDATE);
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
	
	public List<AnimalWinsDTO> createListOfAnimalsWinsDTOs(){
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
	
	public List<UserWinsDTO> createListOfUsersWinsDTOs(){
		final UserWinsDTO dto1 = new UserWinsDTO();
		final UserWinsDTO dto2 = new UserWinsDTO();
		final UserWinsDTO dto3 = new UserWinsDTO();
		final UserWinsDTO dto4 = new UserWinsDTO();
		final UserWinsDTO dto5 = new UserWinsDTO();
		final List<UserWinsDTO> dtos = new ArrayList<>();
		dtos.add(dto1);
		dtos.add(dto2);
		dtos.add(dto3);
		dtos.add(dto4);
		dtos.add(dto5);
		
		return dtos;
	}

}
