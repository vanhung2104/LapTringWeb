package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.ConDB;
import vn.iotstar.dao.ICategoryDao;
import vn.iotstar.models.CategoryModel;

public class CategoryDaoImpl implements ICategoryDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<CategoryModel> findAll() {
		String sql = "select * from Categories";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = new ConDB().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("cate_id"));
				category.setCategoryname(rs.getString("cate_name"));
				category.setImage(rs.getString("icons"));
				category.setStatus(rs.getInt("status"));
				list.add(category);
			}
			conn.close();
			ps.close();
			rs.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CategoryModel findById(int id) {
		String sql = "select * from Categories where cate_id = ?";
		CategoryModel category = new CategoryModel();
		try {
			conn = new ConDB().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {

				category.setCategoryid(rs.getInt("cate_id"));
				category.setCategoryname(rs.getString("cate_name"));
				category.setImage(rs.getString("icons"));
				category.setStatus(rs.getInt("status"));

			}
			conn.close();
			ps.close();
			rs.close();
			return category;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CategoryModel findName(String name) {
		String sql = "select * from Categories where cate_name = ?";
		CategoryModel category = new CategoryModel();
		try {
			conn = new ConDB().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {

				category.setCategoryid(rs.getInt("cate_id"));
				category.setCategoryname(rs.getString("cate_name"));
				category.setImage(rs.getString("icons"));
				category.setStatus(rs.getInt("status"));

			}
			conn.close();
			ps.close();
			rs.close();
			return category;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CategoryModel> searchByName(String keyword) {
		String sql = "select * from Categories where cate_name like ?";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = new ConDB().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("cate_id"));
				category.setCategoryname(rs.getString("cate_name"));
				category.setImage(rs.getString("icons"));
				category.setStatus(rs.getInt("status"));
				list.add(category);
			}
			conn.close();
			ps.close();
			rs.close();
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(CategoryModel category) {
		String sql = "insert into Categories(cate_name,icons,status) values (?,?,?)";
		try {
			conn = new ConDB().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImage());
			ps.setInt(3, category.getStatus());
			ps.executeUpdate();

			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(CategoryModel category) {
		String sql = "update Categories set cate_name = ?, icons = ?, status = ? where cate_id = ?";
		try {
			conn = new ConDB().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImage());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getCategoryid());
			ps.executeUpdate();

			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(CategoryModel category) {
		String sql = "delete from Categories where cate_id = ?";
		try {
			conn = new ConDB().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, category.getCategoryid());
			ps.executeUpdate();

			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateStatus(int id, int status) {
		String sql = "update Categories set status = ? where cate_id = ?";
		try {
			conn = new ConDB().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, id);
			ps.executeUpdate();

			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
