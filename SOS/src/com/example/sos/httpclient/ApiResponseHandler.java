package com.example.sos.httpclient;

import org.json.JSONObject;



public abstract class ApiResponseHandler {

public abstract void onSuccess(String Activityname, JSONObject jsonobj);

public abstract void onFailure(String Activityname, JSONObject jsonobj);
	

}
