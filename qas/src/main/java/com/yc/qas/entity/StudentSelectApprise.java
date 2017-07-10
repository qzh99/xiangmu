package com.yc.qas.entity;

import java.util.Date;

public class StudentSelectApprise {
	private int sNo;
	private String sName;
	private String qName;
	private float qScore;
	private String author;
	private Date aTime;

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

	public String getqName() {
		return qName;
	}

	public void setqName(String qName) {
		this.qName = qName;
	}

	public float getqScore() {
		return qScore;
	}

	public void setqScore(float qScore) {
		this.qScore = qScore;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getaTime() {
		return aTime;
	}

	public void setaTime(Date aTime) {
		this.aTime = aTime;
	}

	@Override
	public String toString() {
		return "StudentSelectApprise [sNo=" + sNo + ", sName=" + sName
				+ ", qName=" + qName + ", qScore=" + qScore + ", author="
				+ author + ", aTime=" + aTime + "]";
	}

}
