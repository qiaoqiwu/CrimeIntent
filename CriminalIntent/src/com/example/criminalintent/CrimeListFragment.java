package com.example.criminalintent;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class CrimeListFragment extends ListFragment {
	private ArrayList<Crime> mCrimes;
	private static final String TAG = "CrimeListFragment";
	
	//getActivity()返回托管activity，fragment处理activity相关事务
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.crimes_title);
		
		//获取CrimeLab的单例，再获取其中的Crime列表
		mCrimes = CrimeLab.get(getActivity()).getCrimes();
		
		//创建默认ArrayAdapter<T>类的实现
		//ArrayAdapter<Crime> adapter = new ArrayAdapter<Crime>(getActivity(), android.R.layout.simple_list_item_1, mCrimes);
		CrimeAdapter adapter = new CrimeAdapter(mCrimes); 
		setListAdapter(adapter);
	}
	
	//响应列表项的点击事件
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		//Crime c = (Crime) (getListAdapter()).getItem(position);
		
		//getListAdapter方法是ListFragment类的便利方法，返回设置在ListFragment列表视图上的adapter
		//getItem(int)方法，把结果转化为Crime对象
		Crime c = ((CrimeAdapter) getListAdapter()).getItem(position);
		//Log.d(TAG, c.getTitle() + "was clicked");
		//Intent i = new Intent(getActivity(), CrimeActivity.class);
		Intent i = new Intent(getActivity(), CrimePagerActivity.class);
		i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getId());
		startActivity(i);
	}
	
	//显示特定Crime对象信息的列表项，使用getter方法获取
	private class CrimeAdapter extends ArrayAdapter<Crime> {
		public CrimeAdapter(ArrayList<Crime> crimes) {
			//调用超类的构造方法绑定Crime对象的数组列表
			super(getActivity(), 0, crimes);
		}
		//重写getView方法返回产生于定制布局的视图对象，并填充对应的Crime数据
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime, null);
			}
			//getItem方法获取列表中当前position的Crime对象
			Crime c = getItem(position);
			TextView titleTextView = (TextView) convertView.findViewById(R.id.crime_list_item_titleTextView);
			titleTextView.setText(c.getTitle());
			TextView dateTextView = (TextView) convertView.findViewById(R.id.crime_list_item_dateTextView);
			dateTextView.setText(c.getDate().toString());
			CheckBox solvedCheckBox = (CheckBox) convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
			solvedCheckBox.setChecked(c.isSolved());
			return convertView;
		}
	}
	@Override
	public void onResume() {
		super.onResume();
		((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
	}
}
