package com.mbl.farm.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mbl.farm.dto.CowDTO;
import com.mbl.farm.model.Cow;
import com.mbl.farm.model.Production;

@Component
public class CowMapperImpl extends AbstractMapper<Cow, CowDTO> implements CowMapper{

	@Autowired
	private ListMapper listMapper;

	@Override
	public Cow toModel(CowDTO cowDTO) {
		final Cow cow = super.toModel(cowDTO);
		List<Production> prods = listMapper.toProdList(cowDTO.getProductionsIDs());
		cow.setProductions(prods);
		return cow;
	}
	
	@Override
	public CowDTO toDTO(Cow model) {
		final CowDTO cowDTO = super.toDTO(model);
		final List<Integer> prodIDs = listMapper.toIntList(model.getProductions());
		cowDTO.setProductionsIDs(prodIDs);
		return cowDTO;
	}
	
	@Override
	protected Class<? extends Cow> getModelClazz() {
		return Cow.class;
	}

	@Override
	protected Class<? extends CowDTO> getDTOClazz() {
		return CowDTO.class;
	}

}
