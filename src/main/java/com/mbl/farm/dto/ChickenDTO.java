package com.mbl.farm.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class ChickenDTO extends AnimalDTO{
	
	private String type;
}
