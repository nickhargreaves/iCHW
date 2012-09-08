package com.databasetest.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;



public class Other extends Activity{
	private DatabaseHelper dbHelper;
	String village;
	Spinner spinner1;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);
        this.dbHelper = new DatabaseHelper(this);
        
        Bundle extras = getIntent().getExtras();
       village = extras.getString("village");
        final int householdnumber = extras.getInt("householdnumber");
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button4 = (Button)findViewById(R.id.button4);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        
        if(village.equals("Alara"))
        {
        spinner1.setSelection(0);       
        }
        else if(village.equals("Ywaya"))
        {
        spinner1.setSelection(1);       
        }
        else if(village.equals("Ulare"))
        {
        spinner1.setSelection(2);       
        }
        else if(village.equals("Fundula"))
        {
        spinner1.setSelection(3);       
        }
        else if(village.equals("Kondiek"))
        {
        spinner1.setSelection(4);       
        }
        else if(village.equals("Ligose"))
        {
        spinner1.setSelection(5);       
        }
        else if(village.equals("Mukwiro"))
        {
        spinner1.setSelection(6);       
        }
        else if(village.equals("Ogero"))
        {
        spinner1.setSelection(7);       
        }
        else if(village.equals("Oriang"))
        {
        spinner1.setSelection(8);       
        }
        else if(village.equals("Umlunda"))
        {
        spinner1.setSelection(9);       
        }
        else if(village.equals("Murumba"))
        {
        spinner1.setSelection(10);       
        }
        else if(village.equals("Sega Town Central"))
        {
        spinner1.setSelection(11);       
        }
        else if(village.equals("Sega Town East"))
        {
        spinner1.setSelection(12);       
        }
        else if(village.equals("Sega Town Northeast"))
        {
        spinner1.setSelection(13);       
        }
        else if(village.equals("Ugambe"))
        {
        spinner1.setSelection(14);       
        }
        else if(village.equals("Odende"))
        {
        spinner1.setSelection(15);       
        }
        else if(village.equals("Serowa"))
        {
        spinner1.setSelection(16);       
        }
        
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { 
                // Your code here
            	Houses emp = new Houses(String.valueOf(householdnumber), spinner1.getSelectedItem().toString(), village);
            	    	
            	dbHelper.UpdateVillage(emp);
            	dbHelper.UpdateVillageInds(emp);
            	village=spinner1.getSelectedItem().toString();
            } 

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            } 
        });    
        
        button2.setOnClickListener(new View.OnClickListener() {
			
 			public void onClick(View v) {
 				// TODO Auto-generated method stub
        Intent pancakes = new Intent(Other.this, editHouse.class);
		pancakes.putExtra("village", village);
		pancakes.putExtra("householdnumber", householdnumber);
		startActivity(pancakes);
 			}
        });
  button4.setOnClickListener(new View.OnClickListener() {
			
 			public void onClick(View v) {
 				// TODO Auto-generated method stub
        Intent pancakes = new Intent(Other.this, Death2.class);
		pancakes.putExtra("village", village);
		pancakes.putExtra("householdnumber", householdnumber);
		startActivity(pancakes);
 			}
        });
        Button button3 = (Button)findViewById(R.id.button3);
 button3.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent pancakes = new Intent(Other.this, Tabs2.class);
				pancakes.putExtra("village", village);
				pancakes.putExtra("householdnumber", householdnumber);
				startActivity(pancakes);
			}
		});
 Button button5 = (Button)findViewById(R.id.button5);
 
 button1.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent pancakes = new Intent(v.getContext(), Action1.class);
			v.getContext().startActivity(pancakes);
		}
	}); 
 
 button5.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent pancakes = new Intent(v.getContext(), Tabs.class);
							
				Houses emp=new Houses(String.valueOf(householdnumber), village);
				dbHelper.deleteHouse(emp);
				dbHelper.deleteIndividuals(emp);
				v.getContext().startActivity(pancakes);
			}
		});
 Button button6 = (Button)findViewById(R.id.button6);
 button6.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent pancakes = new Intent(Other.this, AddIndividual.class);
			    pancakes.putExtra("village", village);
				pancakes.putExtra("householdnumber", householdnumber);
				startActivity(pancakes);
			}
		});
}
}
