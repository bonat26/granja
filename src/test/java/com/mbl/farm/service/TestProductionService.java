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
import com.mbl.farm.dao.ProductionDao;
import com.mbl.farm.dto.ProductionDTO;
import com.mbl.farm.mapper.ProductionMapper;
import com.mbl.farm.model.Production;

@RunWith(MockitoJUnitRunner.class)
public class TestProductionService {

	private static final Integer ID = 1;
	private static final Integer WRONGID = 2;
	private static final Integer BUYPRICE = 5;
	private static final Integer SELLPRICE = 10;
	private static final Integer WRONGBUYPRICE = 0;
	private static final Integer WRONGSELLPRICE = 0;
	
	@InjectMocks
	private ProductionService service = new ProductionServiceImpl();
	
	@Mock
	private ProductionDao dao;
	
	@Mock
	private ProductionMapper mapper;
	
	@Test
	public void testTransformToDtoOk() {
		final Production model = new Production();
		model.setBuyPrice(BUYPRICE);
		model.setSellPrice(SELLPRICE);
		final ProductionDTO dtoMock = new ProductionDTO();
		dtoMock.setBuyPrice(BUYPRICE);
		dtoMock.setSellPrice(SELLPRICE);
		Mockito.when(mapper.toDTO(model)).thenReturn(dtoMock);
		
		final ProductionDTO dto = service.transform(model);
		Assert.assertNotNull(dto);
		Assert.assertEquals(dto.getBuyPrice(), BUYPRICE);
		Assert.assertEquals(dto.getSellPrice(), SELLPRICE);
	}
	
	@Test
	public void testTransformToDtoKo() {
		final Production model = new Production();
		model.setBuyPrice(BUYPRICE);
		model.setSellPrice(SELLPRICE);
		final ProductionDTO dtoMock = new ProductionDTO();
		dtoMock.setBuyPrice(WRONGBUYPRICE);
		dtoMock.setSellPrice(WRONGSELLPRICE);
		Mockito.when(mapper.toDTO(model)).thenReturn(dtoMock);
		
		final ProductionDTO dto = service.transform(model);
		Assert.assertNotNull(dto);
		Assert.assertNotEquals(dto.getBuyPrice(), BUYPRICE);
		Assert.assertNotEquals(dto.getSellPrice(), SELLPRICE);
	}
	
	@Test
	public void testTransformToModelOk() {
		final Production modelMock = new Production();
		modelMock.setBuyPrice(BUYPRICE);
		modelMock.setSellPrice(SELLPRICE);
		final ProductionDTO dtoMock = new ProductionDTO();
		dtoMock.setBuyPrice(BUYPRICE);
		dtoMock.setSellPrice(SELLPRICE);
		Mockito.when(mapper.toModel(dtoMock)).thenReturn(modelMock);
		
		final Production model = service.transform(dtoMock);
		Assert.assertNotNull(model);
		Assert.assertEquals(model.getBuyPrice(), BUYPRICE);
		Assert.assertEquals(model.getSellPrice(), SELLPRICE);
	}
	
	@Test
	public void testTransformToModelKo() {
		final Production modelMock = new Production();
		modelMock.setBuyPrice(WRONGBUYPRICE);
		modelMock.setSellPrice(WRONGSELLPRICE);
		final ProductionDTO dtoMock = new ProductionDTO();
		dtoMock.setBuyPrice(BUYPRICE);
		dtoMock.setSellPrice(SELLPRICE);
		Mockito.when(mapper.toModel(dtoMock)).thenReturn(modelMock);
		
		final Production model = service.transform(dtoMock);
		Assert.assertNotNull(model);
		Assert.assertNotEquals(model.getBuyPrice(), BUYPRICE);
		Assert.assertNotEquals(model.getSellPrice(), SELLPRICE);
	}
	
	@Test
	public void testFindOneOk() {
		final Production modelMock = new Production();
		modelMock.setIdProduction(ID);
		modelMock.setBuyPrice(BUYPRICE);
		modelMock.setSellPrice(SELLPRICE);
		Mockito.when(dao.findOne(ID)).thenReturn(modelMock);
		
		final Production model = service.findById(ID);
		Assert.assertNotNull(model);
		Assert.assertEquals(model.getBuyPrice(), BUYPRICE);
		Assert.assertEquals(model.getSellPrice(), SELLPRICE);
	}
	
	@Test
	public void testFindOneKo() {
		final Production modelMock = new Production();
		modelMock.setIdProduction(WRONGID);
		Mockito.when(dao.findOne(ID)).thenReturn(modelMock);
		
		final Production model = service.findById(ID);
		Assert.assertNotNull(model);
		Assert.assertNotEquals(model.getIdProduction(), ID);
	}
	
	@Test
	public void testCreateOk() {
		final Production modelMock = new Production();
		modelMock.setBuyPrice(BUYPRICE);
		modelMock.setSellPrice(SELLPRICE);
		Mockito.when(dao.save(modelMock)).thenReturn(modelMock);
		
		final Production model = service.create(modelMock);
		Assert.assertNotNull(model);
		Assert.assertEquals(model.getBuyPrice(), BUYPRICE);
		Assert.assertEquals(model.getSellPrice(), SELLPRICE);
		
	}
	
	@Test
	public void testCreateKo() {
		final Production modelMock = new Production();
		modelMock.setBuyPrice(WRONGBUYPRICE);
		modelMock.setSellPrice(WRONGSELLPRICE);
		Mockito.when(dao.save(modelMock)).thenReturn(modelMock);
		
		final Production model = service.create(modelMock);
		Assert.assertNotNull(model);
		Assert.assertNotEquals(model.getBuyPrice(), BUYPRICE);
		Assert.assertNotEquals(model.getSellPrice(), SELLPRICE);
		
	}
	
	@Test
	public void testTransformListOk() {
		final Production model = new Production();
		final ProductionDTO dtoMock = new ProductionDTO();
		final List<Production> models = createListOfProductions();
		final List<ProductionDTO> dtosMocks = createListOfProductionsDTOs();
		Mockito.when(service.transform(model)).thenReturn(dtoMock);
		
		final List<ProductionDTO> dtos = service.transform(models);
		Assert.assertNotNull(dtos);
		Assert.assertEquals(dtos, dtosMocks);
	}
	
	@Test
	public void testTransformListKo() {
		final Production model = new Production();
		final ProductionDTO dtoMock = new ProductionDTO();
		final List<Production> models = createListOfProductions();
		final List<ProductionDTO> wrongDtosMocks = createListOfProductionsDTOs();
		wrongDtosMocks.remove(0);
		Mockito.when(service.transform(model)).thenReturn(dtoMock);
		
		final List<ProductionDTO> dtos = service.transform(models);
		Assert.assertNotNull(dtos);
		Assert.assertNotEquals(dtos, wrongDtosMocks);
	}
	
	@Test
	public void testUpdate() {
		//For coverage
		final Production model = new Production();
		service.update(model);
	}
	
	@Test
	public void testDelete() {
		//For coverage
		final Production model = new Production();
		service.delete(model);
	}
	
	public List<Production> createListOfProductions(){
		final Production model1 = new Production();
		final Production model2 = new Production();
		final Production model3 = new Production();
		final Production model4 = new Production();
		final Production model5 = new Production();
		final List<Production> models = new ArrayList<>();
		models.add(model1);
		models.add(model2);
		models.add(model3);
		models.add(model4);
		models.add(model5);
		
		return models;
	}
	
	public List<ProductionDTO> createListOfProductionsDTOs(){
		final ProductionDTO dto1 = new ProductionDTO();
		final ProductionDTO dto2 = new ProductionDTO();
		final ProductionDTO dto3 = new ProductionDTO();
		final ProductionDTO dto4 = new ProductionDTO();
		final ProductionDTO dto5 = new ProductionDTO();
		final List<ProductionDTO> dtos = new ArrayList<>();
		dtos.add(dto1);
		dtos.add(dto2);
		dtos.add(dto3);
		dtos.add(dto4);
		dtos.add(dto5);
		
		return dtos;
	}
}
