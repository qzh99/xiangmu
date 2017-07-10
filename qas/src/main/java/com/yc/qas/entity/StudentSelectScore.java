package com.yc.qas.entity;

import java.util.Date;

public class StudentSelectScore {
	private int sNo;
	private String sName;
	private String timName;
	private int sGrade;
	private String sAuthor;
	private Date sTime;

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

	public String getTimName() {
		return timName;
	}

	public void setTimName(String timName) {
		this.timName = timName;
	}

	public int getsGrade() {
		return sGrade;
	}

	public void setsGrade(int sGrade) {
		this.sGrade = sGrade;
	}

	public String getsAuthor() {
		return sAuthor;
	}

	public void setsAuthor(String sAuthor) {
		this.sAuthor = sAuthor;
	}

	public Date getsTime() {
		return sTime;
	}

	public void setsTime(Date sTime) {
		this.sTime = sTime;
	}

	@Override
	public String toString() {
		return "StudentSelectScore [sNo=" + sNo + ", sName=" + sName
				+ ", timName=" + timName + ", sGrade=" + sGrade + ", sAuthor="
				+ sAuthor + ", sTime=" + sTime + "]";
	}

}
