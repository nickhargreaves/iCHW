package com.databasetest.sample;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
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



public class editHouse extends Activity implements LocationListener {
	int haslatrine2 =0;
	int treatswater2 =0;
	int handwashing2 = 0;
	int staplefood2 = 0;
	int iec2 = 0;
	Spinner spinner1;
	ProgressBar pb;
	static final String tag = "Main"; // for Log

	TextView txtInfo;
	TextView txtInfo2;
	
	LocationManager lm;
	StringBuilder sb;
	int noOfFixes = 0;
	int gpssource=1;
	
	private DatabaseHelper dbHelper;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.householdinfo);
        pb =(ProgressBar)findViewById(R.id.progressBar1);
        pb.setVisibility(View.GONE);
        this.dbHelper = new DatabaseHelper(this);
        
        Bundle extras = getIntent().getExtras();
        final String village = extras.getString("village");
        final int householdnumber = extras.getInt("householdnumber");
        lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        //set views
        CheckBox checkbox1 = (CheckBox)findViewById(R.id.checkBox1); 
	       CheckBox checkbox2 = (CheckBox)findViewById(R.id.checkBox2); 
	       CheckBox checkbox3 = (CheckBox)findViewById(R.id.checkBox3); 
	       CheckBox checkbox4 = (CheckBox)findViewById(R.id.checkBox4); 
	       CheckBox checkbox5 = (CheckBox)findViewById(R.id.checkBox5);
	       TextView textView4 = (TextView)findViewById(R.id.textView4);
	       TextView textView3 = (TextView)findViewById(R.id.textView3);
	       txtInfo2 = (TextView)findViewById(R.id.textView2);
	       Button bSwitch = (Button) findViewById(R.id.button2);
	       final Button button3 = (Button) findViewById(R.id.button3);
	       
	       button3.setVisibility(R.id.button3);
	       
	       //get head of household
	       Individuals emp = new Individuals(String.valueOf(householdnumber), village, 1);
	       
	         
	         
	          List<String> leader = dbHelper.SelectName(emp);
				StringBuilder sb3 = new StringBuilder();
		         for (String IndName : leader) {
		           sb3.append(IndName);
		        }
		         final String PersonName = sb3.toString();
		         textView4.setText(PersonName+"'s House");
		       
		        
			         
		         
		         
		         
		   //retrieve values for house and set checkboxes *** i'll change to a better way later give me a break**
		         Houses emp2 = new Houses(String.valueOf(householdnumber), village);
		         //gps
		         final List<String> coord2 = dbHelper.SelectCoordinates(emp2);
					final StringBuilder sc3 = new StringBuilder();
			         for (String coordinates : coord2) {
			           sc3.append(coordinates);
			        }
			         txtInfo = (TextView)findViewById(R.id.textView1);
			         txtInfo.setText(sc3.toString());
			         
			         
		         //haslatrine
		        
		         
		         List<String> haslatrine1 = dbHelper.SelectHaslatrine(emp2);
					StringBuilder sb5 = new StringBuilder();
			         for (String haslatrine : haslatrine1) {
			           sb5.append(haslatrine);
			        }
			     //treatswater
			         List<String> treatswater1 = dbHelper.SelectTreatswater(emp2);
						StringBuilder sb6 = new StringBuilder();
				         for (String treatswater : treatswater1) {
				           sb6.append(treatswater);
				        }  
		         //set method
		         List<String> method0 = dbHelper.SelectMethod(emp2);
					StringBuilder method1 = new StringBuilder();
			         for (String method2 : method0) {
			           method1.append(method2);
			        }
			        if(method1.toString().equals("Boil")){
			        	spinner1.setSelection(0);
			        }else if(method1.toString().equals("Add chlorine or lime")){
			        	spinner1.setSelection(1);
			        }else if(method1.toString().equals("Strain through cloth")){
			        	spinner1.setSelection(2);
			        }else if(method1.toString().equals("Pur or other water treatment")){
			        	spinner1.setSelection(3);
			        }else{
			        	spinner1.setSelection(4);
			        }
			     //handwashing
				         List<String> handwashing1 = dbHelper.SelectHandwashing(emp2);
							StringBuilder sb7 = new StringBuilder();
					         for (String handwashing : handwashing1) {
					           sb7.append(handwashing);
					        }
			     //staplefood
					         List<String> staplefood1 = dbHelper.SelectStaplefood(emp2);
								StringBuilder sb8 = new StringBuilder();
						         for (String staplefood : staplefood1) {
						           sb8.append(staplefood);
						        }
			     //iec  
						         List<String> iec1 = dbHelper.SelectIec(emp2);
									StringBuilder sb9 = new StringBuilder();
							         for (String iec : iec1) {
							           sb9.append(iec);
							        }
			         
if(sb5.toString().equals("1")){
	checkbox1.setChecked(true);
	haslatrine2=1;
}
else
{
	checkbox1.setChecked(false);
	handwashing2=0;
}
if(sb6.toString().equals("1")){
	checkbox2.setChecked(true);
	treatswater2=1;
	spinner1.setVisibility(View.VISIBLE);
}
else
{
	checkbox2.setChecked(false);
	treatswater2=0;
   	spinner1.setVisibility(View.GONE);
}
if(sb7.toString().equals("1")){
	checkbox3.setChecked(true);
	handwashing2=1;
}
else
{
	checkbox3.setChecked(false);
	handwashing2=0;
}
if(sb8.toString().equals("1")){
	checkbox4.setChecked(true);
	staplefood2=1;
}
else
{
	checkbox4.setChecked(false);
	staplefood2=0;
}
if(sb9.toString().equals("1")){
	checkbox5.setChecked(true);
	iec2=1;
}
else
{
	checkbox5.setChecked(false);
	iec2=0;
}
//update onClick


checkbox1.setOnCheckedChangeListener(new OnCheckedChangeListener()
{
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {
        if ( isChecked )
        {
        	haslatrine2=1;
        }
        else
        {
        	haslatrine2=0;
        	
        }

    }
}); 

checkbox2.setOnCheckedChangeListener(new OnCheckedChangeListener()
{
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {
        if ( isChecked )
        {
        	treatswater2=1;
        	spinner1.setVisibility(View.VISIBLE);
        }
        else
        {
        	treatswater2=0;
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
        	handwashing2=1;
        }
        else
        {
        	handwashing2=0;
        	
        }

    }
});
checkbox4.setOnCheckedChangeListener(new OnCheckedChangeListener()
{
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {
        if ( isChecked )
        {
        	staplefood2=1;
        }
        else
        {
        	staplefood2=0;
        	
        }

    }
});
checkbox5.setOnCheckedChangeListener(new OnCheckedChangeListener()
{
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {
        if ( isChecked )
        {
        	iec2=1;
        }
        else
        {
        	iec2=0;
        	
        }

    }
});
final List<String> chw = dbHelper.selectCHW();
	final StringBuilder sb10 = new StringBuilder();
  for (String CHW : chw) {
    sb10.append(CHW);
 }
 //update gps
  button3.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//submit data to db
			txtInfo2.setText("Getting location data...");
			
			txtInfo.setVisibility(View.GONE);
			txtInfo2.setVisibility(View.VISIBLE);
			
			gpssource=2;
			
			pb.setVisibility(View.VISIBLE);
			button3.setVisibility(View.GONE);
		}
	});
//send
bSwitch.setOnClickListener(new View.OnClickListener() {
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//submit data to db
		String coord;
		if(gpssource==1){
		
		coord = txtInfo.getText().toString();
		}
		else{
		coord = txtInfo2.getText().toString();
		}
		
		String latlon;
		if(coord.equals("Getting location data...")){
			latlon="Coordinates: 0, 0";
		}
		else{
			latlon=coord;
		}
		String method = spinner1.getSelectedItem().toString();
		Houses emp3 = new Houses(String.valueOf(householdnumber), village, sb10.toString(), latlon, haslatrine2, treatswater2, method, handwashing2, staplefood2, iec2, PersonName);
		  dbHelper.UpdateHouse(emp3);
		  
		  
		Intent pancakes = new Intent(v.getContext(), Tabs.class);
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
		

		

		txtInfo2.setText(sb.toString());
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
