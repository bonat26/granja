package com.mbl.farm.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.mbl.farm.dao.CowDao;
import com.mbl.farm.dto.CowDTO;
import com.mbl.farm.mapper.CowMapper;
import com.mbl.farm.model.Cow;

@RunWith(MockitoJUnitRunner.class)
public class TestCowService {
	private static final Integer PAGE = 0;
	private static final Integer SIZE = 5;
	private static final Integer ID = 1;
	private static final Integer WRONGID = 2;
	private static final String TYPE = "s";
	private static final String WRONGTYPE = "m";

	
	@InjectMocks
	private CowService service = new CowServiceImpl();
	
	@Mock
	private CowDao dao;
	
	@Mock
	private CowMapper mapper;
	

	@Test
	public void testTransformToDtoOk() {
		final Cow model = new Cow();
		model.setType(TYPE);
		final CowDTO dtoMock = new CowDTO();
		dtoMock.setType(TYPE);
		Mockito.when(mapper.toDTO(model)).thenReturn(dtoMock);
		
		final CowDTO dto = service.transform(model);
		Assert.assertNotNull(dto);
		Assert.assertEquals(dto.getType(), TYPE);
	}
	
	@Test
	public void testTransformToDtoKo() {
		final Cow model = new Cow();
		model.setType(TYPE);
		final CowDTO dtoMock = new CowDTO();
		dtoMock.setType(WRONGTYPE);
		Mockito.when(mapper.toDTO(model)).thenReturn(dtoMock);
		
		final CowDTO dto = service.transform(model);
		Assert.assertNotNull(dto);
		Assert.assertNotEquals(dto.getType(), TYPE);
	}
	
	@Test
	public void testTransformToModelOk() {
		final Cow modelMock = new Cow();
		modelMock.setType(TYPE);
		final CowDTO dtoMock = new CowDTO();
		dtoMock.setType(TYPE);
		Mockito.when(mapper.toModel(dtoMock)).thenReturn(modelMock);
		
		final Cow model = service.transform(dtoMock);
		Assert.assertNotNull(model);
		Assert.assertEquals(model.getType(), TYPE);
	}
	
	@Test
	public void testTransformToModelKo() {
		final Cow modelMock = new Cow();
		modelMock.setType(WRONGTYPE);
		final CowDTO dtoMock = new CowDTO();
		dtoMock.setType(TYPE);
		Mockito.when(mapper.toModel(dtoMock)).thenReturn(modelMock);
		
		final Cow model = service.transform(dtoMock);
		Assert.assertNotNull(model);
		Assert.assertNotEquals(model.getType(), TYPE);
	}
	
	@Test
	public void testFindOneOk() {
		final Cow modelMock = new Cow();
		modelMock.setType(TYPE);
		Mockito.when(dao.findOne(ID)).thenReturn(modelMock);
		
		final Cow model = service.findOne(ID);
		Assert.assertNotNull(model);
		Assert.assertEquals(model.getType(), TYPE);
	}
	
	@Test
	public void testFindOneKo() {
		final Cow modelMock = new Cow();
		modelMock.setIdAnimal(WRONGID);
		Mockito.when(dao.findOne(ID)).thenReturn(modelMock);
		
		final Cow model = service.findOne(ID);
		Assert.assertNotNull(model);
		Assert.assertNotEquals(model.getIdAnimal(), ID);
	}
	
	@Test
	public void testCreateOk() {
		final Cow modelMock = new Cow();
		modelMock.setType(TYPE);
		Mockito.when(dao.save(modelMock)).thenReturn(modelMock);
		
		final Cow model = service.create(modelMock);
		Assert.assertNotNull(model);
		Assert.assertEquals(model.getType(), TYPE);
		
	}
	
	@Test
	public void testCreateKo() {
		final Cow modelMock = new Cow();
		modelMock.setType(WRONGTYPE);
		Mockito.when(dao.save(modelMock)).thenReturn(modelMock);
		
		final Cow model = service.create(modelMock);
		Assert.assertNotNull(model);
		Assert.assertNotEquals(model.getType(), TYPE);
		
	}
	
	@Test
	public void testUpdate() {
		//For coverage
		final Cow model = new Cow();
		service.update(model);
	}
}
