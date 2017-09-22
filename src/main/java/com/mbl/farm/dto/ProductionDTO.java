package com.mbl.farm.dto;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductionDTO {
	
	private Date buyDate;
	
	private Date sellDate;
	
	private Integer buyPrice;
	
	private Integer sellPrice;
	
	
}
