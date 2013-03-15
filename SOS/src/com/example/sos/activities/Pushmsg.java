package com.example.sos.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.sos.R;
import com.google.android.gcm.GCMRegistrar;

public class Pushmsg extends Activity {

	private String SENDER_ID = "99884322526";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GCMRegistrar.checkDevice(this);
		GCMRegistrar.checkManifest(this);
		final String regId = GCMRegistrar.getRegistrationId(this);
		if (regId.equals("")) {
		GCMRegistrar.register(this, SENDER_ID);
		} else {
		  Log.i("tag", "Already registered");
		}
		
	}
	
	
	
}
