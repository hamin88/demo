package com.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
public class HibernateUtil {
 
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static final HibernateTemplate hibernateTemplate =  new HibernateTemplate(sessionFactory,true);
 
	public HibernateUtil(){
		
	}
	private static SessionFactory buildSessionFactory() {
		try{
			
			return new AnnotationConfiguration().configure()
					.buildSessionFactory();
	 	 
	 	}catch(Exception e){
	 			e.printStackTrace();
	 			return null;
	 	}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	} 
	public static HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
}
