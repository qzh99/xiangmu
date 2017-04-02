package com.yc.qas.entity;

public class StudentScore {
	private int sNo;
	private String sName;
	private int timId;
	private String timName;
	private int sGrade;

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

	public int getTimId() {
		return timId;
	}

	public void setTimId(int timId) {
		this.timId = timId;
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

	@Override
	public String toString() {
		return "StudentScore [sNo=" + sNo + ", sName=" + sName + ", timId="
				+ timId + ", timName=" + timName + ", sGrade=" + sGrade + "]";
	}

}
