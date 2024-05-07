package com.johnbenign.AirlineReservation.factory;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.johnbenign.AirlineReservation.bo.Maintainable;
import com.johnbenign.AirlineReservation.dto.CommonDTO;

@Configuration
@ComponentScan(basePackages="com.johnbenign.AirlineReservation.dao, com.johnbenign.AirlineReservation.bo")
public class MaintainableFactory
{
	private static final Logger logger = Logger.getLogger(MaintainableFactory.class.getName());
	
	private static ApplicationContext factory;
	
	public <T extends Maintainable> T newInstance(Class<T> maintainableClass)
	{
		T maintainable = null;
		try
		{
			factory = new AnnotationConfigApplicationContext(MaintainableFactory.class);
			
			maintainable = (T) factory.getBean(maintainableClass.newInstance().getClass());
		}
		catch (BeansException|InstantiationException|IllegalAccessException  e)
		{
			logger.error("error: " + e.getMessage());
			logger.error("error: ", e);
		}
		
		
		return maintainable;
	}
}
