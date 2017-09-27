package com.mbl.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.mbl.farm.dao.ProductionDao;
import com.mbl.farm.dto.ProductionDTO;
import com.mbl.farm.mapper.ProductionMapper;
import com.mbl.farm.model.Production;

@Service
public class ProductionServiceImpl implements ProductionService{

	@Autowired
	private ProductionDao productionDao;
	
	@Autowired
	private ProductionMapper mapper;
	
	@Override
	public ProductionDTO transform(Production p) {
		return mapper.toDTO(p);
	}

	@Override
	public Production transform(ProductionDTO p) {
		return mapper.toModel(p);
	}

	@Override
	public Production create(Production p) {
		return productionDao.save(p);
	}

	@Override
	public void update(Production p) {
		productionDao.save(p);
	}

	@Override
	public void delete(Production p) {
		productionDao.delete(p);
	}

	@Override
	public List<Production> getAll(Integer page, Integer size) {
		List<Production> prods = new ArrayList<>();
		productionDao.findAll(new PageRequest(page, size)).forEach(p -> prods.add(p));
		return prods;
	}

	@Override
	public Production findById(Integer id) {
		return productionDao.findOne(id);
	}

	

}
