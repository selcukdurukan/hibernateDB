package com.ba.boost;

import com.ba.boost.controller.BillingController;
import com.ba.boost.controller.ContactInformationController;
import com.ba.boost.controller.MagazineController;
import com.ba.boost.controller.UserController;
import com.ba.boost.model.Billing;
import com.ba.boost.model.ContactInformation;
import com.ba.boost.model.Magazine;
import com.ba.boost.model.User;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		UserController userController = new UserController();
		ContactInformationController contactController = new ContactInformationController();
		BillingController billingController = new BillingController();
		MagazineController magazineController = new MagazineController();

		ContactInformation c1 = new ContactInformation();
		c1.setEmail("selcukdurukan@outlook.com.tr");
		c1.setPhoneNumber("5373450196");
		c1.setAddress("Efendibey Mah. Candan Sok. 38/12 Merkez/Nigde");
		contactController.create(c1);

		User u1 = new User();
		u1.setFirstName("Selçuk");
		u1.setLastName("Durukan");
		u1.setContact(c1);
		userController.create(u1);

		Billing b1 = new Billing(111222, "Su", u1);
		billingController.create(b1);

		Billing b2 = new Billing(2223333, "Internet", u1);
		billingController.create(b2);

		Billing b3 = new Billing(333444, "Dogal gaz", u1);
		billingController.create(b3);

		Billing b4 = new Billing(444555, "Elektrik", u1);
		billingController.create(b4);

		Magazine m1 = new Magazine("GirGir", "Komedi", 10);
		magazineController.create(m1);
	

		User u2 = new User();
		u2.setFirstName("Ayse");
		u2.setLastName("Durukan");
		u2.setContact(c1);
		m1.getReaders().add(u2);
		u2.getMagazines().add(m1);

		userController.create(u2);
		

//		ArrayList<User> lists = userController.retrive();
//		for (User u : lists) {
//			System.out.println(u);
//		}
//		
//		ArrayList<ContactInformation> lists2 =  contactController.retrive();
//		for (ContactInformation c : lists2) {
//			System.out.println(c);
//		}

	}
}
