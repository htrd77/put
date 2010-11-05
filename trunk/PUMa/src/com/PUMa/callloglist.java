package com.PUMa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class callloglist extends Activity implements OnClickListener{
	Button ViewMapsButtonCL, GetDirectionsButtonCL, SaveLocationButtonCL; 
	@Override
	public void onCreate(Bundle savedInstanceState) 
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.cll);
	        
	        
	        ViewMapsButtonCL = (Button)findViewById(R.id.ViewMapButtonCL);
	        GetDirectionsButtonCL = (Button)findViewById(R.id.GetDirectionsButtonCL);
	        SaveLocationButtonCL = (Button)findViewById(R.id.SaveLocationButtonCL);
	        
	        ViewMapsButtonCL.setOnClickListener(this);
	        GetDirectionsButtonCL.setOnClickListener(this);
	        SaveLocationButtonCL.setOnClickListener(this);
	        
	    }

	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.ViewMapButtonCL:
			Intent i1=new Intent(this,viewmap.class);
	    	startActivity(i1);
	    	break;
	    	
		case R.id.GetDirectionsButtonCL:
			Intent i2=new Intent(this,getdirections.class);
	    	startActivity(i2);
	    	break;
	    	
		case R.id.SaveLocationButtonCL:
			Intent i3=new Intent(this,groupcl.class);
	    	startActivity(i3);
	    	break;
		}
		// TODO Auto-generated method stub
		
	}


}
