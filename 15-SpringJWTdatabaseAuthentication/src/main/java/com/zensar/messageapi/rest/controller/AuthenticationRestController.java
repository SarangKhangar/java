package com.zensar.messageapi.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.zensar.messageapi.entity.ZensarUser;
import com.zensar.messageapi.security.jwt.util.JWTUtil;

@RestController
public class AuthenticationRestController {

	@Autowired
	private JWTUtil util;

	@Autowired
	private AuthenticationManager manager;

	@PostMapping("/api/authenticate")
	public ResponseEntity authenticate(@RequestBody ZensarUser user) {

		UsernamePasswordAuthenticationToken authenticationToken;
		authenticationToken = new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword(),
				AuthorityUtils.createAuthorityList("ROLE_USER"));
        try {
		manager.authenticate(authenticationToken);
		
		String token = util.generateToken(user.getName());
		ResponseEntity<String> entity = new ResponseEntity<String>(token, HttpStatus.OK);
		
		return entity;
		
        } 
        catch (Exception e)
        {
    		ResponseEntity<String> entity = new ResponseEntity<String>("not authenticated", HttpStatus.UNAUTHORIZED);

        	return entity;
        }
        
	}

}
