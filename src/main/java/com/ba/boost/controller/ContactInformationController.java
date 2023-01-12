package com.ba.boost.controller;

import java.util.ArrayList;
import java.util.List;

import com.ba.boost.hibernate.DatabaseCRUDable;
import com.ba.boost.model.ContactInformation;
import com.ba.boost.model.User;
import com.ba.boost.util.HibernateUtil;

import org.hibernate.Session;

import jakarta.persistence.TypedQuery;

public class ContactInformationController implements DatabaseCRUDable<ContactInformation>{

	@Override
	public ArrayList<ContactInformation> retrive() {
		Session session = databaseConnection();
		String hql = "SELECT xxx FROM ContactInformation AS xxx"; // SQL'in aksine tablo adı değil okumak istedigimiz sınıf ismini
													// yazıyoruz. Java sınıf adı yazım kurallarına uygun olmalı.
													// Bunların hepsini hibernate reflection kullanarak yapıyor.
		TypedQuery<ContactInformation> typedQuery = session.createQuery(hql, ContactInformation.class);

		ArrayList<ContactInformation> contacts = (ArrayList<ContactInformation>) typedQuery.getResultList();
		return contacts;
	}

	@Override
	public ContactInformation find(long key) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "SELECT xxx FROM ContactInformation AS xxx WHERE xxx.oid =: key"; // SQL'in aksine tablo adı değil okumak istedigimiz sınıf ismini
													// yazıyoruz. Java sınıf adı yazım kurallarına uygun olmalı.
													// Bunların hepsini hibernate reflection kullanarak yapıyor.
		TypedQuery<ContactInformation> typedQuery = session.createQuery(hql, ContactInformation.class);
		typedQuery.setParameter("key", key);
		ContactInformation contactInfo = typedQuery.getSingleResult();
		return contactInfo;
	}

}
