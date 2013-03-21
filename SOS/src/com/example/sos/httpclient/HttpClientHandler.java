package com.example.sos.httpclient;


import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;




public class HttpClientHandler extends AsyncHttpResponseHandler {

	private final ApiResponseHandler handler;
	private  final int requestId;


	public HttpClientHandler(ApiResponseHandler handler,int requestId) {
		this.handler=handler;
		this.requestId=requestId;
	}

	@Override
	public void onSuccess(String response){
     
     Log.v("json response",response);
     Log.i("json response",response);
		try{
        	JSONObject jsonobject =new JSONObject(response);
        	handler.onSuccess(requestId,jsonobject);
        	    
        }catch(JSONException e){
        	e.printStackTrace();
        }
		
	}
	
	
	
	@Override
	public void onFailure(Throwable e){
		
		Log.e("hsdjfhjkas", e.getMessage());
        	handler.onFailure(requestId, new JSONObject());
     
}
	
	
}
	
