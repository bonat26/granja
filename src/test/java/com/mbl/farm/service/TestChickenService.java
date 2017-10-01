package com.mbl.farm.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.mbl.farm.dao.ChickenDao;
import com.mbl.farm.dto.ChickenDTO;
import com.mbl.farm.mapper.ChickenMapper;
import com.mbl.farm.model.Chicken;

@RunWith(MockitoJUnitRunner.class)
public class TestChickenService {
	
	private static final Integer PAGE = 0;
	private static final Integer SIZE = 5;
	private static final Integer ID = 1;
	private static final Integer WRONGID = 2;
	private static final String TYPE = "s";
	private static final String WRONGTYPE = "m";

	
	@InjectMocks
	private ChickenService service = new ChickenServiceImpl();
	
	@Mock
	private ChickenDao dao;
	
	@Mock
	private ChickenMapper mapper;
	

	@Test
	public void testTransformToDtoOk() {
		final Chicken model = new Chicken();
		model.setType(TYPE);
		final ChickenDTO dtoMock = new ChickenDTO();
		dtoMock.setType(TYPE);
		Mockito.when(mapper.toDTO(model)).thenReturn(dtoMock);
		
		final ChickenDTO dto = service.transform(model);
		Assert.assertNotNull(dto);
		Assert.assertEquals(dto.getType(), TYPE);
	}
	
	@Test
	public void testTransformToDtoKo() {
		final Chicken model = new Chicken();
		model.setType(TYPE);
		final ChickenDTO dtoMock = new ChickenDTO();
		dtoMock.setType(WRONGTYPE);
		Mockito.when(mapper.toDTO(model)).thenReturn(dtoMock);
		
		final ChickenDTO dto = service.transform(model);
		Assert.assertNotNull(dto);
		Assert.assertNotEquals(dto.getType(), TYPE);
	}
	
	@Test
	public void testTransformToModelOk() {
		final Chicken modelMock = new Chicken();
		modelMock.setType(TYPE);
		final ChickenDTO dtoMock = new ChickenDTO();
		dtoMock.setType(TYPE);
		Mockito.when(mapper.toModel(dtoMock)).thenReturn(modelMock);
		
		final Chicken model = service.transform(dtoMock);
		Assert.assertNotNull(model);
		Assert.assertEquals(model.getType(), TYPE);
	}
	
	@Test
	public void testTransformToModelKo() {
		final Chicken modelMock = new Chicken();
		modelMock.setType(WRONGTYPE);
		final ChickenDTO dtoMock = new ChickenDTO();
		dtoMock.setType(TYPE);
		Mockito.when(mapper.toModel(dtoMock)).thenReturn(modelMock);
		
		final Chicken model = service.transform(dtoMock);
		Assert.assertNotNull(model);
		Assert.assertNotEquals(model.getType(), TYPE);
	}
	
	@Test
	public void testFindOneOk() {
		final Chicken modelMock = new Chicken();
		modelMock.setType(TYPE);
		Mockito.when(dao.findOne(ID)).thenReturn(modelMock);
		
		final Chicken model = service.findOne(ID);
		Assert.assertNotNull(model);
		Assert.assertEquals(model.getType(), TYPE);
	}
	
	@Test
	public void testFindOneKo() {
		final Chicken modelMock = new Chicken();
		modelMock.setIdAnimal(WRONGID);
		Mockito.when(dao.findOne(ID)).thenReturn(modelMock);
		
		final Chicken model = service.findOne(ID);
		Assert.assertNotNull(model);
		Assert.assertNotEquals(model.getIdAnimal(), ID);
	}
	
	@Test
	public void testCreateOk() {
		final Chicken modelMock = new Chicken();
		modelMock.setType(TYPE);
		Mockito.when(dao.save(modelMock)).thenReturn(modelMock);
		
		final Chicken model = service.create(modelMock);
		Assert.assertNotNull(model);
		Assert.assertEquals(model.getType(), TYPE);
		
	}
	
	@Test
	public void testCreateKo() {
		final Chicken modelMock = new Chicken();
		modelMock.setType(WRONGTYPE);
		Mockito.when(dao.save(modelMock)).thenReturn(modelMock);
		
		final Chicken model = service.create(modelMock);
		Assert.assertNotNull(model);
		Assert.assertNotEquals(model.getType(), TYPE);
		
	}
	
	@Test
	public void testUpdate() {
		//For coverage
		final Chicken model = new Chicken();
		service.update(model);
	}
	
	
}
