package com.mbl.farm.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "ID_USER")
	private Integer idUser;
	
	@Column (name ="USERNAME", nullable = false)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Chicken> Chickens;
}
