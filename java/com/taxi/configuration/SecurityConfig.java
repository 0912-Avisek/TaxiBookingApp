package com.taxi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	

	private  LogoutHandler logouthandle;

    @Autowired
	public void setLogouthandle(LogoutHandler logouthandle) {
		this.logouthandle = logouthandle;
	}





	@Bean
    SecurityFilterChain getsecurityfilterchain(HttpSecurity httpsecurity) throws Exception {
		
		httpsecurity
		.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(authorize-> authorize
				.requestMatchers("/admin/**").authenticated()
				.requestMatchers("/**").permitAll())
		.formLogin(form->form
				.permitAll()
				)
		.logout(logout->logout
				.addLogoutHandler(logouthandle)
				//.logoutUrl("/dologout")
				)
		;
		
		
		return httpsecurity.build();
	}
	
}
