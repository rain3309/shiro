package com.rain.shiro.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert(value=true)
@DynamicUpdate(value=true)
@Table(name="sys_role")
public class Role implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String perms;
	private Boolean allPerms;
	
	private Set<UserRole> userroles = new HashSet<>();

	@Id
	@TableGenerator(name="tg_sys_role",pkColumnName="f_table",pkColumnValue="sys_role",table="t_id_table",valueColumnName="f_id_value",initialValue=1,allocationSize=1)
	@GeneratedValue(strategy= GenerationType.TABLE,generator="tg_sys_role")
	@Column(name="f_id",unique=true,nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="f_name",length=32)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="f_perm",length=1024)
	public String getPerms() {
		return perms;
	}

	public void setPerms(String perms) {
		this.perms = perms;
	}
	@Column(name="f_allperms",nullable=false,length=1)
	public Boolean getAllPerms() {
		return allPerms;
	}

	public void setAllPerms(Boolean allPerms) {
		this.allPerms = allPerms;
	}

	@OneToMany(fetch=FetchType.LAZY,mappedBy="role")
	public Set<UserRole> getUserroles() {
		return userroles;
	}

	public void setUserroles(Set<UserRole> userroles) {
		this.userroles = userroles;
	}

}
