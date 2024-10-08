package vn.iotstar.models;

import java.io.Serializable;

public class CategoryModel implements Serializable{
	private static final long serialVersionUID = 1L;
	private int categoryid;
	private String categoryname;
	private String image;
	private int status;
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CategoryModel [categoryid=" + categoryid + ", categoryname=" + categoryname + ", image=" + image
				+ ", status=" + status + "]";
	}
	public CategoryModel(int categoryid, String categoryname, String image, int status) {
		super();
		this.categoryid = categoryid;
		this.categoryname = categoryname;
		this.image = image;
		this.status = status;
	}
	public CategoryModel() {
		super();
	}
	
	
}
