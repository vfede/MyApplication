package com.example.myapplication;

import com.parse.ParseClassName;
import com.parse.ParseUser;

@ParseClassName("_User")
public class MyUser extends ParseUser {

	public String getUserId() {
		return getObjectId();
	}

	public static MyUser getCurrentUser() {
		return (MyUser) ParseUser.getCurrentUser();
	}

	public void setCustomField() {
		put("customField", "customValue");
	}
}
