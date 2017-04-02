package com.yc.qas.entity;

public class Teacher {
	private int tId;
	private String tName;
	private String tPwd;
	private String tEmail;

	public Teacher() {
	}

	public Teacher(int tId, String tPwd) {
		this.tId = tId;
		this.tPwd = tPwd;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String gettPwd() {
		return tPwd;
	}

	public void settPwd(String tPwd) {
		this.tPwd = tPwd;
	}

	public String gettEmail() {
		return tEmail;
	}

	public void settEmail(String tEmail) {
		this.tEmail = tEmail;
	}

	@Override
	public String toString() {
		return "Teacher [tId=" + tId + ", tName=" + tName + ", tPwd=" + tPwd
				+ ", tEmail=" + tEmail + "]";
	}

}
