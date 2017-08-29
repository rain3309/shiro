package com.rain.shiro.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="sys_membergroup")
public class MemberGroup implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String description;
	private String ip;
	private Integer type;
	private Integer seq;
	
	@Id
	@TableGenerator(name="tg_sys_membergroup",pkColumnName="f_table",pkColumnValue="sys_membergroup",valueColumnName="f_id_value",table="t_id_table",initialValue=1,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="tg_sys_membergroup")
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
	@Column(name="f_desc",length=512)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name="f_ip",length=32)
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Column(name="f_type")
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Column(name="f_seq")
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	
}
