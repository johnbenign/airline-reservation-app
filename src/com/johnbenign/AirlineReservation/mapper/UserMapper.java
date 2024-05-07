package com.johnbenign.AirlineReservation.mapper;

import org.apache.log4j.Logger;

import com.johnbenign.AirlineReservation.dto.UserDTO;

public class UserMapper
{
	private static final Logger logger = Logger.getLogger(UserMapper.class.getName());

	public void updateRecord(UserDTO userDTO, UserDTO userDTO2)
	{
		if(userDTO.getAddress() != null)
			userDTO2.setAddress(userDTO.getAddress());
			
		
		if(userDTO.getDateOfBirth() != null)
			userDTO2.setDateOfBirth(userDTO.getDateOfBirth());
		
		if(userDTO.getEmail() != null)
			userDTO2.setEmail(userDTO.getEmail());
		
		if(userDTO.getFirstName() != null)
			userDTO2.setFirstName(userDTO.getFirstName());
		
		if(userDTO.getLastName() != null)
			userDTO2.setLastName(userDTO.getLastName());
		
		userDTO2.setFullName(userDTO2.getFirstName() + " " + userDTO2.getLastName());
		
		if(userDTO.getGender() != null)
			userDTO2.setGender(userDTO.getGender());
		
		if(userDTO.getPhoneNumber() != null)
			userDTO2.setPhoneNumber(userDTO.getPhoneNumber());
		
		if(userDTO.getKey() != null)
			userDTO2.setKey(userDTO.getKey());
		
		if(userDTO.getUserId() != null)
			userDTO2.setUserId(userDTO.getUserId());
	}

}
