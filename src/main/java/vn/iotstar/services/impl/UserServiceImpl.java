package vn.iotstar.services.impl;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class UserServiceImpl implements IUserService {

	IUserDao userDao = new UserDaoImpl();

	@Override
	public UserModel findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);
	}

	@Override
	public UserModel login(String username, String password) {

		UserModel user = this.findByUsername(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}
	
	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		userDao.insert(new UserModel(email, username, fullname, password, null, 5, phone, date));
		return true;
	}
	
	@Override
	public boolean resetpassword(String username, String email, String password) {
		UserModel user = new UserModel();
		user = userDao.findByUsername(username);
		user.setPassword(password);
		userDao.update(user);
		return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);

	}
	
	public static void main(String[] args) {

		try {
			IUserService userService = new UserServiceImpl();
			boolean kt = userService.resetpassword("hung6", "vanhung21@gmail.com", "5");
			System.out.println(userService.findByUsername("hung6"));

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
