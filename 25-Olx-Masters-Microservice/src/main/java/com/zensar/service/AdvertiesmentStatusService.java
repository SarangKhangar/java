package com.zensar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.bean.AdvertiesmentStatus;
import com.zensar.db.AdvertiesmentStatusDAO;

@Service
public class AdvertiesmentStatusService {
	
	@Autowired
	AdvertiesmentStatusDAO dao;
	
	public AdvertiesmentStatus addAdvertiesmentStatus(AdvertiesmentStatus advstatus) {
		return this.dao.save(advstatus);
	}
	
	public List<AdvertiesmentStatus> getAllAdvertiesmentStatus() {
		return  this.dao.findAll();
	}

}
