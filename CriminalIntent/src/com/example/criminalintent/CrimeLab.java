package com.example.criminalintent;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;

/**
 * @author qiaoqiwu
 * 将Crime数组对象存储在单例中
 */
public class CrimeLab {
	private ArrayList<Crime> mCrimes;
	private static CrimeLab sCrimeLab;
	private Context mAppContext;
	
	//构造方法，使用Context参数，单例可完成启动activity，获取项目资源
	private CrimeLab(Context appContext) {
		mAppContext = appContext;
		mCrimes = new ArrayList<Crime>();
		for (int i=0; i<100; i++) {
			Crime c = new Crime();
			c.setTitle("Crime #" + i);
			c.setSolved(i % 2 == 0);
			mCrimes.add(c);
		}
	}
	//get方法返回实例
	public static CrimeLab get(Context c) {
		if (sCrimeLab == null) {
			sCrimeLab = new CrimeLab(c.getApplicationContext());
		}
		return sCrimeLab;
	}
	//返回数组列表
	public ArrayList<Crime> getCrimes() {
		return mCrimes;
	}
	//返回带有指定ID的Crime对象
	public Crime getCrime(UUID id) {
		for (Crime c : mCrimes) {
			if (c.getId().equals(id))
				return c;
		}
		return null;
	}
}
