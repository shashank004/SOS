package com.example.sos.activities;




import com.example.sos.R;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;


public class MainActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
		public void OnfbClick(View view){
		
		//fb login
		Session.openActiveSession(this,true, new Session.StatusCallback() {
			@Override
			public void call(Session session, SessionState state, Exception exception){
				if (state.equals(SessionState.OPENING)) {
					//make request to 
					Request.executeMeRequestAsync(session, new Request.GraphUserCallback() {

						 
					  @Override
					  public void onCompleted(GraphUser user, Response response) {
						 
							  if(user != null){
								  Log.i("name", user.getName());
								  Log.v("name", user.getName());
							 
							  }
						  }
						});
				}
			}
		});
	}


	public void OnloginClick(View view){
		Intent intent = new Intent(getApplicationContext(), Login.class);
		startActivity(intent);
		
		
	}
	
	public void OnsignupClick(View view){
		Intent intent = new Intent(MainActivity.this, Signup.class);
		startActivity(intent);
	}
	
	
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
	}
	 

		
	
}
