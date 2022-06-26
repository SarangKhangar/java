package com.zensar.messageapi.security.jwt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.zensar.messageapi.security.jwt.util.JWTUtil;

public class JWTFilter extends BasicAuthenticationFilter {
	
	public JWTFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//1 Fetch the token from user request generate
		//Bearer token
		String autherizationHeaderValue = request.getHeader("Authorization");
		
		//System.out.println("In do filter");
		if(autherizationHeaderValue!=null)
		{
		String token = autherizationHeaderValue.substring(7);
		
		//Validate the token
		JWTUtil util = new JWTUtil();
		try
		{
			util.validateToken(token);
			
			//if valid allow user to access the resource
			UsernamePasswordAuthenticationToken authenticationToken;
			authenticationToken= new UsernamePasswordAuthenticationToken("zensar", null, AuthorityUtils.createAuthorityList("ROLE_USER"));
			
			//following line authenticate user
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}}
		//Calling filter function must so that next filter in chain will execute
		chain.doFilter(request, response);
	}

}
