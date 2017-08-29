package com.rain.shiro.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="sys_userdetail")
public class UserDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private User user;
	private Date validationDate;
	private String validationValue;
	private Date loginErrorDate;
	private Integer loginErrorCount;
	private Date preLoginDate;
	private String preLoginIp;
	private Date lastLoginDate;
	private String lastLoginIp;
	private Date createDate;
	private String createIp;
	
	private Integer logins;
	private String comeFrom;
	private String wechat;
	private String qq;
	private String msn;
	
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@MapsId
	@ManyToOne
	@JoinColumn(name="f_user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="f_validation_date")
	public Date getValidationDate() {
		return validationDate;
	}
	public void setValidationDate(Date validationDate) {
		this.validationDate = validationDate;
	}
	@Column(name="f_validation_value",length=32)
	public String getValidationValue() {
		return validationValue;
	}
	public void setValidationValue(String validationValue) {
		this.validationValue = validationValue;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="f_loginerror_date")
	public Date getLoginErrorDate() {
		return loginErrorDate;
	}
	public void setLoginErrorDate(Date loginErrorDate) {
		this.loginErrorDate = loginErrorDate;
	}
	@Column(name="f_loginerror_count")
	public Integer getLoginErrorCount() {
		return loginErrorCount;
	}
	public void setLoginErrorCount(Integer loginErrorCount) {
		this.loginErrorCount = loginErrorCount;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="f_prelogin_date")
	public Date getPreLoginDate() {
		return preLoginDate;
	}
	public void setPreLoginDate(Date preLoginDate) {
		this.preLoginDate = preLoginDate;
	}
	@Column(name="f_prelogin_ip",length=32)
	public String getPreLoginIp() {
		return preLoginIp;
	}
	public void setPreLoginIp(String preLoginIp) {
		this.preLoginIp = preLoginIp;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="f_lastlogin_date")
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	@Column(name="f_lastlogin_ip",length=32)
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="f_create_date")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Column(name="f_create_ip",length=32)
	public String getCreateIp() {
		return createIp;
	}
	public void setCreateIp(String createIp) {
		this.createIp = createIp;
	}
	@Column(name="f_logins")
	public Integer getLogins() {
		return logins;
	}
	public void setLogins(Integer logins) {
		this.logins = logins;
	}
	@Column(name="f_comefrom",length=32)
	public String getComeFrom() {
		return comeFrom;
	}
	public void setComeFrom(String comeFrom) {
		this.comeFrom = comeFrom;
	}
	@Column(name="f_wechat",length=32)
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	@Column(name="f_qq",length=32)
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	@Column(name="f_msn",length=32)
	public String getMsn() {
		return msn;
	}
	public void setMsn(String msn) {
		this.msn = msn;
	}

}
