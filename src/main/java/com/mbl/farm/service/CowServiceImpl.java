package com.mbl.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.mbl.farm.dao.CowDao;
import com.mbl.farm.dto.CowDTO;
import com.mbl.farm.model.Cow;

public class CowServiceImpl implements CowService{

	@Autowired
	private CowDao cowDao;
	
	@Autowired
	private DozerBeanMapper dozer;
	
	@Override
	public CowDTO transform(Cow c) {
		return dozer.map(c, CowDTO.class);
	}

	@Override
	public Cow transform(CowDTO c) {
		return dozer.map(c, Cow.class);
	}

	@Override
	public Page<CowDTO> getAll(Pageable pageable) {
		final Iterable<Cow> cows = cowDao.findAll();
		final List<CowDTO> cowDTOs = new ArrayList<>();
		cows.forEach(a -> {
			final CowDTO cowDto = transform(a);
			cowDTOs.add(cowDto);
		});
		final Page<CowDTO> res = new PageImpl<CowDTO>(cowDTOs, pageable, cowDTOs.size());
		return res;
	}

}
