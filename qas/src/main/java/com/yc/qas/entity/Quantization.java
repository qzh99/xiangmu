package com.yc.qas.entity;

public class Quantization {
	private Integer qId;
	private float qScore;
	private String qName;
	
	public Integer getqId() {
		return qId;
	}
	public void setqId(Integer qId) {
		this.qId = qId;
	}
	public float getqScore() {
		return qScore;
	}
	public void setqScore(float qScore) {
		this.qScore = qScore;
	}
	public String getqName() {
		return qName;
	}
	public void setqName(String qName) {
		this.qName = qName;
	}
	@Override
	public String toString() {
		return "Quantization [qId=" + qId + ", qScore=" + qScore + ", qName="
				+ qName + "]";
	}
	
}
	