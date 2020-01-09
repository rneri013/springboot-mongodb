package com.neri.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neri.springboot.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/user")
	public String getUsers(Model model) {
		model.addAttribute("usersList",userService.findAll());
		
		return "user";
		
	}
}
