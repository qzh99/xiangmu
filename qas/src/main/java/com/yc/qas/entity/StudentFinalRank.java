package com.yc.qas.entity;

public class StudentFinalRank {
	private int sNo;
	private String sName;
	private float stuAppraise;
	private float stuScore;
	private float totals;
	
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

	public float getStuAppraise() {
		return stuAppraise;
	}

	public void setStuAppraise(float stuAppraise) {
		this.stuAppraise = stuAppraise;
	}

	public float getStuScore() {
		return stuScore;
	}

	public void setStuScore(float stuScore) {
		this.stuScore = stuScore;
	}

	public float getTotals() {
		return totals;
	}

	public void setTotals(float totals) {
		this.totals = totals;
	}

	
}
