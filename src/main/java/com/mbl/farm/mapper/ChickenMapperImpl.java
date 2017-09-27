package com.mbl.farm.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mbl.farm.dto.ChickenDTO;
import com.mbl.farm.model.Chicken;
import com.mbl.farm.model.Production;

@Component
public class ChickenMapperImpl extends AbstractMapper<Chicken, ChickenDTO> implements ChickenMapper{

	@Autowired
	private ListMapper listMapper;

	@Override
	public Chicken toModel(ChickenDTO chickenDTO) {
		final Chicken chicken = super.toModel(chickenDTO);
		List<Production> prods = listMapper.toProdList(chickenDTO.getProductionsIDs());
		chicken.setProductions(prods);
		return chicken;
	}
	
	@Override
	public ChickenDTO toDTO(Chicken model) {
		final ChickenDTO chickenDTO = super.toDTO(model);
		final List<Integer> prodIDs = listMapper.toIntList(model.getProductions());
		chickenDTO.setProductionsIDs(prodIDs);
		return chickenDTO;
	}
	
	@Override
	protected Class<? extends Chicken> getModelClazz() {
		return Chicken.class;
	}

	@Override
	protected Class<? extends ChickenDTO> getDTOClazz() {
		return ChickenDTO.class;
	}

}
