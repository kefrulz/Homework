package com.androidbegin.parselogintutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginSignupActivity extends Activity {
	// Declare Variables
	Button loginbutton;
	Button signup;
	String usernametxt;
	String passwordtxt;
	EditText password;
	EditText username;

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from main.xml
		setContentView(R.layout.loginsignup);
		// Locate EditTexts in main.xml
		username = (EditText) findViewById(R.id.username);
		password = (EditText) findViewById(R.id.password);

		// Locate Buttons in main.xml
		loginbutton = (Button) findViewById(R.id.login);
		signup = (Button) findViewById(R.id.signup);


		loginbutton.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {

				usernametxt = username.getText().toString();
				passwordtxt = password.getText().toString();


				ParseUser.logInInBackground(usernametxt, passwordtxt,
						new LogInCallback() {
							public void done(ParseUser user, ParseException e) {
								if (user != null) {

									Intent intent = new Intent(
											LoginSignupActivity.this,
											Welcome.class);
									startActivity(intent);
									Toast.makeText(getApplicationContext(),
											"Successfully Logged in",
											Toast.LENGTH_LONG).show();
									finish();
								} else {
									Toast.makeText(
											getApplicationContext(),
											"No such user exist, please signup",
											Toast.LENGTH_LONG).show();
								}
							}
						});
			}
		});

		signup.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {

				usernametxt = username.getText().toString();
				passwordtxt = password.getText().toString();
				

				if (usernametxt.equals("") && passwordtxt.equals("")) {
					Toast.makeText(getApplicationContext(),
							"Please complete the sign up form",
							Toast.LENGTH_LONG).show();

				} else {

					ParseUser user = new ParseUser();
					user.setUsername(usernametxt);
					user.setPassword(passwordtxt);
					user.signUpInBackground(new SignUpCallback() {
						public void done(ParseException e) {
							if (e == null) {

								Toast.makeText(getApplicationContext(),
										"Successfully Signed up, please log in.",
										Toast.LENGTH_LONG).show();
							} else {
								Toast.makeText(getApplicationContext(),
										"Username not available/No internet connection", Toast.LENGTH_LONG)
										.show();
							}
						}
					});
				}

			}
		});

	}
}
