package com.example.sos.activities;

import com.example.sos.classes.Validation;
import com.example.sos.errorpkg.Errorss;

import android.app.Activity;
import android.content.Intent;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.sos.R;

public class Login extends Activity {

	private EditText phne ;
	private EditText password ;
	

	@Override
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		phne = (EditText)findViewById(R.id.uname);
		password = (EditText)findViewById(R.id.password);
		
		}

	public void onLogin(View view){
		Errorss errormsg = new Errorss();
		
		
		String phn =phne.getText().toString();
		String pas= password.getText().toString();

		

		//creating object of validation class
		Validation validation = new Validation();

	if(validation.phoneValidation(phn)){
		phne.setError(errormsg.getErrorPhone());
	}
	
	if(validation.WhiteSpaceCheck(phn)){
		phne.setError(errormsg.getErrorSpace());
		
	}
	
	if(validation.fieldNotNull(pas)){
		password.setError(errormsg.getErrorEmpty());
		
	}
	
		   if(phn.equalsIgnoreCase("9971855777") && pas.equals("1234")){
			   Intent intent = new Intent(getApplicationContext(), Setting.class);
			   startActivity(intent);
		   }
		
	}
	
	
		
	


}