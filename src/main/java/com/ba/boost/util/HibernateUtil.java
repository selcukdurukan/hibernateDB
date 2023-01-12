package com.ba.boost.util;

import com.ba.boost.model.Billing;
import com.ba.boost.model.ContactInformation;
import com.ba.boost.model.Magazine;
import com.ba.boost.model.User;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

		if (HibernateUtil.sessionFactory == null) {
			HibernateUtil.sessionFactory = createSessionFactory();
		}
		return sessionFactory;
	}

	private static SessionFactory createSessionFactory() {
		Configuration config = new Configuration();

		config.addAnnotatedClass(User.class);
		config.addAnnotatedClass(ContactInformation.class);
		config.addAnnotatedClass(Billing.class);
		config.addAnnotatedClass(Magazine.class);

		SessionFactory factory = config.configure("hibernate.cfg.xml").buildSessionFactory();

		return factory;
	}

}
