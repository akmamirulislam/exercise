package com.ftfl.dhakatraveller;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class DisplayActivity extends Activity {

	// Declaration of EditText & Button
	EditText tvName, tvDescription, tvAddress, tvDistrict, tvLatitude,
			tvLongitude, tvMenus, tvSpecialMenu, tvOpeningTime, tvCloseDay;
	Button btnViewMap;

	// Declaration of String Values
	String mName, mDescription, mAddress, mDistrict, mLatitude, mLongitude,
			mMenu, mSpecialmenu, mOpeningtime, mCloseday;

	// id
	int selected_id;

	// Database object
	DBHelper db;

	// Profile Object
	Profile profile;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display);

		// Initialization of Edittext & Button
		initialization();

		Bundle bundle = getIntent().getExtras();
		// get the values out by key
		selected_id = bundle.getInt("id");

		// Reading Data From Database
		profile = db.Get_Contact(selected_id);

		// getText
		mName = profile.getmName();
		mDescription = profile.getmDescription();
		mAddress = profile.getmAddress();
		mDistrict = profile.getmDistrict();
		mLatitude = profile.getmLatitude();
		mLongitude = profile.getmlongitude();
		mMenu = profile.getmMenus();
		mSpecialmenu = profile.getmSpecialMenu();
		mOpeningtime = profile.getmDailyOpenTime();
		mCloseday = profile.getmCloseDay();

		// SetText
		setText();
	}

	// Initialization of Edittext & Button
	public void initialization() {
		tvName = (EditText) findViewById(R.id.tvName);
		tvDescription = (EditText) findViewById(R.id.tvDescription);
		tvAddress = (EditText) findViewById(R.id.tvAddress);
		tvDistrict = (EditText) findViewById(R.id.tvDistrict);
		tvLatitude = (EditText) findViewById(R.id.tvLatitude);
		tvLongitude = (EditText) findViewById(R.id.tvLongitude);
		tvMenus = (EditText) findViewById(R.id.tvMenus);
		tvSpecialMenu = (EditText) findViewById(R.id.tvSpecialMenu);
		tvOpeningTime = (EditText) findViewById(R.id.tvOpeningTime);
		tvCloseDay = (EditText) findViewById(R.id.tvCloseDay);
		btnViewMap = (Button) findViewById(R.id.btnViewMap);
	}

	// SetText
	public void setText() {
		tvName.setText(mName);
		tvDescription.setText(mDescription);
		tvAddress.setText(mAddress);
		tvDistrict.setText(mDistrict);
		tvLatitude.setText(mLatitude);
		tvLongitude.setText(mLongitude);
		tvMenus.setText(mMenu);
		tvSpecialMenu.setText(mSpecialmenu);
		tvOpeningTime.setText(mOpeningtime);
		tvCloseDay.setText(mCloseday);
	}

}
