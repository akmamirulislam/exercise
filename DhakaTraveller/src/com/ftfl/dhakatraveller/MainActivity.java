package com.ftfl.dhakatraveller;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView myListView;

	// DBHelper Object
	DBHelper db;

	// Profile Object
	Profile myProfile;

	// Profile ArrayList
	ArrayList<Profile> res_List;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		myProfile = new Profile();
		res_List = db.Get_Contacts();

		CustomAdapter adapter = new CustomAdapter(MainActivity.this, res_List);
		myListView = (ListView) findViewById(R.id.myListView);
		myListView.setAdapter(adapter);

		myListView
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					private int selectedId;

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						Bundle bundle = new Bundle();
						bundle.putInt("id", selectedId);
						Intent clickIntent = new Intent(MainActivity.this,
								DisplayActivity.class);
						clickIntent.putExtras(bundle);
						startActivity(clickIntent);

					}
				});

	}

}
