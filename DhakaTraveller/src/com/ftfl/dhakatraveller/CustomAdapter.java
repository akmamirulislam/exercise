package com.ftfl.dhakatraveller;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<Profile> {
	private final Activity context;
	private ArrayList<Profile> profile_array_list;;

	static class ViewHolder {
		public TextView name, address;
	}



	public CustomAdapter(Activity context, ArrayList<Profile> res_array_list) {
		super(context, R.layout.single_row, res_array_list);
		this.context = context;
		this.profile_array_list = res_array_list;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;
		if (convertView == null) {
			LayoutInflater inflater = context.getLayoutInflater();
			rowView = inflater.inflate(R.layout.single_row, parent, false);

			ViewHolder viewHolder = new ViewHolder();
			viewHolder.name = (TextView) rowView
					.findViewById(R.id.textViewName);
			viewHolder.address = (TextView) rowView
					.findViewById(R.id.textViewAddress);

			rowView.setTag(viewHolder);
		}

		ViewHolder holder = (ViewHolder) rowView.getTag();
		holder.name.setText(profile_array_list.get(position).getmName());
		holder.address.setText(profile_array_list.get(position).getmAddress());

		return rowView;
	}
}
