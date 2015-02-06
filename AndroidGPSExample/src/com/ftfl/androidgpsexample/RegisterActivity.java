package com.ftfl.androidgpsexample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ftfl.androidgpsexample.database.DataSource;
import com.ftfl.androidgpsexample.gps.GPSTracker;
import com.ftfl.androidgpsexample.model.Profile;

@SuppressLint("SimpleDateFormat")
public class RegisterActivity extends Activity {

	// Variable Declaration
	ImageView mImageView = null;
	TextView mtvLatitude = null;
	TextView mtvLongitude = null;
	EditText metRemarks = null;
	Button mButtonSave = null;

	// String Values
	String mImage = null;
	String mLatitude = null;
	String mLongitude = null;
	String mRemarks = null;
	String mLocalTime = null;

	// Intent Object
	Intent mIntent = null;

	// Profile Object
	Profile mProfile = null;

	// GPSTracker class
	GPSTracker mGPS = null;

	// DataSource Object
	DataSource mDataSource = null;

	// Photo Object
	String mPhotoPath = "";
	Bitmap bitmap = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		// Initialization
		initialization();

		// get the Intent that started this Activity
		mIntent = getIntent();

		// get the Bundle that stores the data of this Activity
		Bundle mBundle = mIntent.getExtras();
		mPhotoPath = mBundle.getString("ImagePath");

		// Set Image Into the ImageView
		if (mPhotoPath.length() > 0) {
			previewCapturedImage();
			mImageView.setImageBitmap(bitmap);
		} else {
			mImageView.setImageResource(R.drawable.ic_launcher);
		}

		// create class object
		mGPS = new GPSTracker(this);

		// check if GPS enabled
		if (mGPS.canGetLocation()) {

			double latitude = mGPS.getLatitude();
			double longitude = mGPS.getLongitude();

			// SetText
			mtvLatitude.setText(Double.toString(latitude));
			mtvLongitude.setText(Double.toString(longitude));

		} else {
			// can't get location
			// GPS or Network is not enabled
			// Ask user to enable GPS/network in settings
			mGPS.showSettingsAlert();
		}

	}

	public void save(View v) {

		// GetText

		// get the Intent that started this Activity
		mIntent = getIntent();

		// get the Bundle that stores the data of this Activity
		Bundle mBundle = mIntent.getExtras();
		mPhotoPath = mBundle.getString("ImagePath");

		// Get mLocalTime
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		Date currentLocalTime = cal.getTime();
		DateFormat date = new SimpleDateFormat("dd-MM-yyy HH:mm:ss z");
		date.setTimeZone(TimeZone.getDefault());
		mLocalTime = date.format(currentLocalTime);

		// Latitude & Longitude
		mGPS = new GPSTracker(this);

		double latitude = mGPS.getLatitude();
		double longitude = mGPS.getLongitude();

		mLatitude = Double.toString(latitude);
		mLongitude = Double.toString(longitude);

		// Profile Object
		mProfile = new Profile(mPhotoPath, mLatitude, mLongitude, mRemarks,
				mLocalTime);

		// Database Object
		mDataSource.addProfile(mProfile);

		// Toast Message
		Toast.makeText(getApplicationContext(), "Data Inserted Successfully..",
				Toast.LENGTH_LONG).show();

	}

	// Initialization or FindViewById
	public void initialization() {
		mImageView = (ImageView) findViewById(R.id.ivImageRegister);
		mtvLatitude = (TextView) findViewById(R.id.tvLatitude);
		mtvLongitude = (TextView) findViewById(R.id.tvLongitude);
		metRemarks = (EditText) findViewById(R.id.etRemarks);
		mButtonSave = (Button) findViewById(R.id.btnSave);
	}

	// Display image from a path to ImageView
	private void previewCapturedImage() {
		try {
			// bimatp factory
			BitmapFactory.Options options = new BitmapFactory.Options();

			// downsizing image as it throws OutOfMemory Exception for larger
			// images
			options.inSampleSize = 10;
			bitmap = BitmapFactory.decodeFile(mPhotoPath, options);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
}
