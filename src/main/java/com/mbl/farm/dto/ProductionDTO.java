package com.mbl.farm.dto;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductionDTO {
	
	private Integer id;
	
	private Date date;
	
	private Boolean state;
	
	private Integer price;
	
	
}
