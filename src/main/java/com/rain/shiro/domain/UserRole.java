package com.rain.shiro.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="sys_userrole")
public class UserRole implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer roleIndex;
	private User user;
	private Role role;
	
	@Id
	@TableGenerator(name="tg_sys_userrole",pkColumnName="f_table",pkColumnValue="sys_userrole",table="t_id_table",valueColumnName="f_id_value",initialValue=1,allocationSize=1)
	@GeneratedValue(strategy= GenerationType.TABLE,generator="tg_sys_userrole")
	@Column(name="f_id",unique=true,nullable=false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="f_index")
	public Integer getRoleIndex() {
		return roleIndex;
	}
	public void setRoleIndex(Integer roleIndex) {
		this.roleIndex = roleIndex;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="f_user_id",nullable=false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="f_role_id",nullable=false)
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

}
