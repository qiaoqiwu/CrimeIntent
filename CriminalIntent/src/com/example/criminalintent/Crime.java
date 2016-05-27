package com.example.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * @author qiaoqiwu
 * 模型层Crime类
 */
public class Crime {
	private UUID mId;
	private String mTitle;
	private Date mDate;
	private boolean mSolved;
	
	public Crime() {
		mId = UUID.randomUUID();
		mDate = new Date();
	}
	//重写toString方法，返回Crime标题
	@Override
	public String toString() {
		return mTitle;
	}
	public Date getDate() {
		return mDate;
	}

	public void setDate(Date Date) {
		this.mDate = Date;
	}

	public boolean isSolved() {
		return mSolved;
	}

	public void setSolved(boolean Solved) {
		this.mSolved = Solved;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String Title) {
		this.mTitle = Title;
	}

	public UUID getId() {
		return mId;
	}
}
