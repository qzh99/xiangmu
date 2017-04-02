package com.yc.qas.entity;

public class StudentUnion {
	private int suId;
	private String suName;
	private String suPwd;
	private String suEmail;

	public StudentUnion() {
		
	}

	public StudentUnion(int suId, String suPwd) {
		this.suId = suId;
		this.suPwd = suPwd;
	}

	public int getSuId() {
		return suId;
	}

	public void setSuId(Integer suId) {
		this.suId = suId;
	}

	public String getSuName() {
		return suName;
	}

	public void setSuName(String suName) {
		this.suName = suName;
	}

	public String getSuPwd() {
		return suPwd;
	}

	public void setSuPwd(String suPwd) {
		this.suPwd = suPwd;
	}

	public String getSuEmail() {
		return suEmail;
	}

	public void setSuEmail(String suEmail) {
		this.suEmail = suEmail;
	}

	@Override
	public String toString() {
		return "StudentUnion [suId=" + suId + ", suName=" + suName + ", suPwd="
				+ suPwd + ", suEmail=" + suEmail + "]";
	}

}
