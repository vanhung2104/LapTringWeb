package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iotstar.configs.ConDB;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImpl implements IUserDao {

	@Override
	public UserModel findByUsername(String username) {
		String sql = "select * from users where username = ?";
		try {
			Connection conn = new ConDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username); // 1 là vị trí của tham số ?
			ResultSet rs = ps.executeQuery();
			UserModel user = new UserModel();
			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImage(rs.getString("image"));
				user.setRoleid(rs.getInt("roleid"));
				user.setPhone(rs.getString("phone"));
			}
			return user;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {

		try {
			IUserDao userDao = new UserDaoImpl();
			System.out.println(userDao.findByUsername("Hung"));

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
