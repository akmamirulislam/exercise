package com.ftfl.dhakatraveller;

public class Profile {

	int mID;
	String mName;
	String mDescription;
	String mAddress;
	String mDistrict;
	String mMenus;
	String mSpecialMenu;
	String mlongitude;
	String mLatitude;
	String mDailyOpenTime;
	String mCloseDay;

	public Profile() {
	}

	public Profile(String eName, String eDescription, String eAddress,
			String eDistrict, String eMenus, String eSpecialMenu,
			String elongitude, String eLatitude, String eDailyOpenTime,
			String eCloseDay) {
		this.mName = eName;
		this.mDescription = eDescription;
		this.mAddress = eAddress;
		this.mDistrict = eDistrict;
		this.mMenus = eMenus;
		this.mSpecialMenu = eSpecialMenu;
		this.mlongitude = elongitude;
		this.mLatitude = eLatitude;
		this.mDailyOpenTime = eDailyOpenTime;
		this.mCloseDay = eCloseDay;
	}

	public Profile(int eID, String eName, String eDescription, String eAddress,
			String eDistrict, String eMenus, String eSpecialMenu,
			String elongitude, String eLatitude, String eDailyOpenTime,
			String eCloseDay) {
		this.mID = eID;
		this.mName = eName;
		this.mDescription = eDescription;
		this.mAddress = eAddress;
		this.mDistrict = eDistrict;
		this.mMenus = eMenus;
		this.mSpecialMenu = eSpecialMenu;
		this.mlongitude = elongitude;
		this.mLatitude = eLatitude;
		this.mDailyOpenTime = eDailyOpenTime;
		this.mCloseDay = eCloseDay;
	}

	public int getmID() {
		return mID;
	}

	public void setmID(int mID) {
		this.mID = mID;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmDescription() {
		return mDescription;
	}

	public void setmDescription(String mDescription) {
		this.mDescription = mDescription;
	}

	public String getmAddress() {
		return mAddress;
	}

	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	public String getmDistrict() {
		return mDistrict;
	}

	public void setmDistrict(String mDistrict) {
		this.mDistrict = mDistrict;
	}

	public String getmMenus() {
		return mMenus;
	}

	public void setmMenus(String mMenus) {
		this.mMenus = mMenus;
	}

	public String getmSpecialMenu() {
		return mSpecialMenu;
	}

	public void setmSpecialMenu(String mSpecialMenu) {
		this.mSpecialMenu = mSpecialMenu;
	}

	public String getmlongitude() {
		return mlongitude;
	}

	public void setmlongitude(String mlongitude) {
		this.mlongitude = mlongitude;
	}

	public String getmLatitude() {
		return mLatitude;
	}

	public void setmLatitude(String mLatitude) {
		this.mLatitude = mLatitude;
	}

	public String getmDailyOpenTime() {
		return mDailyOpenTime;
	}

	public void setmDailyOpenTime(String mDailyOpenTime) {
		this.mDailyOpenTime = mDailyOpenTime;
	}

	public String getmCloseDay() {
		return mCloseDay;
	}

	public void setmCloseDay(String mCloseDay) {
		this.mCloseDay = mCloseDay;
	}

}
