package com.PUMa;

// adfds

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class bookmarklist extends Activity implements OnClickListener{

	@Override
	public void onCreate(Bundle savedInstanceState) 
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.bml);
	        
	       
	    }
	public void onClick(View screen3bm) {
		switch(screen3bm.getId())
		{
		case R.id.ViewMapButtonBM:
			break;
	    	
		case R.id.GroupsButtonBM:
			break;
	    	
		case R.id.GetDirectionsButtonBM:
			break;
		}
		// TODO Auto-generated method stub
		
	}
	        

	

}
