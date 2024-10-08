package vn.iotstar.services;

import java.util.List;

import vn.iotstar.models.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();

	CategoryModel findById(int id);

	CategoryModel findName(String name);
	
	Boolean checkName(String name);

	List<CategoryModel> searchByName(String keyword);

	void insert(CategoryModel category);

	void update(CategoryModel category);

	void delete(CategoryModel category);
	
	void updateStatus(int id, int status);
}
