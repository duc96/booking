package src.main.Model.Response;

import java.text.SimpleDateFormat;
import java.util.Date;

import src.main.java.booking.AdminUsers;

public class UserResponse {
	private Integer id;
	private Integer index;
	private	String email;
	private String fullname;
	private String address1;
	private String address2;
	private String city;
	private String country;
	private String zipcode;
	private String cretatedate;
	private String status;
	
	public void serialize(AdminUsers user)
	{
		this.email 			= user.getEmail();
		this.fullname 		= user.getFullname();
		this.address1 		= user.getAddress1();
		this.address2 		= user.getAddress2();
		this.city 			= user.getCity();
		this.country 		= user.getCountry();
		this.zipcode 		= user.getZipcode();
		this.id				= user.getUserId();
		this.status			= "Hoạt động";
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy");
		this.cretatedate = format.format(user.getCretatedate());
		
		if(user.getIsdeleted() == 1) {
			this.status			= "Khoá";
		}
	}
	
	public Integer getIndex() {
		return this.index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
}
