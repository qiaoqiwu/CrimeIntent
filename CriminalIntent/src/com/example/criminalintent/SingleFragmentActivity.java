package com.example.criminalintent;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

/**
 * @author qiaoqiwu
 * 抽象类SingleFragmentActivity封装CrimeActivity
 */
public abstract class SingleFragmentActivity extends FragmentActivity {
	//createFragment()抽象方法，用于实例化新的fragment
	protected abstract Fragment createFragment();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment);
		//使用FragmentManager将管理fragment并将其视图添加到activity视图层级结构中
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
		if (fragment == null) {
			fragment = createFragment();
			fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
		}
	}
}
