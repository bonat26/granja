package com.mbl.farm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbl.farm.dto.ChickenDTO;
import com.mbl.farm.dto.CowDTO;
import com.mbl.farm.mapper.ChickenMapper;
import com.mbl.farm.mapper.CowMapper;
import com.mbl.farm.model.Chicken;
import com.mbl.farm.model.Cow;
import com.mbl.farm.model.User;

@Service
public class FarmerServiceImpl implements FarmerService{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ChickenService chickenService;
	
	@Autowired
	private CowService cowService;
	
	@Autowired
	private ChickenMapper chickenMapper;
	
	@Autowired
	private CowMapper cowMapper;

	@Override
	public Chicken transform(ChickenDTO chickenDTO) {
		return chickenMapper.toModel(chickenDTO);
	}

	@Override
	public ChickenDTO transform(Chicken chicken) {
		return chickenMapper.toDTO(chicken);
	}

	@Override
	public Chicken create(Integer id, Chicken chicken) {
		chicken.setUser(id);
		chickenService.create(chicken);
		User user = userService.findById(id);
		user.getAnimals().add(chicken);
		userService.update(user);
		return chickenService.findOne(chicken.getIdAnimal());
	}

	@Override
	public Cow transform(CowDTO cowDTO) {
		return cowMapper.toModel(cowDTO);
	}

	@Override
	public CowDTO transform(Cow cow) {
		return cowMapper.toDTO(cow);
	}

	@Override
	public Cow create(Integer id, Cow cow) {
		cow.setUser(id);
		cowService.create(cow);
		User user = userService.findById(id);
		user.getAnimals().add(cow);
		userService.update(user);
		return cowService.findOne(cow.getIdAnimal());
	}

}
