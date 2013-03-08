package com.example.sos.api.input;

import org.json.JSONObject;

public class LoginInput implements ApiInput {


private  String phone;
private  String password;


public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public  String getPassword() {
	return password;
}
public  void setPassword(String password) {
	this.password = password;
}

@Override
public JSONObject APIinp() {
	
	
	
	JSONObject logininp = new JSONObject();
	try{
	logininp.put("phone", phone);
	logininp.put("password", password);
	
	}catch(Exception e){
		System.out.println(e);
	}
	
	return logininp;
}


}



