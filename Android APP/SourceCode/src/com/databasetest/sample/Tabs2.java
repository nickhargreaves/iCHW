package com.databasetest.sample;



import android.app.TabActivity;
import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.GridView;
import android.widget.TabHost;
import android.widget.TextView;

public class Tabs2 extends TabActivity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab2);
        
        
        SetupTabs();

    }
    
     
    
    void SetupTabs()
    {
    	Bundle extras = getIntent().getExtras();
    	final String village = extras.getString("village");
        final int householdnumber = extras.getInt("householdnumber");
    	TabHost host=getTabHost();

        
        
        TabHost.TabSpec spec2=host.newTabSpec("tag2");
        Intent in2=new Intent(this, GridList2.class);
        
        in2.putExtra("village", village);
		in2.putExtra("householdnumber", householdnumber);
		
        spec2.setIndicator("Individuals");
        spec2.setContent(in2);
        
        host.addTab(spec2);
 
        
       
    }
    
}