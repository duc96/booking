package src.main.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import src.main.java.booking.AdminUserSession;
import src.main.java.booking.AdminUsers;
import src.main.Lib.Utils;
import src.main.Model.BookingHibernateDao;
import src.main.Model.IGenericDao;
import src.main.Model.Response.UserResponse;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
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
	 * Get user list
	 * @return
	 */
	public List<UserResponse> getList(HashMap<String, ?> postBody)
	{
		int rowCount = 10;
		int current = 0;
		List <UserResponse> results = new ArrayList<UserResponse>();
		Criteria cr = daoObj.find();
		
//		cr.add(Restrictions.eq("isdeleted", 0));
		
		if(postBody.containsKey("rowCount")) {
			rowCount = Integer.parseInt((String)postBody.get("rowCount"));
			cr.setMaxResults(rowCount);
		}
		if(postBody.containsKey("current")) {
			current = Integer.parseInt((String)postBody.get("current")) - 1;
			if(current < 0) {
				current = 0;
			}
			cr.setFirstResult(rowCount*current);
		}
		
		if(postBody.containsKey("searchPhrase")) {
			String keyword = (String)postBody.get("searchPhrase");
			if(keyword.isEmpty() == false) {
				Disjunction myQueryDisjunc = Restrictions.disjunction();
				myQueryDisjunc.add(Restrictions.ilike("email", "%"+ keyword + "%"));
				myQueryDisjunc.add(Restrictions.ilike("fullname", "%"+ keyword + "%"));
				cr.add(myQueryDisjunc);
			}
		}
		
		//searchPhrase
		
		List <AdminUsers> cursor = cr.list();
		int _index = rowCount*current;
        for (Iterator iterator = cursor.iterator(); iterator.hasNext();){
        	UserResponse user = new UserResponse();
        	user.serialize((AdminUsers) iterator.next());
        	user.setIndex(_index + 1);
        	results.add(user);
        	_index += 1;
        }
		return results;
	}
	
	/**
	 * Get user
	 * @param id
	 * @return
	 */
	public UserResponse getUser(Integer id)
	{
		Criteria cr = daoObj.find();
		cr.add(Restrictions.eq("userId", id));
		
		AdminUsers user = null;
		List users = cr.list();
        for (Iterator iterator = users.iterator(); iterator.hasNext();){
        	user = (AdminUsers) iterator.next(); 
        	break;
        }
		UserResponse result = new UserResponse();
		if(user != null) {
			result.serialize(user);
			return result;
		}
		return null;
	}
	
	/**
	 * Update user
	 * @param postBody
	 * @return
	 */
	public void removeUser(Integer id)
	{	
		Criteria cr = daoObj.find();
		cr.add(Restrictions.eq("userId", id));
		
		AdminUsers user = null;
		List users = cr.list();
        for (Iterator iterator = users.iterator(); iterator.hasNext();){
        	user = (AdminUsers) iterator.next(); 
        	break;
        }
        System.out.println(user);
        if(user != null) {
        	user.setIsdeleted(1);
			daoObj.update(user);
        }
	}
	
	/**
	 * Update user
	 * @param postBody
	 * @return
	 */
	public void updateUser(HashMap<String, ?> postBody)
	{
		int id = Integer.parseInt((String)postBody.get("id"));
		
		Criteria cr = daoObj.find();
		cr.add(Restrictions.eq("userId", id));
		
		AdminUsers user = null;
		List users = cr.list();
        for (Iterator iterator = users.iterator(); iterator.hasNext();){
        	user = (AdminUsers) iterator.next(); 
        	break;
        }
		if(user == null) {
			throw new NullPointerException("Không tìm thấy dữ liệu."); 
		}
		
		if(postBody.containsKey("password")) {
			user.setPassword(Utils.generatePassword((String)postBody.get("password")));
		}
		
		if(postBody.containsKey("fullname")) {
			user.setFullname((String)postBody.get("fullname"));
		}
		
		daoObj.update(user);
	}
	
	/**
	 * Create new user
	 * @param postBody
	 * @return
	 */
	public int createNewUser(HashMap<String, ?> postBody)
	{
		AdminUsers user = new AdminUsers();
		
		if(postBody.containsKey("email")) {
			user.setEmail((String)postBody.get("email"));
		}
		
		if(postBody.containsKey("password")) {
			user.setPassword(Utils.generatePassword((String)postBody.get("password")));
		}
		
		if(postBody.containsKey("fullname")) {
			user.setFullname((String)postBody.get("fullname"));
		}
		
		user.setCretatedate(new Date());
		user.setIsdeleted(0);
		user = (AdminUsers)daoObj.create(user);
		
		return user.getUserId();
		
	}
	
	/**
	 * Check authentication
	 * @param username
	 * @param password
	 * @return
	 */
	public String auth(String email, String password) {
		String token = "";
		Criteria cr = daoObj.find();
		cr.add(Restrictions.eq("email", email));
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
}
