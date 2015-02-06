package com.ftfl.androidgpsexample.database;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ftfl.androidgpsexample.model.Profile;

public class DataSource {
	private SQLiteDatabase db;
	private DBHelper dbHelper;

	public DataSource(Context context) {
		dbHelper = new DBHelper(context);
	}

	public void open() throws SQLException {
		db = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	// Adding new
	public long addProfile(Profile eProfile) {
		open();
		ContentValues values = new ContentValues();
		values.put(DBHelper.KEY_FILE_NAME, eProfile.getmFileName());
		values.put(DBHelper.KEY_LATITUDE, eProfile.getmLatitude());
		values.put(DBHelper.KEY_LOGITUDE, eProfile.getmLongitude());
		values.put(DBHelper.KEY_DESCRIPTION, eProfile.getmDescription());
		values.put(DBHelper.KEY_DATE_TIME, eProfile.getmDateTime());

		long inserted = db.insert(DBHelper.TABLE_NAME, null, values);
		close();
		return inserted;
	}

	// delete data form database.
	public boolean deleteData(Integer eId) {
		this.open();
		try {
			db.delete(DBHelper.TABLE_NAME, DBHelper.KEY_ID + "=" + eId, null);
		} catch (Exception ex) {
			Log.e("ERROR", "data not deleted");
			return false;
		}
		this.close();
		return true;
	}

	// update database by Id
	public long updateProfile(Integer id, Profile eProfile) {
		open();
		ContentValues values = new ContentValues();
		values.put(DBHelper.KEY_FILE_NAME, eProfile.getmFileName());
		values.put(DBHelper.KEY_LATITUDE, eProfile.getmLatitude());
		values.put(DBHelper.KEY_LOGITUDE, eProfile.getmLongitude());
		values.put(DBHelper.KEY_DESCRIPTION, eProfile.getmDescription());
		values.put(DBHelper.KEY_DATE_TIME, eProfile.getmDateTime());

		long updated = 0;
		try {
			updated = db.update(DBHelper.TABLE_NAME, values, DBHelper.KEY_ID
					+ "=" + id, null);
		} catch (Exception ex) {
			Log.e("ERROR", "data upgraion problem");
		}
		close();
		return updated;
	}

	// Getting All Profile list
	public ArrayList<Profile> getProfileList() {
		ArrayList<Profile> profileList = new ArrayList<Profile>();
		open();
		Cursor cursor = db.query(DBHelper.TABLE_NAME, null, null, null, null,
				null, null);

		// looping through all rows and adding to list
		if (cursor != null && cursor.getCount() > 0) {
			cursor.moveToFirst();
			for (int i = 0; i < cursor.getCount(); i++) {
				int id = cursor.getInt(cursor.getColumnIndex(DBHelper.KEY_ID));
				String filename = cursor.getString(cursor
						.getColumnIndex(DBHelper.KEY_FILE_NAME));
				String latitude = cursor.getString(cursor
						.getColumnIndex(DBHelper.KEY_LATITUDE));
				String longitude = cursor.getString(cursor
						.getColumnIndex(DBHelper.KEY_LOGITUDE));
				String description = cursor.getString(cursor
						.getColumnIndex(DBHelper.KEY_DESCRIPTION));
				String datetime = cursor.getString(cursor
						.getColumnIndex(DBHelper.KEY_DATE_TIME));

				Profile mProfile = new Profile(id, filename, latitude,
						longitude, description, datetime);
				profileList.add(mProfile);
				cursor.moveToNext();
			}
		}
		cursor.close();
		db.close();

		// return profile list
		return profileList;
	}

	// Getting All Profile list
	public Profile getDetail(int id) {
		Profile mProfileDetail;
		open();

		String selectQuery = "SELECT  * FROM " + DBHelper.TABLE_NAME
				+ " WHERE " + DBHelper.KEY_ID + "=" + id;

		Cursor cursor = db.rawQuery(selectQuery, null);
		cursor.moveToFirst();
		String filename = cursor.getString(cursor
				.getColumnIndex(DBHelper.KEY_FILE_NAME));
		String latitude = cursor.getString(cursor
				.getColumnIndex(DBHelper.KEY_LATITUDE));
		String longitude = cursor.getString(cursor
				.getColumnIndex(DBHelper.KEY_LOGITUDE));
		String description = cursor.getString(cursor
				.getColumnIndex(DBHelper.KEY_DESCRIPTION));
		String datetime = cursor.getString(cursor
				.getColumnIndex(DBHelper.KEY_DATE_TIME));

		mProfileDetail = new Profile(id, filename, latitude, longitude,
				description, datetime);

		cursor.moveToNext();

		cursor.close();
		db.close();

		// return place detail
		return mProfileDetail;
	}

	public boolean isEmpty() {
		this.open();
		Cursor cursor = db.query(DBHelper.TABLE_NAME, new String[] {
				DBHelper.KEY_ID, DBHelper.KEY_FILE_NAME, DBHelper.KEY_LATITUDE,
				DBHelper.KEY_LOGITUDE, DBHelper.KEY_DESCRIPTION,
				DBHelper.KEY_DATE_TIME }, null, null, null, null, null);

		if (cursor.getCount() == 0) {
			this.close();
			return true;
		} else {
			this.close();
			return false;
		}
	}
}
