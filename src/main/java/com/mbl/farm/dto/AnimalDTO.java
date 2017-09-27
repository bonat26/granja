package com.mbl.farm.dto;

import java.util.List;

import com.mbl.farm.model.Production;

import lombok.Data;

@Data
public abstract class AnimalDTO {

	private String frecuency;
	
	private List<Integer> productionsIDs;
}
