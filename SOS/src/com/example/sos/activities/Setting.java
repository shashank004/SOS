package com.example.sos.activities;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.example.sos.R;
import com.example.sos.api.input.LoginInput;
import com.example.sos.api.input.SettingInput;
import com.example.sos.httpclient.ApiResponseHandler;
import com.example.sos.httpclient.HttpClient;
import com.loopj.android.http.RequestParams;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Setting extends Activity{

	private SettingInput si = new SettingInput();
	private Map<Integer,String> activitymap = new HashMap<Integer, String>();
	private EditText phone1;
	private EditText phone2;
	private EditText phone3;
	private EditText phone4;
	private EditText phone5;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);
		
		phone1 =(EditText)findViewById(R.id.setphone1);
		phone2 =(EditText)findViewById(R.id.setphone2);
		phone3 =(EditText)findViewById(R.id.setphone3);
		phone4 =(EditText)findViewById(R.id.setphone4);
		phone5 =(EditText)findViewById(R.id.setphone5);
		
	}
	
	public void onStart() {
		super.onStart();
	HttpClient.getClientObject().register(1, arh); 
	}
	
	public void onStop() {
		
		HttpClient.getClientObject().unRegister(1);
		super.onStop();
	}
	
	public void onPhoneSelection(View view){
		Intent intent = new Intent(getApplicationContext(), ContactSearch.class);
		startActivity(intent);
	}
	
	public void onSetting(View view){
		
		
		String phne1 = phone1.toString();
		String phne2 = phone2.toString();
		String phne3 = phone3.toString();
		String phne4 = phone4.toString();
		String phne5 = phone5.toString();
		
		
		//setting the values obtained to settingInput object
		si.setPhone1(phne1);
		si.setPhone2(phne2);
		si.setPhone3(phne3);
		si.setPhone4(phne4);
		si.setPhone5(phne5);
		
		//creating an API by calling api method
		clientCall();
		
	}
	
	public void clientCall(){
	
	String jsonstrng = si.APIinp().toString();
	RequestParams param = new RequestParams();
	param.put("parameters",jsonstrng );
	int requestId =1;
	
	HttpClient.getClientObject().register(1, arh);
	
	HttpClient.getClientObject().post(3,getApplicationContext(), HttpClient.header(), param, "http://192.168.3.242:8080/backend/signup",requestId);
	activitymap.put(requestId, "signup");
	
}
	
	ApiResponseHandler arh = new ApiResponseHandler(){
		@Override
		public void onSuccess(int reqId, JSONObject jsonobj) {
		if(activitymap.get(reqId).equals("signup")){
	    
		}
		}
		@Override
		public void onFailure(int reqId, JSONObject jsonobj) {
			// TODO Auto-generated method stub
			
		}
		
	};
	}
	

	
