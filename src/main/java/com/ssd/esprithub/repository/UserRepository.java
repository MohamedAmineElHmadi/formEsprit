package com.ssd.esprithub.repository;

import org.springframework.data.repository.CrudRepository;

import com.ssd.esprithub.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	User findByEmail(String email);

}