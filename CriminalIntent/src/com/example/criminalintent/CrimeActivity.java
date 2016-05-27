package com.example.criminalintent;

import java.util.UUID;
import android.support.v4.app.Fragment;

public class CrimeActivity extends SingleFragmentActivity {
	/*
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment);
		
		//使用FragmentManager将管理fragment并将其视图添加到activity视图层级结构中
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
		
		if (fragment == null) {
			fragment = new CrimeFragment();
			fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
		}
	}
	*/
	@Override
	protected Fragment createFragment() {
		//return new CrimeFragment();
		UUID crimeId = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
		return CrimeFragment.newInstance(crimeId);
	}
}
