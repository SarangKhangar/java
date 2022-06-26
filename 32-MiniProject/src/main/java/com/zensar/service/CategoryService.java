package com.zensar.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.bean.Address;
import com.zensar.bean.Category;
import com.zensar.db.CategoryDAO;

@Service
public class CategoryService {

	@Autowired
	CategoryDAO dao;

	public Category addCategory(Category category) {
		return this.dao.save(category);
	}

	public Category findByCategoryId(String categoryId) {
         return this.dao.findById(categoryId).get();
	}

	public Category updateCategoryById(Category category, String id) {
		Optional<Category> optional = this.dao.findById(id);
        if(optional.isPresent()) {
		return dao.save(category);
        }
        return category;
	}

	public boolean findByCategoryIdToDelete(String categoryId) {
		Optional<Category> optional = this.dao.findById(categoryId);
		if (optional.isPresent()) {
			this.dao.deleteById(categoryId);
			return true;}
		else {
		return false;}
	}

	public List<Category> viewAllCategories() {
		return this.dao.findAll();
	}

}
