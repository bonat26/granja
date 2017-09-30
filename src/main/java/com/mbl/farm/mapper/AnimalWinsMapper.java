package com.mbl.farm.mapper;

import com.mbl.farm.dto.AnimalWinsDTO;
import com.mbl.farm.model.Animal;

public interface AnimalWinsMapper extends Mapper<Animal, AnimalWinsDTO>{
	Integer getWins(Animal model);
}
