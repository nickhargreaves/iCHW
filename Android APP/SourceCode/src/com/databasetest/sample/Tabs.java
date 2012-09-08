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

public class Tabs extends TabActivity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab);

        SetupTabs();

    }
    
     
    
    void SetupTabs()
    {

    	TabHost host=getTabHost();

        
        
        TabHost.TabSpec spec2=host.newTabSpec("tag2");
        Intent in2=new Intent(this, GridList.class);
        
        spec2.setIndicator("Households");
        spec2.setContent(in2);
        
        host.addTab(spec2);
 
        
       
    }
    
}