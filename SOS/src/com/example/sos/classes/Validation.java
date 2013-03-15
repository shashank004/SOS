package com.example.sos.classes;




public   class Validation {
	
	
	//function to check if the given string is boolean
public static boolean fieldNotNull(String field){
		if(field.equals(null)){
			return true;
			
		}
		return false;
	}

//function to to validate phone number
  public  static boolean phoneValidation(String phone){
	  if(phone.equals(null)){
		  return false;
		  
	  }
	  else if(phone.contentEquals("0000000000")){
		  return false;
	  }
	  else if(phone.startsWith("0")){
		  return false;
	  }
	  else if(phone.length() != 10){
			return false;
			}
		return true;
		
  }
	
  
  //function to validate email address
public static boolean emailValidation(String email){
	String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	if(email.equals(null)){
		  return false;
	}
	else if(email.matches(EMAIL_REGEX)==false){
		return false;
	}
	return true;
	}
	

//function to validate white space in between string
public static boolean WhiteSpaceCheck(String string){
if(string != null){
    for(int i = 0; i < string.length(); i++){
        if(Character.isWhitespace(string.charAt(i))){
            return false;
        }
         }
}
return true;
}


}


