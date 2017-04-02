package com.yc.qas.entity;

public class TotalScore {
	private Integer tsId;
	private Integer suId;
	private Integer scoId;
	private Integer aId;
	private Integer toSum;

	public Integer getTsId() {
		return tsId;
	}

	public void setTsId(Integer tsId) {
		this.tsId = tsId;
	}

	public Integer getSuId() {
		return suId;
	}

	public void setSuId(Integer suId) {
		this.suId = suId;
	}

	public Integer getScoId() {
		return scoId;
	}

	public void setScoId(Integer scoId) {
		this.scoId = scoId;
	}

	public Integer getaId() {
		return aId;
	}

	public void setaId(Integer aId) {
		this.aId = aId;
	}

	public Integer getToSum() {
		return toSum;
	}

	public void setToSum(Integer toSum) {
		this.toSum = toSum;
	}

	@Override
	public String toString() {
		return "TotalScore [tsId=" + tsId + ", suId=" + suId + ", scoId="
				+ scoId + ", aId=" + aId + ", toSum=" + toSum + "]";
	}

}
