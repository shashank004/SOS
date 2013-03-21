package com.example.sos.activities;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.example.sos.api.input.LoginInput;
import com.example.sos.api.input.SignupInput;
import com.example.sos.classes.Validation;
import com.example.sos.errorpkg.Errorss;
import com.example.sos.httpclient.ApiResponseHandler;
import com.example.sos.httpclient.HttpClient;

import android.app.Activity;
import android.content.Intent;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.sos.R;
import com.loopj.android.http.RequestParams;

public class Login extends Activity {

	private EditText phne ;
	private EditText password ;
	private LoginInput li = new LoginInput();
	private Map<Integer,String> activitymap = new HashMap<Integer, String>();
	

	@Override
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		//taking the the fields
		phne = (EditText)findViewById(R.id.uname);
		password = (EditText)findViewById(R.id.password);
		
		}

//	public void onStart() {
//		super.onStart();
//	HttpClient.getClientObject().register(1, arh); 
//	}
//	
//	public void onStop() {
//		
//		HttpClient.getClientObject().unRegister(1);
//		super.onStop();
//	}
	
	public void onLogin(View view){
		
		//taking out the values of the phone number and password
		String phn =phne.getText().toString();
		String pas= password.getText().toString();
        li.setPhone(phn);
        li.setPassword(pas);
		
		// checking validations on the phone number and password entered
	if(Validation.phoneValidation(phn)==false){
		phne.setError(Errorss.Error_Phone);
	}
	
	if(Validation.WhiteSpaceCheck(phn)==false){
		phne.setError(Errorss.Error_Space);
		
	}
	
	//if(Validation.fieldNotNull(pas)==false){
		//password.setError(Errorss.Error_empty);
		
//	}
//	
		   if(phn.equalsIgnoreCase("9971855777") && pas.equals("1234")){
			   Intent intent = new Intent(getApplicationContext(), Setting.class);
			   startActivity(intent);
		   }
		
//	clientCall();
	
	}
	
	}
	
//
//private void  clientCall(){
//	String jsonstrng = li.APIinp().toString();
//	RequestParams param = new RequestParams();
//	param.put("input",jsonstrng );
//	int requestId =1;
//	
//	
//	
//	HttpClient.getClientObject().post(1,getApplicationContext(), HttpClient.header(), param, "http://192.168.3.242:8080/backend/login",requestId);
//	activitymap.put(requestId, "login");
//	
//}
//
//
//
//
//	ApiResponseHandler arh = new ApiResponseHandler(){
//		
//		
// 
//		@Override
//		public void onSuccess(int reqId, JSONObject jsonobj) {
//		if(activitymap.get(reqId).equals("login-" +
//				"")){
//	    
//		}
//		}
//
//		@Override
//		public void onFailure(int reqId, JSONObject jsonobj) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//	};
//		
//	public void onclickfp(View view){
//		
//		Intent intent = new Intent(Login.this, forgotPaswrd.class);
//		startActivity(intent);
//	}
//	
//}