package com.yc.qas.entity;

import java.io.Serializable;

public class Appraise implements Serializable {
	private static final long serialVersionUID = -3501865766587930184L;
	private int sNo;
	private int qId;
	private String author;
	private String aTime;

	public Appraise() {
	}

	public Appraise(int sNo, int qId, String author, String time) {
		this.sNo = sNo;
		this.qId = qId;
		this.author = author;
		this.aTime = time;
	}

	

	public Appraise(int sNo, int qId) {
		this.sNo = sNo;
		this.qId = qId;
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getaTime() {
		return aTime;
	}

	public void setaTime(String aTime) {
		this.aTime = aTime;
	}

	@Override
	public String toString() {
		return "Appraise [sNo=" + sNo + ", qId=" + qId + ", author=" + author
				+ ", aTime=" + aTime + "]";
	}

}
