package com.rain.shiro.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert(value=true)
@DynamicUpdate(value=true)
@Table(name="sys_user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;								//ID
	private String username;						//用户名
	private String password;						//密码
	private String salt;							//盐
	private String email;							//邮箱
	private String realName;						//真实姓名
	private String gender;							//性别
	private String phone;							//电话
	private Date birthDay;							//出生年月
	private String rank;							//等级
	private String type;							//类型
	private String stutas;							//状态
	
	private List<UserRole> userRoles = new ArrayList<>();
	private List<UserOrg> userOrgs = new ArrayList<>();
	private List<UserMemberGroup> groups = new ArrayList<>();
	private Set<UserDetail> details = new HashSet<>();
	
	@Id
	@TableGenerator(name="tg_sys_user",pkColumnName="f_table",pkColumnValue="sys_user",table="t_id_table",valueColumnName="f_id_value",initialValue=1,allocationSize=1)
	@GeneratedValue(strategy= GenerationType.TABLE,generator="tg_sys_user")
	@Column(name="f_user_id",unique=true,nullable=false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="f_username",length=64,unique=true)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name="f_password",length=256)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="f_salt",length=128)
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	@Column(name="f_email",length=64)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="f_realname",length=64)
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	@Pattern(regexp="[F,M]")
	@Column(name="f_gender",length=1)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(name="f_phone",length=16)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="f_birthday")
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	@Column(name="f_rank",length=8)
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	@Column(name="f_type",length=8)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Column(name="f_stutas",length=8)
	public String getStutas() {
		return stutas;
	}
	public void setStutas(String stutas) {
		this.stutas = stutas;
	}
	@OneToMany(fetch=FetchType.LAZY,cascade= {CascadeType.REMOVE},mappedBy="user")
	@OrderBy("roleIndex")
	public List<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	@OneToMany(fetch=FetchType.LAZY,cascade= {CascadeType.REMOVE},mappedBy="user")
	@OrderBy("orgIndex")
	public List<UserOrg> getUserOrgs() {
		return userOrgs;
	}
	public void setUserOrgs(List<UserOrg> userOrgs) {
		this.userOrgs = userOrgs;
	}
	@OneToMany(fetch=FetchType.LAZY,cascade= {CascadeType.REMOVE},mappedBy="user")
	@OrderBy("groupIndex")
	public List<UserMemberGroup> getGroups() {
		return groups;
	}
	public void setGroups(List<UserMemberGroup> groups) {
		this.groups = groups;
	}
	@OneToMany(fetch=FetchType.LAZY,cascade= {CascadeType.REMOVE},mappedBy="user")
	public Set<UserDetail> getDetails() {
		return details;
	}
	public void setDetails(Set<UserDetail> details) {
		this.details = details;
	}

}
