package com.mbl.farm.mapper;

import org.springframework.stereotype.Component;

import com.mbl.farm.dto.UserDTO;
import com.mbl.farm.model.User;

@Component
public class UserMapperImpl extends AbstractMapper<User, UserDTO> implements UserMapper{

	@Override
	protected Class<? extends User> getModelClazz() {
		return User.class;
	}

	@Override
	protected Class<? extends UserDTO> getDTOClazz() {
		return UserDTO.class;
	}

}
