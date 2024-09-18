package vn.iotstar.services;

import vn.iotstar.models.UserModel;

public interface IUserService {
	
	UserModel findByUsername(String username);
	
	UserModel login(String username,String password);
}
