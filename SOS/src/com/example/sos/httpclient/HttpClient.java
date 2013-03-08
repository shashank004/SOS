package com.example.sos.httpclient;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.json.JSONObject;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;



public class HttpClient {
	private AsyncHttpClient httpClient = new AsyncHttpClient();

	private  Context url;;
	private static Header[] headerarr =new Header[2];
	public  Map<String,ApiResponseHandler> mymap = new HashMap<String, ApiResponseHandler>();
	
	
	
	

	
	public static Header[] header(){
		Header header1 = new BasicHeader("<Data-Type>", "application/json");
		Header header2 = new BasicHeader("<Accept>","Input");
		headerarr[0] = header1;
		headerarr[1] = header2;
	    return headerarr;
	}
	
	
	
	
	public void getRequest(JSONObject jobj,String activityName, ApiResponseHandler handler){
		
		if(mymap.get(activityName) != null){
	    mymap.put(activityName, handler);
		}
		
		HttpClientHandler handler1 =  new HttpClientHandler(handler);
	
		String jsonstrng = jobj.toString();
		RequestParams param = new RequestParams();
		param.put("parameters",jsonstrng );
		
		httpClient.setTimeout(5000);
		httpClient.get(url, activityName, header(),param, handler1);
	   
		}
	
	
	public void postRequest(JSONObject jobj,String activityName,  ApiResponseHandler handler){
		
		if(mymap.get(activityName) != null){
	
		mymap.put(activityName, handler);
			}
		HttpClientHandler handler1 =  new HttpClientHandler(handler);
		String jsonstrng = jobj.toString();
		RequestParams param = new RequestParams();
		
		param.put("parameters",jsonstrng );
		httpClient.setTimeout(5000);
		httpClient.post(url, activityName, headerarr, param, null, handler1);
		
		}
	
}
