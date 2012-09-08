package com.databasetest.sample;

import java.util.Calendar;
import java.util.List;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class EditIndRecord extends Activity{
	DatabaseHelper dbHelper;
	Button button2;
	ImageButton imageButton1;
	TextView editText1;
	TextView editText2;
	RadioButton radioButton1;
	RadioButton radioButton2;
	Button button1;
	String sex3;

	private int mYear;
	private int mMonth;
	private int mDay;
	private TextView mDateDisplay;
	private Button mPickDate;
	
	static final int DATE_DIALOG_ID = 0;
	  public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.addhousehold);
	        dbHelper=new DatabaseHelper(this);
	        
	        Bundle extras = getIntent().getExtras();
	    	final String village = extras.getString("village");
	    	final int householdnumber = extras.getInt("householdnumber");
	        final int PID=extras.getInt("PID");
	        
	        
	        
	        imageButton1 = (ImageButton)findViewById(R.id.imageButton1);
	        imageButton1.setVisibility(View.GONE);
	        
	        radioButton1 = (RadioButton)findViewById(R.id.radioButton1);
	        radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
	        editText2 = (TextView)findViewById(R.id.editText2);
	        
	        mDateDisplay = (TextView) findViewById(R.id.dateDisplay);
	         mPickDate = (Button) findViewById(R.id.pickDate);
	         
	        mDateDisplay.setVisibility(View.GONE);
	        editText2.setVisibility(View.VISIBLE);
	        
	        button1 = (Button)findViewById(R.id.button1);
	        
	        
	        Individuals emp = new Individuals(String.valueOf(householdnumber), village, PID);
	        
	         
	        //get person's name
	           
	         
	         List<String> personname = dbHelper.SelectName(emp);
				StringBuilder sb3 = new StringBuilder();
		         for (String IndName : personname) {
		           sb3.append(IndName);
		        }
		         
		          
		         final String PersonName = sb3.toString();
		         editText1 = (TextView)findViewById(R.id.editText1);
		         editText1.setText(PersonName);
		     //get sex
		         List<String> sex = dbHelper.SelectSex(emp);
					StringBuilder sb5 = new StringBuilder();
			         for (String Sex : sex) {
			           sb5.append(Sex);
			        }
			         final String sex2 = sb5.toString();
			         
			         if(sex2.equals("Male")){
			        	 radioButton1.setChecked(true);
			         }else{
			        	 radioButton2.setChecked(true);
			         }
			    //get birthday     
			         List<String> dob = dbHelper.SelectDOB(emp);
						StringBuilder dob1 = new StringBuilder();
				         for (String Birthday : dob) {
				           dob1.append(Birthday);
				        }
				       String birthday=dob1.toString();
				       
				  editText2.setText(birthday);  
				  
				 				
				  //submit
				  button1.setOnClickListener(new View.OnClickListener(){
					  public void onClick(View v){
						  
						  //set sex depending on radiobuttons
						  if(radioButton1.isChecked())
							{
								sex3 = "Male";
							}
						  else
							{
								sex3="Female";
							}
							//birthdate
							String bdate;
							if(editText2.getVisibility()==View.VISIBLE)
							{
								bdate = editText2.getText().toString();
							}
							else
							{
								bdate = mDateDisplay.getText().toString();
							}
			Individuals emp = new Individuals(String.valueOf(householdnumber), village, PID, editText1.getText().toString(), bdate, sex3);
						  
			dbHelper.EditMember(emp);
			if(PID==1)
			{
				Houses emp2 = new Houses(String.valueOf(householdnumber), village, "", editText1.getText().toString());
				dbHelper.EditHouseHead(emp2);
			}
			
			//and now, moving on to the boring screen
			Intent pancakes = new Intent(EditIndRecord.this, EditCategories.class);
		    pancakes.putExtra("village", village);
			pancakes.putExtra("householdnumber", householdnumber);
			pancakes.putExtra("PID", PID);
			startActivity(pancakes);
			
					  }
				  });				  
				  
			      // capture our View elements
			        

			         // add a click listener to the button
			         mPickDate.setOnClickListener(new View.OnClickListener() {
			             public void onClick(View v) {
			                 showDialog(DATE_DIALOG_ID);
			             }
			         });

			         // get the current date
			         final Calendar c = Calendar.getInstance();
			         mYear = c.get(Calendar.YEAR);
			         mMonth = c.get(Calendar.MONTH);
			         mDay = c.get(Calendar.DAY_OF_MONTH);

			         // display the current date (this method is below)
			         updateDisplay();

			         
			 	}
			 	// updates the date in the TextView
			     private void updateDisplay() {
			         mDateDisplay.setText(
			             new StringBuilder()
			                     // Month is 0 based so add 1
			                     .append(mMonth + 1).append("-")
			                     .append(mDay).append("-")
			                     .append(mYear).append(" "));
			         
			         
			     }

			 	// the callback received when the user "sets" the date in the dialog
			     private DatePickerDialog.OnDateSetListener mDateSetListener =
			             new DatePickerDialog.OnDateSetListener() {

			                 public void onDateSet(DatePicker view, int year, 
			                                       int monthOfYear, int dayOfMonth) {
			                     mYear = year;
			                     mMonth = monthOfYear;
			                     mDay = dayOfMonth;
			                     updateDisplay();
			                     mDateDisplay.setVisibility(View.VISIBLE);
			         	        editText2.setVisibility(View.GONE);
			                 }
			             };
			             @Override
			             protected Dialog onCreateDialog(int id) {
			                 switch (id) {
			                 case DATE_DIALOG_ID:
			                     return new DatePickerDialog(this,
			                                 mDateSetListener,
			                                 mYear, mMonth, mDay);
			                 }
			                 return null;
			             }
	  
}
