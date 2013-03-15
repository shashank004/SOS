package com.example.sos.api.input;

import org.json.JSONObject;


public class SignupInput implements ApiInput {

private  String phone ;
private  String password;
private  String email;
private  String fname;
private   String lname;
	
	
	
	
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


public  String getfname() {
	return fname;
}
public  void setfname(String fname) {
	this.fname = fname;
}

public  void setlname(String lname) {
	this.lname = lname;
}
public  String getlname() {
	return lname;
}





	@Override
	public JSONObject APIinp() {

   JSONObject signupinp = new JSONObject();
   
   
   try{
		signupinp.put("phoneNo", phone);
		signupinp.put("password", password);
		signupinp.put("emailId", email);
		signupinp.put("firstName", fname);
		signupinp.put("lastName", lname);
		signupinp.put("fbId", null);
		
		}catch(Exception e){
			System.out.println(e);
		}
		
		return signupinp;
		
	}
}
