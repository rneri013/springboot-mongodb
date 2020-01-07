package com.neri.springboot.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.neri.springboot.entity.User;
import com.neri.springboot.repository.UserRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		List<User> users = userRepository.findAll();

		if (users.isEmpty()) {

			createUser("Renan Neri", "renan.neri@nava.com.br");
			createUser("Layla Morais", "layla@gmail.com");
			createUser("Renan de Novo", "renan@gmail.com");

		}
		 User user = userRepository.findByNameIgnoreCaseLike("lay");
		 System.out.println(user.getName());
		 
		 User user2 = userRepository.findByEmailQuery("renan.neri@nava.com.br");
		 System.out.println(user2.getName());
		 //		 user.setName("Renan");
//		 userRepository.save(user);
		 

	}
	
	public void createUser(String name, String email) {
		User user = new User(name, email);
		userRepository.save(user);
	}
	

}
