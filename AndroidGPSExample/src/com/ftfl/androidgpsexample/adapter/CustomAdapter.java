package com.ftfl.androidgpsexample.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ftfl.androidgpsexample.R;
import com.ftfl.androidgpsexample.model.Profile;

public class CustomAdapter extends ArrayAdapter<Profile> {
	Activity mContext;
	Profile mProfile;

	// Profile ArrayList
	ArrayList<Profile> mProfileArrayList;

	// Photo Object
	String mPhotoPath = null;
	Bitmap bitmap = null;

	public CustomAdapter(Activity context, ArrayList<Profile> eProfileArrayList) {
		super(context, R.layout.single_row, eProfileArrayList);
		this.mContext = context;
		this.mProfileArrayList = eProfileArrayList;
	}

	// holder Class to contain inflated xml file elements
	static class ViewHolder {
		public ImageView ivImage;
		public TextView mtvRemark;
		public TextView mtvDateTime;
		public TextView mtvDistance;
	}

	// Create ListView row
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		// Get Model object from Array list
		mProfile = mProfileArrayList.get(position);
		ViewHolder mVHolder = null;

		View rowView = convertView;
		if (convertView == null) {
			// Layout inflater to call external xml layout ()
			LayoutInflater inflater = mContext.getLayoutInflater();
			rowView = inflater.inflate(R.layout.single_row, parent, false);
			mVHolder = new ViewHolder();
			mVHolder.ivImage = (ImageView) rowView
					.findViewById(R.id.ivSingleRowImage);
			mVHolder.mtvRemark = (TextView) rowView
					.findViewById(R.id.tvSingleRowRemark);
			mVHolder.mtvDateTime = (TextView) rowView
					.findViewById(R.id.tvSingleRowDateTime);
			mVHolder.mtvDistance = (TextView) rowView
					.findViewById(R.id.tvSingleRowDistance);
			rowView.setTag(mVHolder);
		} else
			mVHolder = (ViewHolder) rowView.getTag();
		mVHolder.mtvRemark.setText(mProfile.getmFileName().toString());
		mVHolder.mtvDateTime.setText(mProfile.getmDateTime().toString());
		mVHolder.mtvDistance.setText(mProfile.getmDistance().toString());

		// Image Preview
		previewCapturedImage();
		mVHolder.ivImage.setImageBitmap(bitmap);
		return rowView;
	}

	/**
	 * Display image from a path to ImageView
	 */
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
