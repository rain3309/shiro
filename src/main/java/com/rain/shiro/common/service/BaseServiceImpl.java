package com.rain.shiro.common.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rain.shiro.common.orm.Limitable;

@Service
@Transactional(readOnly=true)
public class BaseServiceImpl<T> implements BaseService<T>{

	
	private BaseDao<T> dao;
	@Autowired
	public void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}
	
	@Override
	public T save(T bean) {
		return dao.save(bean);
	}
	
	@Override
	public T get(Integer id) {
		return dao.findOne(id);
	}

	@Override
	public List<T> findAll() {
		return dao.findAll();
	}

	@Override
	public List<T> findAll(Map<String,String[]> params, Limitable limit) {
		return dao.findAll(spec(params), limit);
	}

	@Override
	public Page<T> findAll(Map<String,String[]> params, Pageable pageable) {
		return dao.findAll(spec(params), pageable);
	}

	@Override
	public T delete(Integer id) {
		T bean = get(id);
		return dao.delete(bean);
	}
	
	public Specification<T> spec(Map<String,String[]> params){
		Specification<T> spec = new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				Path exp = root;
				List<Predicate> predicates = new ArrayList<>();
				for(Entry<String, String[]> entry : params.entrySet()) {
					String key = entry.getKey();
					String[] val = entry.getValue();
					String[] keys = key.split("\\.");
					exp = exp.get(keys[1]);
					switch(keys[0]) {
						case "EQ":
							predicates.add(builder.equal(exp, val[0]));
							break;
						case "LIKE":
							predicates.add(builder.like(exp, val[0]));
							break;
						case "LT":
							predicates.add(builder.lt(exp, Integer.parseInt(val[0])));
							break;
						case "GT":
							predicates.add(builder.gt(exp, Integer.parseInt(val[0])));
							break;
					}
				}
				if (predicates.size() > 0) {
					return builder.and(predicates.toArray(new Predicate[predicates.size()]));
				}
				return builder.conjunction();
			}
		};
		return spec;
	}

}
