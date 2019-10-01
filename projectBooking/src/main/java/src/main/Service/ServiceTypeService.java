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

import src.main.java.booking.ServiceType;
import src.main.Lib.Utils;
import src.main.Model.IGenericDao;
import src.main.Model.ServiceTypeHibernateDao;
import src.main.Model.Response.ServiceTypeResponse;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTypeService {
	
	@Autowired
	ServiceTypeHibernateDao <ServiceType> daoObj;
	
	
	@Autowired
	public void initialDAO() {
		System.out.println(99222);
		daoObj.setClazz(ServiceType.class);
	}
	
	/**
	 * Get service type list
	 * @return
	 */
	public List<ServiceTypeResponse> getList(HashMap<String, ?> postBody)
	{
		int rowCount = 10;
		int current = 0;
		List <ServiceTypeResponse> results = new ArrayList<ServiceTypeResponse>();
		Criteria cr = daoObj.find();
		
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
				myQueryDisjunc.add(Restrictions.ilike("serviceName", "%"+ keyword + "%"));
				myQueryDisjunc.add(Restrictions.ilike("serviceDescription", "%"+ keyword + "%"));
				cr.add(myQueryDisjunc);
			}
		}
		
		List <ServiceType> cursor = cr.list();
		int _index = rowCount*current;
        for (Iterator iterator = cursor.iterator(); iterator.hasNext();){
        	ServiceTypeResponse service = new ServiceTypeResponse();
        	service.serialize((ServiceType) iterator.next());
        	service.setIndex(_index + 1);
        	results.add(service);
        	_index += 1;
        }
		return results;
	}
	
	/**
	 * Get service
	 * @param id
	 * @return
	 */
	public ServiceTypeResponse getService(Integer id)
	{
		Criteria cr = daoObj.find();
		cr.add(Restrictions.eq("serviceId", id));
		
		ServiceType service = null;
		List cursor = cr.list();
        for (Iterator iterator = cursor.iterator(); iterator.hasNext();){
        	service = (ServiceType) iterator.next(); 
        	break;
        }
        ServiceTypeResponse result = new ServiceTypeResponse();
		if(service != null) {
			result.serialize(service);
			return result;
		}
		return null;
	}
	
	/**
	 * Update service type
	 * @param postBody
	 * @return
	 */
	public void removeService(Integer id)
	{	
		Criteria cr = daoObj.find();
		cr.add(Restrictions.eq("serviceId", id));
		
		ServiceType service = null;
		List cursor = cr.list();
        for (Iterator iterator = cursor.iterator(); iterator.hasNext();){
        	service = (ServiceType) iterator.next(); 
        	break;
        }
        if(service != null) {
        	service.setIsdeleted(1);
			daoObj.update(service);
        }
	}
	
	/**
	 * Update service type
	 * @param postBody
	 * @return
	 */
	public void updateService(HashMap<String, ?> postBody)
	{
		int id = Integer.parseInt((String)postBody.get("id"));
		
		Criteria cr = daoObj.find();
		cr.add(Restrictions.eq("serviceId", id));
		
		ServiceType service = null;
		List cursor = cr.list();
        for (Iterator iterator = cursor.iterator(); iterator.hasNext();){
        	service = (ServiceType) iterator.next(); 
        	break;
        }
		if(service == null) {
			throw new NullPointerException("Không tìm thấy dữ liệu."); 
		}
		
		if(postBody.containsKey("name")) {
			service.setServiceName((String)postBody.get("password"));
		}
		
		if(postBody.containsKey("description")) {
			service.setServiceDescription((String)postBody.get("description"));
		}
		
		daoObj.update(service);
	}
	
	/**
	 * Create new service type
	 * @param postBody
	 * @return
	 */
	public int createNewService(HashMap<String, ?> postBody)
	{
		ServiceType service = new ServiceType();
		
		if(postBody.containsKey("ServiceName")) {
			service.setServiceName((String)postBody.get("ServiceName"));
		}
		
		if(postBody.containsKey("ServiceDescription")) {
			service.setServiceDescription((String)postBody.get("ServiceDescription"));
		}
		service.setServiceCode(service.getServiceName().replace(" ", "_").toUpperCase());
		service.setCretatedate(new Date());
		service.setIsdeleted(0);
		service = (ServiceType)daoObj.create(service);
		
		return service.getServiceId();
		
	}
}
