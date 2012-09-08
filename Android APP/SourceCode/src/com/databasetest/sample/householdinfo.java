package com.databasetest.sample;

import java.util.List;


import android.app.Activity;
import android.content.Intent;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;




public class householdinfo extends Activity implements LocationListener {
	
	int haslatrine =0;
	int treatswater =0;
	int handwashing = 0;
	int staplefood = 0;
	int iec = 0;
	String lat ="0";
	String lon ="0";
	private DatabaseHelper dbHelper;
	Spinner spinner1;
	
	static final String tag = "Main"; // for Log

	TextView txtInfo;
	ProgressBar pb;
	LocationManager lm;
	StringBuilder sb;
	int noOfFixes = 0;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.householdinfo);
        this.dbHelper = new DatabaseHelper(this);
        
        /* get TextView to display the GPS data */
		txtInfo = (TextView) findViewById(R.id.textView1);
		pb =(ProgressBar)findViewById(R.id.progressBar1);
		/* the location manager is the most vital part it allows access
		 * to location and GPS status services */
		lm = (LocationManager) getSystemService(LOCATION_SERVICE);
		
        
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        CheckBox checkbox1 = (CheckBox)findViewById(R.id.checkBox1); 
	       CheckBox checkbox2 = (CheckBox)findViewById(R.id.checkBox2); 
	       CheckBox checkbox3 = (CheckBox)findViewById(R.id.checkBox3); 
	       CheckBox checkbox4 = (CheckBox)findViewById(R.id.checkBox4); 
	       CheckBox checkbox5 = (CheckBox)findViewById(R.id.checkBox5); 
	//get householdnumber, chw, village
        List<String> names = dbHelper.selectVillage();
		StringBuilder sb = new StringBuilder();
         for (String Village : names) {
           sb.append(Village);
           
        }
         final String village = sb.toString();	   		        
        //
        List<String> names2 = dbHelper.selectHouseholdnumber();
		StringBuilder sb2 = new StringBuilder();
         for (String HouseholdNumber : names2) {
           sb2.append(HouseholdNumber);
        }
         final String householdnumber = sb2.toString();
         //Households emp2 = new Households("", sb.toString(), "");	       
         //int households = dbHelper.getHousesCount(emp2);
         //final int householdnumber = households + 1;
         
         final List<String> chw = dbHelper.selectCHW();
 		StringBuilder sb4 = new StringBuilder();
          for (String CHW : chw) {
            sb4.append(CHW);
         }
          final String CHW = sb4.toString(); 
         
     //get head of household
         Individuals emp = new Individuals(householdnumber, village, 1);
   
         
         
          List<String> leader = dbHelper.SelectName(emp);
			StringBuilder sb3 = new StringBuilder();
	         for (String IndName : leader) {
	           sb3.append(IndName);
	        }
	         final String PersonName = sb3.toString();
	         
	         
    //set head of household
	         TextView textView4 = (TextView)findViewById(R.id.textView4);
	         textView4.setText(PersonName+"'s House");
    //get GPS coordinates
    //set data
	         checkbox1.setOnCheckedChangeListener(new OnCheckedChangeListener()
	           {
	               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
	               {
	                   if ( isChecked )
	                   {
	                   	haslatrine=1;
	                   }
	                   else
	                   {
	                   	haslatrine=0;
	                   	
	                   }

	               }
	           }); 
	     
	         checkbox2.setOnCheckedChangeListener(new OnCheckedChangeListener()
	           {
	               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
	               {
	                   if ( isChecked )
	                   {
	                   	treatswater=1;
	                   	spinner1.setVisibility(View.VISIBLE);
	                   }
	                   else
	                   {
	                   	treatswater=0;
	                   	spinner1.setVisibility(View.GONE);
	                   }

	               }
	           });
	         checkbox3.setOnCheckedChangeListener(new OnCheckedChangeListener()
	           {
	               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
	               {
	                   if ( isChecked )
	                   {
	                   	handwashing=1;
	                   }
	                   else
	                   {
	                   	handwashing=0;
	                   	
	                   }

	               }
	           });
	         checkbox4.setOnCheckedChangeListener(new OnCheckedChangeListener()
	           {
	               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
	               {
	                   if ( isChecked )
	                   {
	                   	staplefood=1;
	                   }
	                   else
	                   {
	                   	staplefood=0;
	                   	
	                   }

	               }
	           });
	         checkbox5.setOnCheckedChangeListener(new OnCheckedChangeListener()
	           {
	               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
	               {
	                   if ( isChecked )
	                   {
	                   	iec=1;
	                   }
	                   else
	                   {
	                   	iec=0;
	                   	
	                   }

	               }
	           });
	         
	         
	         
	         
Button bSwitch = (Button) findViewById(R.id.button2);
        
        bSwitch.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//submit data to db
				String coord = txtInfo.getText().toString();
				String latlon;
				String method = spinner1.getSelectedItem().toString();
				if(coord.equals("Getting location data...")){
					latlon="Coordinates: 0, 0";
				}
				else{
					latlon=coord;
				}
				
				Houses emp3 = new Houses(householdnumber, village, CHW, latlon, haslatrine, treatswater, method, handwashing, staplefood, iec, PersonName);
				dbHelper.UpdateHous(emp3);
								  
				Intent pancakes = new Intent(v.getContext(), death.class);
				v.getContext().startActivity(pancakes);
			}
		});
        }
	@Override
	protected void onResume() {
		/*
		 * onResume is is always called after onStart, even if the app hasn't been
		 * paused
		 *
		 * add location listener and request updates every 1000ms or 10m
		 */
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10f, this);
		super.onResume();
	}

	@Override
	protected void onPause() {
		/* GPS, as it turns out, consumes battery like crazy */
		lm.removeUpdates(this);
		super.onResume();
	}

	@Override
	public void onLocationChanged(Location location) {
		Log.v(tag, "Location Changed");

		sb = new StringBuilder(512);

		noOfFixes++;

		/* display some of the data in the TextView */

		String lat = String.valueOf(location.getLatitude());
		String lon = String.valueOf(location.getLongitude());

		sb.append("Coordinates: ");
		sb.append(location.getLongitude());
		sb.append(", ");

		
		sb.append(location.getLatitude());
		

		

		txtInfo.setText(sb.toString());
		pb.setVisibility(View.GONE);
	}

	@Override
	public void onProviderDisabled(String provider) {
		/* this is called if/when the GPS is disabled in settings */
		Log.v(tag, "Disabled");

		/* bring up the GPS settings */
		Intent intent = new Intent(
				android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
		startActivity(intent);
	}

	@Override
	public void onProviderEnabled(String provider) {
		Log.v(tag, "Enabled");
		Toast.makeText(this, "GPS Enabled", Toast.LENGTH_SHORT).show();

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		/* This is called when the GPS status alters */
		switch (status) {
		case LocationProvider.OUT_OF_SERVICE:
			Log.v(tag, "Status Changed: Out of Service");
			Toast.makeText(this, "Status Changed: Out of Service",
					Toast.LENGTH_SHORT).show();
			break;
		case LocationProvider.TEMPORARILY_UNAVAILABLE:
			Log.v(tag, "Status Changed: Temporarily Unavailable");
			Toast.makeText(this, "Status Changed: Temporarily Unavailable",
					Toast.LENGTH_SHORT).show();
			break;
		case LocationProvider.AVAILABLE:
			Log.v(tag, "Status Changed: Available");
			Toast.makeText(this, "Status Changed: Available",
					Toast.LENGTH_SHORT).show();
			break;
		}
	}

	@Override
	protected void onStop() {
		/* may as well just finish since saving the state is not important for this toy app */
		finish();
		super.onStop();
	}
}