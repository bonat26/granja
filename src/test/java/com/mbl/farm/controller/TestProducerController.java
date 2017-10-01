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

import com.mbl.farm.dto.ProductionDTO;
import com.mbl.farm.model.Production;
import com.mbl.farm.service.ProducerService;

@RunWith(MockitoJUnitRunner.class)
public class TestProducerController {
	
	private static final Integer ID = 1;
	private static final Integer BUYPRICE = 5;
	private static final Integer SELLPRICE = 10;
	
	@InjectMocks
	private ProducerController controller = new ProducerController();
	
	@Mock
	private ProducerService service;
	
	@Test
	public void testCreateOk() {
		final Production model = new Production();
		model.setBuyPrice(BUYPRICE);
		model.setSellPrice(SELLPRICE);
		Mockito.when(service.create(ID, model)).thenReturn(model);
		final ProductionDTO dtoMock = new ProductionDTO();
		dtoMock.setBuyPrice(BUYPRICE);
		dtoMock.setSellPrice(SELLPRICE);
		Mockito.when(service.transform(model)).thenReturn(dtoMock);
		Mockito.when(service.transform(dtoMock)).thenReturn(model);
		
		final ProductionDTO dto = controller.createProduction(ID, dtoMock);
		Assert.assertNotNull(dto);
		Assert.assertEquals(dto.getBuyPrice(), BUYPRICE);
		Assert.assertEquals(dto.getSellPrice(), SELLPRICE);
	}
	
	@Test
	public void testCreateKo() {
		final Production model = new Production();
		model.setBuyPrice(BUYPRICE);
		model.setSellPrice(SELLPRICE);
		Mockito.when(service.create(ID, model)).thenReturn(model);
		final ProductionDTO dtoMock = null;
		Mockito.when(service.transform(model)).thenReturn(dtoMock);
		Mockito.when(service.transform(dtoMock)).thenReturn(model);
		
		final ProductionDTO dto = controller.createProduction(ID, dtoMock);
		Assert.assertNull(dto);
	}
	
	@Test
	public void testGetAllOk() {
		final List<Production> models = createListOfProductions();
		final List<ProductionDTO> dtosMock = createListOfProductionsDTOs();
		
		Mockito.when(service.getAll(ID)).thenReturn(models);
		Mockito.when(service.transform(models)).thenReturn(dtosMock);
		
		final List<ProductionDTO> dtos = controller.getProductions(ID);
		Assert.assertNotNull(dtos);
		Assert.assertEquals(dtos, dtosMock);
		
	}
	
	@Test
	public void testGetAllKo() {
		final List<Production> models = null;
		final List<ProductionDTO> dtosMock = null;
		
		Mockito.when(service.getAll(ID)).thenReturn(models);
		Mockito.when(service.transform(models)).thenReturn(dtosMock);
		
		final List<ProductionDTO> dtos = controller.getProductions(ID);
		Assert.assertNull(dtos);
		
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
