package com.example.sos.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.sos.R;
import com.example.sos.classes.Validation;
import com.example.sos.errorpkg.Errorss;

public class forgotPaswrd extends MainActivity {
	
	private EditText phone ;
	private EditText password ;
	private EditText cpassword;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forgotpas);
		phone = (EditText)findViewById(R.id.username);
		password = (EditText)findViewById(R.id.password);
		cpassword = (EditText)findViewById(R.id.cpassword);

}
	public void onclickfp(View view){
		
	String	phne = phone.getText().toString();
	String	paswrd= password.getText().toString();
	String  cpaswrd=cpassword.getText().toString();
	
	if(Validation.phoneValidation(phne)==false){
		phone.setError(Errorss.Error_Phone);
	}
	if(Validation.WhiteSpaceCheck(phne)==false){
		phone.setError(Errorss.Error_Space);
		
	}
	
	if(Validation.fieldNotNull(paswrd)==false){
		password.setError(Errorss.Error_empty);
		
	}
	if(Validation.fieldNotNull(cpaswrd)==false){
		cpassword.setError(Errorss.Error_empty);
		
	}
	
	if(!paswrd.equals(cpaswrd)){
		cpassword.setError(Errorss.Error_mismatch);
	}
	
	//here the api will come for sending the new password to the database
	
	
	
	
	
	
	
	}
}