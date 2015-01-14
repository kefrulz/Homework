package com.androidbegin.parselogintutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.parse.ParseAnonymousUtils;
import com.parse.ParseUser;

public class MainActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		if (ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser())) {

			Intent intent = new Intent(MainActivity.this,
					LoginSignupActivity.class);
			startActivity(intent);
			finish();
		} else {

			ParseUser currentUser = ParseUser.getCurrentUser();
			if (currentUser != null) {

				Intent intent = new Intent(MainActivity.this, Welcome.class);
				startActivity(intent);
				finish();
			} else {

				Intent intent = new Intent(MainActivity.this,
						LoginSignupActivity.class);
				startActivity(intent);
				finish();
			}
		}

	}
}
