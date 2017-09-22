package com.mbl.farm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Production {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "ID_PRODUCTION")
	private Integer idProduction;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column (name = "PRODUCTION_DATE")
	private Date date;
	
	private Boolean state;
	
	private Integer price;
	
	@ManyToOne
	private Chicken chicken;
}
