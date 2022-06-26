package com.zensar.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zensar.bean.Adverties;

@Repository
public interface AdvertiesDAO extends JpaRepository<Adverties, Integer> {

}
