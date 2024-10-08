package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.ICategoryDao;
import vn.iotstar.dao.impl.CategoryDaoImpl;
import vn.iotstar.models.CategoryModel;
import vn.iotstar.services.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {
	public ICategoryDao cateDao = new CategoryDaoImpl();

	@Override
	public List<CategoryModel> findAll() {
		return cateDao.findAll();
	}

	@Override
	public CategoryModel findById(int id) {
		// TODO Auto-generated method stub
		return cateDao.findById(id);
	}

	@Override
	public CategoryModel findName(String name) {
		// TODO Auto-generated method stub
		return cateDao.findName(name);
	}

	@Override
	public Boolean checkName(String name) {
		CategoryModel cate = this.findName(name);
		if (cate.getCategoryid() == 0) {
			return false;
		}
		return true;
	}

	@Override
	public List<CategoryModel> searchByName(String keyword) {
		// TODO Auto-generated method stub
		return cateDao.searchByName(keyword);
	}

	@Override
	public void insert(CategoryModel category) {
		Boolean check = this.checkName(category.getCategoryname());
		if (!check) {
			cateDao.insert(category);
		}
	}

	@Override
	public void update(CategoryModel category) {
		Boolean check = this.checkName(category.getCategoryname());
		if (check) {
			cateDao.update(category);
		}
	}

	@Override
	public void delete(CategoryModel category) {
		Boolean check = this.checkName(category.getCategoryname());
		if (check) {
			cateDao.delete(category);
		}
	}

	@Override
	public void updateStatus(int id, int status) {
		// TODO Auto-generated method stub
		cateDao.updateStatus(id, status);
	}

	public static void main(String[] args) {
		ICategoryService cate = new CategoryServiceImpl();
		CategoryModel category = cate.findName("realme");
		cate.insert(new CategoryModel(1, "realme", null, 0));
		System.out.println(category);
		if (cate.checkName("realme")) {
			System.out.println("có");
		} else {
			System.out.println("không");
		}
	}
}
