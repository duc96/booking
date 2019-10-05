package src.main.Model.Response;

import java.text.SimpleDateFormat;
import java.util.Date;
import src.main.java.booking.AdminUserRole;

public class UserRoleResponse {
	private Integer id;
	private Integer index;
	private	String user_role_name;
	private String user_role_description;
	private String cretatedate;
	
	/**
	 * Serialize data
	 * @param userRole
	 */
	public void serialize(AdminUserRole userRole)
	{
		this.user_role_name = userRole.getUserRoleName();
		this.user_role_description = userRole.getUserRoleDescription();
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy");
		this.cretatedate = format.format(userRole.getCretatedate());
	}
	
	/**
	 * Set index of row
	 * @return
	 */
	public Integer getIndex() {
		return this.index;
	}

	/**
	 * Get index of row
	 * @param index
	 */
	public void setIndex(Integer index) {
		this.index = index;
	}
}
