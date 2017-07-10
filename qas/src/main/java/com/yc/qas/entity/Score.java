package com.yc.qas.entity;

public class Score {
	private int sNo;
	private int timId;
	private float sGrade;
	private String sAuthor;
	private String sTime;


	public Score() {
		super();
	}

	public Score(int sNo, int timId, float sGrade2, String sAuthor) {
		super();
		this.sNo = sNo;
		this.timId = timId;
		this.sGrade = sGrade2;
		this.sAuthor = sAuthor;
	}

	public Score(int sNo, int timId) {
		super();
		this.sNo = sNo;
		this.timId = timId;
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public int getTimId() {
		return timId;
	}

	public void setTimId(int timId) {
		this.timId = timId;
	}

	public float getsGrade() {
		return sGrade;
	}

	public void setsGrade(float sGrade) {
		this.sGrade = sGrade;
	}

	public String getsAuthor() {
		return sAuthor;
	}

	public void setsAuthor(String sAuthor) {
		this.sAuthor = sAuthor;
	}

	public String getsTime() {
		return sTime;
	}

	public void setsTime(String sTime) {
		this.sTime = sTime;
	}

	@Override
	public String toString() {
		return "Score [sNo=" + sNo + ", timId=" + timId + ", sGrade=" + sGrade
				+ ", sAuthor=" + sAuthor + ", sTime=" + sTime + "]";
	}

}
