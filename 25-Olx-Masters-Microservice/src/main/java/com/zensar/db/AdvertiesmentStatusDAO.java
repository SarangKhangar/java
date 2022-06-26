package com.zensar.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zensar.bean.AdvertiesmentStatus;

@Repository
public interface AdvertiesmentStatusDAO extends JpaRepository<AdvertiesmentStatus, Integer> {

}
