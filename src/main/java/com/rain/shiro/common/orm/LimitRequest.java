package com.rain.shiro.common.orm;

import java.io.Serializable;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class LimitRequest implements Limitable,Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer firstResult;
	private Integer maxResult;
	private Sort sort;

	public LimitRequest(Integer firstResult,Integer maxResult) {
		this(firstResult,maxResult,null);
	}
	
	public LimitRequest(Integer firstResult,Integer maxResult,Direction direction,String ... properties) {
		this(firstResult,maxResult,new Sort(direction,properties));
	}
	
	public LimitRequest(Integer firstResult,Integer maxResult,Sort sort) {
		if(firstResult != null && firstResult > 0) {
			this.firstResult = firstResult;
		}
		if(maxResult != null && maxResult >0) {
			this.maxResult = maxResult;
		}
		this.sort = sort;
	}
	
	@Override
	public Integer getFirstResult() {
		return firstResult;
	}

	@Override
	public Integer getMaxResult() {
		return maxResult;
	}

	@Override
	public Integer getLastResult() {
		Integer lastResult = 0;
		Integer firstResult = getFirstResult();
		if(firstResult != null && firstResult > 0) {
			lastResult += firstResult;
		}
		Integer maxResult = getMaxResult();
		if(maxResult != null && maxResult > 0) {
			lastResult += maxResult;
		}
		return lastResult;
	}

	@Override
	public Sort getSort() {
		// TODO Auto-generated method stub
		return sort;
	}

	@Override
	public void setSort() {
		
	}

}
