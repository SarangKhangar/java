package com.zensar.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zensar.bean.Adverties;
import com.zensar.db.AdvertiesDAO;

@Service
public class AdvertiesService {

	@Autowired
	AdvertiesDAO dao;

	public Adverties addAdveries(Adverties adverties) {
		return this.dao.save(adverties);
	}

	public List<Adverties> getAllAdverties() {
		return this.dao.findAll();
	}

	public Adverties updateAdverties(Adverties adverties, Integer id) {
		return this.dao.save(adverties);
	}
	public boolean deleteAdvertiseById(Integer id) {
		dao.deleteById(id);
		if (dao.findById(id) != null) {
			return false;
		}
		return true;
	}

	public Adverties getCategoryId(int categoryId) {
		Optional<Adverties> optional = dao.findById(categoryId);
		if (optional.isPresent())
			return optional.get();
		return null;
	}

}
