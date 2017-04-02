package com.yc.qas.entity;

/**
 * @author Q
 * 学科表(单个课程表)
 * timId--课程id
 * timName--课程名
 */
public class Timetable {
	
	private int timId;
	private String timName;

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

	@Override
	public String toString() {
		return "Timetable [timId=" + timId + ", timName=" + timName + "]";
	}

}
