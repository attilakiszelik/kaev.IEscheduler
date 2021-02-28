package com.kaev.IEscheduler.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception{
		
		auth
			.inMemoryAuthentication()
				.withUser("user1")
				.password("{noop}user1")
				.roles("USER")
			.and()
				.withUser("user2")
				.password("{noop}user2")
				.roles("USER")
			.and()
				.withUser("kaev")
				.password("{noop}pass")
				.roles("ADMIN");	
		
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception{
		
		http
			.authorizeRequests()
/*				.antMatchers(HttpMethod.GET,"/").permitAll()
				.antMatchers("/new").hasRole("USER")
				.antMatchers("/update/*").hasRole("ADMIN")
				.antMatchers("/delete/*").hasRole("ADMIN")
*/				.antMatchers("/css/loginStyleSheet.css").permitAll()
				.antMatchers("/images/MAN.jpg").permitAll()
				.antMatchers("/registration").permitAll()
				.antMatchers("/reg").permitAll()
/*				.antMatchers("/new_password").permitAll()
				.antMatchers("/nwpsswrd").permitAll()
*/				.anyRequest().authenticated()
			.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
			.and()
				.logout()
				.logoutSuccessUrl("/login?logout")
				.permitAll();
		//TODO: only for test period
		http
			.csrf()
				.disable()
			.headers().
				frameOptions().disable();
	
	}
	
}
