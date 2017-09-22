package com.mbl.farm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mbl.farm.dao.ChickenDao;
import com.mbl.farm.model.Chicken;

@Service
public class ChickenServiceImpl implements ChickenService {
	
	@Autowired
	private ChickenDao dao;

	@Override
	public Chicken create(Chicken t) {
		return dao.save(t);
	}

	@Override
	public void delete(Chicken t) {
		dao.delete(t);
	}

	@Override
	public void update(Chicken t) {
		dao.save(t);
	}

	/*@Override
	public List<Chicken> getAll() {
		final List<Chicken> chickens = new ArrayList<>();
		dao.findAll().forEach(ch -> chickens.add(ch));
		return chickens;
	}*/
	
	@Override
	public Page<Chicken> getAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public Chicken findById(Integer id) {
		return dao.findOne(id);
	}

}
