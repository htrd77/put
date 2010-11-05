package com.PUMa;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class callloglist extends Activity implements OnClickListener{
	@Override
	public void onCreate(Bundle savedInstanceState) 
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.cll);
	        
	    }

	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.ViewMapButtonCL:
			break;
	    	
		case R.id.GetDirectionsButtonCL:
			break;
	    	
		case R.id.SaveLocationButtonCL:
			break;
		}
		// TODO Auto-generated method stub
		
	}


}
