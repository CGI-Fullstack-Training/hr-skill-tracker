package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//		http.csrf().disable().authorizeHttpRequests((authorize) ->
//		// authorize.anyRequest().authenticated()
//		authorize.antMatchers("/associate/**", "/skill/**", "/api/auth/**").permitAll().anyRequest().authenticated()
//
//		);

		http.csrf().disable().authorizeHttpRequests((authorize) -> authorize.antMatchers(HttpMethod.GET, "/associate")
				.hasRole("HR").antMatchers(HttpMethod.POST, "/associate").hasRole("HR")
				.antMatchers(HttpMethod.PUT, "/associate").hasRole("HR").antMatchers(HttpMethod.DELETE).hasRole("HR"));

		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf -> csrf.disable());
		http.headers(headers -> headers.frameOptions().disable());

		return http.build();
	}
}
