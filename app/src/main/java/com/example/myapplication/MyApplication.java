package com.example.myapplication;

import android.app.Application;
import android.os.SystemClock;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseObject;

public class MyApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// pause if you want to manually attach debugger on launch
		SystemClock.sleep(3000);

		// Initialize Parse and Facebook sdk
		ParseObject.registerSubclass(MyUser.class);

		Parse.initialize(this, getResources().getString(R.string.parse_app_id_beta), getResources().getString(R.string.parse_client_key_beta));
		Log.i("Parse SDK", "Parse init");

		// Initialize User
		MyUser.enableAutomaticUser();
	}
}
