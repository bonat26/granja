package com.mbl.farm.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbl.farm.dao.ChickenDao;
import com.mbl.farm.dto.ChickenDTO;
import com.mbl.farm.model.Chicken;

@RunWith(MockitoJUnitRunner.class)
public class TestChickenService {
	
	private static final Integer ID = 1;
	private static final String TYPE = "AA";
	private static final String FRECUENCY = "1";
	private static final Chicken CHICKEN = new Chicken();

	
	@InjectMocks
	private ChickenService chickenService = new ChickenServiceImpl();
	
	@Mock
	private ChickenDao chickenDao;
	
	@Mock
	private Pageable pageable;
	
	@Before
	public void init() {
		CHICKEN.setIdAnimal(ID);
		CHICKEN.setType(TYPE);
		CHICKEN.setFrecuency(FRECUENCY);
	}
	
	@Test
	public void testFindAllChickenOK() {
		//INCOMPLETO
		Page<ChickenDTO> chickens = chickenService.getAll(pageable);
	}
	

	private Chicken CreateChicken(String type, String frecuency) {
		final Chicken ch = new Chicken();
		ch.setType(TYPE);
		ch.setFrecuency(FRECUENCY);
		return ch;
	}
	
	
}
