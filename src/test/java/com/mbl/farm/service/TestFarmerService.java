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
import com.mbl.farm.dao.FarmerDao;
import com.mbl.farm.dto.AnimalDTO;
import com.mbl.farm.dto.ChickenDTO;
import com.mbl.farm.dto.CowDTO;
import com.mbl.farm.mapper.ChickenMapper;
import com.mbl.farm.mapper.CowMapper;
import com.mbl.farm.model.Animal;
import com.mbl.farm.model.Chicken;
import com.mbl.farm.model.Cow;

@RunWith(MockitoJUnitRunner.class)
public class TestFarmerService {
	
	private static final Integer ID = 1;
	private static final Integer WRONGID = 2;
	private static final String TYPE = "s";
	private static final String WRONGTYPE = "m";
	
	@InjectMocks
	private FarmerService service = new FarmerServiceImpl(); 
 	
	@Mock
	private FarmerDao farmerDao;
	
	@Mock
	private UserService userService;

	@Mock
	private AnimalService animalService;
	
	@Mock
	private ChickenService chickenService;
	
	@Mock
	private CowService cowService;
	
	@Mock
	private ChickenMapper chickenMapper;
	
	@Mock
	private CowMapper cowMapper;
	
	@Test
	public void testTransformChickenToDtoOk() {
		final Chicken model = new Chicken();
		model.setType(TYPE);
		final ChickenDTO dtoMock = new ChickenDTO();
		dtoMock.setType(TYPE);
		Mockito.when(chickenMapper.toDTO(model)).thenReturn(dtoMock);
		
		final ChickenDTO dto = service.transform(model);
		Assert.assertNotNull(dto);
		Assert.assertEquals(dto.getType(), TYPE);
	}
	
	@Test
	public void testTransformChickenToDtoKo() {
		final Chicken model = new Chicken();
		model.setType(TYPE);
		final ChickenDTO dtoMock = new ChickenDTO();
		dtoMock.setType(WRONGTYPE);
		Mockito.when(chickenMapper.toDTO(model)).thenReturn(dtoMock);
		
		final ChickenDTO dto = service.transform(model);
		Assert.assertNotNull(dto);
		Assert.assertNotEquals(dto.getType(), TYPE);
	}
	
	@Test
	public void testTransformChickenToModelOk() {
		final Chicken modelMock = new Chicken();
		modelMock.setType(TYPE);
		final ChickenDTO dtoMock = new ChickenDTO();
		dtoMock.setType(TYPE);
		Mockito.when(chickenMapper.toModel(dtoMock)).thenReturn(modelMock);
		
		final Chicken model = service.transform(dtoMock);
		Assert.assertNotNull(model);
		Assert.assertEquals(model.getType(), TYPE);
	}
	
	@Test
	public void testTransformChickenToModelKo() {
		final Chicken modelMock = new Chicken();
		modelMock.setType(WRONGTYPE);
		final ChickenDTO dtoMock = new ChickenDTO();
		dtoMock.setType(TYPE);
		Mockito.when(chickenMapper.toModel(dtoMock)).thenReturn(modelMock);
		
		final Chicken model = service.transform(dtoMock);
		Assert.assertNotNull(model);
		Assert.assertNotEquals(model.getType(), TYPE);
	}
	
	@Test
	public void testCreateChickenOk() {
		final Chicken modelMock = new Chicken();
		modelMock.setType(TYPE);
		Mockito.when(chickenService.create(modelMock)).thenReturn(modelMock);
		
		final Chicken model = service.create(ID, modelMock);
		Assert.assertNotNull(model);
		Assert.assertEquals(model.getType(), TYPE);
		
	}
	
	@Test
	public void testCreateChickenKo() {
		final Chicken modelMock = new Chicken();
		modelMock.setType(WRONGTYPE);
		Mockito.when(chickenService.create(modelMock)).thenReturn(modelMock);
		
		final Chicken model = service.create(ID, modelMock);
		Assert.assertNotNull(model);
		Assert.assertNotEquals(model.getType(), TYPE);
		
	}
	
	@Test
	public void testTransformCowToDtoOk() {
		final Cow model = new Cow();
		model.setType(TYPE);
		final CowDTO dtoMock = new CowDTO();
		dtoMock.setType(TYPE);
		Mockito.when(cowMapper.toDTO(model)).thenReturn(dtoMock);
		
		final CowDTO dto = service.transform(model);
		Assert.assertNotNull(dto);
		Assert.assertEquals(dto.getType(), TYPE);
	}
	
	@Test
	public void testTransformCowToDtoKo() {
		final Cow model = new Cow();
		model.setType(TYPE);
		final CowDTO dtoMock = new CowDTO();
		dtoMock.setType(WRONGTYPE);
		Mockito.when(cowMapper.toDTO(model)).thenReturn(dtoMock);
		
		final CowDTO dto = service.transform(model);
		Assert.assertNotNull(dto);
		Assert.assertNotEquals(dto.getType(), TYPE);
	}
	
	@Test
	public void testTransformCowToModelOk() {
		final Cow modelMock = new Cow();
		modelMock.setType(TYPE);
		final CowDTO dtoMock = new CowDTO();
		dtoMock.setType(TYPE);
		Mockito.when(cowMapper.toModel(dtoMock)).thenReturn(modelMock);
		
		final Cow model = service.transform(dtoMock);
		Assert.assertNotNull(model);
		Assert.assertEquals(model.getType(), TYPE);
	}
	
	@Test
	public void testTransformCowToModelKo() {
		final Cow modelMock = new Cow();
		modelMock.setType(WRONGTYPE);
		final CowDTO dtoMock = new CowDTO();
		dtoMock.setType(TYPE);
		Mockito.when(cowMapper.toModel(dtoMock)).thenReturn(modelMock);
		
		final Cow model = service.transform(dtoMock);
		Assert.assertNotNull(model);
		Assert.assertNotEquals(model.getType(), TYPE);
	}
	
	@Test
	public void testCreateCowOk() {
		final Cow modelMock = new Cow();
		modelMock.setType(TYPE);
		Mockito.when(cowService.create(modelMock)).thenReturn(modelMock);
		
		final Cow model = service.create(ID, modelMock);
		Assert.assertNotNull(model);
		Assert.assertEquals(model.getType(), TYPE);
		
	}
	
	@Test
	public void testCreateCowKo() {
		final Cow modelMock = new Cow();
		modelMock.setType(WRONGTYPE);
		Mockito.when(cowService.create(modelMock)).thenReturn(modelMock);
		
		final Cow model = service.create(ID, modelMock);
		Assert.assertNotNull(model);
		Assert.assertNotEquals(model.getType(), TYPE);
		
	}
	
	@Test
	public void testTransformListOk() {
		final List<Animal> models = createListOfAnimals();
		final List<AnimalDTO> dtosMocks = createListOfAnimalsDTOs();
		Mockito.when(animalService.transform(models)).thenReturn(dtosMocks);
		
		final List<AnimalDTO> dtos = service.transform(models);
		Assert.assertNotNull(dtos);
		Assert.assertEquals(dtos, dtosMocks);
	}
	
	@Test
	public void testTransformListKo() {
		final List<Animal> models = createListOfAnimals();
		final List<AnimalDTO> dtosMocks = createListOfAnimalsDTOs();
		final List<AnimalDTO> wrongDtosMocks = createListOfAnimalsDTOs();
		wrongDtosMocks.remove(0);
		Mockito.when(animalService.transform(models)).thenReturn(dtosMocks);
		
		final List<AnimalDTO> dtos = service.transform(models);
		Assert.assertNotNull(dtos);
		Assert.assertNotEquals(dtos, wrongDtosMocks);
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
