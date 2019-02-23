package com.app.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();
	
	
	@Autowired
	private com.app.services.UserDetailsService userDetailsService;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try
		{
			com.app.models.UserDetails findFirst = userDetailsService.findByUserName(username);
			return new JwtUserDetails(findFirst.getUsername(),findFirst.getPassword(),findFirst.getRole());
		}
		catch(Exception e)
		{
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}
	
	}

}