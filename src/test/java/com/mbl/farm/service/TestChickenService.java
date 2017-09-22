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
		CHICKEN.setIdChicken(ID);
		CHICKEN.setType(TYPE);
		CHICKEN.setFrecuency(FRECUENCY);
	}
	
	@Test
	public void testFindChickenOK() {
		Mockito.when(chickenDao.findOne(ID)).thenReturn(CHICKEN);
		
		final Chicken ch = chickenService.findById(ID);
		
		Assert.assertNotNull(ch);
		Assert.assertEquals(ch.getIdChicken(), ID);
		Assert.assertEquals(ch.getType(), TYPE);
		Assert.assertEquals(ch.getFrecuency(), FRECUENCY);
	}

	
	@Test
	public void testFindChickenKO() {
		Mockito.when(chickenDao.findOne(ID)).thenReturn(CHICKEN);
		
		final Chicken ch = chickenService.findById(2);
		
		Assert.assertNull(ch);
	}
	
	@Test
	public void testFindAllChickenOK() {
		//INCOMPLETO
		Page<Chicken> chickens = chickenService.getAll(pageable);
	}
	
	@Test
	public void testCreateChicken() {
		Mockito.when(chickenDao.save(CHICKEN)).thenReturn(CreateChicken(ID,TYPE,FRECUENCY));
		
		final Chicken ch = chickenService.create(CHICKEN);
		
		Assert.assertNotNull(ch);
		Assert.assertEquals(ch.getIdChicken(), ID);
		Assert.assertEquals(ch.getType(), TYPE);
		Assert.assertEquals(ch.getFrecuency(), FRECUENCY);
	}
	
	@Test
	public void testDeleteChicken() {
		//INCOMPLETO
		chickenService.delete(CHICKEN);
	}
	
	@Test
	public void testUpdateChicken() {
		//INCOMPLETO
		chickenService.update(CHICKEN);
	}

	private Chicken CreateChicken(Integer id, String type, String frecuency) {
		final Chicken ch = new Chicken();
		ch.setIdChicken(ID);
		ch.setType(TYPE);
		ch.setFrecuency(FRECUENCY);
		return ch;
	}
	
	
}
