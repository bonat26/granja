package com.mbl.farm.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("CH")
public class Chicken extends Animal{
	
	@Column(columnDefinition = "varchar(2)")
	private String type;
}
