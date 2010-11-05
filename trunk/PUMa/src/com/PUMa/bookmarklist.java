package com.PUMa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class bookmarklist extends Activity implements OnClickListener{

	Button ViewMapButton, GroupButton, GetDirectionsButton;
	@Override
	public void onCreate(Bundle savedInstanceState) 
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.bml);
	        
	        ViewMapButton = (Button)findViewById(R.id.ViewMapButtonBM);
	        GroupButton = (Button)findViewById(R.id.GroupsButtonBM);
	        GetDirectionsButton = (Button)findViewById(R.id.GetDirectionsButtonBM);
	        
	    }
	public void onClick(View screen3bm) {
		switch(screen3bm.getId())
		{
		case R.id.ViewMapButtonBM:
			Intent i1=new Intent(this,viewmap.class);
	    	startActivity(i1);
	    	break;
	    	
		case R.id.GroupsButtonBM:
			Intent i2=new Intent(this,groupbm.class);
	    	startActivity(i2);
	    	break;
	    	
		case R.id.GetDirectionsButtonBM:
			Intent i3=new Intent(this,getdirections.class);
	    	startActivity(i3);
	    	break;
		}
		// TODO Auto-generated method stub
		
	}
	        

	

}
