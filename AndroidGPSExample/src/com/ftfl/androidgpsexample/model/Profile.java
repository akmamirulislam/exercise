package com.ftfl.androidgpsexample.model;

public class Profile {

	// Variable Declaration
	Integer mID = 0;
	String mFileName = "";
	String mLatitude = "";
	String mLongitude = "";
	String mDescription = "";
	String mDateTime = "";
	String mDistance = "";

	// Empty constructor
	public Profile() {
	}

	// Constructor Without ID
	public Profile(String eFileName, String eLatitude, String eLongitude,
			String eDescription, String eDateTime) {
		this.mFileName = eFileName;
		this.mLatitude = eLatitude;
		this.mLongitude = eLongitude;
		this.mDescription = eDescription;
		this.mDateTime = eDateTime;
	}

	// Constructor With ID
	public Profile(Integer eID, String eFileName, String eLatitude,
			String eLongitude, String eDescription, String eDateTime) {
		this.mID = eID;
		this.mFileName = eFileName;
		this.mLatitude = eLatitude;
		this.mLongitude = eLongitude;
		this.mDescription = eDescription;
		this.mDateTime = eDateTime;
	}

	/*
	 * Getter and Setter Methods
	 */
	public Integer getmID() {
		return mID;
	}

	public void setmID(Integer eID) {
		this.mID = eID;
	}

	public String getmFileName() {
		return mFileName;
	}

	public void setmFileName(String eFileName) {
		this.mFileName = eFileName;
	}

	public String getmLatitude() {
		return mLatitude;
	}

	public void setmLatitude(String eLatitude) {
		this.mLatitude = eLatitude;
	}

	public String getmLongitude() {
		return mLongitude;
	}

	public void setmLongitude(String eLongitude) {
		this.mLongitude = eLongitude;
	}

	public String getmDescription() {
		return mDescription;
	}

	public void setmDescription(String eDescription) {
		this.mDescription = eDescription;
	}

	public String getmDateTime() {
		return mDateTime;
	}

	public void setmDateTime(String eDateTime) {
		this.mDateTime = eDateTime;
	}

	public String getmDistance() {
		return mDistance;
	}

	public void setmDistance(String eDistance) {
		this.mDistance = eDistance;
	}

}
