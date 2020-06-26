package com.lms.authserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.authserver.models.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	
    Optional<Users> findByName(String username);
    
    @SuppressWarnings("unchecked")
	Users saveAndFlush(Users entity);
}
