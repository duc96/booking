package src.main.Model.Response;

import java.text.SimpleDateFormat;
import java.util.Date;

import src.main.java.booking.ServiceType;

public class ServiceTypeResponse {
	private Integer id;
	private Integer index;
	private String service_name;
	private String service_description;
	private String cretatedate;
	
	public void serialize(ServiceType serviceType)
	{
		this.service_name 			= serviceType.getServiceName();
		this.service_description 	= serviceType.getServiceDescription();
		
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
