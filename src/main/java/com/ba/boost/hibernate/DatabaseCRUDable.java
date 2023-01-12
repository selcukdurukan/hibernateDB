package com.ba.boost.hibernate;

import java.util.List;

import com.ba.boost.util.HibernateUtil;

import org.hibernate.Session;

public interface DatabaseCRUDable<T> {

	default void create(T entity) {
		try {
			Session session = databaseConnection();
			session.getTransaction().begin();

			session.persist(entity);

			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Data yaratilirken hata olustu. " + e.getMessage());
		}

	}

	List<T> retrive();

	default void update(T entity) {
		try {
			Session session = databaseConnection();
			session.getTransaction().begin();

			session.merge(entity);

			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Data guncellenirken hata olustu.");
		}
	}

	default void delete(T entity) {
		try {
			Session session = databaseConnection();
			session.getTransaction().begin();

			session.remove(entity);

			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Data silinirken hata olustu.");
		}

	}

	T find(long key);

	default Session databaseConnection() {
		return HibernateUtil.getSessionFactory().openSession();
	}
}
