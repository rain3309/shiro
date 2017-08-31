package com.rain.shiro.common.orm;

import org.springframework.data.domain.Sort;

public interface Limitable {
	
	public Integer getFirstResult();
	
	public Integer getMaxResult();
	
	public Integer getLastResult();
	
	public Sort getSort();
	
	public void setSort();

}
