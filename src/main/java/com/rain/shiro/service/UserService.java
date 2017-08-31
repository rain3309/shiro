package com.rain.shiro.service;


import com.rain.shiro.common.service.BaseService;
import com.rain.shiro.domain.User;
import com.rain.shiro.domain.UserDetail;

public interface UserService extends BaseService<User>{
	
	public User save(User bean, UserDetail detail, Integer[] roleIds,Integer[] orgIds, Integer[] groupIds, Integer orgId,Integer groupId, String ip);
	
	public User register(String ip, int groupId, int orgId, String username, String password);
	
	public Boolean userExist(String username);
	
	public void updateEmail(Integer id, String email);
	
	public void updatePassword(Integer id,String password);
	
	public User check(Integer id);
	

}
