package com.PUMa;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.*;

public class bookmarklist extends ListActivity implements OnClickListener{

	//telephonyservices telephonyservices = new telephonyservices();
	//public String[] phnos = telephonyservices.phnos;
	Button ViewMapButtonBM,GroupsButtonBM,GetDirectionsButtonBM;
	ListView list;
	@Override
	public void onCreate(Bundle savedInstanceState) 
	    {
			
	        super.onCreate(savedInstanceState);
	        //setContentView(R.layout.bml);
	        
	                
	        
            ListView list = getListView();
            View bml = getLayoutInflater().inflate(R.layout.bml,list,false);
            getListView().addHeaderView(bml, null, true);
            
            ViewMapButtonBM = (Button)bml.findViewById(R.id.ViewMapButtonBM);
	        GroupsButtonBM = (Button)bml.findViewById(R.id.GroupsButtonBM);
	        //GetDirectionsButtonBM = (Button)findViewById(R.id.GetDirectionsButtonBM);
	        
	        ViewMapButtonBM.setOnClickListener(this);
            GroupsButtonBM.setOnClickListener(this);
            //GetDirectionsButtonBM.setOnClickListener(this);
                        
            getListView().setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, LIST));
            getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
            getListView().setTextFilterEnabled(true);
            
   
            getListView().setOnItemClickListener(new OnItemClickListener()
            {
            			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
            					long arg3) {
            				if (getListView().isItemChecked(arg2))
        					{
        						for (int i=0; i<getListView().getChildCount(); i++)
        						{
        							if (getListView().getFirstVisiblePosition()+i==arg2)
        								getListView().getChildAt(i).setBackgroundColor(android.R.color.darker_gray);
        							else

        getListView().getChildAt(i).setBackgroundColor(android.R.color.transparent);
        						}
        					}
        					else
        						getListView().getChildAt(arg2-
        getListView().getFirstVisiblePosition()).setBackgroundColor(android.R.color.transparent);

        				}
                });
            			
            
           /* list.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View view,
						int position, long id) {*/
					// TODO Auto-generated method stub
					//Intent i8=new Intent(null, viewmap.class);
			    	//startActivity(i8);
					//Toast.makeText(getApplicationContext(), ((TextView) view).getText(),Toast.LENGTH_SHORT).show();
					
				//}
           
            	
            	
            //});
	    }
	
	
	 static final String[] LIST = new String[] {
		    "Amrutha", "Snigdha", "Varsha", "Sean", "Vijay", "Test1", "Test1", "Test1", "Test1", "Test1", "Test1",
		    "Test1", "Test1", "Test1", "Test1", "Test1"
		  };
	
	
	
	
	
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
	    	
		
		}
		// TODO Auto-generated method stub
		
	}
	        

	

}
