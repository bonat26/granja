package com.mbl.farm.service;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbl.farm.dto.MoneyPerUserDTO;

public interface MoneyPerUserService {
	
	Page<MoneyPerUserDTO> getMoneyEarned(Pageable pageable, Date startDate, Date endDate);
	
}
