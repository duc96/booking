package src.main.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import src.main.java.booking.Khachhang;
import src.main.Lib.HibernateUtil;
import src.main.Lib.Utils;
import src.main.Model.BookingHibernateDao;
import src.main.Model.IGenericDao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	BookingHibernateDao <Khachhang> staffDAO;
	
	/**
	 * Check authentication
	 * @param username
	 * @param password
	 * @return
	 */
	public String auth(Khachhang staff2) {
		String token = "";
		System.out.println(9999992);
		staffDAO.setClazz(Khachhang.class);
		Criteria cr = staffDAO.find();
		
//		query.select(query.from(Khachhang.class));
//		List<Khachhang> list = query.getResultList();
//		Criteria cr = staffDAO.find();
//		cr.add(Restrictions.eq("usernamekhachhang", username));
//		cr.add(Restrictions.eq("passwordkhachhang", Utils.generatePassword(password)));
//		
		Khachhang staff = null;
		List staffs = cr.list();
        for (Iterator iterator = staffs.iterator(); iterator.hasNext();){
        	staff = (Khachhang) iterator.next(); 
        	break;
        }
        System.out.println(44444);
        System.out.print(staff);
        if(staff != null) {
        	token = Utils.generateToken();
        }
        return "sdfsf";
    }
}
