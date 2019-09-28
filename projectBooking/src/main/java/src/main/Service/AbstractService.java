package src.main.Service;

import org.springframework.beans.factory.annotation.Autowired;

import src.main.Model.BookingHibernateDao;

public abstract class AbstractService {
	@Autowired
	protected BookingHibernateDao<?> daoObj;
	
	@Autowired
	public void initialDAO() {
		System.out.print(daoObj);
	}
}
