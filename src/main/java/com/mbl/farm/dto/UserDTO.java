package com.mbl.farm.dto;

import java.util.List;

import com.mbl.farm.model.Animal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
	
	private String name;
	
	private List<Integer> animalsIDs;

}
