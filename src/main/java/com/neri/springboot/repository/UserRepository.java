package com.neri.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neri.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("select u from User u where u.name like %?1%")
	User findByName2(String name);

	User findByNameIgnoreCase(String name);
}
