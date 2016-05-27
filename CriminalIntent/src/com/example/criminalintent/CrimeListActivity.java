package com.example.criminalintent;

import android.support.v4.app.Fragment;
/**
 * @author qiaoqiwu
 * 实现抽象类SingleFragmentActivity，返回一个新的CrimeListFragment实例
 */
public class CrimeListActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new CrimeListFragment();
	}

}
