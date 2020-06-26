package com.lms.authserver.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lms.authserver.models.Users;
import com.lms.authserver.repo.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	/*
	 * @Autowired private UsersRepository usersRepository;
	 */
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		
		/*
		 * Users u1= new Users(); u1.setEmail("ytu@123.com"); Role r1 =new Role();
		 * r1.setRole("Admin"); Set<Role> roleSet = new HashSet(); roleSet.add(r1);
		 * u1.setRoles(roleSet); u1.setLastName("ABC"); u1.setActive(1);
		 * u1.setName("Test3"); u1.setPassword("abc123");
		 * usersRepository.saveAndFlush(u1);
		 */
		 

		Optional<Users> usersOptional = usersRepository.findByName(username);

		usersOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
		return usersOptional.map(CustomUserDetails::new).get();
	}
}
