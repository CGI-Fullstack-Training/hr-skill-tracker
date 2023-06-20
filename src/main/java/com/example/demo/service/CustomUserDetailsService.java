package com.example.demo.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

	private UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		log.info("loadUserByUsername :: {}",usernameOrEmail);
		User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(
				() -> new UsernameNotFoundException("User not found with username or email: " + usernameOrEmail));
log.info("user details from DB {}",user);
		Set<GrantedAuthority> authorities = user.getRoles().stream()
				.map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
		 org.springframework.security.core.userdetails.User u1 = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
		log.info("u1 {} ",u1);
		 return u1;
	}
}
