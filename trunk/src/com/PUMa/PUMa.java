package com.PUMa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PUMa extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
        Button CallLogListButton,BookmarksButton;
    	/** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) 
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            
            CallLogListButton = (Button)findViewById(R.id.CallLogListButton);
            BookmarksButton = (Button)findViewById(R.id.BookmarksButton);
            
            CallLogListButton.setOnClickListener(this);
            BookmarksButton.setOnClickListener(this);
        }
            
        public void onClick(View sc)
         {
        	
        	switch(sc.getId()){
        	case R.id.CallLogListButton:
        	Intent i=new Intent(this,callloglist.class);
        	startActivity(i);
        	break;
        		
        	case R.id.BookmarksButton:
        	Intent i2=new Intent(this,bookmarklist.class);
        	startActivity(i2);
        	break;
         }
        
    }
}