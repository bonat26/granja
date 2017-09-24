package com.mbl.farm.service;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Pageable;

import com.mbl.farm.dao.AnimalDao;
import com.mbl.farm.dto.AnimalDTO;
import com.mbl.farm.dto.ChickenDTO;

@RunWith(MockitoJUnitRunner.class)
public class TestAnimalService {
	
	private static final Integer ID = 1;
	private static final String FRECUENCY = "1";
	private static final AnimalDTO ANIMAL = new ChickenDTO();
	
	@InjectMocks
	private AnimalService animalService = new AnimalServiceImpl();
	
	@Mock
	private AnimalDao animalDao;
	
	@Mock
	private Pageable pageable;
	
	
}
