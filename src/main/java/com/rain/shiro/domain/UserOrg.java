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
@Table(name="sys_userorg")
public class UserOrg implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer orgIndex;
	private User user;
	private Org org;
	
	@Id
	@TableGenerator(name="tg_sys_userorg",pkColumnName="f_table",pkColumnValue="sys_userorg",valueColumnName="f_id_value",table="t_id_table",initialValue=1,allocationSize=1)
	@GeneratedValue(generator="tg_sys_userorg",strategy=GenerationType.TABLE)
	@Column(name="f_id",nullable=false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="f_index")
	public Integer getOrgIndex() {
		return orgIndex;
	}
	public void setOrgIndex(Integer orgIndex) {
		this.orgIndex = orgIndex;
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
	@JoinColumn(name="f_org_id",nullable=false)
	public Org getOrg() {
		return org;
	}
	public void setOrg(Org org) {
		this.org = org;
	}

}
