package com.zensar.messageapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth .inMemoryAuthentication()
		.withUser("zensar")
		.password("$2a$10$LLLareMXzqsjBEeuXQvXJe5ezAkZJ46a1l3N6HB56FQnHcN/uhZPq")
		.roles("USER")
		.and()
		.withUser("admin")
		.password("$2a$10$s4DriHefxyuYA7iKPLLik.M52v7jANvpCxzEk/nHsvxG0QWkrzJ6G")
		.roles("ADMIN");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		    
		    .csrf().disable()
		    .authorizeRequests()
		    .antMatchers(HttpMethod.POST,"/api/message").hasRole("ADMIN")
		    .anyRequest()
		    .authenticated()
		    .and()
		    .httpBasic()
		    .and()
		    .sessionManagement()
		    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

}

