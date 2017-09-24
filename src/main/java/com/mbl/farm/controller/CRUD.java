package com.mbl.farm.controller;

import java.io.Serializable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CRUD<T, ID extends Serializable> {

	T create(T t);

	void delete(T t);

	void update(T t);
	
	Page<T> getAll(Pageable pageable);

	T findById(ID id);

}
