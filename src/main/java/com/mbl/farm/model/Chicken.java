package com.mbl.farm.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CHICKENS")
public class Chicken {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_CHICKEN")
	private Integer idChicken;
	
	@Column(columnDefinition = "varchar(2)", nullable = false)
	private String type;
	
	private String frecuency;
	
	@ManyToOne
	private User user;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "chicken")
	private List<Production> productions;
}
