package com.persistance_class_Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.persistance_class.User;

public class UserDao {

	public static int registerUser(User e1) {
		int status = 0;

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = null;
		Transaction ns = null;

		try {
			ss = sf.openSession();
			ns = ss.beginTransaction();
			
			status = (Integer) ss.save(e1);
			ns.commit();
		} catch (Exception e) {
			ns.rollback();
			e.printStackTrace();
		} finally {
			ss.close();
			sf.close();
		}
		return status;
	}
}
