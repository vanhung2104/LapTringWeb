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

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO [users](email, username, fullname, password, image, roleid, phone, createdate) VALUES (?,?,?,?,?,?,?,?)";
		try {
			Connection conn = new ConDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getImage());
			ps.setInt(6, user.getRoleid());
			ps.setString(7, user.getPhone());
			ps.setDate(8, user.getCreateDate());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from [users] where email = ?";
		try {
			Connection conn = new ConDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from [users] where username = ?";
		try {
			Connection conn = new ConDB().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}
	
	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {

		try {
			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);
			UserModel user = new UserModel("vanhung", "hung1", "hehi", "123", null, 5, "123", date);
			IUserDao userDao = new UserDaoImpl();
			userDao.insert(user);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
