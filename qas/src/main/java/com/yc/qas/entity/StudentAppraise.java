package com.yc.qas.entity;

import java.util.Date;

public class StudentAppraise {
	private String sName;
	private int qId;
	private String qName;
	private float sum;
	private String author;
	private Date aTime;

	public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
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

	public float getSum() {
		return sum;
	}

	public void setSum(float sum) {
		this.sum = sum;
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
		return "StudentAppraise [sName=" + sName + ", qId=" + qId + ", qName="
				+ qName + ", sum=" + sum + ", author=" + author + ", aTime="
				+ aTime + "]";
	}

}
