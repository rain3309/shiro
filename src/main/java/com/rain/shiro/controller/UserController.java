package com.rain.shiro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rain.shiro.domain.User;
import com.rain.shiro.service.UserService;

@Controller
public class UserController {

	private UserService service;
	@Autowired
	public void setService(UserService service) {
		this.service = service;
	}
	@RequestMapping(value="index")
	public void index(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("serviceµÄÖµ£º ----------------- "+service);
		User user = service.get(1);
		System.out.println(user);
	}
}
