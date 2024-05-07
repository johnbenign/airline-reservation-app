package com.johnbenign.AirlineReservation.factory;

import org.apache.log4j.Logger;

import com.johnbenign.AirlineReservation.config.ObjectFactory;
/**
 * All methods in this class must be declared static
 * @author DELL
 *
 */
public abstract class AbstractFactory
{
	
	private static final Logger logger = Logger.getLogger(AbstractFactory.class.getName());
	
	public static ObjectFactory getObjectFactory()
	{
		try
		{
			return ObjectFactory.class.newInstance();
		} 
		catch (InstantiationException|IllegalAccessException e)
		{
			logger.error("error: " + e.getMessage());
			logger.error("error: ", e);
			
			return null;
		}
	}
}
