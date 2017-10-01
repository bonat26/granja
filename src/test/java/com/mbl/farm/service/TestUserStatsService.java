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
import com.mbl.farm.dao.UserStatsDao;
import com.mbl.farm.dto.UserWinsDTO;
import com.mbl.farm.mapper.UserWinsMapper;
import com.mbl.farm.model.User;

@RunWith(MockitoJUnitRunner.class)
public class TestUserStatsService {
	
	private static final String NAME = "name";
	private static final String WRONGNAME = "wrongname";
	
	@InjectMocks
	private UserStatsService service = new UserStatsServiceImpl();
	
	@Mock
	private UserStatsDao dao;
	
	@Mock
	private UserWinsMapper mapper;
	
	@Test
	public void testTransformToDtoOk() {
		final User model = new User();
		model.setName(NAME);
		final UserWinsDTO dtoMock = new UserWinsDTO();
		dtoMock.setName(NAME);
		Mockito.when(mapper.toDTO(model)).thenReturn(dtoMock);
		
		final UserWinsDTO dto = service.transform(model);
		Assert.assertNotNull(dto);
		Assert.assertEquals(dto.getName(),NAME);
	}
	
	@Test
	public void testTransformToDtoKo() {
		final User model = new User();
		model.setName(NAME);
		final UserWinsDTO dtoMock = new UserWinsDTO();
		dtoMock.setName(WRONGNAME);
		Mockito.when(mapper.toDTO(model)).thenReturn(dtoMock);
		
		final UserWinsDTO dto = service.transform(model);
		Assert.assertNotNull(dto);
		Assert.assertNotEquals(dto.getName(),NAME);
	}
	
	@Test
	public void testTransformListOk() {
		final User model = new User();
		final UserWinsDTO dtoMock = new UserWinsDTO();
		final List<User> models = createListOfUsers();
		final List<UserWinsDTO> dtosMocks = createListOfUserWinsDTOs();
		Mockito.when(service.transform(model)).thenReturn(dtoMock);
		
		final List<UserWinsDTO> dtos = service.transform(models);
		Assert.assertNotNull(dtos);
		Assert.assertEquals(dtos, dtosMocks);
	}
	
	@Test
	public void testTransformListKo() {
		final User model = new User();
		final UserWinsDTO dtoMock = new UserWinsDTO();
		final List<User> models = createListOfUsers();
		final List<UserWinsDTO> wrongDtosMocks = createListOfUserWinsDTOs();
		wrongDtosMocks.remove(0);
		Mockito.when(service.transform(model)).thenReturn(dtoMock);
		
		final List<UserWinsDTO> dtos = service.transform(models);
		Assert.assertNotNull(dtos);
		Assert.assertNotEquals(dtos, wrongDtosMocks);
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
	
	public List<UserWinsDTO> createListOfUserWinsDTOs(){
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
