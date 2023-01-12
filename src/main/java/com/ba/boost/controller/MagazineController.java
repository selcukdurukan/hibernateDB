package com.ba.boost.controller;

import java.util.ArrayList;
import java.util.List;

import com.ba.boost.hibernate.DatabaseCRUDable;
import com.ba.boost.model.Magazine;
import com.ba.boost.model.Magazine;
import com.ba.boost.util.HibernateUtil;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;

public class MagazineController implements DatabaseCRUDable<Magazine>{

	@Override
	public ArrayList<Magazine> retrive() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT xxx FROM Magazine AS xxx"; // SQL'in aksine tablo adı değil okumak istedigimiz sınıf ismini
													// yazıyoruz. Java sınıf adı yazım kurallarına uygun olmalı.
													// Bunların hepsini hibernate reflection kullanarak yapıyor.
		TypedQuery<Magazine> typedQuery = session.createQuery(hql, Magazine.class);

		ArrayList<Magazine> users = (ArrayList<Magazine>) typedQuery.getResultList();
		return users;
	}

	@Override
	public Magazine find(long key) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT xxx FROM Magazine AS xxx WHERE xxx.oid =: key"; // SQL'in aksine tablo adı değil okumak istedigimiz sınıf ismini
													// yazıyoruz. Java sınıf adı yazım kurallarına uygun olmalı.
													// Bunların hepsini hibernate reflection kullanarak yapıyor.
		TypedQuery<Magazine> typedQuery = session.createQuery(hql, Magazine.class);
		typedQuery.setParameter("key", key);
		Magazine Magazine = typedQuery.getSingleResult();
		return Magazine;
	}

}
