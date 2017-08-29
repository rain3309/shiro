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
@Table(name="sys_usergroup")
public class UserMemberGroup implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer groupIndex;
	private User user;
	private MemberGroup group;
	@Id
	@TableGenerator(name="tg_sys_usergroup",pkColumnName="f_table",pkColumnValue="sys_usergroup",valueColumnName="f_id_value",table="t_id_table",initialValue=1,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="tg_sys_usergroup")
	@Column(name="f_id",nullable=false,unique=true)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="f_index")
	public Integer getGroupIndex() {
		return groupIndex;
	}
	public void setGroupIndex(Integer groupIndex) {
		this.groupIndex = groupIndex;
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
	@JoinColumn(name="f_group_id",nullable=false)
	public MemberGroup getGroup() {
		return group;
	}
	public void setGroup(MemberGroup group) {
		this.group = group;
	}
	
}
