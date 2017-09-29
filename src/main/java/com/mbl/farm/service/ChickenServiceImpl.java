package com.mbl.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mbl.farm.dao.ChickenDao;
import com.mbl.farm.dto.ChickenDTO;
import com.mbl.farm.mapper.ChickenMapper;
import com.mbl.farm.model.Chicken;

@Service
public class ChickenServiceImpl implements ChickenService {

	@Autowired
	private ChickenDao chickenDao;
	
	@Autowired
	private ChickenMapper mapper;
	
	@Override
	public Chicken transform(ChickenDTO ch) {
		return mapper.toModel(ch);
	}

	@Override
	public ChickenDTO transform(Chicken ch) {
		return mapper.toDTO(ch);
	}

	@Override
	public Chicken create(Chicken c) {
		return chickenDao.save(c);
	}
	
	@Override
	public void update(Chicken c) {
		chickenDao.save(c);
	}
	
	@Override
	public Chicken findOne(Integer id) {
		return chickenDao.findOne(id);
	}

	@Override
	public List<Chicken> getAll(Integer page, Integer size) {
		final List<Chicken> chickens = new ArrayList<>();
		chickenDao.findAll(new PageRequest(page, size)).forEach(c -> chickens.add(c));
		return chickens;
	}

	@Override
	public List<ChickenDTO> transform(List<Chicken> chickens) {
		final List<ChickenDTO> chickenDTOs = new ArrayList<>();
		chickens.forEach(c -> chickenDTOs.add(transform(c)));
		return chickenDTOs;
	}


	
}
