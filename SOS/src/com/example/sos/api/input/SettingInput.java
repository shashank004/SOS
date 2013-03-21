package com.example.sos.api.input;

import org.json.JSONObject;

public class SettingInput implements ApiInput {
	
	private String phone1;
	private String phone2;
	private String phone3;
	private String phone4;
	private String phone5;
	
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	public String getPhone4() {
		return phone4;
	}
	public void setPhone4(String phone4) {
		this.phone4 = phone4;
	}
	public String getPhone5() {
		return phone5;
	}
	public void setPhone5(String phone5) {
		this.phone5 = phone5;
	}
	
	
	
	
	@Override
	public JSONObject APIinp() {
		   
		JSONObject settinginp = new JSONObject();
		   
		   
		   try{
			   settinginp.put("phone1", phone1);
			   settinginp.put("phone2", phone2);
			   settinginp.put("phone3", phone3);
			   settinginp.put("phone4", phone4);
			   settinginp.put("phone5", phone5);
			  
				
				}catch(Exception e){
					System.out.println(e);
				}
				
				return settinginp;
				
	}
	
	
	
}
