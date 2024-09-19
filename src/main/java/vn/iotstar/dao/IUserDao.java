package vn.iotstar.dao;

import vn.iotstar.models.UserModel;

public interface IUserDao {

	UserModel findByUsername(String username);

	public  void insert(UserModel user);
	
	public void update(UserModel user);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);
}
