package com.databasetest.sample;

import java.util.Calendar;
import java.util.List;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;



	public class Questionnare extends Activity{
		private int mYear;
		private int mMonth;
		private int mDay;
		private DatabaseHelper dbHelper;
		Spinner spinnerANC;
		int progress = 0;
		int prog=0;
		String profile;
		int prof;
		int y;
		int x =1;
		int PID = 1;
		String howoften;
		private TextView mDateDisplay;
		private TextView mDateDisplay1;
		private TextView mDateDisplay2;
		private TextView mDateDisplay3;
		private TextView mDateDisplay4;
		private TextView pDisplay2;
		private Calendar penta1;
		private Calendar penta3;
		private Calendar measles;
		private Calendar vitaminac;
		private Calendar deworming;
		private Calendar lastP;
		private TextView textView2;
		private TextView textView3;
		private TextView editText2;
		private TextView editText3;
		private TextView textView6;
		private Spinner spinner1;
		private Spinner spinner2;
		private Spinner spinner3;
		private Button bPickDate2;
		CheckBox cliniccardcb;
		CheckBox mPickDate;
		CheckBox mPickDate2;
		CheckBox mPickDate3;
		CheckBox mPickDate4;
		CheckBox mPickDate5;
		CheckBox fullyimmunizedcb;
		CheckBox pDate;
		CheckBox givenbirth;
		CheckBox vitaminacb;
		CheckBox checkdeworming;
		String rel;
		String relationtohead = "Head of Household";
		int bc=0;
		int bednet=0;
		int knowhivstatus=0;
		int chronic=0;
		int disability=0;
		int personflagged=0;
		
		int ovc=0;
		int orphan=0;
		
		int cliniccard=0;
		int penta1given=0;
		int penta3given=0;
		int measlesgiven=0;
		int fullyimmunized=0;
		int vitamina=0;
		int deworm=0;
		int currentlypregnant=0;
		int birthinlast12=0;
		
		TextView textView8;
		Spinner spinnerANC2;
		
		static final int DATE_DIALOG_ID = 0;
		private TextView activeDateDisplay;
		private Calendar activeDate;
		TextView textView7;
		Spinner spinnerHowOften;
		@Override
	    public void onCreate(Bundle savedInstanceState) {
		
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.questionnare);
	        this.dbHelper = new DatabaseHelper(this);
	    	 textView7=(TextView)findViewById(R.id.textView7);
	    	 spinnerHowOften=(Spinner)findViewById(R.id.spinnerHowOften);
	    	
	    	 textView8=(TextView)findViewById(R.id.textView8);
	    	 spinnerANC2=(Spinner)findViewById(R.id.spinnerANC2);
	    	 
	       final ProgressBar pb = (ProgressBar)findViewById(R.id.progressBar1);
	       final CheckBox checkbox1gi = (CheckBox)findViewById(R.id.checkBox1gi); 
	       final CheckBox checkbox2gi = (CheckBox)findViewById(R.id.checkBox2gi); 
	       final CheckBox checkbox3gi = (CheckBox)findViewById(R.id.checkBox3gi); 
	       final CheckBox checkbox4gi = (CheckBox)findViewById(R.id.checkBox4gi); 
	       final CheckBox checkbox5gi = (CheckBox)findViewById(R.id.checkBox5gi); 
	      final Spinner spinner1gi = (Spinner)findViewById(R.id.spinner1gi); 
	      final Spinner spinner1u5 = (Spinner)findViewById(R.id.spinner1u5);
	       final TextView over16editText1 = (TextView)findViewById(R.id.over16editText1);
	       
	       final CheckBox checkbox1u16 = (CheckBox)findViewById(R.id.checkBox1u16);
	       final CheckBox checkbox2u16 = (CheckBox)findViewById(R.id.checkBox2u16);
	       
	       final TextView editText1a =(TextView)findViewById(R.id.editText1a);
	       final TextView editText2a =(TextView)findViewById(R.id.editText2a);
	       final CheckBox checkbox1a = (CheckBox)findViewById(R.id.checkBox1a);
	       
	       final TextView textView2gi =(TextView)findViewById(R.id.textView2gi);
	       checkbox1u16.setOnCheckedChangeListener(new OnCheckedChangeListener()
           {
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                   if ( !isChecked )
                   {
                   	orphan=0;
                   }
                   else
                   {
                   	orphan=1;
                   	
                   }

               }
           });
	       checkbox2u16.setOnCheckedChangeListener(new OnCheckedChangeListener()
           {
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                   if ( !isChecked )
                   {
                   	ovc=0;
                   }
                   else
                   {
                   	ovc=1;
                   	
                   }

               }
           });
	       
	       //final TextView textView6 = (TextView)findViewById(R.id.textView6);
	       //set general information data
	       checkbox1gi.setOnCheckedChangeListener(new OnCheckedChangeListener()
           {
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                   if ( !isChecked )
                   {
                   	bc=0;
                   }
                   else
                   {
                   	bc=1;
                   	
                   }

               }
           });
	       
	       checkbox2gi.setOnCheckedChangeListener(new OnCheckedChangeListener()
           {
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                   if ( !isChecked )
                   {
                   	bednet=0;
                   	textView7.setVisibility(View.GONE);
                   	spinnerHowOften.setVisibility(View.GONE);
                   }
                   else
                   {
                   	bednet=1;
                   	textView7.setVisibility(View.VISIBLE);
                   	spinnerHowOften.setVisibility(View.VISIBLE);
                   }

               }
           });
	       
	       checkbox3gi.setOnCheckedChangeListener(new OnCheckedChangeListener()
           {
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                   if ( !isChecked )
                   {
                   	knowhivstatus=0;
                   }
                   else
                   {
                    knowhivstatus=1;
                   	
                   }

               }
           });
	       
	       checkbox4gi.setOnCheckedChangeListener(new OnCheckedChangeListener()
           {
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                   if ( !isChecked )
                   {
                   	chronic=0;
                   }
                   else
                   {
                   	chronic=1;
                   	
                   }

               }
           });
	       checkbox5gi.setOnCheckedChangeListener(new OnCheckedChangeListener()
           {
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
               {
                   if ( !isChecked )
                   {
                   	disability=0;
                   }
                   else
                   {
                   	disability=1;
                   	
                   }

               }
           });
            pb.setProgress(progress);
            //conditional data handling
           
            CheckBox flagged = (CheckBox)findViewById(R.id.checkBox1a);
            flagged.setOnCheckedChangeListener(new OnCheckedChangeListener()
            {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
                {
                    if ( !isChecked )
                    {
                    	editText2a.setVisibility(View.GONE);
                    	personflagged=0;
                    }
                    else
                    {
                    	editText2a.setVisibility(View.VISIBLE);
                    	personflagged=1;
                    	
                    }

                }
            });
	        //set person's name to - select person's name where village=current and householdnumber=current and PID =1
				      //get householdnumber, village - read from database of current.
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
				         
				         Individuals emp = new Individuals(householdnumber, village, PID);
				     
				         
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
						         
						         final int age4 = age3-age2;
						        					         
	   //y = getCount select individuals where village=current and householdnumber = current
						        int numberofmembers = dbHelper.getMembersCount(emp);
						         y=numberofmembers-1;
						         TextView textView5 = (TextView)findViewById(R.id.textView5);
						         textView5.setText(String.valueOf(numberofmembers));
        //x = 1
						         
						         final TextView textView4 = (TextView)findViewById(R.id.textView4);
						         textView4.setText(String.valueOf(x));				         
	        //determine which layouts to show from (current year - dob[3]) & sex
						         
	   
						         List<String> sex = dbHelper.SelectSex(emp);
									StringBuilder sb5 = new StringBuilder();
							         for (String Sex : sex) {
							           sb5.append(Sex);
							        }
							         String sex2 = sb5.toString();
							         
				Button button2 = (Button)findViewById(R.id.button2);
				Button button2u5 = (Button)findViewById(R.id.button2u5);
				Button button2u16 = (Button)findViewById(R.id.button2u16);
				Button over16button2 = (Button)findViewById(R.id.over16button2);
				Button button4mi = (Button)findViewById(R.id.button4mi);
				Button buttonai = (Button)findViewById(R.id.button2ai);
			
				final Button next = (Button)findViewById(R.id.nextpersonorhousehold);
		
				final LinearLayout generalinfo  = (LinearLayout)findViewById(R.id.generalinfo); 
				final LinearLayout under5  = (LinearLayout)findViewById(R.id.under5);
				final LinearLayout under16  = (LinearLayout)findViewById(R.id.under16);
				final LinearLayout over16  = (LinearLayout)findViewById(R.id.over16);
				final LinearLayout maternalinfo  = (LinearLayout)findViewById(R.id.maternalinfo);
				final LinearLayout additional  = (LinearLayout)findViewById(R.id.additional);
				
				if(sex2.equals("Male"))
				{
					if(age4<5){
						prof=1;
						profile="under5";
						prog =4;
					}
					else{
						if(age4<16)
						{
							profile ="under16over5male";
							prof =2;
							prog=3;	
						}
						else
						{
							profile = "maleover16";
							prof =3;
							prog=3;
						}
					}
				}
				else
					//sex2=="Female"
				{
					if(age4<5)
					{
						prof=1;
						profile="under5";
						prog =4;
					}
					else
					{
						if(age4<12)
						{
							profile ="under16over5male";
							prof =2;
							prog=3;	
						}
						else
						{
							if(age4<16)
							{
								profile ="under16over12female";
								prof =4;
								prog=4;
							}
							
							else
							{
								if(age4<45)
								{
									profile = "birther";
									prof =6;
									prog=4;
								}
								else
								{
									//nonbirther
									profile = "nonbirther"; 
									prof =7;
									prog =3;
								}
							}
						}
					}
				}
				
			
				button2.setOnClickListener(new View.OnClickListener() {
							public void onClick(View v) {
							// TODO Auto-generated method stub
								if(PID>1){
								relationtohead = spinner1gi.getSelectedItem().toString();
								}
								if(bednet==1)
								{
								howoften = spinnerHowOften.getSelectedItem().toString();
								}
								else
								{
								howoften ="";
								}
								generalinfo.setVisibility(View.GONE);
								//send data to database
								Individualsgen gen = new Individualsgen(householdnumber, village, PID, relationtohead, bc, bednet, howoften, knowhivstatus, chronic, disability);
								dbHelper.UpdateIndGen(gen);
								//
								spinner1gi.setVisibility(View.VISIBLE);
								textView2gi.setVisibility(View.VISIBLE);
								if(prof==1){
									pb.setProgress(25);
									under5.setVisibility(View.VISIBLE);
								}
								else if(prof==2){
									pb.setProgress(33);
									under16.setVisibility(View.VISIBLE);
								}else if(prof==3){
									pb.setProgress(25);
									over16.setVisibility(View.VISIBLE);
								}else if(prof==4){
									pb.setProgress(33);
									under16.setVisibility(View.VISIBLE);
								}else if(prof==5){
									pb.setProgress(25);
									under16.setVisibility(View.VISIBLE);
								}else if(prof==6){
									pb.setProgress(25);
									over16.setVisibility(View.VISIBLE);
								}else if(prof==7){
									pb.setProgress(33);
									over16.setVisibility(View.VISIBLE);
								}
								
								
						}
					});
				button2u5.setOnClickListener(new View.OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						String malnutrition = spinner1u5.getSelectedItem().toString();
						
						Individualsu5 u5 = new Individualsu5(householdnumber, village, PID, cliniccard, penta1given, mDateDisplay.getText().toString(), penta3given, mDateDisplay1.getText().toString(), measlesgiven, mDateDisplay2.getText().toString(), fullyimmunized, vitamina, mDateDisplay3.getText().toString(), deworm, mDateDisplay4.getText().toString(), malnutrition);
						dbHelper.UpdateIndu5(u5);
						
						under5.setVisibility(View.GONE);
						pb.setProgress(50);
						under16.setVisibility(View.VISIBLE);
												
					}
				});
				button2u16.setOnClickListener(new View.OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Individualsu16 u16 = new Individualsu16(householdnumber, village, PID, orphan, ovc);
						dbHelper.UpdateIndu16(u16);
						under16.setVisibility(View.GONE);
						
						if(prof==2){
							pb.setProgress(66);
							additional.setVisibility(View.VISIBLE);
						}else if(prof==4){
							pb.setProgress(50);
							maternalinfo.setVisibility(View.VISIBLE);
						}else //if(prof==1)
							{
							pb.setProgress(75);
							additional.setVisibility(View.VISIBLE);
						}
												
					}
				});
				over16button2.setOnClickListener(new View.OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						String phonenumber = over16editText1.getText().toString();
						Individualso16 o16 = new Individualso16(householdnumber, village, PID, phonenumber);
						dbHelper.UpdateIndo16(o16);
						
						over16.setVisibility(View.GONE);
						
						if(prof==3){
							pb.setProgress(66);
							additional.setVisibility(View.VISIBLE);
						}else if(prof==6){
							pb.setProgress(50);
							maternalinfo.setVisibility(View.VISIBLE);
						}else //if(prof==7)
							{
							pb.setProgress(66);
							additional.setVisibility(View.VISIBLE);
						}
												
					}
				});
			button4mi.setOnClickListener(new View.OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						String lastperioddate = pDisplay2.getText().toString();
						String outcome = spinner1.getSelectedItem().toString();
						String whenbbd=spinner3.getSelectedItem().toString();
						String anc = spinnerANC.getSelectedItem().toString();
						String anc2 = spinnerANC2.getSelectedItem().toString();
						String wheredeliver=spinner2.getSelectedItem().toString();
						
						Individualsmi mi = new Individualsmi(householdnumber, village, PID, currentlypregnant, lastperioddate, birthinlast12, outcome, whenbbd, anc, anc2, wheredeliver);
						dbHelper.UpdateIndmi(mi);
						
						maternalinfo.setVisibility(View.GONE);
						additional.setVisibility(View.VISIBLE);
						
						
							pb.setProgress(75);
							
						
												
					}
				});			         
	        	
			buttonai.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Individualsai ai = new Individualsai(householdnumber, village, PID, personflagged, editText1a.getText().toString(), editText2a.getText().toString());
					dbHelper.UpdateIndai(ai);
					
					additional.setVisibility(View.GONE);
					
					pb.setProgress(100);
					next.setText("Done! Continue");
					next.setVisibility(View.VISIBLE);	
					spinner1gi.setSelection(0);
					checkbox1gi.setChecked(false);
					checkbox2gi.setChecked(false);
					checkbox3gi.setChecked(false);
					checkbox4gi.setChecked(false);
					checkbox5gi.setChecked(false);
					over16editText1.setText("");
					checkbox1u16.setChecked(false);
					checkbox2u16.setChecked(false);
					checkbox1a.setChecked(false);
					editText1a.setText("");
					editText2a.setText("");
					cliniccardcb.setChecked(false);
					mPickDate.setChecked(false);
					mPickDate2.setChecked(false);
					mPickDate3.setChecked(false);
					fullyimmunizedcb.setChecked(false);
					spinner1u5.setSelection(0);
					pDate.setChecked(false);
					givenbirth.setChecked(false);
					spinner1.setSelection(0);
					spinnerHowOften.setSelection(0);
					spinner2.setSelection(0);
					spinner3.setSelection(0);
					spinnerANC.setSelection(0);
					spinnerANC2.setSelection(0);
					mPickDate4.setChecked(false);
					mPickDate5.setChecked(false);
				}
			});
			
							         
			
	        //when progress bar is 100% - while there is another person show screen for person, else show done button
				next.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					
					if(y==0)
					{
					// TODO Auto-generated method stub
					Intent pancakes = new Intent(v.getContext(), householdinfo.class);
					v.getContext().startActivity(pancakes);	
					}
					else
					{
						next.setVisibility(View.GONE);
						pb.setProgress(0);
						x = x + 1;
						PID = PID + 1;
						Individuals emp = new Individuals(householdnumber, village, PID);
					     
				         
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
						         
						         final int age4 = age3-age2;
						        					         
	   			         
	        //determine which layouts to show from (current year - dob[3]) & sex
						         
	   
						         List<String> sex = dbHelper.SelectSex(emp);
									StringBuilder sb5 = new StringBuilder();
							         for (String Sex : sex) {
							           sb5.append(Sex);
							        }
							         String sex2 = sb5.toString();
							         
				
				
				if(sex2.equals("Male"))
				{
					if(age4<5){
						prof=1;
						profile="under5";
						prog =4;
					}
					else{
						if(age4<16)
						{
							profile ="under16over5male";
							prof =2;
							prog=3;	
						}
						else
						{
							profile = "maleover16";
							prof =3;
							prog=3;
						}
					}
				}
				else
					//sex2=="Female"
				{
					if(age4<5)
					{
						prof=1;
						profile="under5";
						prog =4;
					}
					else
					{
						if(age4<12)
						{
							profile ="under16over5male";
							prof =2;
							prog=3;	
						}
						else
						{
							if(age4<16)
							{
								profile ="under16over12female";
								prof =4;
								prog=4;
							}
							
							else
							{
								if(age4<45)
								{
									profile = "birther";
									prof =6;
									prog=4;
								}
								else
								{
									//nonbirther
									profile = "nonbirther"; 
									prof =7;
									prog =3;
								}
							}
						}
					}
				}
						textView4.setText(String.valueOf(x));
						generalinfo.setVisibility(View.VISIBLE);
						y = y-1;
					}
					
					}
				
			});
				
				cliniccardcb = ( CheckBox ) findViewById( R.id.checkBox1u5 );
		        cliniccardcb.setOnCheckedChangeListener(new OnCheckedChangeListener()
		        {
		            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		            {
		                if ( isChecked )
		                {
		                	cliniccard=1;
		                }
		                if (!isChecked)
		                {
		                // do nothing
		                	cliniccard=0;
		                }

		            }
		        });
		        fullyimmunizedcb = ( CheckBox ) findViewById( R.id.checkBox5u5 );
		        fullyimmunizedcb.setOnCheckedChangeListener(new OnCheckedChangeListener()
		        {
		            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		            {
		                if ( isChecked )
		                {
		                	fullyimmunized=1;
		                }
		                if (!isChecked)
		                {
		                // do nothing
		                	fullyimmunized=0;
		                }

		            }
		        });
		        
		        
		   
		        
				/*  capture our View elements for penta1  vitamina and deworming */
		        mDateDisplay = (TextView) findViewById(R.id.dateDisplayu5);
		        mDateDisplay3 = (TextView) findViewById(R.id.dateVitamina);
		        mDateDisplay4 = (TextView) findViewById(R.id.dateDeworming);
		        mPickDate = ( CheckBox ) findViewById( R.id.checkBox2u5 );
		        mPickDate4 = ( CheckBox ) findViewById( R.id.checkBox6u5 );
		        mPickDate5 = ( CheckBox ) findViewById( R.id.checkDeworming );
		        /* get the current date */
		        penta1 = Calendar.getInstance();
		        /* add a click listener to checkbox */
		        mPickDate.setOnCheckedChangeListener(new OnCheckedChangeListener()
		        {
		            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		            {
		                if ( isChecked )
		                {
		                	showDateDialog(mDateDisplay, penta1);
		                	mDateDisplay.setVisibility(View.VISIBLE);
		                	penta1given=1;
		                }
		                if (!isChecked)
		                {
		                // do nothing
		                	mDateDisplay.setVisibility(View.GONE);
		                	penta1given=0;
		                }

		            }
		        });
		        
		        //
		        vitaminac = Calendar.getInstance();
		        mPickDate4.setOnCheckedChangeListener(new OnCheckedChangeListener()
		        {
		            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		            {
		                if ( isChecked )
		                {
		                	showDateDialog(mDateDisplay3, vitaminac);
		                	mDateDisplay3.setVisibility(View.VISIBLE);
		                	vitamina=1;
		                }
		                if (!isChecked)
		                {
		                // do nothing
		                	mDateDisplay3.setVisibility(View.GONE);
		                	vitamina=0;
		                }

		            }
		        });
		        deworming=Calendar.getInstance();
		        mPickDate5.setOnCheckedChangeListener(new OnCheckedChangeListener()
		        {
		            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		            {
		                if ( isChecked )
		                {
		                	showDateDialog(mDateDisplay4, deworming);
		                	mDateDisplay4.setVisibility(View.VISIBLE);
		                	deworm=1;
		                }
		                if (!isChecked)
		                {
		                // do nothing
		                	mDateDisplay4.setVisibility(View.GONE);
		                	deworm=0;
		                }

		            }
		        });
		        
		        
		        
		        bPickDate2 = (Button) findViewById(R.id.button2m);
		        pDisplay2 = (TextView) findViewById(R.id.editText1m);
		        lastP = Calendar.getInstance();
		        pDate = ( CheckBox ) findViewById( R.id.checkBox1m );
		       pDate.setOnCheckedChangeListener(new OnCheckedChangeListener()
		        {
		            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		            {
		                if ( isChecked )
		                {
		                	
		                	bPickDate2.setVisibility(View.VISIBLE);
		                	textView8.setVisibility(View.VISIBLE);
		                	spinnerANC2.setVisibility(View.VISIBLE);
		                	pDisplay2.setVisibility(View.VISIBLE);
		                	currentlypregnant=1;
		                	
		                }
		                if (!isChecked)
		                {
		                // do nothing
		                	bPickDate2.setVisibility(View.GONE);
		                	pDisplay2.setVisibility(View.GONE);
		                	textView8.setVisibility(View.GONE);
		                	spinnerANC2.setVisibility(View.GONE);
		                	currentlypregnant=0;
		                }

		            }
		        });
		       bPickDate2.setOnClickListener(new View.OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						showDateDialog(pDisplay2, lastP);	
						
					}
				});
		       
		      //have you given birth section
		        spinner1 = (Spinner) findViewById(R.id.spinner1m);
		        editText2 = (TextView) findViewById(R.id.textView5m);
		        
		        spinnerANC=(Spinner)findViewById(R.id.spinnerANC);
		        textView6 = (TextView) findViewById(R.id.textView6);
		        textView3 = (TextView) findViewById(R.id.textView3m);
		        textView2 = (TextView) findViewById(R.id.textView2m);
		        spinner2 = (Spinner) findViewById(R.id.spinner2m);
		        spinner3 = (Spinner) findViewById(R.id.spinner3m);
		        givenbirth = ( CheckBox ) findViewById( R.id.checkBox2m );
		        
		    
								
				


spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { 
        // Your code here
    	if(spinner1.getSelectedItem().toString().equals("Baby Died")){
			editText2.setVisibility(View.VISIBLE);
			spinner3.setVisibility(View.VISIBLE);
			spinner2.setVisibility(View.GONE);
			textView3.setVisibility(View.GONE);
    	}
    	if(spinner1.getSelectedItem().toString().equals("Miscarriage")){
			
			spinner2.setVisibility(View.GONE);
			textView3.setVisibility(View.GONE);
			editText2.setVisibility(View.GONE);
			spinner3.setVisibility(View.GONE);
    	}
    	if(spinner1.getSelectedItem().toString().equals("Baby Survived")){
			
    		editText2.setVisibility(View.GONE);
			spinner3.setVisibility(View.GONE);
			spinner2.setVisibility(View.VISIBLE);
			textView3.setVisibility(View.VISIBLE);
    	}
    } 

    public void onNothingSelected(AdapterView<?> adapterView) {
        return;
    } 
}); 
		        givenbirth.setOnCheckedChangeListener(new OnCheckedChangeListener()
		        {
		            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		            {
		                if ( isChecked )
		                {
		                	
		                	//editText2.setVisibility(View.VISIBLE);
		                	
		                	spinnerANC.setVisibility(View.VISIBLE);
		                	textView6.setVisibility(View.VISIBLE);
		                	spinner2.setVisibility(View.VISIBLE);
		                	//spinner3.setVisibility(View.VISIBLE);
		                	spinner1.setVisibility(View.VISIBLE);
		                	textView2.setVisibility(View.VISIBLE);
		                	textView3.setVisibility(View.VISIBLE);
		                	birthinlast12=1;
		                }
		                if (!isChecked)
		                {
		                // do nothing
		                	textView2.setVisibility(View.GONE);
		                	textView3.setVisibility(View.GONE);
		                	editText2.setVisibility(View.GONE);
		                	spinnerANC.setVisibility(View.GONE);
		                	textView6.setVisibility(View.GONE);
		                	spinner2.setVisibility(View.GONE);
		                	spinner1.setVisibility(View.GONE);
		                	spinner3.setVisibility(View.GONE);
		                	birthinlast12=0;
		                }

		            }
		        });
		        /*capture our view elements for penta3*/
		        mDateDisplay1 = (TextView) findViewById(R.id.dateDisplay1u5);
		        mPickDate2 = ( CheckBox ) findViewById( R.id.checkBox3u5 );
		        /* get the current date */
		        penta3 = Calendar.getInstance();
		        /* add a click listener to check box */
		        mPickDate2.setOnCheckedChangeListener(new OnCheckedChangeListener()
		        {
		            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		            {
		                if ( isChecked )
		                {
		                	showDateDialog(mDateDisplay1, penta3);
		                	mDateDisplay1.setVisibility(View.VISIBLE);
		                	penta3given=1;
		                }
		                if (!isChecked)
		                {
		                // do nothing
		                	mDateDisplay1.setVisibility(View.GONE);
		                	penta3given=0;
		                }

		            }
		        });
		        
		        /*capture our view elements for measles*/
		        mDateDisplay2 = (TextView) findViewById(R.id.editText3u5);
		        mPickDate3 = ( CheckBox ) findViewById( R.id.checkBox4u5 );
		        /* get the current date */
		        measles = Calendar.getInstance();
		        /* add a click listener to check box */
		        mPickDate3.setOnCheckedChangeListener(new OnCheckedChangeListener()
		        {
		            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		            {
		                if ( isChecked )
		                {
		                	showDateDialog(mDateDisplay2, measles);
		                	mDateDisplay2.setVisibility(View.VISIBLE);
		                	measlesgiven=1;
		                	
		                }
		                if (!isChecked)
		                {
		                // do nothing
		                	mDateDisplay2.setVisibility(View.GONE);
		                	measlesgiven=0;
		                }

		            }
		        });
		        
		        /* display the current date (this method is below)  */
		        updateDisplay(mDateDisplay, penta1);
		        updateDisplay(mDateDisplay1, penta3);
		        updateDisplay(mDateDisplay2, measles);
		        updateDisplay(pDisplay2, lastP);
		        updateDisplay(mDateDisplay3,vitaminac);
		        updateDisplay(mDateDisplay4,deworming);
		        
		}
		        private void updateDisplay(TextView dateDisplay, Calendar date) {
		            dateDisplay.setText(
		                    new StringBuilder()
		                        // Month is 0 based so add 1
		                        .append(date.get(Calendar.MONTH) + 1).append("-")
		                        .append(date.get(Calendar.DAY_OF_MONTH)).append("-")
		                        .append(date.get(Calendar.YEAR)).append(" "));

		        }

		        public void showDateDialog(TextView dateDisplay, Calendar date) {
		            activeDateDisplay = dateDisplay;
		            activeDate = date;
		            showDialog(DATE_DIALOG_ID);
		        }

		        private OnDateSetListener dateSetListener = new OnDateSetListener() {
		            
		            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
		                activeDate.set(Calendar.YEAR, year);
		                activeDate.set(Calendar.MONTH, monthOfYear);
		                activeDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		                updateDisplay(activeDateDisplay, activeDate);
		                unregisterDateDisplay();
		            }
		        };

		        private void unregisterDateDisplay() {
		            activeDateDisplay = null;
		            activeDate = null;
		        }

		        @Override
		        protected Dialog onCreateDialog(int id) {
		            switch (id) {
		                case DATE_DIALOG_ID:
		                    return new DatePickerDialog(this, dateSetListener, activeDate.get(Calendar.YEAR), activeDate.get(Calendar.MONTH), activeDate.get(Calendar.DAY_OF_MONTH));
		            }
		            return null;
		        }

		        @Override
		        protected void onPrepareDialog(int id, Dialog dialog) {
		            super.onPrepareDialog(id, dialog);
		            switch (id) {
		                case DATE_DIALOG_ID:
		                    ((DatePickerDialog) dialog).updateDate(activeDate.get(Calendar.YEAR), activeDate.get(Calendar.MONTH), activeDate.get(Calendar.DAY_OF_MONTH));
		                    break;
		            }
		        }
		        

				}
		
	