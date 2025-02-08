package com.springootrestcrud.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSpringController {

	/*
	 * @Bean public InMemoryUserDetailsManager userDetailManager() {
	 * 
	 * UserDetails john = User.builder() .username("john")
	 * .password("{noop}test123") .roles("EMPLOYEE") .build();
	 * 
	 * UserDetails mary = User.builder() .username("mary")
	 * .password("{noop}test123") .roles("EMPLOYEE", "MANAGER") .build();
	 * 
	 * UserDetails susan = User.builder() .username("susan")
	 * .password("{noop}test123") .roles("EMPLOYEE", "MANAGER", "ADMIN") .build();
	 * return new InMemoryUserDetailsManager(john,mary,susan); }
	 */
	// add support for JDBC and no more hard coded uses
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		 JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

	        // define query to retrieve a user by username
	        jdbcUserDetailsManager.setUsersByUsernameQuery(
	                "select user_id, pw, active from members where user_id=?");

	        // define query to retrieve the authorities/roles by username
	        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
	                "select user_id, role from roles where user_id=?");

	        return jdbcUserDetailsManager;  
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception {
		
		http.authorizeHttpRequests(configurer -> configurer
				.requestMatchers(HttpMethod.GET, "/api/employee").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET,"/api/employee/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST,"/api/employee").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT,"/api/employee/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE,"/api/employee/**").hasRole("ADMIN")
				);
		// use http basic authentication
		
		http.httpBasic(Customizer.withDefaults());
		
		// disable cross site request forgery, not required for REST controllers
		
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
	}
}
