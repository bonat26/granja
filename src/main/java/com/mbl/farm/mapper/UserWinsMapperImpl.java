package com.mbl.farm.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mbl.farm.dto.UserWinsDTO;
import com.mbl.farm.model.Animal;
import com.mbl.farm.model.User;

@Component
public class UserWinsMapperImpl extends AbstractMapper<User, UserWinsDTO> implements UserWinsMapper{

	@Autowired
	private AnimalWinsMapper animalWinsMapper;
	
	@Override
	public UserWinsDTO toDTO(User model) {
		final UserWinsDTO userWinsDTO = super.toDTO(model);
		List<Animal> animals = model.getAnimals();
		userWinsDTO.setWins(getWins(animals));
		return userWinsDTO;
	}
	
	private Integer getWins(List<Animal> animals) {
		Integer wins = 0;
		for(Integer i = 0; i < animals.size(); i++) {
			wins += animalWinsMapper.getWins(animals.get(i));
		}
		return wins;
	}

	@Override
	protected Class<? extends User> getModelClazz() {
		return User.class;
	}

	@Override
	protected Class<? extends UserWinsDTO> getDTOClazz() {
		return UserWinsDTO.class;
	}

}
