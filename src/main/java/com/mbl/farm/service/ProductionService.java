package com.mbl.farm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbl.farm.dto.ProductionDTO;
import com.mbl.farm.model.Production;

public interface ProductionService {
	ProductionDTO transform (Production p);                 
	                                            
	Production transform (ProductionDTO p);                 
	                                            
	ProductionDTO create(ProductionDTO p);                  
                                                
	void update(ProductionDTO p);                     
	                                            
	void delete(ProductionDTO p);                     
	                                            
	Page<ProductionDTO> getAll(Pageable pageable);

	ProductionDTO findById(Integer id);
}
