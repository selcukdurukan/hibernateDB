package com.ba.boost.controller;

import java.util.ArrayList;
import java.util.List;

import com.ba.boost.hibernate.DatabaseCRUDable;
import com.ba.boost.model.Billing;
import com.ba.boost.model.Billing;
import com.ba.boost.util.HibernateUtil;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;

public class BillingController implements DatabaseCRUDable<Billing>{

	@Override
	public ArrayList<Billing> retrive() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT xxx FROM Billing AS xxx"; // SQL'in aksine tablo adı değil okumak istedigimiz sınıf ismini
													// yazıyoruz. Java sınıf adı yazım kurallarına uygun olmalı.
													// Bunların hepsini hibernate reflection kullanarak yapıyor.
		TypedQuery<Billing> typedQuery = session.createQuery(hql, Billing.class);

		ArrayList<Billing> users = (ArrayList<Billing>) typedQuery.getResultList();
		return users;
	}

	@Override
	public Billing find(long key) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT xxx FROM Billing AS xxx WHERE xxx.oid =: key"; // SQL'in aksine tablo adı değil okumak istedigimiz sınıf ismini
													// yazıyoruz. Java sınıf adı yazım kurallarına uygun olmalı.
													// Bunların hepsini hibernate reflection kullanarak yapıyor.
		TypedQuery<Billing> typedQuery = session.createQuery(hql, Billing.class);
		typedQuery.setParameter("key", key);
		Billing Billing = typedQuery.getSingleResult();
		return Billing;
	}

}
