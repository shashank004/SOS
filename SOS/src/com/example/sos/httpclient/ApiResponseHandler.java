package com.example.sos.httpclient;

import org.json.JSONObject;



public abstract class ApiResponseHandler {

public abstract void onSuccess(int reqId, JSONObject jsonobj);

public abstract void onFailure(int reqId, JSONObject jsonobj);
	

}

