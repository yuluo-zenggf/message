package com.hwua.entity;

/**
 * 用户实体类
 * 
 * @author Administrator
 *
 */
public class User {
	private Integer id; // 用户id
	private String name; // 用户名
	private String pwd; // 用户密码
	private String email; // 用户邮箱

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(Integer id, String name, String pwd, String email) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.email = email;
	}

	public User(String name, String pwd, String email) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.email = email;
	}

	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}

	public User() {
		super();
	}

}
