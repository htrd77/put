package com.PUMa;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;

public class getgpscoords extends Service implements LocationListener {
	public double[] coords = new double[2];

	public void onCreate() {
		LocationManager locMan;
		LocationListener gpsListener = null;
		locMan = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locMan.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 1,
				gpsListener);

		gpsListener = new LocationListener() {
			Location curLocation;
			boolean locationChanged = false;

			public void onLocationChanged(Location location) {
				if (curLocation == null) {
					curLocation = location;
					locationChanged = true;
				}

				if (curLocation.getLatitude() == location.getLatitude()
						&& curLocation.getLongitude() == location
								.getLongitude())
					locationChanged = false;
				else {
					locationChanged = true;
					curLocation = location;
				}
				coords[0] = curLocation.getLatitude(); // ///The current
														// latitude value.
				coords[1] = curLocation.getLongitude(); // ///The current
														// longitude value.
				// We need to put both these values in the database for
				// retrieving them to plot on the maps.

			}

			public void onProviderDisabled(String provider) {
			}

			public void onProviderEnabled(String provider) {
			}

			public void onStatusChanged(String provider, int status,
					Bundle extras) {
			}
		};

	}

	
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub

	}

	
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}