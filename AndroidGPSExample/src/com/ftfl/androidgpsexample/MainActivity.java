package com.ftfl.androidgpsexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Button mButtonRegister;
	Button mButtonRetrive;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mButtonRegister = (Button) findViewById(R.id.btnRegister);
		mButtonRetrive = (Button) findViewById(R.id.btnRetrive);

		mButtonRegister.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(getBaseContext(), CameraActivity.class);
				startActivity(i);

			}
		});

	}

}
