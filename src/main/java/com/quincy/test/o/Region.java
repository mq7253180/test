package com.quincy.test.o;

import java.io.Serializable;

public class Region implements Serializable {
	private static final long serialVersionUID = -7160794018694023343L;
	private Long id;
	private String enName;
	private String cnName;
	private String telPrefix;
	private String code;
	private String code2;
	private String currency;
	private String locale;
	private Long parentId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	public String getTelPrefix() {
		return telPrefix;
	}
	public void setTelPrefix(String telPrefix) {
		this.telPrefix = telPrefix;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode2() {
		return code2;
	}
	public void setCode2(String code2) {
		this.code2 = code2;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}