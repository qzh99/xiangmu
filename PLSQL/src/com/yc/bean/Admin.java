package com.yc.bean;

public class Admin {
	private String name;
	private String pwd;
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	public Admin() {
		super();
	}

	public Admin(String name,String pwd) {
		super();
		this.name = name;
		this.pwd=pwd;
	}

	/**
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		// TODO 自动生成的方法存根
		return this.pwd;
	}
	
}
