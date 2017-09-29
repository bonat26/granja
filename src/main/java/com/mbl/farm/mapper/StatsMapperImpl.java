package com.mbl.farm.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mbl.farm.dto.AnimalWinsDTO;
import com.mbl.farm.model.Animal;
import com.mbl.farm.model.Production;

@Component
public class StatsMapperImpl extends AbstractMapper<Animal, AnimalWinsDTO> implements StatsMapper{

	@Override
	public AnimalWinsDTO toDTO(Animal model) {
		final AnimalWinsDTO animalWinsDTO = super.toDTO(model);
		animalWinsDTO.setWins(getWins(model));
		return null;
	}

	private Integer getWins(Animal model) {
		Integer wins = 0;
		List<Production> productions = model.getProductions();
		for(Integer i = 0; i < productions.size(); i++) {
			wins += getBenefit(productions.get(i));
		}
		return wins;
	}

	private Integer getBenefit(Production p) {
		return p.getSellPrice() - p.getBuyPrice();
	}

	@Override
	protected Class<? extends Animal> getModelClazz() {
		return Animal.class;
	}

	@Override
	protected Class<? extends AnimalWinsDTO> getDTOClazz() {
		return AnimalWinsDTO.class;
	}

}
