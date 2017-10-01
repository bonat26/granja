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
import com.mbl.farm.dao.UserDao;
import com.mbl.farm.dto.UserDTO;
import com.mbl.farm.mapper.UserMapper;
import com.mbl.farm.model.User;

@RunWith(MockitoJUnitRunner.class)
public class TestUserService {
	
	private static final Integer ID = 1;
	private static final Integer WRONGID = 2;
	private static final String NAME = "name";
	private static final String WRONGNAME = "wrongname";
	
	@InjectMocks
	private UserService service = new UserServiceImpl();
	
	@Mock
	private UserDao dao;
	
	@Mock
	private UserMapper mapper;
	
	@Test
	public void testTransformToDtoOk() {
		final User model = new User();
		model.setName(NAME);
		final UserDTO dtoMock = new UserDTO();
		dtoMock.setName(NAME);
		Mockito.when(mapper.toDTO(model)).thenReturn(dtoMock);
		
		final UserDTO dto = service.transform(model);
		Assert.assertNotNull(dto);
		Assert.assertEquals(dto.getName(),NAME);
	}
	
	@Test
	public void testTransformToDtoKo() {
		final User model = new User();
		model.setName(NAME);
		final UserDTO dtoMock = new UserDTO();
		dtoMock.setName(WRONGNAME);
		Mockito.when(mapper.toDTO(model)).thenReturn(dtoMock);
		
		final UserDTO dto = service.transform(model);
		Assert.assertNotNull(dto);
		Assert.assertNotEquals(dto.getName(),NAME);
	}
	
	@Test
	public void testTransformToModelOk() {
		final User modelMock = new User();
		modelMock.setName(NAME);
		final UserDTO dtoMock = new UserDTO();
		dtoMock.setName(NAME);
		Mockito.when(mapper.toModel(dtoMock)).thenReturn(modelMock);
		
		final User model = service.transform(dtoMock);
		Assert.assertNotNull(model);
		Assert.assertEquals(model.getName(),NAME);
	}
	
	@Test
	public void testTransformToModelKo() {
		final User modelMock = new User();
		modelMock.setName(WRONGNAME);
		final UserDTO dtoMock = new UserDTO();
		dtoMock.setName(NAME);
		Mockito.when(mapper.toModel(dtoMock)).thenReturn(modelMock);
		
		final User model = service.transform(dtoMock);
		Assert.assertNotNull(model);
		Assert.assertNotEquals(model.getName(),NAME);
	}
	
	@Test
	public void testFindOneOk() {
		final User modelMock = new User();
		modelMock.setIdUser(ID);
		modelMock.setName(NAME);
		Mockito.when(dao.findOne(ID)).thenReturn(modelMock);
		
		final User model = service.findById(ID);
		Assert.assertNotNull(model);
		Assert.assertEquals(model.getName(),NAME);
	}
	
	@Test
	public void testFindOneKo() {
		final User modelMock = new User();
		modelMock.setIdUser(WRONGID);
		Mockito.when(dao.findOne(ID)).thenReturn(modelMock);
		
		final User model = service.findById(ID);
		Assert.assertNotNull(model);
		Assert.assertNotEquals(model.getIdUser(), ID);
	}
	
	@Test
	public void testCreateOk() {
		final User modelMock = new User();
		modelMock.setName(NAME);
		Mockito.when(dao.save(modelMock)).thenReturn(modelMock);
		
		final User model = service.create(modelMock);
		Assert.assertNotNull(model);
		Assert.assertEquals(model.getName(),NAME);
		
	}
	
	@Test
	public void testCreateKo() {
		final User modelMock = new User();
		modelMock.setName(NAME);
		Mockito.when(dao.save(modelMock)).thenReturn(modelMock);
		
		final User model = service.create(modelMock);
		Assert.assertNotNull(model);
		Assert.assertEquals(model.getName(),NAME);
		
	}
	
	@Test
	public void testTransformListOk() {
		final User model = new User();
		final UserDTO dtoMock = new UserDTO();
		final List<User> models = createListOfUsers();
		final List<UserDTO> dtosMocks = createListOfUserDTOs();
		Mockito.when(service.transform(model)).thenReturn(dtoMock);
		
		final List<UserDTO> dtos = service.transform(models);
		Assert.assertNotNull(dtos);
		Assert.assertEquals(dtos, dtosMocks);
	}
	
	@Test
	public void testTransformListKo() {
		final User model = new User();
		final UserDTO dtoMock = new UserDTO();
		final List<User> models = createListOfUsers();
		final List<UserDTO> wrongDtosMocks = createListOfUserDTOs();
		wrongDtosMocks.remove(0);
		Mockito.when(service.transform(model)).thenReturn(dtoMock);
		
		final List<UserDTO> dtos = service.transform(models);
		Assert.assertNotNull(dtos);
		Assert.assertNotEquals(dtos, wrongDtosMocks);
	}
	
	@Test
	public void testUpdate() {
		//For coverage
		final User model = new User();
		service.update(model);
	}
	
	@Test
	public void testDelete() {
		//For coverage
		final User model = new User();
		service.delete(model);
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
	
	public List<UserDTO> createListOfUserDTOs(){
		final UserDTO dto1 = new UserDTO();
		final UserDTO dto2 = new UserDTO();
		final UserDTO dto3 = new UserDTO();
		final UserDTO dto4 = new UserDTO();
		final UserDTO dto5 = new UserDTO();
		final List<UserDTO> dtos = new ArrayList<>();
		dtos.add(dto1);
		dtos.add(dto2);
		dtos.add(dto3);
		dtos.add(dto4);
		dtos.add(dto5);
		
		return dtos;
	}

}
