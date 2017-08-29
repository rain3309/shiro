package com.rain.shiro.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rain.shiro.domain.User;
import com.rain.shiro.repository.UserDao;
import com.rain.shiro.service.UserService;

@Service
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;
	
	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public User get(Integer id) {
		return dao.findOne(id);
	}

}
