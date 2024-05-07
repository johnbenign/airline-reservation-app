package com.johnbenign.AirlineReservation.bo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.johnbenign.AirlineReservation.config.ObjectFactory;
import com.johnbenign.AirlineReservation.dao.UserDAO;
import com.johnbenign.AirlineReservation.dto.ResponseDTO;
import com.johnbenign.AirlineReservation.dto.UserDTO;
import com.johnbenign.AirlineReservation.factory.AbstractFactory;

@Component
public class UserBO
{
	private static final Logger logger = Logger.getLogger(UserBO.class.getName());
	
	private ObjectFactory factory;
	
	public UserBO()
	{
		factory = ConnectionManager.getFactory();
		
		if(factory == null)
		{
			logger.warn("factory object is null, init factory");
			
			ConnectionManager.initContext();
		}
		else
		{
			logger.info(" factory object is not null");
		}
		
		 
	}
	
	public ResponseDTO createUser(UserDTO userDTO)
	{
		logger.info("about to create user");
		
		UserDAO userDAO = factory.newInstance(UserDAO.class);
		
		ResponseDTO response = userDAO.createUser(userDTO);
		
		return response;
	}
	
	public ResponseDTO editUser(UserDTO userDTO)
	{
		logger.info("about to edit user...");
		
		UserDAO userDAO = factory.newInstance(UserDAO.class);
				
		ResponseDTO response = userDAO.editUser(userDTO);
		
		return response;
	}
	
	public UserDTO getUser(Integer userId)
	{
		logger.info(" --- about to get user by id --- ");
		
		UserDAO userDAO = factory.newInstance(UserDAO.class);
		
		UserDTO user = userDAO.getUser(userId);
		
		return user;
	}
	
	public List<UserDTO> getAllUser()
	{
		logger.info("getting all users!");
		
		UserDAO userDAO = factory.newInstance(UserDAO.class);
		
		List<UserDTO> users = userDAO.getAllUser();
		
		return users;
		
	}
	
	public ResponseDTO deleteUser(Integer userId)
	{
		logger.info(" --- about to delete user by id --- ");
		
		UserDAO userDAO = factory.newInstance(UserDAO.class);
		
		ResponseDTO response = userDAO.deleteser(userId);
		
		return response;
	}
	
}
