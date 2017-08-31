package com.rain.shiro.repository;


import com.rain.shiro.common.service.BaseDao;
import com.rain.shiro.domain.User;

public interface UserDao extends BaseDao<User>{
	
	public User findByUsername(String username);
}
