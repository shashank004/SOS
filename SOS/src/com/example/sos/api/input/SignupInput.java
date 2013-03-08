package com.example.sos.api.input;

import org.json.JSONObject;

public class SignupInput implements ApiInput {

private  String phone ;
private  String password;
private  String email;
private  String uname;
	
	
	
	
	public  String getPhone() {
	return phone;
}


public  void setPhone(String phone) {
	this.phone = phone;
}


public  String getPassword() {
	return password;
}

public  void setPassword(String password) {
	this.password = password;
}

public  String getEmail() {
	return email;
}

public  void setEmail(String email) {
	this.email = email;
}


public  String getUname() {
	return uname;
}

public  void setUname(String uname) {
	this.uname = uname;
}


	@Override
	public JSONObject APIinp() {

   JSONObject signupinp = new JSONObject();
   
   
   try{
		signupinp.put("phone", phone);
		signupinp.put("password", password);
		signupinp.put("email", email);
		signupinp.put("uname", uname);
		
		}catch(Exception e){
			System.out.println(e);
		}
		
		return signupinp;
	}

}
