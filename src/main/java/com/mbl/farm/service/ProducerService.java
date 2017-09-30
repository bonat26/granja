package com.mbl.farm.service;

import java.util.List;

import com.mbl.farm.dto.ProductionDTO;
import com.mbl.farm.model.Production;

public interface ProducerService {

	Production transform(ProductionDTO productionDTO);

	ProductionDTO transform(Production production);

	List<ProductionDTO> transform(List<Production> productions);

	Production create(Integer id, Production production);

	List<Production> getAll(Integer id);

}
