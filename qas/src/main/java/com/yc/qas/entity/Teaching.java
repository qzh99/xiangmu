package com.yc.qas.entity;

/**
 * @author Q 教师授课表 tId --教师id timId --课程id cId --班级id
 */
public class Teaching {
	private int tId;
	private int timId;
	private int cId;

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public int getTimId() {
		return timId;
	}

	public void setTimId(int timId) {
		this.timId = timId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	@Override
	public String toString() {
		return "Teaching [tId=" + tId + ", timId=" + timId + ", cId=" + cId
				+ "]";
	}

}
