package com.example.sos.activities;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.example.sos.R;
import com.example.sos.api.input.SignupInput;
import com.example.sos.classes.Validation;
import com.example.sos.errorpkg.Errorss;
import com.example.sos.httpclient.ApiResponseHandler;
import com.example.sos.httpclient.HttpClient;
import com.loopj.android.http.RequestParams;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;



public class Signup extends Activity{
	private EditText fnam;
	private EditText lnam;
	private EditText phne;
	private EditText email;
	private EditText password;
	private SignupInput si = new SignupInput();
	private Map<Integer,String> activitymap = new HashMap<Integer, String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		fnam = (EditText)findViewById(R.id.fname);
		lnam = (EditText)findViewById(R.id.lname);
		phne = (EditText)findViewById(R.id.phones);
		email = (EditText)findViewById(R.id.emails);
		password = (EditText)findViewById(R.id.passwords);
		
	}
	

public void onSignup(View view){
	
	
	
	String A=fnam.getText().toString();
	si.setfname(A);
	
	
	String B =phne.getText().toString();
	si.setPhone(B);


	String C= email.getText().toString();
	si.setEmail(C);
	
	
	String D= password.getText().toString();
	si.setPassword(D);

	
	String E=lnam.getText().toString();
	si.setlname(E);
	
	
	
	if(Validation.phoneValidation(B)==false){
		phne.setError(Errorss.Error_Phone);
	}

	if(Validation.fieldNotNull(A)==false){
		password.setError(Errorss.Error_empty);
	}
	if(Validation.fieldNotNull(A)==false){
		password.setError(Errorss.Error_empty);
	}
	if(Validation.fieldNotNull(A)==false){
		password.setError(Errorss.Error_empty);
	}
	if(Validation.fieldNotNull(A)==false){
		password.setError(Errorss.Error_empty);
	}
	if(Validation.fieldNotNull(A)==false){
		password.setError(Errorss.Error_empty);
	}
	clientCall();
   
	
}


private void  clientCall(){
	String jsonstrng = si.APIinp().toString();
	RequestParams param = new RequestParams();
	param.put("parameters",jsonstrng );
	int requestId =1;
	
	HttpClient.getClientObject().register(1, arh); 
	
	HttpClient.getClientObject().post(1,getApplicationContext(), HttpClient.header(), param, "http://10.0.0.51:8080/backend/signup",requestId);
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

	