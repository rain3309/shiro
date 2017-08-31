package com.rain.shiro.common.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.rain.shiro.common.orm.Limitable;

public interface BaseService<T> {

	public T get(Integer id);
	
	public List<T> findAll();
	
	public List<T> findAll(Map<String, String[]> params,Limitable limit);
	
	public Page<T> findAll(Map<String, String[]> params,Pageable page);
	
	public T delete(Integer id);
	
	public T save(T bean);
	
}
