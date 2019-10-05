package src.main.Model.Response;

import java.text.SimpleDateFormat;
import java.util.Date;

import src.main.java.booking.ServiceType;

public class ServiceTypeResponse {
	private Integer id;
	private Integer index;
	private String service_type_name;
	private String service_type_description;
	private String cretatedate;
	
	public void serialize(ServiceType serviceType)
	{
		this.id 					= serviceType.getServiceTypeId();
		this.service_type_name 			= serviceType.getServiceTypeName();
		this.service_type_description 	= serviceType.getServiceTypeDescription();
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy");
		this.cretatedate = format.format(serviceType.getCretatedate());
	}
	
	public Integer getIndex() {
		return this.index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
}
