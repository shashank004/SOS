package com.example.sos.pushmessage;

//import com.example.sos.pushmessage.IntentReceiver;
import com.example.sos.R;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.UAirship;
import com.urbanairship.push.CustomPushNotificationBuilder;
import com.urbanairship.push.PushManager;

import android.app.Application;

public class NotificationView extends Application{

	@Override
	public void onCreate(){
		
		//	get config from .properties file
		AirshipConfigOptions options = AirshipConfigOptions.loadDefaultOptions(this);
		
        UAirship.takeOff(this, options);
        
      //use CustomPushNotificationBuilder to specify a custom layout
        CustomPushNotificationBuilder nb = new CustomPushNotificationBuilder();

        nb.statusBarIconDrawableId = R.drawable.icon_small;//custom status bar icon

        nb.layout = R.layout.notification;
        nb.layoutIconDrawableId = R.drawable.icon;//custom layout icon
        nb.layoutIconId = R.id.icon;
        nb.layoutSubjectId = R.id.subject;
        nb.layoutMessageId = R.id.message;

        // customize the sound played when a push is received
        //nb.soundUri = Uri.parse("android.resource://"+this.getPackageName()+"/" +R.raw.cat);

        PushManager.shared().setNotificationBuilder(nb);
        
        PushManager.enablePush();
        
        PushManager.shared().setIntentReceiver(IntentReciever.class);
    }
	}
