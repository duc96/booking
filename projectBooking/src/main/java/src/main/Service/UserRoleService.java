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

import src.main.Lib.Utils;
import src.main.Model.BookingHibernateDao;
import src.main.Model.IGenericDao;
import src.main.Model.Response.UserRoleResponse;
import src.main.java.booking.AdminUserRole;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
	
	@Autowired
	BookingHibernateDao daoObj;
	
	@Autowired
	public void initialDAO() {
		daoObj.setClazz(AdminUserRole.class);
	}
	
	/**
	 * Get user role list
	 * @return
	 */
	public List<UserRoleResponse> getList(HashMap<String, ?> postBody)
	{
		int rowCount = 10;
		int current = 0;
		List <UserRoleResponse> results = new ArrayList<UserRoleResponse>();
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
				myQueryDisjunc.add(Restrictions.ilike("userRoleName", "%"+ keyword + "%"));
				myQueryDisjunc.add(Restrictions.ilike("userRoleDescription", "%"+ keyword + "%"));
				cr.add(myQueryDisjunc);
			}
		}
		
		//searchPhrase
		
		List <AdminUserRole> cursor = cr.list();
		int _index = rowCount*current;
        for (Iterator iterator = cursor.iterator(); iterator.hasNext();){
        	UserRoleResponse userRole = new UserRoleResponse();
        	userRole.serialize((AdminUserRole) iterator.next());
        	userRole.setIndex(_index + 1);
        	results.add(userRole);
        	_index += 1;
        }
		return results;
	}
	
	/**
	 * Get user role
	 * @param id
	 * @return
	 */
	public UserRoleResponse getUserRole(Integer id)
	{
		Criteria cr = daoObj.find();
		cr.add(Restrictions.eq("userId", id));
		
		AdminUserRole userRole = null;
		List users = cr.list();
        for (Iterator iterator = users.iterator(); iterator.hasNext();){
        	userRole = (AdminUserRole) iterator.next(); 
        	break;
        }
		UserRoleResponse result = new UserRoleResponse();
		if(userRole != null) {
			result.serialize(userRole);
			return result;
		}
		return null;
	}
	
	/**
	 * Update user
	 * @param postBody
	 * @return
	 */
	public void removeUserRole(Integer id)
	{	
		Criteria cr = daoObj.find();
		cr.add(Restrictions.eq("userRoleId", id));
		
		AdminUserRole userRole = null;
		List cursor = cr.list();
        for (Iterator iterator = cursor.iterator(); iterator.hasNext();){
        	userRole = (AdminUserRole) iterator.next(); 
        	break;
        }
        System.out.println(userRole);
        if(userRole != null) {
        	userRole.setIsdeleted(1);
			daoObj.update(userRole);
        }
	}
	
	/**
	 * Update user-role
	 * @param postBody
	 * @return
	 */
	public void updateUserRole(HashMap<String, ?> postBody)
	{
		int id = Integer.parseInt((String)postBody.get("id"));
		
		Criteria cr = daoObj.find();
		cr.add(Restrictions.eq("userRoleId", id));
		
		AdminUserRole userRole = null;
		List cursor = cr.list();
        for (Iterator iterator = cursor.iterator(); iterator.hasNext();){
        	userRole = (AdminUserRole) iterator.next(); 
        	break;
        }
		if(userRole == null) {
			throw new NullPointerException("Không tìm thấy dữ liệu."); 
		}
		
		if(postBody.containsKey("UserRoleName")) {
			userRole.setUserRoleName((String)postBody.get("UserRoleName"));
		}
		
		if(postBody.containsKey("UserRoleDescription")) {
			userRole.setUserRoleDescription((String)postBody.get("UserRoleDescription"));
		}
		
		daoObj.update(userRole);
	}
	
	/**
	 * Create new user
	 * @param postBody
	 * @return
	 */
	public int createNewUserRole(HashMap<String, ?> postBody)
	{
		AdminUserRole userRole = new AdminUserRole();
		
		if(postBody.containsKey("UserRoleName")) {
			userRole.setUserRoleName((String)postBody.get("UserRoleName"));
		}
		
		if(postBody.containsKey("UserRoleDescription")) {
			userRole.setUserRoleDescription((String)postBody.get("UserRoleDescription"));
		}
		
		userRole.setCretatedate(new Date());
		userRole.setIsdeleted(0);
		userRole = (AdminUserRole)daoObj.create(userRole);
		
		return userRole.getUserRoleId();	
	}
}
