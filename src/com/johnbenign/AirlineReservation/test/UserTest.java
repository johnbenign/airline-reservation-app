package com.johnbenign.AirlineReservation.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;

import com.johnbenign.AirlineReservation.bo.ConnectionManager;
import com.johnbenign.AirlineReservation.bo.UserBO;
import com.johnbenign.AirlineReservation.config.ObjectFactory;
import com.johnbenign.AirlineReservation.config.ObjectInjector;
import com.johnbenign.AirlineReservation.dto.ResponseDTO;
import com.johnbenign.AirlineReservation.dto.UserDTO;
import com.johnbenign.AirlineReservation.factory.AbstractFactory;

public class UserTest
{
	private static final Logger logger = Logger.getLogger(UserTest.class.getName());
	private ObjectFactory factory;
	
    @Before
    public void setUp() throws Exception
    {
        //setting up
    	
    	ConnectionManager.initContext();
    	
    	factory = ConnectionManager.getFactory();
    }

    @After
    public void tearDown() throws Exception
    {
        //tearing down
    }
	
    //@Test
	public void createUser()
	{
    	
    	
    	UserDTO user = factory.newInstance(UserDTO.class);
    	
		user.setAddress("BLK 24 Flat 2 MOPOL Barracks Idimu Lagos");
		user.setDateOfBirth(new java.util.Date());
		user.setEmail("johnbenign6@gmail.com");
		user.setFirstName("Onye");
		user.setGender((short)0);
		user.setLastName("Victor");
		user.setPhoneNumber("345678"
				+ "");
		user.setFullName(user.getFirstName() + " " + user.getLastName());
		//ser.setUserId("1");
		
		UserBO userBO = factory.newInstance(UserBO.class);
		
		//userBO = factory.getBean(UserBO.class);
		
		ResponseDTO response = userBO.createUser(user);
		
		assertNotNull("response should not be null", response);
		
		assertTrue("result should be true", response.getResult());
		
		System.out.println("new user created");
	}
	
	//@Test
	public void editUser()
	{
    	
    	UserDTO user = factory.newInstance(UserDTO.class);
    	
		user.setEmail("divineihugba15@gmail.com");
		user.setUserId(20001);
		
		UserBO userBO = factory.newInstance(UserBO.class);
		
		ResponseDTO response = userBO.editUser(user);
		
		assertNotNull("response should not be null", response);
		
		assertTrue("result should be true", response.getResult());
		
		System.out.println("edited successfully");
	}
	
	//@Test
	public void getUser()
	{
    	
    	
		Integer userId = 20001;
		
		UserBO userBO = factory.newInstance(UserBO.class);
		
		UserDTO user = userBO.getUser(userId);
		
		assertNotNull("response should not be null", user);
		
		//assertTrue("result should be true", response.getResult());
		
		logger.info("user name: " + user.getFullName());
	}
	
	//@Test
	public void getAllUser()
	{
		logger.info(" about to get all users!");
		
		UserBO userBO = factory.newInstance(UserBO.class);
		
		List<UserDTO> users = userBO.getAllUser();
		
		assertNotNull(" users should not be null!", users);
		
		users.forEach(user -> logger.info("first name: " + user.getFirstName()));
		
	}
	
	//@Test
	public void deleteUser()
	{
		logger.info(" about to delete user!");
		
		Integer userId = 20001;
		
		UserBO userBO = factory.newInstance(UserBO.class);
		
		ResponseDTO response = userBO.deleteUser(userId);
		
		assertNotNull(" response should not be null!", response);
		assertTrue("result should be true", response.getResult());
		
		logger.info("user deleted successfully!");
		
	}
}
