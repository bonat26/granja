package com.mbl.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mbl.farm.dao.CowDao;
import com.mbl.farm.dto.CowDTO;
import com.mbl.farm.mapper.CowMapper;
import com.mbl.farm.model.Cow;

@Service
public class CowServiceImpl implements CowService{

	@Autowired
	private CowDao cowDao;
	
	@Autowired
	private CowMapper mapper;
	
	@Override
	public CowDTO transform(Cow c) {
		return mapper.toDTO(c);
	}

	@Override
	public Cow transform(CowDTO c) {
		return mapper.toModel(c);
	}

	@Override
	public List<Cow> getAll(Integer page, Integer size) {
		List<Cow> cows = new ArrayList<>();
		cowDao.findAll(new PageRequest(page, size)).forEach(c -> cows.add(c));
		return cows;
	}

	@Override
	public List<CowDTO> transform(List<Cow> cows) {
		final List<CowDTO> cowDTOs = new ArrayList<>();
		cows.forEach(c -> cowDTOs.add(transform(c)));
		return cowDTOs;
	}


}
