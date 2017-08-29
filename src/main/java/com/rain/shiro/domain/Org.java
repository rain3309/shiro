package com.rain.shiro.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="sys_org")
public class Org implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String address;
	private String city;
	private String phone;
	private String email;
	private String orgCode;
	private String province;
	private String fax;
	
	private Org parent;
	private List<Org> children;
	
	@Id
	@TableGenerator(name="tg_sys_org",pkColumnName="f_table",pkColumnValue="sys_org",valueColumnName="f_id_value",table="t_id_table",initialValue=1,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="tg_sys_org")
	@Column(name="f_id",nullable=false,unique=true)
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
	@Column(name="f_address",length=64)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="f_city",length=16)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name="f_phone",length=16)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name="f_email",length=16)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="f_orgCode",length=16)
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	@Column(name="f_province",length=8)
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Column(name="f_fix",length=16)
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="f_parent_id")
	public Org getParent() {
		return parent;
	}
	public void setParent(Org parent) {
		this.parent = parent;
	}
	@OneToMany(fetch=FetchType.LAZY,mappedBy="parent")
	public List<Org> getChildren() {
		return children;
	}
	public void setChildren(List<Org> children) {
		this.children = children;
	}
}
