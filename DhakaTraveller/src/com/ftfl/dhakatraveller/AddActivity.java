package com.ftfl.dhakatraveller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

;

public class AddActivity extends Activity {

	// Declaration of Edittext & Button
	EditText etName, etDescription, etAddress, etDistrict, etLatitude,
			etLongitude, etMenus, etSpecialMenu, etOpeningTime, etCloseDay;
	Button btnAddRestaurant;

	// Declaration of String Values
	String mName, mDescription, mAddress, mDistrict, mLatitude, mLongitude,
			mMenu, mSpecialmenu, mOpeningtime, mCloseday;

	// Model Class Object
	Profile profile;

	// DataSource Object
	DBHelper db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);

		// Initialization of Edittext & Button
		initialization();

		btnAddRestaurant.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				// Initialization of String Values
				getText();

				// data passing to model class
				profile = new Profile(mName, mDescription, mAddress, mDistrict,
						mMenu, mSpecialmenu, mLongitude, mLatitude,
						mOpeningtime, mCloseday);

				// data inserting into database
				db.Add_Contact(profile);

				// Toast Message
				Toast.makeText(getApplicationContext(), "Data Inserted",
						Toast.LENGTH_LONG).show();

				// Intent
				Intent addIntent = new Intent(AddActivity.this,
						MainActivity.class);
				startActivity(addIntent);

			}
		});

	}

	// Initialization of Edittext & Button
	public void initialization() {
		etName = (EditText) findViewById(R.id.etName);
		etDescription = (EditText) findViewById(R.id.etDescription);
		etAddress = (EditText) findViewById(R.id.etAddress);
		etDistrict = (EditText) findViewById(R.id.etDistrict);
		etLatitude = (EditText) findViewById(R.id.etLatitude);
		etLongitude = (EditText) findViewById(R.id.etLongitude);
		etMenus = (EditText) findViewById(R.id.etMenus);
		etSpecialMenu = (EditText) findViewById(R.id.etSpecialMenu);
		etOpeningTime = (EditText) findViewById(R.id.etOpeningTime);
		etCloseDay = (EditText) findViewById(R.id.etCloseDay);
		btnAddRestaurant = (Button) findViewById(R.id.btnAddRestaurant);
	}

	// GetText From EditText
	public void getText() {
		mName = etName.getText().toString();
		mDescription = etDescription.getText().toString();
		mAddress = etAddress.getText().toString();
		mDistrict = etDistrict.getText().toString();
		mLatitude = etLatitude.getText().toString();
		mLongitude = etLongitude.getText().toString();
		mMenu = etMenus.getText().toString();
		mSpecialmenu = etSpecialMenu.getText().toString();
		mOpeningtime = etOpeningTime.getText().toString();
		mCloseday = etCloseDay.getText().toString();
	}
}
