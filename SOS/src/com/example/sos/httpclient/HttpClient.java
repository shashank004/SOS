package com.example.sos.httpclient;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import android.content.Context;
import android.util.Log;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;



public class HttpClient {
	private AsyncHttpClient httpClient;
	private static Header[] headerarr =new Header[2];
	public  Map<Integer,ApiResponseHandler> mymap;
	private static HttpClient httpclientsngleton = null;
	
	
	private HttpClient(){
		httpClient = new AsyncHttpClient();
		httpClient.setTimeout(10);
		mymap = new HashMap<Integer, ApiResponseHandler>();
		}
	
	public static HttpClient getClientObject(){
		if(httpclientsngleton == null){
			httpclientsngleton = new HttpClient();
		}
		return httpclientsngleton;
	}
	
	
	//Registering the activity and putting it in map
public void register(int activityId, ApiResponseHandler handler){
		
		if(mymap.get(activityId)!=null){
			Log.i("error", "already registered");
		}
		mymap.put(activityId, handler);
	}
	
	public void unRegister(int activityId){
		mymap.remove(activityId);
	}
	
	
	public static Header[] header(){
		Header header1 = new BasicHeader("Accept", "application/json");
		Header header2 = new BasicHeader("Data-Type","json");
		headerarr[0] = header1;
		headerarr[1] = header2;
	    return headerarr;
	}
	
	
	
	
	
	
	public void post(int activityId, Context context, Header[] headers, RequestParams req, String url,int requestId) {
		ApiResponseHandler handler = mymap.get(activityId);
		if(handler!=null){
			HttpClientHandler handler1 = new HttpClientHandler(handler,requestId);
		httpClient.post(context, url, headers, req, "x-www-form-urlencoded", handler1);
		
		
	}
	
		//public void getRequest(int activityId, int requestId,  String url, RequestParams params) {
		
			
	//	httpClient.get(url, params,handler1);
		}
		//}
//		
//		public void postRequest(int activityId, int requestId,  String url, RequestParams params) {
//			ApiResponseHandler handler = mymap.get(activityId);
//			if(handler!=null){
//				HttpClientHandler handler1 = new HttpClientHandler(handler,requestId);
//				
//			httpClient.post(url, params,handler1);
//			}
	//		}
}

		//public void getRequest(JSONObject jobj,String activityName, ApiResponseHandler handler){
//		if(mymap.get(activityName) != null){
//	    mymap.put(activityName, handler);
//		}
//		
//		HttpClientHandler handler1 =  new HttpClientHandler(handler);
//	
//		String jsonstrng = jobj.toString();
//		RequestParams param = new RequestParams();
//		param.put("parameters",jsonstrng );
//		
//		httpClient.setTimeout(5000);
//		httpClient.get(url, activityName, header(),param, handler1);
	   
	
//	
//	public void postRequest(JSONObject jobj,String activityName,  ApiResponseHandler handler){
//		
//		if(mymap.get(activityName) != null){
//	
//		mymap.put(activityName, handler);
//			}
//		HttpClientHandler handler1 =  new HttpClientHandler(handler);
//		String jsonstrng = jobj.toString();
//		RequestParams param = new RequestParams();
//		
//		param.put("parameters",jsonstrng );
//		httpClient.setTimeout(5000);
//		httpClient.post(url, activityName, headerarr, param, null, handler1);
		
	
