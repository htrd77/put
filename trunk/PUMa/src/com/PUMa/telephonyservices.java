package com.PUMa;


import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class telephonyservices extends Service
{

	PhoneStateListener listener;
	TelephonyManager telephonyManager;
	
	@Override
	public IBinder onBind(Intent arg0) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate()
	{
		telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		telephonyManager.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);

		
		listener = new PhoneStateListener()
		{
			@Override
			public void onCallStateChanged(int state, String IncomingNumber)
			{
				switch(state)
				{
				case TelephonyManager.CALL_STATE_IDLE:
					break;
			    
				case TelephonyManager.CALL_STATE_OFFHOOK:
					//The incoming or outgoing phone number is stored in variable "IncomingNumber" - We can put this in the database through direct call here
					//Call to get and save gps coordinates
					Intent i7=new Intent(null, getgpscoords.class);
					startService(i7);
					//Intent i7=new Intent(this,getgpscoords.class);
					//startActivity(i7);
			        break;
			   
				case TelephonyManager.CALL_STATE_RINGING:
			        break;
				}
			}
		};
		
	}

}
