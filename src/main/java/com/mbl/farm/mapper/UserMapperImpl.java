package com.mbl.farm.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mbl.farm.dto.UserDTO;
import com.mbl.farm.model.Animal;
import com.mbl.farm.model.User;

@Component
public class UserMapperImpl extends AbstractMapper<User, UserDTO> implements UserMapper{
	
	@Autowired
	private ListMapper listMapper;
	
	@Override
	public User toModel(UserDTO dto) {
		final User user = super.toModel(dto);
		List<Animal> animals = listMapper.toAnimalList(dto.getAnimalsIDs());
		user.setAnimals(animals);
		return user;
	}
	
	@Override
	public UserDTO toDTO(User model) {
		final UserDTO userDTO = super.toDTO(model);
		final List<Integer> animalIDs = listMapper.animalListToIntList(model.getAnimals());
		userDTO.setAnimalsIDs(animalIDs);
		return userDTO;
	}
	
	@Override
	protected Class<? extends User> getModelClazz() {
		return User.class;
	}

	@Override
	protected Class<? extends UserDTO> getDTOClazz() {
		return UserDTO.class;
	}

}
