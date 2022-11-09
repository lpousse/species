package fr.diginamic.species.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.diginamic.species.entities.Authority;
import fr.diginamic.species.entities.User;
import fr.diginamic.species.repositories.AuthorityRepository;
import fr.diginamic.species.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AuthorityRepository authorityRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> findAll()
	{
		return userRepo.findAll();
	}
	
	@Transactional
	public User findByUsername(String username)
	{
		return userRepo.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User with login " + username + " not found."));
	}
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = findByUsername(username);
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getAuthorities().forEach(a -> authorities.add(new SimpleGrantedAuthority(a.getName())));
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
	}
	
	public User createUser(String username, String password)
	{
		User user = new User(username, passwordEncoder.encode(password));	
		
		Authority authority = authorityRepo.findById("ROLE_USER").orElseThrow(() -> new RuntimeException("Authority ROLE_USER not found"));
		user.setAuthorities(List.of(authority));
		return userRepo.save(user);
	}

}
