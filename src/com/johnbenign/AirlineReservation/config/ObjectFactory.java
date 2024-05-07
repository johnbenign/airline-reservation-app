package com.johnbenign.AirlineReservation.config;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.johnbenign.AirlineReservation.dto.CommonDTO;


@Configuration
@ComponentScan(basePackages="com.johnbenign.AirlineReservation.dto, com.johnbenign.AirlineReservation.bo, com.johnbenign.AirlineReservation.dao")
public class ObjectFactory
{
	private static final Logger logger = Logger.getLogger(ObjectFactory.class.getName());
	
	private ApplicationContext appContext;
	
	//private FactoryDTO() {}
	
	//@Bean
	public <T> T newInstance(Class<T> genericClass)
	{
		
		//factory.getBean(commonDTOClass.getClass());
		//CommonDTO commonDTO;
		
		T classObject = null;
		try
		{
			
			classObject = (T) appContext.getBean(genericClass.newInstance().getClass());
		}
		catch (BeansException|InstantiationException|IllegalAccessException  e)
		{
			logger.error("error: " + e.getMessage());
			logger.error("error: ", e);
		}
		
		
		return classObject;
	}

	public ApplicationContext getAppContext() {
		return appContext;
	}

	public void setAppContext(ApplicationContext appContext) {
		this.appContext = appContext;
	}
	
	
}
