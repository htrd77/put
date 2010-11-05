package com.PUMa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class bookmarklist extends Activity implements OnClickListener{

	Button ViewMapButtonBM,GroupsButtonBM,GetDirectionsButtonBM;
	@Override
	public void onCreate(Bundle savedInstanceState) 
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.bml);
	        
	        ViewMapButtonBM = (Button)findViewById(R.id.ViewMapButtonBM);
	        GroupsButtonBM = (Button)findViewById(R.id.GroupsButtonBM);
	        GetDirectionsButtonBM = (Button)findViewById(R.id.GetDirectionsButtonBM);
	        
	       ViewMapButtonBM.setOnClickListener(this);
           GroupsButtonBM.setOnClickListener(this);
           GetDirectionsButtonBM.setOnClickListener(this);
	        
	    }
	public void onClick(View ss) {
		switch(ss.getId())
		{
		case R.id.ViewMapButtonBM:
			Intent i4=new Intent(this,viewmap.class);
	    	startActivity(i4);
	    	break;
	    	
		case R.id.GroupsButtonBM:
			Intent i5=new Intent(this,groupbm.class);
	    	startActivity(i5);
	    	break;
	    	
		case R.id.GetDirectionsButtonBM:
			Intent i6=new Intent(this,getdirections.class);
	    	startActivity(i6);
	    	break;
		}
		// TODO Auto-generated method stub
		
	}
	        

	

}
