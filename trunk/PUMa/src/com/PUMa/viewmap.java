package com.PUMa;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class viewmap extends MapActivity{
	public void onCreate(Bundle savedInstanceState)
	 {
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.map);

	 MapView mapView = (MapView) findViewById(R.id.viewmap);
	 mapView.setBuiltInZoomControls(true);

	 List<Overlay> mapOverlays = mapView.getOverlays();
	 Drawable drawable = this.getResources().getDrawable(R.drawable.icon);
	 HelloItemizedOverlay itemizedoverlay = new HelloItemizedOverlay(drawable,this);
	 GeoPoint point = new GeoPoint(17413617,78451598);
	 OverlayItem overlayitem = new OverlayItem(point, "Home - Hyderabad", null);

	 GeoPoint point2 = new GeoPoint(40506736,-74436359);
	 OverlayItem overlayitem2 = new OverlayItem(point2, "Home - Cedar Lane", null);

	 itemizedoverlay.addOverlay(overlayitem);
	 itemizedoverlay.addOverlay(overlayitem2);

	 mapOverlays.add(itemizedoverlay);
	 }
	 @Override
	 protected boolean isRouteDisplayed()
	 {
	 return false;
	 }

}
