package com.johnbenign.AirlineReservation.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.johnbenign.AirlineReservation.bo.ConnectionManager;
import com.johnbenign.AirlineReservation.config.ObjectInjector;
import com.johnbenign.AirlineReservation.dto.ResponseDTO;
import com.johnbenign.AirlineReservation.dto.UserDTO;
import com.johnbenign.AirlineReservation.mapper.UserMapper;

@Component
public class UserDAO extends CommonDAO
{
	private static final Logger logger = Logger.getLogger(UserDAO.class.getName());
	
	
	 Session session = null;
	 //ApplicationContext factory = null;
	
	public UserDAO()
	{
		//Configuration config = ConnectionManager.getConfiguration(UserDTO.class);
		super();
		session = ConnectionManager.getSession(UserDTO.class);
	}
	
	
	
    public ResponseDTO createUser(UserDTO userDTO)
    {
    	ResponseDTO response = null;
    	
    	Transaction tx = null;
    	
    	try
    	{
    		response = factory.newInstance(ResponseDTO.class);
	    
	    	logger.info("about to create user");
    	
    	
	    	logger.info("begin tx...");
    		
			tx = session.beginTransaction();
			
			logger.info("save object");
			
			session.save(userDTO);
			
			logger.info("commit object");
			
			tx.commit();
						
			logger.info("new user has been created!");
			
			response.setResult(true);
			response.setResponse(userDTO);
			response.setStatusCode("0");
		} 
    	catch (Exception e)
    	{
    		try
    		{
    			logger.info("attempting rollback...");
    			
    			if(tx != null)
    			{
    				tx.rollback();
    				
    				logger.info("rollback successful!");
    			}
    			else
    			{
    				logger.info("rollback attempt not succesful");
    			}
    			
    		}
    		catch(Exception rollbackException)
    		{
    			logger.error("error occured during rollback");
    			logger.error("error: " + rollbackException.getMessage());
    			logger.error("error trace: ", rollbackException);
    			
    			response.setErrorMsg(e.getMessage());
    			response.setResult(false);
    			response.setResponse(e);
    		}
    		
			response.setErrorMsg(e.getMessage());
			logger.error("error: " + e.getMessage());
			response.setResult(false);
			response.setResponse(e);
		}
    	finally
    	{
    		ConnectionManager.closeSession();
    	}
    	
    	return response;
    }
    
    public UserDTO getUser(Integer userId)
    {
    	UserDTO user = null;
		try 
		{
			user = (UserDTO) session.get(UserDTO.class, userId);
			
			if(user == null)
			{
				throw new Exception("no record found with given id");
			}
			
		}
		catch (Exception e)
		{
			setErrorMsg(e.getMessage());
			logger.error("error: " + e.getMessage());
			
		}
		finally
		{
			ConnectionManager.closeSession();
		}
    	
    	return user;
    }
    
    public List<UserDTO> getAllUser()
    {
    	List<UserDTO> users = null;
		try 
		{
			Query<UserDTO> userQuery =  session.createQuery("from UserDTO");
			
			users = userQuery.getResultList();
			
			if(users == null)
			{
				throw new HibernateException("no record found!");
			}
		}
		catch (Exception e)
		{
			logger.error("error: " + e.getMessage());
			setErrorMsg(e.getMessage());
		}
		finally
		{
			ConnectionManager.closeSession();
		}
    	
    	return users;
    }
    
    public ResponseDTO editUser(UserDTO userDTO)
    {
    	
    	ResponseDTO response = null;
    	
    	Transaction tx = null;
    	
    	try
    	{
    		response = factory.newInstance(ResponseDTO.class);
	    	
    		logger.info("about to edit user");
	//    	logger.info("about to create user");
    		
    		if(userDTO == null)
    		{
    			throw new Exception("user object is null!");
    		}
	    	
	    	if(userDTO.getUserId() == null)
	    	{
	    		throw new Exception("no user id supplied!");
	    	}
			
			logger.info("update object");
			
			UserMapper userMapper = new UserMapper();
			
			UserDTO userDTO2 = session.get(UserDTO.class, userDTO.getUserId());
			
			if(userDTO2 == null)
			{
				logger.error("no record found with given id!");
				
				throw new Exception(" no record found with given id!");
			}
			
			try
			{
				logger.info("begin tx...");
				
				tx = session.beginTransaction();
				
				userMapper.updateRecord(userDTO, userDTO2);
				
				//session.update(userDTO2);
				
				logger.info("commit tx");
				
				tx.commit();
							
				logger.info(" user record has been updated!");
				
				response.setResult(true);
				response.setResponse(userDTO2);
				response.setStatusCode("0");
			}
			catch (Exception txException)
			{
				logger.error("error occurred during transaction!");
				
				try
				{
					logger.info(" attempting rollback...");
					
					if(tx != null)
					{
						tx.rollback();
						
						logger.info("transaction have been rolled back successfully!");
					}
					else
						logger.info("rollback failed!");
				}
				catch(Exception rollbackException)
				{
					logger.error("rollback failed due to an error");
					logger.error("error: " + rollbackException.getMessage());
					logger.error("error trace: ", rollbackException);
				}
				
				response.setErrorMsg(txException.getMessage());
				logger.error("error: " + txException.getMessage());
				response.setResult(false);
				response.setResponse(txException);
							
				
			}
		} 
    	catch (Exception e)
    	{
			response.setErrorMsg(e.getMessage());
			logger.error("error: " + e.getMessage());
			response.setResult(false);
			response.setResponse(e);
						
			session.close();
		}
    	finally
    	{
    		ConnectionManager.closeSession();
    	}
    	
    	return response;
    }
    
    public ResponseDTO deleteser(Integer userId)
    {
    	ResponseDTO response = null; 
    	
    	Transaction tx =  null;
    	
		try 
		{
			response = factory.newInstance(ResponseDTO.class);
			
			UserDTO user = (UserDTO) session.get(UserDTO.class, userId);
			
			if(user == null)
			{
				throw new Exception("no record found with given id");
			}
			
			try
			{
				tx = session.beginTransaction();
				
				session.delete(user);
				
				tx.commit();
				
				logger.info("record deleted!");
				response.setResult(true);
			} 
			catch (Exception txException)
			{
				logger.error(" error occurred during tx processing!");
				
				try
				{
					logger.info(" attempting rollback...");
					
					tx.rollback();
					
					logger.info(" rolled back successfully!");
				}
				catch(Exception rollbackException)
				{
					logger.error("error occurred during rollback");
					
					response.setErrorMsg(rollbackException.getMessage());
					logger.error("error: " + rollbackException.getMessage());
					response.setResult(false);
					response.setResponse(rollbackException);
				}
				
				response.setErrorMsg(txException.getMessage());
				logger.error("error: " + txException.getMessage());
				response.setResult(false);
				response.setResponse(txException);
			}
			
			
		}
		catch (Exception e)
		{
			response.setErrorMsg(e.getMessage());
			logger.error("error: " + e.getMessage());
			response.setResult(false);
			response.setResponse(e);		
		}
		finally
		{
			ConnectionManager.closeSession();
		}
    	
    	return response;
    }
    
    public ResponseDTO login(String email, String password)
    {
    	//will be implemented next!
    }
   
}
