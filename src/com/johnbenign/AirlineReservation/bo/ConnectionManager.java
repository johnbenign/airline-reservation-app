package com.johnbenign.AirlineReservation.bo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.johnbenign.AirlineReservation.config.ObjectFactory;
import com.johnbenign.AirlineReservation.factory.AbstractFactory;

public class ConnectionManager
{
	private static Configuration con;
	
	private static SessionFactory sessionFactory;
	private static Session session;
	private static ObjectFactory factory;
	
	public static Configuration getConfiguration(Class<?> ... t)
	{
		for(int i = 0; i < t.length; i++)
		{
			con = new Configuration().configure().addAnnotatedClass(t[i]);
		}
		
		return con;
	}
	
	public static SessionFactory getSessionFactory()
	{
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		
		sessionFactory = con.buildSessionFactory(registry);
		
		return sessionFactory;
	}
	
	public static Session getSession(Class<?> ... t)
	{
		getConfiguration(t);
		
		getSessionFactory();
		
		session = sessionFactory.openSession();
		
		return session;
	}

	public static ObjectFactory getFactory() {
		return factory;
	}

	public static void setFactory(ObjectFactory factory) {
		ConnectionManager.factory = factory;
	}
	
	public static void initContext()
	{
		factory = AbstractFactory.getObjectFactory();
		
		factory.setAppContext(new AnnotationConfigApplicationContext(ObjectFactory.class));
	}
	
	public static void closeSession()
	{
		if(session != null)
			session.close();
		
		if(sessionFactory != null)
			sessionFactory.close();
	}
	
	
}
