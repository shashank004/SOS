package com.example.sos.activities;

import com.example.sos.R;
import com.example.sos.api.input.SignupInput;
import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;





public class Signup extends Activity{
	private EditText unam;
	private EditText phne;
	private EditText email;
	private EditText password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		
		unam = (EditText)findViewById(R.id.unames);
		phne = (EditText)findViewById(R.id.phones);
		email = (EditText)findViewById(R.id.emails);
		password = (EditText)findViewById(R.id.passwords);
	}
	

public void onSignup(){
	
	SignupInput si = new SignupInput();
	
	String A=unam.getText().toString();
	si.setUname(A);
	
	
	String B =phne.getText().toString();
	si.setPhone(B);
	

	String C= email.getText().toString();
	si.setEmail(C);
	
	
	String D= password.getText().toString();
	si.setPassword(D);
	     
	
	
	
}
	
}
