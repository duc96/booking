package src.main.java.booking;
// Generated Oct 5, 2019, 3:25:22 PM by Hibernate Tools 5.4.3.Final

import java.util.Date;

/**
 * ServiceType generated by hbm2java
 */
public class ServiceType implements java.io.Serializable {

	private Integer serviceTypeId;
	private String serviceTypeName;
	private String serviceTypeCode;
	private String serviceTypeDescription;
	private Integer createby;
	private Date cretatedate;
	private Integer isdeleted;

	public ServiceType() {
	}

	public ServiceType(String serviceTypeName, String serviceTypeCode, String serviceTypeDescription) {
		this.serviceTypeName = serviceTypeName;
		this.serviceTypeCode = serviceTypeCode;
		this.serviceTypeDescription = serviceTypeDescription;
	}

	public ServiceType(String serviceTypeName, String serviceTypeCode, String serviceTypeDescription, Integer createby,
			Date cretatedate, Integer isdeleted) {
		this.serviceTypeName = serviceTypeName;
		this.serviceTypeCode = serviceTypeCode;
		this.serviceTypeDescription = serviceTypeDescription;
		this.createby = createby;
		this.cretatedate = cretatedate;
		this.isdeleted = isdeleted;
	}

	public Integer getServiceTypeId() {
		return this.serviceTypeId;
	}

	public void setServiceTypeId(Integer serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	public String getServiceTypeName() {
		return this.serviceTypeName;
	}

	public void setServiceTypeName(String serviceTypeName) {
		this.serviceTypeName = serviceTypeName;
	}

	public String getServiceTypeCode() {
		return this.serviceTypeCode;
	}

	public void setServiceTypeCode(String serviceTypeCode) {
		this.serviceTypeCode = serviceTypeCode;
	}

	public String getServiceTypeDescription() {
		return this.serviceTypeDescription;
	}

	public void setServiceTypeDescription(String serviceTypeDescription) {
		this.serviceTypeDescription = serviceTypeDescription;
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
