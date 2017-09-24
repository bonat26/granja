package com.mbl.farm.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.mbl.farm.dao.ProductionDao;
import com.mbl.farm.dto.ProductionDTO;
import com.mbl.farm.model.Production;

public class ProductionServiceImpl implements ProductionService{

	@Autowired
	private ProductionDao productionDao;
	
	@Autowired
	private DozerBeanMapper dozer;
	
	@Override
	public ProductionDTO transform(Production p) {
		return dozer.map(p, ProductionDTO.class);
	}

	@Override
	public Production transform(ProductionDTO p) {
		return dozer.map(p, Production.class);
	}

	@Override
	public ProductionDTO create(ProductionDTO productionDTO) {
		final Production p = transform(productionDTO);
		return transform(productionDao.save(p));
	}

	@Override
	public void update(ProductionDTO productionDTO) {
		final Production p = transform(productionDTO);
		productionDao.save(p);
		
	}

	@Override
	public void delete(ProductionDTO productionDTO) {
		final Production p = transform(productionDTO);
		productionDao.delete(p);
	}

	@Override
	public Page<ProductionDTO> getAll(Pageable pageable) {
		final Iterable<Production> productions = productionDao.findAll();
		final List<ProductionDTO> productionDTOs = new ArrayList<>();
		productions.forEach(p -> {
			final ProductionDTO productionDTO = transform(p);
			productionDTOs.add(productionDTO);
		});
		final Page<ProductionDTO> res = new PageImpl<ProductionDTO>(productionDTOs, pageable, productionDTOs.size());
		return res;
	}

	@Override
	public ProductionDTO findById(Integer id) {
		final Production p = productionDao.findOne(id);
		return transform(p);
	}

}
