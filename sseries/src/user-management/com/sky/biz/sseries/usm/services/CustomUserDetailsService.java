/**
 * 
 */
package com.sky.biz.sseries.usm.services;
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.springframework.security.core.GrantedAuthority;  
import org.springframework.security.core.authority.SimpleGrantedAuthority;  
import org.springframework.security.core.userdetails.UserDetails;  
import org.springframework.security.core.userdetails.UserDetailsService;  
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sky.biz.sseries.usm.dto.UserAccountDTO;

import javax.transaction.Transactional;
import java.util.HashSet;  
import java.util.Set; 
/**
 * @author User
 *
 */
@Transactional  
public class CustomUserDetailsService {//implements UserDetailsService{

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);

	//@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		if(!"user".equals(username)){
			LOGGER.debug("user not found with the provided username");  
            return null;
		}
		LOGGER.debug(" user from username " + username);
		return null;
		//return new UserDTO(username, "password", getAuthorities(),"FCNF"); 
	}
	
	private Set<GrantedAuthority> getAuthorities(){  
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();  
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("admin");  
        authorities.add(grantedAuthority);  
//        for(Role role : user.getRoles()) {  
//            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());  
//            authorities.add(grantedAuthority);  
//        }  
        LOGGER.debug("user authorities are " + authorities.toString());  
        return authorities;  
    }  
}
