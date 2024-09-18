package vn.iotstar.models;

import java.io.Serializable;

public class RoleModel implements Serializable{
private static final long serialVersionUID = 1L;
	
	//khai báo các trường trong Table
	private int roleid;
	private String rolename;
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public RoleModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoleModel(int roleid, String rolename) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
	}
	@Override
	public String toString() {
		return "RoleModel [roleid=" + roleid + ", rolename=" + rolename + "]";
	}

}
