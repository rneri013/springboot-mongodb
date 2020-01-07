package com.neri.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.neri.springboot.entity.User;

public interface UserRepository extends MongoRepository<User, String>{

//	@Query("select u from User u where u.name like %?1%")
	User findByName(String name);

	User findByNameIgnoreCaseLike(String name);
	
	@Query("{'email': ?0}")
	User findByEmailQuery(String email);
}
