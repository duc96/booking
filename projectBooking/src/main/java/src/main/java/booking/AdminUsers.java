package src.main.java.booking;
// Generated Sep 29, 2019, 1:51:37 PM by Hibernate Tools 5.2.12.Final

import java.util.Date;

/**
 * AdminUsers generated by hbm2java
 */
public class AdminUsers implements java.io.Serializable {

	private Integer userId;
	private String email;
	private String password;
	private String fullname;
	private String address1;
	private String address2;
	private String city;
	private String country;
	private String zipcode;
	private Integer createby;
	private Date cretatedate;
	private Integer isdeleted;

	public AdminUsers() {
	}

	public AdminUsers(String email, String password, String fullname) {
		this.email = email;
		this.password = password;
		this.fullname = fullname;
	}

	public AdminUsers(String email, String password, String fullname, String address1, String address2, String city,
			String country, String zipcode, Integer createby, Date cretatedate, Integer isdeleted) {
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
		this.createby = createby;
		this.cretatedate = cretatedate;
		this.isdeleted = isdeleted;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Integer getCreateby() {
		return this.createby;
	}

	public void setCreateby(Integer createby) {
		this.createby = createby;
	}

	public Date getCretatedate() {
		return this.cretatedate;
	}

	public void setCretatedate(Date cretatedate) {
		this.cretatedate = cretatedate;
	}

	public Integer getIsdeleted() {
		return this.isdeleted;
	}

	public void setIsdeleted(Integer isdeleted) {
		this.isdeleted = isdeleted;
	}

}