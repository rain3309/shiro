package com.rain.shiro.common.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import com.rain.shiro.common.orm.Limitable;

public interface BaseDao<T> extends Repository<T, Integer> {

	public T findOne(Integer id);
	
	public List<T> findAll(Specification<T> spec,Limitable limit);
	
	public Page<T> findAll(Specification<T> spec,Pageable pageable);
	
	public List<T> findAll();
	
	public T save(T bean);
	
	public T delete(T bean);
	
}
