package com.example.sos.classes;




public class Validation {
	
	
	//function to check if the given string is boolean
public  boolean fieldNotNull(String field){
		if(field.equals(null)){
			return true;
			
		}
		return false;
	}

//function to to validate phone number
  public  boolean phoneValidation(String phone){
	  if(phone.equals(null)){
		  return true;
		  
	  }
	  else if(phone.length() != 10){
			return true;
			}
		return false;
		
  }
	
  
  //function to validate email address
public  boolean emailValidation(String email){
	String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	if(email.equals(null)){
		  return true;
	}
	else if(email.matches(EMAIL_REGEX)==false){
		return true;
	}
	return false;
	}
	

//function to validate white space in between string
public  boolean WhiteSpaceCheck(String string){
if(string != null){
    for(int i = 0; i < string.length(); i++){
        if(Character.isWhitespace(string.charAt(i))){
            return true;
        }
         }
}
return false;
}


}


