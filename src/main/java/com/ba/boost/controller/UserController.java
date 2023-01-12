package com.ba.boost.controller;

import java.util.ArrayList;
import java.util.List;

import com.ba.boost.hibernate.DatabaseCRUDable;
import com.ba.boost.model.User;
import com.ba.boost.util.HibernateUtil;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;

public class UserController implements DatabaseCRUDable<User> {

	@Override
	public ArrayList<User> retrive() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT xxx FROM User AS xxx"; // SQL'in aksine tablo adı değil okumak istedigimiz sınıf ismini
													// yazıyoruz. Java sınıf adı yazım kurallarına uygun olmalı.
													// Bunların hepsini hibernate reflection kullanarak yapıyor.
		TypedQuery<User> typedQuery = session.createQuery(hql, User.class);

		ArrayList<User> users = (ArrayList<User>) typedQuery.getResultList();
		return users;
	}

	@Override
	public User find(long key) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT xxx FROM User AS xxx WHERE xxx.oid =: key"; // SQL'in aksine tablo adı değil okumak istedigimiz sınıf ismini
													// yazıyoruz. Java sınıf adı yazım kurallarına uygun olmalı.
													// Bunların hepsini hibernate reflection kullanarak yapıyor.
		TypedQuery<User> typedQuery = session.createQuery(hql, User.class);
		typedQuery.setParameter("key", key);
		User user = typedQuery.getSingleResult();
		return user;
	}

}
