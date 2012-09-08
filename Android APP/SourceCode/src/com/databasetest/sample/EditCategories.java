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



		public class EditCategories extends Activity{
		private int mYear;
		private int mMonth;
		private int mDay;
		private DatabaseHelper dbHelper;
		TextView textView2gi;
		Spinner spinnerANC;
		TextView textView8;
		
		Spinner spinnerANC2;
		int progress = 0;
		int prog=0;
		String profile;
		int prof;
		//int y;
		//int x =1;
		int PID;
		private TextView mDateDisplay;
		private TextView mDateDisplay1;
		private TextView mDateDisplay2;
		private TextView mDateDisplay3;
		private TextView mDateDisplay4;
		private TextView pDisplay2;
		private Calendar penta1;
		private Calendar penta3;
		private Calendar measles;
		private Calendar lastP;
		private Calendar vitaminac;
		private Calendar deworming;
		private TextView textView2;
		private TextView textView3;
		private TextView editText2;

		private TextView editText3z;
		private TextView textView6;
		private TextView textView5m;
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
		Button button3;
		Button button4;
		Button button5;
		TextView editText1;
		TextView editText3p;
		TextView editvad;
		TextView editdewormd;
		String rel;
		String whenbbd;
		String pnc;
		String pnc2;
		String prdd;
		String outcome;
		String wheredeliver;
		String howoften1;
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
	        
	        Bundle extras = getIntent().getExtras();
	        final String village = extras.getString("village");
	        final int householdnumber1 = extras.getInt("householdnumber");
	        final int PID = extras.getInt("PID");
	        
	        textView8=(TextView)findViewById(R.id.textView8);
	    	spinnerANC2=(Spinner)findViewById(R.id.spinnerANC2);
	    	spinnerANC=(Spinner)findViewById(R.id.spinnerANC);
	        
	        final String householdnumber = String.valueOf(householdnumber1);
			textView7=(TextView)findViewById(R.id.textView7);
			spinnerHowOften=(Spinner)findViewById(R.id.spinnerHowOften);
			LinearLayout linearLayout1 =(LinearLayout)findViewById(R.id.linearLayout1);
			linearLayout1.setVisibility(View.GONE);
	       
	         final ProgressBar pb = (ProgressBar)findViewById(R.id.progressBar1);
		       final CheckBox checkbox1gi = (CheckBox)findViewById(R.id.checkBox1gi); 
		       final CheckBox checkbox2gi = (CheckBox)findViewById(R.id.checkBox2gi); 
		       final CheckBox checkbox3gi = (CheckBox)findViewById(R.id.checkBox3gi); 
		       final CheckBox checkbox4gi = (CheckBox)findViewById(R.id.checkBox4gi); 
		       final CheckBox checkbox5gi = (CheckBox)findViewById(R.id.checkBox5gi); 
		      final Spinner spinner1gi = (Spinner)findViewById(R.id.spinner2gi); 
		      final Spinner spinner1u5 = (Spinner)findViewById(R.id.spinner1u5);
		       final TextView over16editText1 = (TextView)findViewById(R.id.over16editText1);
		       
		       final CheckBox checkbox1u16 = (CheckBox)findViewById(R.id.checkBox1u16);
		       final CheckBox checkbox2u16 = (CheckBox)findViewById(R.id.checkBox2u16);
		       
		       final TextView editText1a =(TextView)findViewById(R.id.editText1a);
		       final TextView editText2a =(TextView)findViewById(R.id.editText2a);
		       final CheckBox checkbox1a = (CheckBox)findViewById(R.id.checkBox1a);
		    
		       textView2gi =(TextView)findViewById(R.id.textView2gi);
		       textView2gi.setVisibility(View.VISIBLE);
		       spinner1gi.setVisibility(View.VISIBLE);
		       mPickDate = ( CheckBox ) findViewById( R.id.checkBox2u5 );
		       cliniccardcb = ( CheckBox ) findViewById( R.id.checkBox1u5 );
		       mPickDate2 = ( CheckBox ) findViewById( R.id.checkBox3u5 );
		       fullyimmunizedcb = ( CheckBox ) findViewById( R.id.checkBox5u5 );
		       
		       editText2 = (TextView) findViewById(R.id.editText2);
		       editText3p = (TextView) findViewById(R.id.editText3p);
		       spinner1 = (Spinner) findViewById(R.id.spinner1m);
		       textView5m = (TextView) findViewById(R.id.textView5m);
		     
		        textView6 = (TextView) findViewById(R.id.textView6);
		        textView3 = (TextView) findViewById(R.id.textView3m);
		        textView2 = (TextView) findViewById(R.id.textView2m);
		        spinner2 = (Spinner) findViewById(R.id.spinner2m);
		        spinner3 = (Spinner) findViewById(R.id.spinner3m);
		        givenbirth = ( CheckBox ) findViewById( R.id.checkBox2m );
		        mDateDisplay = (TextView) findViewById(R.id.dateDisplayu5);
		        mDateDisplay1 = (TextView) findViewById(R.id.dateDisplay1u5);
		        mDateDisplay3 = (TextView) findViewById(R.id.dateVitamina);
		        mDateDisplay4 = (TextView) findViewById(R.id.dateDeworming);
		        editvad = (TextView) findViewById(R.id.editVitaminadate);
		        editdewormd = (TextView) findViewById(R.id.editDewormingdate);
		       editText1 = (TextView)findViewById(R.id.editText1);
		       button3 =(Button)findViewById(R.id.button3);
		       button4 =(Button)findViewById(R.id.button4);
		       pDate = ( CheckBox ) findViewById( R.id.checkBox1m );
		       bPickDate2 = (Button) findViewById(R.id.button2m);
		        pDisplay2 = (TextView) findViewById(R.id.editText1m);
		        
		        button5 =(Button)findViewById(R.id.button5);
		        editText3z=(TextView)findViewById(R.id.editText3z);
		        mDateDisplay2 = (TextView) findViewById(R.id.editText3u5);
		        mPickDate3 = ( CheckBox ) findViewById( R.id.checkBox4u5 );
		        mPickDate4 = ( CheckBox ) findViewById( R.id.checkBox6u5 );
		        mPickDate5 = ( CheckBox ) findViewById( R.id.checkDeworming );
		      //have you given birth section
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
		                	
		                	//textView5m.setVisibility(View.VISIBLE);
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
		                	spinnerANC.setVisibility(View.GONE);
		                	textView2.setVisibility(View.GONE);
		                	textView3.setVisibility(View.GONE);
		                	textView5m.setVisibility(View.GONE);
		               
		                	textView6.setVisibility(View.GONE);
		                	spinner2.setVisibility(View.GONE);
		                	spinner1.setVisibility(View.GONE);
		                	spinner3.setVisibility(View.GONE);
		                	birthinlast12=0;
		                }

		            }
		        });
		        //
		        final Button button1=(Button)findViewById(R.id.button1);
		        
		        vitaminac = Calendar.getInstance();
		        mPickDate4.setOnCheckedChangeListener(new OnCheckedChangeListener()
		        {
		            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		            {
		                if ( isChecked )
		                {
		                	button1.setVisibility(View.VISIBLE);
		                	mDateDisplay3.setVisibility(View.GONE);
		                	editvad.setVisibility(View.VISIBLE);
		                	vitamina=1;
		                }
		                if (!isChecked)
		                {
		                // do nothing
		                	button1.setVisibility(View.GONE);
		                	mDateDisplay3.setVisibility(View.GONE);
		                	editvad.setVisibility(View.GONE);
		                	vitamina=0;
		                }

		            }
		        });
		        //
		        final Button button6=(Button)findViewById(R.id.button6);
		       
		        deworming=Calendar.getInstance();
		        mPickDate5.setOnCheckedChangeListener(new OnCheckedChangeListener()
		        {
		            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		            {
		                if ( isChecked )
		                {
		                	button6.setVisibility(View.VISIBLE);
		                	mDateDisplay4.setVisibility(View.GONE);
		                	editdewormd.setVisibility(View.VISIBLE);
		                	deworm=1;
		                }
		                if (!isChecked)
		                {
		                // do nothing
		                	button6.setVisibility(View.GONE);
		                	mDateDisplay4.setVisibility(View.GONE);
		                	editdewormd.setVisibility(View.GONE);
		                	deworm=0;
		                }

		            }
		        });
		        
		        
		        mPickDate3.setOnCheckedChangeListener(new OnCheckedChangeListener()
		        {
		            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		            {
		                if ( isChecked )
		                {
		                		                	
		                	button5.setVisibility(View.VISIBLE);
				        	editText3z.setVisibility(View.VISIBLE);
				                	
		                	mDateDisplay2.setVisibility(View.GONE);
		                	measlesgiven=1;
		                	
		                }
		                if (!isChecked)
		                {
		                // do nothing
		                	button5.setVisibility(View.GONE);
				        	editText3z.setVisibility(View.GONE);
		                	mDateDisplay2.setVisibility(View.GONE);
		                	measlesgiven=0;
		                }

		            }
		        });
		        
		       pDate.setOnCheckedChangeListener(new OnCheckedChangeListener()
		        {
		            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		            {
		                if ( isChecked )
		                {
		                	textView8.setVisibility(View.VISIBLE);
		                	spinnerANC2.setVisibility(View.VISIBLE);
		                	bPickDate2.setVisibility(View.VISIBLE);
		                	editText3p.setVisibility(View.VISIBLE);
		                	currentlypregnant=1;
		                	
		                }
		                if (!isChecked)
		                {
		                // do nothing
		                	textView8.setVisibility(View.GONE);
		                	spinnerANC2.setVisibility(View.GONE);
		                	bPickDate2.setVisibility(View.GONE);
		                	editText3p.setVisibility(View.GONE);
		                	pDisplay2.setVisibility(View.GONE);
		                	currentlypregnant=0;
		                }

		            }
		        });
		       mPickDate.setOnCheckedChangeListener(new OnCheckedChangeListener()
		        {
		            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		            {
		                if ( isChecked )
		                {
		                	
		                	button3.setVisibility(View.VISIBLE);
				        	editText1.setVisibility(View.VISIBLE);
				        	mDateDisplay.setVisibility(View.GONE);
				        	penta1given=1;
		                	
		                }
		                if (!isChecked)
		                {
		                // do nothing
		                	button3.setVisibility(View.GONE);
				        	editText1.setVisibility(View.GONE);
		                	mDateDisplay.setVisibility(View.GONE);
		                	penta1given=0;
		                }

		            }
		        });
		       mPickDate2.setOnCheckedChangeListener(new OnCheckedChangeListener()
		        {
		            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		            {
		                if ( isChecked )
		                {
		                	
		                	button4.setVisibility(View.VISIBLE);
				        	editText2.setVisibility(View.VISIBLE);
				        	mDateDisplay1.setVisibility(View.GONE);
				        	penta3given=1;
		                }
		                if (!isChecked)
		                {
		                // do nothing
		                	button4.setVisibility(View.GONE);
				        	editText2.setVisibility(View.GONE);
				        	mDateDisplay1.setVisibility(View.GONE);
				        	penta3given=0;
		                }

		            }
		        });   
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
							
					         
					         Individuals emp = new Individuals(householdnumber, village, PID);
		       //set outcome
					         List<String> outcome0 = dbHelper.SelectOutcome(emp);
								StringBuilder ou1 = new StringBuilder();
						         for (String ou2 : outcome0) {
						           ou1.append(ou2);
						        }
						        if(ou1.toString().equals("Miscarriage")){
						        	spinner1.setSelection(1);
						        }else if(ou1.toString().equals("Baby Died")){
						        	spinner1.setSelection(0);
						        }else if(ou1.toString().equals("Baby Survived")){
						        	spinner1.setSelection(2);
						        }   
						       
						      //get anc
							      
						         List<String> anc0 = dbHelper.SelectANC(emp);
									StringBuilder anc1 = new StringBuilder();
							         for (String anc2 : anc0) {
							           anc1.append(anc2);
							        }
							         
		   if(anc1.toString().equals("1")){
	        	spinnerANC.setSelection(0);
	        }else if(anc1.toString().equals("2")){
	        	spinnerANC.setSelection(1);
	        }else if(anc1.toString().equals("3")){
	        	spinnerANC.setSelection(2);
	        }else if(anc1.toString().equals("4")){
	        	spinnerANC.setSelection(3);
	        }else{
	        	spinnerANC.setSelection(4);
	        }
		 //get anc2
		      
	         List<String> anc20 = dbHelper.SelectANC2(emp);
				StringBuilder anc21 = new StringBuilder();
		         for (String anc22 : anc20) {
		           anc21.append(anc22);
		        }
		         
if(anc21.toString().equals("1")){
spinnerANC2.setSelection(0);
}else if(anc21.toString().equals("2")){
spinnerANC2.setSelection(1);
}else if(anc21.toString().equals("3")){
spinnerANC2.setSelection(2);
}else if(anc21.toString().equals("4")){
spinnerANC2.setSelection(3);
}else{
spinnerANC2.setSelection(4);
}
	      //set wheredeliver
	         List<String> wheredeliver0 = dbHelper.SelectWheredeliver(emp);
				StringBuilder wd1 = new StringBuilder();
		         for (String wd2 : wheredeliver0) {
		           wd1.append(wd2);
		        }
		        if(wd1.toString().equals("At Home")){
		        	spinner2.setSelection(0);
		        }else if(wd1.toString().equals("At Health Facility")){
		        	spinner2.setSelection(1);
		        }else if(wd1.toString().equals("Other")){
		        	spinner2.setSelection(2);
		        }   
		        //set howoften
		         final List<String> howoften = dbHelper.SelectHowoften(emp);
					StringBuilder hf1 = new StringBuilder();
			         for (String hf2 : howoften) {
			           hf1.append(hf2);
			        }
			        if(hf1.toString().equals("Always")){
			        	spinnerHowOften.setSelection(0);
			        }else if(hf1.toString().equals("Very often")){
			        	spinnerHowOften.setSelection(1);
			        }else if(hf1.toString().equals("Not often")){
			        	spinnerHowOften.setSelection(2);
			        } 
			        else if(hf1.toString().equals("Once a while")){
			        	spinnerHowOften.setSelection(3);
			        }
			        else{
			        	spinnerHowOften.setSelection(0);
			        }
      //set babydied
         List<String> babydied0 = dbHelper.SelectBabydied(emp);
			StringBuilder bdd1 = new StringBuilder();
	         for (String bdd2 : babydied0) {
	           bdd1.append(bdd2);
	        }
	        if(bdd1.toString().equals("Before Delivery")){
	        	spinner3.setSelection(0);
	        }else if(bdd1.toString().equals("During Delivery")){
	        	spinner3.setSelection(1);
	        }else if(bdd1.toString().equals("Within two weeks after delivery")){
	        	spinner3.setSelection(2);
	        } else{
	        	spinner3.setSelection(3);
	        }
				//set relation
					         List<String> relation0 = dbHelper.SelectRelation(emp);
								StringBuilder r1 = new StringBuilder();
						         for (String r2 : relation0) {
						           r1.append(r2);
						        }
						        if(r1.toString().equals("Head of Household")){
						        	spinner1gi.setSelection(0);
						        }else if(r1.toString().equals("Spouse")){
						        	spinner1gi.setSelection(1);
						        }else if(r1.toString().equals("Child by Birth")){
						        	spinner1gi.setSelection(2);
						        }else if(r1.toString().equals("Child by Registration")){
						        	spinner1gi.setSelection(3);
						        }else{
						        	spinner1gi.setSelection(4);
						        }
				//get bc
						        List<String> birthcertificate0 = dbHelper.SelectBC(emp);
								StringBuilder bc1 = new StringBuilder();
						         for (String bc2 : birthcertificate0) {
						           bc1.append(bc2);
						        }
						         
						         if(bc1.toString().equals("1"))
						         {
						        	 checkbox1gi.setChecked(true);
						         }
						         else{
						        	 checkbox1gi.setChecked(false);
						         }
				//get bednet
						         List<String> bednet0 = dbHelper.SelectBednet(emp);
									StringBuilder bd1 = new StringBuilder();
							         for (String bd2 : bednet0) {
							           bd1.append(bd2);
							        }
							         
							         if(bd1.toString().equals("1"))
							         {
							        	 checkbox2gi.setChecked(true);
							         }
							         else{
							        	 checkbox2gi.setChecked(false);
							         }
				//get knowstate
							         List<String> knowhivstatus0 = dbHelper.SelectKnowhivstatus(emp);
										StringBuilder kh1 = new StringBuilder();
								         for (String kh2 : knowhivstatus0) {
								           kh1.append(kh2);
								        }
								         
								         if(kh1.toString().equals("1"))
								         {
								        	 checkbox3gi.setChecked(true);
								         }
								         else{
								        	 checkbox3gi.setChecked(false);
								         }
			       //get chronic
			         List<String> chronic0 = dbHelper.SelectChronic(emp);
						StringBuilder ch1 = new StringBuilder();
				         for (String ch2 : chronic0) {
				           ch1.append(ch2);
				        }
				         
				         if(ch1.toString().equals("1"))
				         {
				        	 checkbox4gi.setChecked(true);
				         }
				         else{
				        	 checkbox4gi.setChecked(false);
				         }
		       //get disability
		         List<String> disability0 = dbHelper.SelectDisability(emp);
					StringBuilder ds1 = new StringBuilder();
			         for (String ds2 : disability0) {
			           ds1.append(ds2);
			        }
			         
			         if(ds1.toString().equals("1"))
			         {
			        	 checkbox5gi.setChecked(true);
			         }
			         else{
			        	 checkbox5gi.setChecked(false);
			         }
			       //get currentlypregnant
			         List<String> currentlypregnant0 = dbHelper.SelectCurrentlypregnant(emp);
						StringBuilder cp1 = new StringBuilder();
				         for (String cp2 : currentlypregnant0) {
				           cp1.append(cp2);
				        }
				         
				         if(cp1.toString().equals("1"))
				         {
				        	 
				        	 pDate.setChecked(true);
				        	 editText3p.setVisibility(View.VISIBLE);
				        	 pDisplay2.setVisibility(View.GONE);
				        	 currentlypregnant=1;
				         }
				         else{
				        	
				        	 pDate.setChecked(false);
				        	 editText3p.setVisibility(View.GONE);
				        	 currentlypregnant=0;
				         }  
				       //get lastperiod
					      
				         List<String> lastperiod0 = dbHelper.SelectLastperiod(emp);
							StringBuilder lastperiod1 = new StringBuilder();
					         for (String lastperiod2 : lastperiod0) {
					           lastperiod1.append(lastperiod2);
					        }
					         
					         editText3p.setText(lastperiod1.toString());      
				       //get birthinlast12
				         List<String> binl120 = dbHelper.SelectBirthinlast12(emp);
							StringBuilder binl121 = new StringBuilder();
					         for (String binl122 : binl120) {
					        	 binl121.append(binl122);
					        }
					         
					         if(binl121.toString().equals("1"))
					         {
					        	 givenbirth.setChecked(true);
					         }
					         else{
					        	 givenbirth.setChecked(false);
					         }  	
	         		         
			   //get phone number
			      
			         List<String> phonenumber0 = dbHelper.SelectPhonenumber(emp);
						StringBuilder pn1 = new StringBuilder();
				         for (String pn2 : phonenumber0) {
				           pn1.append(pn2);
				        }
				         if(pn1.toString().equals("null"))
				         {
				        	 
				         }
				         else
				         {
				         over16editText1.setText(pn1.toString());
				         }
			   //get orphan
				         List<String> orphan0 = dbHelper.SelectOrphan(emp);
							StringBuilder orp1 = new StringBuilder();
					         for (String orp2 : orphan0) {
					           orp1.append(orp2);
					        }
					         if(orp1.toString().equals("1"))
					         {
					        	 checkbox1u16.setChecked(true);
					         }
					         else{
					        	 checkbox1u16.setChecked(false);
					         } 
		       //get ovc
		         List<String> ovc0a = dbHelper.SelectOVC(emp);
					StringBuilder ovco1 = new StringBuilder();
			         for (String ovc02 : ovc0a) {
			           ovco1.append(ovc02);
			        }
			         if(ovco1.toString().equals("1"))
			         {
			        	 checkbox2u16.setChecked(true);
			         }
			         else{
			        	 checkbox2u16.setChecked(false);
			         } 	         
	       //get remarks
	         List<String> remarks1 = dbHelper.SelectRemarks(emp);
				StringBuilder remarks2 = new StringBuilder();
		         for (String remarks3 : remarks1) {
		           remarks2.append(remarks3);
		        }
		         editText1a.setText(remarks2);	
		       
	       //get flagged reason
	         List<String> flr = dbHelper.SelectFlaggedreasons(emp);
				StringBuilder flr1 = new StringBuilder();
		         for (String flr2 : flr) {
		           flr1.append(flr2);
		        }
		         editText2a.setText(flr1);	
		       
         //get flagged
         List<String> flagged0a = dbHelper.SelectFlagged(emp);
			StringBuilder flagged0b = new StringBuilder();
	         for (String flagged0c : flagged0a) {
	           flagged0b.append(flagged0c);
	        }
	         if(flagged0b.toString().equals("1"))
	         {
	        	 checkbox1a.setChecked(true);
	         }
	         else{
	        	 checkbox1a.setChecked(false);
	         }
		//getcliniccard
         List<String> cliniccard0a = dbHelper.SelectCliniccard(emp);
			StringBuilder cliniccard0b = new StringBuilder();
	         for (String cliniccard0c : cliniccard0a) {
	           cliniccard0b.append(cliniccard0c);
	        }
	         if(cliniccard0b.toString().equals("1"))
	         {
	        	 cliniccardcb.setChecked(true);
	         }
	         else{
	        	 cliniccardcb.setChecked(false);
	         }  
	    //getfullyimunized
         List<String> fullyimmunized0a = dbHelper.SelectFullyimmunized(emp);
			StringBuilder fullyimmunized0b = new StringBuilder();
	         for (String fullyimmunized0c : fullyimmunized0a) {
	           fullyimmunized0b.append(fullyimmunized0c);
	        }
	         if(fullyimmunized0b.toString().equals("1"))
	         {
	        	 fullyimmunizedcb.setChecked(true);
	         }
	         else{
	        	 fullyimmunizedcb.setChecked(false);
	         }
	       //getpenta1
	         List<String> penta10a = dbHelper.SelectPenta1(emp);
				StringBuilder penta10b = new StringBuilder();
		         for (String penta10c : penta10a) {
		           penta10b.append(penta10c);
		        }
		         if(penta10b.toString().equals("1"))
		         {
		        	mPickDate.setChecked(true);
		        	button3.setVisibility(View.VISIBLE);
		        	editText1.setVisibility(View.VISIBLE);
		        	mDateDisplay.setVisibility(View.GONE);
		        	penta1given=1;
		         }
		         else{
		        	mPickDate.setChecked(false);
		        	button3.setVisibility(View.GONE);
		        	editText1.setVisibility(View.GONE);
		        	penta1given=0;
		         }
		       //getmeasles
		         List<String> measles0a = dbHelper.SelectMeasles(emp);
					StringBuilder measles0b = new StringBuilder();
			         for (String measles0c : measles0a) {
			           measles0b.append(measles0c);
			        }
			         if(measles0b.toString().equals("1"))
			         {
			        	mPickDate3.setChecked(true);
			        	button5.setVisibility(View.VISIBLE);
			        	editText3z.setVisibility(View.VISIBLE);
			        	mDateDisplay2.setVisibility(View.GONE);
			        	measlesgiven=1;
			         }
			         else{
			        	mPickDate3.setChecked(false);
			        	button5.setVisibility(View.GONE);
			        	editText3z.setVisibility(View.GONE);
			        	measlesgiven=0;
			         }       
			         //getmeaslesdate   
			         List<String> msd0a = dbHelper.SelectMeaslesdate(emp);
						StringBuilder msd0b = new StringBuilder();
				         for (String msd0c : msd0a) {
				           msd0b.append(msd0c);
				        }
				 editText3z.setText(msd0b.toString());	         
		  //getpenta1date   
		         List<String> penta1d0a = dbHelper.SelectPenta1date(emp);
					StringBuilder penta1d0b = new StringBuilder();
			         for (String penta1d0c : penta1d0a) {
			           penta1d0b.append(penta1d0c);
			        }
			 editText1.setText(penta1d0b.toString());	
			 
			  //get vitmainadate   
	         List<String> vitmainad0a = dbHelper.SelectVitaminadate(emp);
				StringBuilder vitmainad0b = new StringBuilder();
		         for (String vitmainad0c : vitmainad0a) {
		        	 vitmainad0b.append(vitmainad0c);
		        }
		         if(vitmainad0b.toString().equals("1"))
		         {
		        	mPickDate4.setChecked(true);
		        	button1.setVisibility(View.VISIBLE);
		        	editvad.setVisibility(View.VISIBLE);
		        	mDateDisplay3.setVisibility(View.GONE);
		        	vitamina=1;
		         }
		         else{
		        	mPickDate4.setChecked(false);
		        	button1.setVisibility(View.GONE);
		        	editvad.setVisibility(View.GONE);
		        	vitamina=0;
		         }    
		  //get dewormdate   
         List<String> dewormd0a = dbHelper.SelectDewormdate(emp);
			StringBuilder dewormd0b = new StringBuilder();
	         for (String dewormd0c : dewormd0a) {
	        	 dewormd0b.append(dewormd0c);
	        }
	         if(dewormd0b.toString().equals("1"))
	         {
	        	mPickDate5.setChecked(true);
	        	button6.setVisibility(View.VISIBLE);
	        	editdewormd.setVisibility(View.VISIBLE);
	        	mDateDisplay4.setVisibility(View.GONE);
	        	deworm=1;
	         }
	         else{
	        	mPickDate5.setChecked(false);
	        	button6.setVisibility(View.GONE);
	        	editdewormd.setVisibility(View.GONE);
	        	deworm=0;
	         }  
	 
		       //getpenta3
		         List<String> penta30a = dbHelper.SelectPenta3(emp);
					StringBuilder penta30b = new StringBuilder();
			         for (String penta30c : penta30a) {
			           penta30b.append(penta30c);
			        }
			         if(penta30b.toString().equals("1"))
			         {
			        	 mPickDate2.setChecked(true);
			        	 button4.setVisibility(View.VISIBLE);
				        	editText2.setVisibility(View.VISIBLE);
				        	mDateDisplay1.setVisibility(View.GONE);
				        	penta3given=1;
			         }
			         else{
			        	mPickDate2.setChecked(false);
			        	button4.setVisibility(View.GONE);
			        	editText2.setVisibility(View.GONE);
			        	mDateDisplay1.setVisibility(View.GONE);
			        	penta3given=0;
			         }
			       //getpenta3date   
			         List<String> penta3d0a = dbHelper.SelectPenta3date(emp);
						StringBuilder penta3d0b = new StringBuilder();
				         for (String penta3d0c : penta3d0a) {
				           penta3d0b.append(penta3d0c);
				        }
				 editText2.setText(penta3d0b.toString());    
			       //getvitamina
			         List<String> vitamina0a = dbHelper.SelectVitamina(emp);
						StringBuilder vitamina0b = new StringBuilder();
				         for (String vitamina0c : vitamina0a) {
				           vitamina0b.append(vitamina0c);
				        }
				         if(vitamina0b.toString().equals("1"))
				         {
				        	 mPickDate4.setChecked(true);
				         }
				         else{
				        	 mPickDate4.setChecked(false);
				         }
				       //getdeworming
				         List<String> deworming0a = dbHelper.SelectDeworming(emp);
							StringBuilder deworming0b = new StringBuilder();
					         for (String deworming0c : deworming0a) {
					        	 deworming0b.append(deworming0c);
					        }
					         if(deworming0b.toString().equals("1"))
					         {
					        	 mPickDate5.setChecked(true);
					         }
					         else{
					        	 mPickDate5.setChecked(false);
					         }
	    //getmalnutritionk     
	         List<String> malnutrition0 = dbHelper.SelectMalnutrition(emp);
				StringBuilder mal1 = new StringBuilder();
		         for (String mal2 : malnutrition0) {
		           mal1.append(mal2);
		        }
		        if(mal1.toString().equals("Not malnourished -> 12.5cm")){
		        	spinner1u5.setSelection(0);
		        }else if(mal1.toString().equals("Moderately malnourished -> 12.5cm")){
		        	spinner1u5.setSelection(1);
		        }else 
		        {
		        	spinner1u5.setSelection(2);
		        }		         
			   //set name
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
							        //int numberofmembers = dbHelper.getMembersCount(emp);
							        // y=numberofmembers-1;
							         TextView textView5 = (TextView)findViewById(R.id.textView5);
							         //textView5.setText(String.valueOf(numberofmembers));
							         textView5.setVisibility(View.GONE);
	        //x = 1
							         
							         final TextView textView4 = (TextView)findViewById(R.id.textView4);
							         //textView4.setText(String.valueOf(x));
							         textView4.setVisibility(View.GONE);
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
									String relationtohead = spinner1gi.getSelectedItem().toString();
									generalinfo.setVisibility(View.GONE);
									
									if(bednet==1)
									{
									howoften1 = spinnerHowOften.getSelectedItem().toString();
									}
									else
									{
									howoften1 ="";
									}
									//send data to database
									Individualsgen gen = new Individualsgen(householdnumber, village, PID, relationtohead, bc, bednet, howoften1, knowhivstatus, chronic, disability);
									dbHelper.UpdateIndGen(gen);
									//
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
							String dob;
							if(editText1.getVisibility()==View.VISIBLE){
								dob=editText1.getText().toString();
							}else
							{
								dob=mDateDisplay.getText().toString();
							}
							
							String p3d;
							if(editText2.getVisibility()==View.VISIBLE){
								p3d=editText2.getText().toString();
							}else
							{
								p3d=mDateDisplay1.getText().toString();
							}
							String mslsd;
							if(editText3z.getVisibility()==View.VISIBLE){
								mslsd=editText3z.getText().toString();
							}else
							{
								mslsd=mDateDisplay2.getText().toString();
							}
							String vad;
							if(editvad.getVisibility()==View.VISIBLE){
								vad=editvad.getText().toString();
							}else
							{
								vad=mDateDisplay3.getText().toString();
							}
							String dwd;
							if(editdewormd.getVisibility()==View.VISIBLE){
								dwd=editdewormd.getText().toString();
							}else
							{
								dwd=mDateDisplay4.getText().toString();
							}
							Individualsu5 u5 = new Individualsu5(householdnumber, village, PID, cliniccard, penta1given, dob, penta3given, p3d, measlesgiven, mslsd.toString(), fullyimmunized, vitamina, vad, deworm, dwd, malnutrition);
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
							//outcome=spinner1.getSelectedItem().toString();
						   outcome=spinner1.getSelectedItem().toString();
						whenbbd=spinner3.getSelectedItem().toString();
							pnc = spinnerANC.getSelectedItem().toString();
							pnc2 = spinnerANC2.getSelectedItem().toString();
							wheredeliver=spinner2.getSelectedItem().toString();
														
						 if(editText3p.getVisibility()==View.VISIBLE){
								prdd=editText3p.getText().toString();
							}else
							{
								prdd=pDisplay2.getText().toString();
							}

							Individualsmi mi = new Individualsmi(householdnumber, village, PID, currentlypregnant, prdd, birthinlast12, outcome, whenbbd, pnc, pnc2, wheredeliver);
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
						spinner2.setSelection(0);
						spinner3.setSelection(0);
				
						spinnerANC.setSelection(0);
						spinnerANC2.setSelection(0);
					}
				});
				
								         
				
		        //when progress bar is 100% - while there is another person show screen for person, else show done button
					next.setOnClickListener(new View.OnClickListener() {
					
					public void onClick(View v) {
						int householdnumber2 =Integer.parseInt(householdnumber);
						Intent pancakes = new Intent(EditCategories.this, Tabs2.class);
						pancakes.putExtra("village", village);
						pancakes.putExtra("householdnumber", householdnumber2);
						startActivity(pancakes);	
					}
					
				});
					
					
			       					/*  capture our View elements for penta1   */
			        
			        
			        /* get the current date */
			        penta1 = Calendar.getInstance();
			        /* add a click listener to checkbox */
			      
			        button1.setOnClickListener(new View.OnClickListener() {
						
						public void onClick(View v) {
							// TODO Auto-generated method stub
							
							showDateDialog(mDateDisplay3, vitaminac);
							editvad.setVisibility(View.GONE);
							mDateDisplay3.setVisibility(View.VISIBLE);
						
						}
					});
			        button6.setOnClickListener(new View.OnClickListener() {
						
						public void onClick(View v) {
							// TODO Auto-generated method stub
							
							showDateDialog(mDateDisplay4, deworming);
							editdewormd.setVisibility(View.GONE);
							mDateDisplay4.setVisibility(View.VISIBLE);
						
						}
					});
			        button3.setOnClickListener(new View.OnClickListener() {
						
						public void onClick(View v) {
							// TODO Auto-generated method stub
							showDateDialog(mDateDisplay, penta1);
							editText1.setVisibility(View.GONE);
							mDateDisplay.setVisibility(View.VISIBLE);
													}
					});
			        button4.setOnClickListener(new View.OnClickListener() {
						
						public void onClick(View v) 
						{
							// TODO Auto-generated method stub
							showDateDialog(mDateDisplay1, penta3);
							editText2.setVisibility(View.GONE);
							mDateDisplay1.setVisibility(View.VISIBLE);
						}
					});
			        button5.setOnClickListener(new View.OnClickListener() {
						
						public void onClick(View v) {
							// TODO Auto-generated method stub
			        showDateDialog(mDateDisplay2, measles);
			        editText3z.setVisibility(View.GONE);
					mDateDisplay2.setVisibility(View.VISIBLE);
											}
			});
			        lastP = Calendar.getInstance();
			        
			       bPickDate2.setOnClickListener(new View.OnClickListener() {
						
						public void onClick(View v) {
							// TODO Auto-generated method stub
							showDateDialog(pDisplay2, lastP);	
							pDisplay2.setVisibility(View.VISIBLE);
							editText3p.setVisibility(View.GONE);
						}
					});
			       
			      
			        /*capture our view elements for penta3*/
			       
			        
			        /* get the current date */
			        penta3 = Calendar.getInstance();
			        /* add a click listener to check box */
			    
			        
			        /*capture our view elements for measles*/
			       
			        /* get the current date */
			        measles = Calendar.getInstance();
			        /* add a click listener to check box */
			        
			        
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
			
		