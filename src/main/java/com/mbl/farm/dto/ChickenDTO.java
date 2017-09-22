package com.mbl.farm.dto;

import java.util.List;

import com.mbl.farm.model.Production;

import lombok.Data;

@Data
public class ChickenDTO {
	
	private String type;
	
	private String frecuency;
	
	private List<Production> productions;
}
