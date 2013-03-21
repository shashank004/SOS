package com.example.sos.services;

import java.util.List;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.widget.Toast;

public class Shake extends Service implements SensorEventListener{

	

	private SensorManager mSensorManager;
	private Sensor mSensor;
	private Context context =getApplicationContext();
	private long lastUpdate;

	private Sensor shakingSensor(){
	mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
	 if (mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY) != null){
		 List<Sensor> gravSensors = mSensorManager.getSensorList(Sensor.TYPE_GRAVITY);
		  for(int i=0; i<gravSensors.size(); i++) {
		    if ((gravSensors.get(i).getVendor().contains("Google Inc.")) &&
		       (gravSensors.get(i).getVersion() == 3)){
		      // Use the version 3 gravity sensor.
		      mSensor = gravSensors.get(i);
		    }
		  }
		}
		else{
		  // Use the accelerometer.
		  if (mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){
		    mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		  }
		  else{
			  Toast.makeText(context, "This application will not run on your device", Toast.LENGTH_LONG).show();
		  }
		}
	return mSensor;
	 }

 @Override
 public void onCreate(){
	 super.onCreate();
	
	 mSensorManager.registerListener(this, shakingSensor(), SensorManager.SENSOR_DELAY_NORMAL);
 }
 @Override
 public void onDestroy(){
	 super.onDestroy();
	
	 mSensorManager.unregisterListener(this, shakingSensor());
 }
	
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onSensorChanged(SensorEvent event) {
		 {
	          // alpha is calculated as t / (t + dT)
	          // with t, the low-pass filter's time-constant
	          // and dT, the event delivery rate

//	          final float alpha = 0.8;
//
//	          gravity[0] = alpha * gravity[0] + (1 - alpha) * event.values[0];
//	          gravity[1] = alpha * gravity[1] + (1 - alpha) * event.values[1];
//	          gravity[2] = alpha * gravity[2] + (1 - alpha) * event.values[2];
//
//	          linear_acceleration[0] = event.values[0] - gravity[0];
//	          linear_acceleration[1] = event.values[1] - gravity[1];
//	          linear_acceleration[2] = event.values[2] - gravity[2];
//	     }
		
		
		
		
    float[] values = event.values;
    // Movement
    float x = values[0];
    float y = values[1];
    float z = values[2];

    float accelationSquareRoot = (x * x + y * y + z * z)
        / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
    long actualTime = System.currentTimeMillis();
    if (accelationSquareRoot >= 2) //
    {
      if (actualTime - lastUpdate < 200) {
        return;
      }
      lastUpdate = actualTime;
      Toast.makeText(this, "Device was shuffed", Toast.LENGTH_SHORT)
          .show();
    }

		
	}
	}



	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
