package vn.iotstar.dao;

import vn.iotstar.models.UserModel;

public interface IUserDao {
	
	UserModel findByUsername(String username); 
}
