/**
 * 
 */
package com.sky.biz.sseries;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.sky.biz.sseries.usm.services.CustomUserDetailsService; 
@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
/**
 * @author MrMai
 *
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
	
//	 @Override  
//	    protected void configure(HttpSecurity http) throws Exception {  
//	        http  
//	            .authorizeRequests()  
//	                .antMatchers("/admin/**").hasAuthority("ADMIN")  
//	                .antMatchers("/user/**").hasAuthority("USER")  
//	                .anyRequest().authenticated()  
//	            .and()  
//	            .formLogin()  
//	            .and()  
//	            .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");  
//	        ;  
//	    }  
//	 
//	 @Override  
//	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {  
//	        auth.userDetailsService(userDetailsServiceBean());  
//	    }  
//	  
//	    @Override  
//	    public UserDetailsService userDetailsServiceBean() throws Exception {  
//	        return new CustomUserDetailsService();  
//	    }
}
