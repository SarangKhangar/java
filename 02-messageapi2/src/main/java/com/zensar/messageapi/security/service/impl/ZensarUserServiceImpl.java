package com.zensar.messageapi.security.service.impl;

import org.hibernate.jdbc.Expectation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zensar.messageapi.entity.ZensarUser;
import com.zensar.messageapi.repository.ZensarUserRepository;

import antlr.Utils;

@Service
public class ZensarUserServiceImpl implements UserDetailsService {
	
	@Autowired
	private ZensarUserRepository repo; 

	//following method use for fetching useername and password from the database
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ZensarUser foundUser = this.repo.findByName(username);
		
		if(foundUser==null) {
			throw new  UsernameNotFoundException(username);
		}
		
		User authenticaUser = new User(foundUser.getName(), foundUser.getPassword(),AuthorityUtils.createAuthorityList("ROLE_USER"));
		
		return authenticaUser;
	}

}
