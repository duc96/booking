package src.main.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import src.main.java.booking.AdminUserSession;
import src.main.java.booking.AdminUsers;
import src.main.Lib.Utils;
import src.main.Model.BookingHibernateDao;
import src.main.Model.IGenericDao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	BookingHibernateDao daoObj;
	
	@Autowired
	private void initialDAO() {
		daoObj.setClazz(AdminUsers.class);
	}
	
	/**
	 * Check authentication
	 * @param username
	 * @param password
	 * @return
	 */
	public String auth(String loginname, String password) {
		String token = "";
		Criteria cr = daoObj.find();
		System.out.println(111222);
		System.out.print(password);
		cr.add(Restrictions.eq("loginname", loginname));
		cr.add(Restrictions.eq("password", Utils.generatePassword(password)));
		
		AdminUsers user = null;
		List users = cr.list();
        for (Iterator iterator = users.iterator(); iterator.hasNext();){
        	user = (AdminUsers) iterator.next(); 
        	break;
        }
        if(user != null) {
        	token = createToken(user.getUserId());
        }
        return token;
    }
	
	/**
	 * Create user's token
	 * @param userid
	 * @return
	 */
	private String createToken(int userid)
	{
		String token = Utils.generateToken();
		AdminUserSession _session = new AdminUserSession();
		_session.setUserId(userid);
		_session.setToken(token);
		_session.setCretatedate(new Date());
		_session.setLastmodified(new Date());
		daoObj.create(_session);
		
		return token;
	}
	
	private void createNewUser()
	{
		AdminUsers user = new AdminUsers();
		user.setLoginname("admin");
		user.setPassword(Utils.generatePassword("password"));
		user.setFullname("Administration");
		user.setCreateby(0);
		
		daoObj.create(user);
		
	}
}
