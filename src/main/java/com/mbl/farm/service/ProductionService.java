package com.mbl.farm.service;

import java.util.List;

import com.mbl.farm.dto.ProductionDTO;
import com.mbl.farm.model.Production;

public interface ProductionService {
	ProductionDTO transform (Production p);                 
	                                            
	Production transform (ProductionDTO p);                 
	                                            
	Production create(Production p);                  
                                                
	void update(Production p);                     
	                                            
	void delete(Production p);                     
	                                            
	List<Production> getAll(Integer page, Integer size);

	Production findById(Integer id);
}
