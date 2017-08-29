package com.rain.shiro.repository;

import org.springframework.data.repository.Repository;

import com.rain.shiro.domain.User;

public interface UserDao extends Repository<User, Integer>{
	
	public User findOne(Integer id);

}
