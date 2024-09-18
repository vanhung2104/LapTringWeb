package vn.iotstar.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//khai báo các trường trong Table
	private int id;
	private String username;
	private String email;
	private String fullname;
	private String password;
	private int roleid;
	private String image;
	private String phone;
	private Date createDate;
	public UserModel(String email, String username, String fullname, String password,String image, int roleid, 
			String phone, Date createDate) {
		super();
		this.username = username;
		this.email = email;
		this.fullname = fullname;
		this.password = password;
		this.roleid = roleid;
		this.image = image;
		this.phone = phone;
		this.createDate = createDate;
	}
	//tạo constructor
	public UserModel() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", email=" + email + ", fullname=" + fullname
				+ ", password=" + password + ", roleid=" + roleid + ", image=" + image + ", phone=" + phone
				+ ", createDate=" + createDate + "]";
	}
}
