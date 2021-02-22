package com.example.IEscheduler.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	public void configureAuthentitaction (AuthenticationManagerBuilder auth) throws Exception{
		
		auth
			.inMemoryAuthentication()
				.withUser("user1")
				.password("user1")
				.roles("USER")
			.and()
				.withUser("user2")
				.password("user2")
				.roles("USER")
			.and()
				.withUser("kaev")
				.password("pass")
				.roles("ADMIN");	
		
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception{
		
		http
			.authorizeRequests()
				.antMatchers(HttpMethod.GET,"/").permitAll()
				.antMatchers("/new").hasRole("USER")
				.antMatchers("/update/*").hasRole("ADMIN")
				.antMatchers("/delete/*").hasRole("ADMIN")
			.and()
				.formLogin().permitAll();
	
	}
	
}
