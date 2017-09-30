package com.mbl.farm.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Inheritance
@DiscriminatorColumn(name = "ANIM_TYPE")
@Table(name = "ANIMALS")
public abstract class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_ANIMAL")
	private Integer idAnimal;
	
	@Column(columnDefinition = "varchar(2)")
	private String type;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "animal")
	private List<Production> productions;
	
	@ManyToOne
	private Integer user;
}
