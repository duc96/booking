package src.main.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import src.main.java.booking.Khachhang;
import src.main.Lib.HibernateUtil;
import src.main.Lib.Utils;
import src.main.Model.BookingHibernateDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
	@Autowired
	SessionFactory sessionFactory;
	
	static BookingHibernateDao<Khachhang> staffDAO;
	
	/**
	 * Check authentication
	 * @param username
	 * @param password
	 * @return
	 */
	public static String auth(String username, String password) {
		String token = "";
		System.out.println(username);
		System.out.println(Utils.generatePassword(password));
		Criteria cr = staffDAO.find();
//		cr.add(Restrictions.eq("usernamekhachhang", username));
//		cr.add(Restrictions.eq("passwordkhachhang", Utils.generatePassword(password)));
		
		Khachhang staff = null;
		List staffs = cr.list();
//        for (Iterator iterator = staffs.iterator(); iterator.hasNext();){
//        	staff = (Khachhang) iterator.next(); 
//        	break;
//        }
//        
//        if(staff != null) {
//        	token = Utils.generateToken();
//        }
        return "1223";
    }

	@Autowired
	private void setHibernateDao()  {
		this.staffDAO = new BookingHibernateDao();
		this.staffDAO.setClazz(Khachhang.class);
		this.staffDAO.setSessionFactory(HibernateUtil.getSessionFactory());
	}
}
