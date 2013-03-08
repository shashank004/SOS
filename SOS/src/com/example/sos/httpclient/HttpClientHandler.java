package com.example.sos.httpclient;


import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import com.loopj.android.http.AsyncHttpResponseHandler;




public class HttpClientHandler extends AsyncHttpResponseHandler {

	private  ApiResponseHandler handler;


	public HttpClientHandler(ApiResponseHandler handler2) {
		this.handler=handler;
	}

	@Override
	public void onSuccess(String response){

		try{
        	JSONObject jsonobject =new JSONObject(response);
        	    
        }catch(JSONException e){
        	e.printStackTrace();
        }
		
	}
	
	
	
	@Override
	public void onFailure(Throwable e){
		Log.i("Error", "could not complete api request");
	}

}
	
	
