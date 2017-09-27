package com.mbl.farm.mapper;

import java.util.List;

import com.mbl.farm.model.Production;

public interface ListMapper {
	
	public List<Integer> toIntList(List<Production> prods);
	
	public List<Production> toProdList(List<Integer> ids);
	
}
