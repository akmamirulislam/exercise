package com.ftfl.dhakatraveller;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "MyDBName.db";
	public static final String CONTACTS_TABLE_NAME = "contacts";

	public static final String CONTACTS_COLUMN_ID = "id";
	public static final String CONTACTS_COLUMN_NAME = "name";
	public static final String CONTACTS_COLUMN_DESCRIPTION = "description";
	public static final String CONTACTS_COLUMN_ADDRESS = "address";
	public static final String CONTACTS_COLUMN_DISTRICT = "district";
	public static final String CONTACTS_COLUMN_LONGITUDE = "longitude";
	public static final String CONTACTS_COLUMN_LATITUDE = "latitude";
	public static final String CONTACTS_COLUMN_MENUS = "menus";
	public static final String CONTACTS_COLUMN_SPECIAL_MENU = "specialMenu";
	public static final String CONTACTS_COLUMN_CLOSE_DAY = "closeDay";
	public static final String CONTACTS_COLUMN_OPENING_TIME = "openingTime";

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}

	// Table Create Statement
	public String CREATE_CONTACTS_TABLE = "CREATE TABLE " + CONTACTS_TABLE_NAME
			+ "(" + CONTACTS_COLUMN_ID + " integer primary key autoincrement, "
			+ CONTACTS_COLUMN_NAME + " text not null, "
			+ CONTACTS_COLUMN_DESCRIPTION + " text not null, "
			+ CONTACTS_COLUMN_ADDRESS + " text not null, "
			+ CONTACTS_COLUMN_DISTRICT + " text not null, "
			+ CONTACTS_COLUMN_LONGITUDE + " text not null, "
			+ CONTACTS_COLUMN_LATITUDE + " text not null, "
			+ CONTACTS_COLUMN_MENUS + " text not null, "
			+ CONTACTS_COLUMN_SPECIAL_MENU + " text not null, "
			+ CONTACTS_COLUMN_CLOSE_DAY + " text not null, "
			+ CONTACTS_COLUMN_OPENING_TIME + " text not null);";

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_CONTACTS_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS contacts");
		onCreate(db);
	}

	/*
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	// Adding new contact
	public void Add_Contact(Profile contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(CONTACTS_COLUMN_NAME, contact.getmName());
		values.put(CONTACTS_COLUMN_DESCRIPTION, contact.getmDescription());
		values.put(CONTACTS_COLUMN_ADDRESS, contact.getmAddress());
		values.put(CONTACTS_COLUMN_DISTRICT, contact.getmDistrict());
		values.put(CONTACTS_COLUMN_LONGITUDE, contact.getmlongitude());
		values.put(CONTACTS_COLUMN_LATITUDE, contact.getmLatitude());
		values.put(CONTACTS_COLUMN_MENUS, contact.getmMenus());
		values.put(CONTACTS_COLUMN_SPECIAL_MENU, contact.getmSpecialMenu());
		values.put(CONTACTS_COLUMN_CLOSE_DAY, contact.getmCloseDay());
		values.put(CONTACTS_COLUMN_OPENING_TIME, contact.getmDailyOpenTime());

		// Inserting Row
		db.insert(CONTACTS_TABLE_NAME, null, values);
		db.close(); // Closing database connection
	}

	// Getting single contact
	Profile Get_Contact(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(CONTACTS_TABLE_NAME, new String[] {
				CONTACTS_COLUMN_ID, CONTACTS_COLUMN_NAME,
				CONTACTS_COLUMN_DESCRIPTION, CONTACTS_COLUMN_ADDRESS,
				CONTACTS_COLUMN_DISTRICT, CONTACTS_COLUMN_LONGITUDE,
				CONTACTS_COLUMN_LATITUDE, CONTACTS_COLUMN_MENUS,
				CONTACTS_COLUMN_SPECIAL_MENU, CONTACTS_COLUMN_CLOSE_DAY,
				CONTACTS_COLUMN_OPENING_TIME }, CONTACTS_COLUMN_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		Profile contact = new Profile(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getString(2), cursor.getString(3),
				cursor.getString(4), cursor.getString(5), cursor.getString(6),
				cursor.getString(7), cursor.getString(8), cursor.getString(9),
				cursor.getString(10));
		// return contact
		cursor.close();
		db.close();

		return contact;
	}

	// Getting Contact 
	public ArrayList<Profile> Get_Contacts() {
		ArrayList<Profile> res_list = new ArrayList<Profile>();
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor result = db.rawQuery("select * from " + CONTACTS_TABLE_NAME,
				null);
		if (result.moveToFirst()) {
			do {
				int id = result.getInt(0);
				String name = result.getString(1);
				String description = result.getString(2);
				String address = result.getString(3);
				String district = result.getString(4);
				String longitude = result.getString(5);
				String latitude = result.getString(5);
				String menus = result.getString(7);
				String specialmenus = result.getString(8);
				String close_day = result.getString(9);
				String daily_open_time = result.getString(10);

				Profile resInfo = new Profile(name, description, address,
						district, longitude, latitude, menus, specialmenus,
						close_day, daily_open_time);
				resInfo.setmID(id);

				res_list.add(resInfo);
			} while (result.moveToNext());
		}
		return res_list;
	}

	// Getting Single Contact
	public Profile getRestaurantById(int eId) {
		Profile single_profile = null;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor result = db.rawQuery("select * from " + CONTACTS_TABLE_NAME
				+ " where id='" + eId + "'", null);
		if (result.moveToFirst()) {
			do {
				int id = result.getInt(0);
				String name = result.getString(1);
				String description = result.getString(2);
				String address = result.getString(3);
				String district = result.getString(4);
				String longitude = result.getString(5);
				String latitude = result.getString(5);
				String menus = result.getString(7);
				String specialmenus = result.getString(8);
				String close_day = result.getString(9);
				String daily_open_time = result.getString(10);

				single_profile = new Profile(name, description, address,
						district, longitude, latitude, menus, specialmenus,
						close_day, daily_open_time);
				single_profile.setmID(id);

			} while (result.moveToNext());
		}
		return single_profile;
	}

	// Updating single contact
	public long updateProfile(Integer id, Profile contact) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(CONTACTS_COLUMN_NAME, contact.getmName());
		values.put(CONTACTS_COLUMN_DESCRIPTION, contact.getmDescription());
		values.put(CONTACTS_COLUMN_ADDRESS, contact.getmAddress());
		values.put(CONTACTS_COLUMN_DISTRICT, contact.getmDistrict());
		values.put(CONTACTS_COLUMN_LONGITUDE, contact.getmlongitude());
		values.put(CONTACTS_COLUMN_LATITUDE, contact.getmLatitude());
		values.put(CONTACTS_COLUMN_MENUS, contact.getmMenus());
		values.put(CONTACTS_COLUMN_SPECIAL_MENU, contact.getmSpecialMenu());
		values.put(CONTACTS_COLUMN_CLOSE_DAY, contact.getmCloseDay());
		values.put(CONTACTS_COLUMN_OPENING_TIME, contact.getmDailyOpenTime());

		return db.update(CONTACTS_TABLE_NAME, values, CONTACTS_COLUMN_ID
				+ " = ?", new String[] { Integer.toString(id) });
		// return true;
	}

	// Deleting single contact
	public void deleteProfile(Integer id) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete("restaurant", CONTACTS_COLUMN_ID + " = ? ",
				new String[] { Integer.toString(id) });
	}

	// Getting contacts Count
	public int Get_Total_Contacts() {
		String countQuery = "SELECT  * FROM " + CONTACTS_TABLE_NAME;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}

}
