package com.mbl.farm.dto;

import java.util.List;

import com.mbl.farm.model.Production;

import lombok.Data;

@Data
public class CowDTO {
	
	private String frecuency;
	
	private List<Production> productions;
}
