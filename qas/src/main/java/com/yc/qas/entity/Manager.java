package com.yc.qas.entity;

public class Manager {
	private int mId;
	private String mName;
	private String mPwd;
	private String mEmail;

	public Manager() {
	}

	public Manager(int mId, String mPwd) {
		this.mId = mId;
		this.mPwd = mPwd;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmPwd() {
		return mPwd;
	}

	public void setmPwd(String mPwd) {
		this.mPwd = mPwd;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	@Override
	public String toString() {
		return "Manager [mId=" + mId + ", mName=" + mName + ", mPwd=" + mPwd
				+ ", mEmail=" + mEmail + "]";
	}


}
