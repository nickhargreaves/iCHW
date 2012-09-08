package com.databasetest.sample;

import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class Questioncategories extends Activity{
	private int mYear;
	private int mMonth;
	private int mDay;
	private DatabaseHelper dbHelper;
	String donegen=null;
	public final static String jina ="com.databasetest.sample._jina";
	public final static String b2en ="com.databasetest.sample._b2en";
	@Override
    public void onCreate(Bundle savedInstanceState) {
	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questioncategories);
        this.dbHelper = new DatabaseHelper(this);
    	 
        //set person's name to - select person's name where village=current and householdnumber=current and PID =1
			      //get householdnumber, village - read from database of current.
					List<String> names = dbHelper.selectVillage();
					StringBuilder sb = new StringBuilder();
			         for (String Village : names) {
			           sb.append(Village);
			           
			        }
			         String village = sb.toString();	   		        
			        //
			        List<String> names2 = dbHelper.selectHouseholdnumber();
					StringBuilder sb2 = new StringBuilder();
			         for (String HouseholdNumber : names2) {
			           sb2.append(HouseholdNumber);
			        }
			         String householdnumber = sb2.toString();
			         
			         Individuals emp = new Individuals(householdnumber, village);
			     
			         
			         List<String> personname = dbHelper.SelectName(emp);
						StringBuilder sb3 = new StringBuilder();
				         for (String IndName : personname) {
				           sb3.append(IndName);
				        }
				         final String PersonName = sb3.toString();
				         TextView textView1 = (TextView)findViewById(R.id.textView1);
				         textView1.setText(PersonName);
				         
        //calculate age from "explode" dob, 
				         List<String> age = dbHelper.SelectAge(emp);
							StringBuilder sb4 = new StringBuilder();
					         for (String Birthday : age) {
					           sb4.append(Birthday);
					        }
					         String dob = sb4.toString();
					         String[] tokens = dob.split("-");
					         	
					         String year = tokens[2].trim();				         
					         //the math goes here
					         Calendar c = Calendar.getInstance();
					         mYear = c.get(Calendar.YEAR);
					         mMonth = c.get(Calendar.MONTH);
					         mDay = c.get(Calendar.DAY_OF_MONTH);
					         
					         int day = new Integer(tokens[1]);
					         int month = new Integer(tokens[0]);
					         int year2 = new Integer(year);
					         
					         int age2 = year2 + month/12 - (31-day)/365;
					         int age3 = mYear +mMonth/12 - (31-mDay)/365;
					         
					         int age4 = age3-age2;
					        					         
					         
        //determine which buttons to show from (current year - dob[3])
					         Button button3 =(Button)findViewById(R.id.button3);
					         if (age4>5){
					        	 button3.setVisibility(View.GONE);
					         }
					         
					         Button button7 =(Button)findViewById(R.id.button7);
					         if (age4>16){
					        	 button7.setVisibility(View.GONE);
					         }
					         Button button5 =(Button)findViewById(R.id.button5);
					         if (age4<16){
					        	 button5.setVisibility(View.GONE);
					         }
        //determine which buttons to show from sex
					         List<String> sex = dbHelper.SelectSex(emp);
								StringBuilder sb5 = new StringBuilder();
						         for (String Sex : sex) {
						           sb4.append(Sex);
						        }
						         String sex2 = sb5.toString();
						         
						         Button button4 =(Button)findViewById(R.id.button4);
						         if (sex2=="Male"){
						        	 button4.setVisibility(View.GONE);
						         }
						         
						         if (age4<12){
						        	 button4.setVisibility(View.GONE);
						         }
						         if (age4>45){
						        	 button4.setVisibility(View.GONE);
						         }
						         
        //y = getCount select individuals where village=current and householdnumber = current
						         int numberofmembers = dbHelper.getMembersCount(emp);
						         TextView textView5 = (TextView)findViewById(R.id.textView5);
						         textView5.setText(String.valueOf(numberofmembers));
        //x = 1
						         int x =1;
						         TextView textView4 = (TextView)findViewById(R.id.textView4);
						         textView4.setText(String.valueOf(x));						         					         
						         
        //after each section make button inactive
						         final Button button2 = (Button)findViewById(R.id.button2);
						         donegen = getIntent().getStringExtra(GeneralInformation.done);
						        
						      if (donegen!=null){
						      int donegen1 = new Integer(donegen);
						      
						      				    
						         if(donegen1>0){
						        	button2.setEnabled(false);
						         }
						      }
					
						      String b2en1 = getIntent().getStringExtra(under5.b2en1);
						      if (b2en1!=null){
							      int b2en2 = new Integer(b2en1);
							      
							      				    
							         if(b2en2>0){
							        	button2.setEnabled(false);
							         }
							      }
						      
						      
						      Button button31 = (Button)findViewById(R.id.button3);
						         String doneunder5 = getIntent().getStringExtra(under5.done);
						      
						      if (doneunder5!=null){
						      int doneunder51 = new Integer(doneunder5);
						      					    
						         if(doneunder51>0){
						        	button31.setEnabled(false);
						         }
						      }
        //progress bar is inactive buttons/total buttons * 100
        //when progress bar is 100% pick next person, x++
        //while there is another person show screen for person, else show done button
        
Button bSwitch = (Button) findViewById(R.id.button2);
        
        bSwitch.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent pancakes = new Intent(Questioncategories.this, GeneralInformation.class);
				//v.getContext().startActivity(pancakes);
				pancakes.putExtra(jina, PersonName);
				
				
				startActivity(pancakes);
			}
		});
Button bSwitch4 = (Button) findViewById(R.id.button3);
        
        bSwitch4.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent pancakes = new Intent(Questioncategories.this, under5.class);
				//v.getContext().startActivity(pancakes);
				pancakes.putExtra(jina, PersonName);
				if(button2.isEnabled()==true)
				{
				pancakes.putExtra(b2en, 0);
				}
				else
				{
					pancakes.putExtra(b2en, 1);
				}
				startActivity(pancakes);
			}
		});
        
Button bSwitch1 = (Button) findViewById(R.id.button7);
        
        bSwitch1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
        
Button bSwitch2 = (Button) findViewById(R.id.button5);
        
        bSwitch2.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent pancakes = new Intent(v.getContext(), over16.class);
				//v.getContext().startActivity(pancakes);
			}
		});
        
Button bSwitch3 = (Button) findViewById(R.id.button6);
        
        bSwitch3.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent pancakes = new Intent(v.getContext(), additionalinformation.class);
				//v.getContext().startActivity(pancakes);
			}
		});

Button bSwitch5 = (Button) findViewById(R.id.button4);
        
        bSwitch5.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent pancakes = new Intent(v.getContext(), maternalinformation.class);
				//v.getContext().startActivity(pancakes);
			}
		});
Button bSwitch6 = (Button) findViewById(R.id.button8);
        
        bSwitch6.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent pancakes = new Intent(v.getContext(), household.class);
				//v.getContext().startActivity(pancakes);
			}
		});
	}
}