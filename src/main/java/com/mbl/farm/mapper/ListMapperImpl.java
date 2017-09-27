package com.mbl.farm.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mbl.farm.model.Production;
import com.mbl.farm.service.ProductionService;

@Component
public class ListMapperImpl implements ListMapper{
	
	@Autowired
	ProductionService productionService;
	
	@Override
	public List<Integer> toIntList(List<Production> prods) {
		List<Integer> prodIDs = new ArrayList<>();
		prods.forEach(a -> prodIDs.add(a.getIdProduction()));
		return prodIDs;
	}
	
	@Override
	public List<Production> toProdList(List<Integer> ids){
		List<Production> prodIDs = new ArrayList<>();
		ids.forEach(a -> prodIDs.add(productionService.findById(a)));
		return prodIDs;
	}
	
}
