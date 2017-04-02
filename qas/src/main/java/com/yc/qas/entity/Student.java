package com.yc.qas.entity;

public class Student {
	private int sNo;
	private String sName;
	private Integer cId;
	private String sPwd;
	private String sEmail;
	private String timId;

	public Student() {

	}

	public Student(int sNo, String sPwd) {
		this.sNo = sNo;
		this.sPwd = sPwd;
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getsPwd() {
		return sPwd;
	}

	public void setsPwd(String sPwd) {
		this.sPwd = sPwd;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getTimId() {
		return timId;
	}

	public void setTimId(String timId) {
		this.timId = timId;
	}

	@Override
	public String toString() {
		return "Student [sNo=" + sNo + ", sName=" + sName + ", cId=" + cId
				+ ", sPwd=" + sPwd + ", sEmail=" + sEmail + ", timId=" + timId
				+ "]";
	}

}
