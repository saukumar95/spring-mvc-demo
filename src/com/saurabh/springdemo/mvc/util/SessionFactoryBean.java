package com.saurabh.springdemo.mvc.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.saurabh.springdemo.mvc.model.Student;

public class SessionFactoryBean {

	private static SessionFactory sessionFactory = null;

	private SessionFactoryBean() {

	}

	public static SessionFactory getInstance() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		}
		return sessionFactory;
	}
}
