package fr.diginamic.species.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http.csrf().disable().authorizeHttpRequests()
			.antMatchers("/species/**").hasRole(Role.ADMIN.name())
			.antMatchers("/person/**").hasAnyRole(Role.ADMIN.name(), Role.USER.name())
			.antMatchers("/**").permitAll()
			.and().httpBasic();
		return http.build();
	}
	
	/*@Bean
	public InMemoryUserDetailsManager userDetailsService()
	{
		UserDetails user = User.withUsername("user")
				.password(passwordEncoder().encode("user123"))
				.roles(Role.USER.name())
				.build();
		
		UserDetails userAdmin = User.withUsername("admin")
				.password(passwordEncoder().encode("admin456"))
				.roles("ADMIN", "USER")
				.build();
		
		return new InMemoryUserDetailsManager(user, userAdmin);
	}*/
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
