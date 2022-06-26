package com.zensar.messageapi.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.messageapi.entity.ZensarUser;

@Repository
public interface ZensarUserRepository extends JpaRepository<ZensarUser, Integer> {
	

	ZensarUser findByName(String username);

}
