package src.main.Lib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	/**
	 * Get Session Factory
	 * @return org.hibernate.SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = null;
		try {
			Configuration configuration = new Configuration();
			sessionFactory = configuration.configure().buildSessionFactory();
		} catch (Throwable ex) {
			ex.printStackTrace();
		}
		return sessionFactory;
	}
	
	/**
	 * Get Connection Session
	 * @return org.hibernate.Session
	 */
	public static Session getSession() {
		return getSessionFactory().openSession();
	}
}
