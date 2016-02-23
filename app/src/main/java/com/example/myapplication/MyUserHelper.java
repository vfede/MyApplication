package com.example.myapplication;

import android.os.SystemClock;
import android.util.Log;

import com.parse.ParseException;
import com.parse.SaveCallback;

public class MyUserHelper {

	public static void init() {
		MyUser user = MyUser.getCurrentUser();

		Log.d("parse issue", "Start User Save at " + SystemClock.elapsedRealtime());
		Log.d("parse issue", "userId: " + user.getUserId());
		Log.d("parse issue", "userHash: " + user.hashCode());

		user.setCustomField();

		user.saveInBackground(new SaveCallback() {
			@Override
			public void done(ParseException e) {

				MyUser user = MyUser.getCurrentUser();
				String userId = user.getUserId();

				if (e != null) {
					Log.e("parse issue", "error: " + e.getMessage());
					e.printStackTrace();
					Log.d("parse issue", "userId on error: " + userId);
					Log.d("parse issue", "userHash on error: " + user.hashCode());
				}
				else if (userId == null || userId.isEmpty())
					Log.d("parse issue", "User is null or empty after save: >" + user + "<");
				else {
					Log.d("parse issue", "userId on save: " + userId);
					Log.d("parse issue", "userHash on save: " + user.hashCode());
				}
			}
		});
	}
}