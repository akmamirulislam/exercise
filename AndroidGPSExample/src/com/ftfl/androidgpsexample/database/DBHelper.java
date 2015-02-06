package com.ftfl.androidgpsexample.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "gpsManager";

	// Create Database
	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// table name
	public static final String TABLE_NAME = "gpstrackingCamera";

	// Table Columns names
	public static final String KEY_ID = "id";
	public static final String KEY_FILE_NAME = "fileName";
	public static final String KEY_LATITUDE = "latitude";
	public static final String KEY_LOGITUDE = "longitude";
	public static final String KEY_DESCRIPTION = "description";
	public static final String KEY_DATE_TIME = "datetime";

	// table information
	public String CREATE_TABLE = "create table " + TABLE_NAME + "(" + KEY_ID
			+ " integer primary key autoincrement, " 
			+ KEY_FILE_NAME	+ " text not null, " 
			+ KEY_LATITUDE	+ " text not null, " 
			+ KEY_LOGITUDE + " text not null, "
			+ KEY_DESCRIPTION + " text not null, "
			+ KEY_DATE_TIME + " text not null);";

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DBHelper.class.getName(), "Upgrading database from version "
				+ oldVersion + " to " + newVersion
				+ ", which will destroy all old data");

		db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE);
		onCreate(db);
	}

}