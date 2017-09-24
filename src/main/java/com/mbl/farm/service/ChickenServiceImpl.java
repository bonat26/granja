package com.mbl.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mbl.farm.dao.ChickenDao;
import com.mbl.farm.dto.ChickenDTO;
import com.mbl.farm.model.Chicken;

@Service
public class ChickenServiceImpl implements ChickenService {

	@Autowired
	private ChickenDao chickenDao;
	
	@Autowired
	private DozerBeanMapper dozer;
	
	@Override
	public Chicken transform(ChickenDTO ch) {
		return dozer.map(ch, Chicken.class);
	}

	@Override
	public ChickenDTO transform(Chicken ch) {
		return dozer.map(ch, ChickenDTO.class);
	}

	@Override
	public Page<ChickenDTO> getAll(Pageable pageable) {
		final Iterable<Chicken> chickens = chickenDao.findAll();
		final List<ChickenDTO> chickenDTOs = new ArrayList<>();
		chickens.forEach(a -> {
			final ChickenDTO chickenDto = transform(a);
			chickenDTOs.add(chickenDto);
		});
		final Page<ChickenDTO> res = new PageImpl<ChickenDTO>(chickenDTOs, pageable, chickenDTOs.size());
		return res;
	}
}
