package com.nighthawk.spring_portfolio.mvc.jwt;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nighthawk.spring_portfolio.mvc.person.*;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private PersonJpaRepository repository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Person person = repository.findByEmail(email);
		if (person != null) {
			return new User(person.getEmail(), person.getPassword(),
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + email);
		}
	}
}