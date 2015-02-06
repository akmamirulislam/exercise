package com.ftfl.androidgpsexample;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.ftfl.androidgpsexample.adapter.CustomAdapter;
import com.ftfl.androidgpsexample.database.DataSource;
import com.ftfl.androidgpsexample.model.Profile;

public class RetriveActivity extends Activity {

	// Declaration of ListView
	int mSelectedID = 0;
	ListView mListView = null;

	// Profile Object
	Profile mProfile = null;

	// DataSource Object
	DataSource mDataSource = null;

	// Profile Type ArrayList
	ArrayList<Profile> mProfileArrayList = null;

	// CustomAdapter
	CustomAdapter mCustomAdapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_retrive);

		// Initialization ListView
		mListView = (ListView) findViewById(R.id.lvRestaurant);

		// Get Data From DataSource
		mDataSource = new DataSource(this);
		mProfileArrayList = mDataSource.getProfileList();

		// Set Adapter
		mCustomAdapter = new CustomAdapter(RetriveActivity.this,
				mProfileArrayList);
		mListView.setAdapter(mCustomAdapter);

	}

}
