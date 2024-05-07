package com.johnbenign.AirlineReservation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.johnbenign.AirlineReservation.bo.UserBO;
import com.johnbenign.AirlineReservation.dao.UserDAO;
import com.johnbenign.AirlineReservation.dto.ResponseDTO;
import com.johnbenign.AirlineReservation.dto.UserDTO;

@Configuration
@ComponentScan(basePackages="com.johnbenign.AirlineReservation.bo, com.johnbenign.AirlineReservation.dao, com.johnbenign.AirlineReservation.dto")
public class ObjectInjector
{
//	@Bean
//	public UserDTO getUserDTOObject()
//	{
//		return new UserDTO();
//	}
//	
//	@Bean
//	public ResponseDTO getResponseObject()
//	{
//		return new ResponseDTO();
//	}
//	
//	@Bean
//	public UserDAO getUserDAOObject()
//	{
//		return new UserDAO();
//	}
//	
//	@Bean
//	public UserBO getUserBOObject()
//	{
//		return new UserBO();
//	}
}
