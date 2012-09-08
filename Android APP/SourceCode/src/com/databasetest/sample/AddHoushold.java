package com.databasetest.sample;

import java.util.Calendar;
import java.util.List;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;



public class AddHoushold extends Activity{
	private TextView mDateDisplay;
	private TextView editText1;
	private Button mPickDate;
	private RadioButton radiomale;
	private RadioButton radiofemale;
	private int mYear;
	private int mMonth;
	private int mDay;
	private int PID = 1;
	private DatabaseHelper dbHelper;
	static final int DATE_DIALOG_ID = 0;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addhousehold);
        this.dbHelper = new DatabaseHelper(this);
        
        editText1 = (TextView) findViewById(R.id.editText1);
        radiomale = (RadioButton) findViewById(R.id.radioButton1);
        radiofemale = (RadioButton) findViewById(R.id.radioButton2);
       
        //
        final RadioGroup radiogroup1 = (RadioGroup)findViewById(R.id.radioGroup1);
        
        
        
        
        //when done
ImageButton bSwitch = (ImageButton) findViewById(R.id.imageButton1);
        
        bSwitch.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent pancakes = new Intent(v.getContext(),Questionnare.class);
				v.getContext().startActivity(pancakes);
							}
		});
       // final TextView output = (TextView) findViewById(R.id.textView1);
        //final TextView output2 = (TextView) findViewById(R.id.textView2);
        Button submitPerson =(Button) findViewById(R.id.button1);
        
        submitPerson.setOnClickListener(new View.OnClickListener() {
        	
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Object o = editText1.getText();
				String personname = o.toString();
				String bdate = mDateDisplay.getText().toString();
				String sex = "";
				if(radiomale.isChecked()==true)
				{
					sex = "Male";
				}
				if(radiofemale.isChecked()==true)
				{
					sex="Female";
				}
				//get householdnumber, village - read from database of current.
				List<String> names = dbHelper.selectVillage();
				StringBuilder sb = new StringBuilder();
		         for (String Village : names) {
		           sb.append(Village);
		        }
		         	       
		               
		        
		        //
		         //final String village = sb.toString();
		         //final Households emp2 = new Households("", village, "");
		         //int householdnumber = dbHelper.getHousesCount(emp2);
					//householdnumber = householdnumber + 1;
					//String sb2=String.valueOf(householdnumber);
		       List<String> names2 = dbHelper.selectHouseholdnumber();
				StringBuilder sb2 = new StringBuilder();
		        for (String HouseholdNumber : names2) {
		        sb2.append(HouseholdNumber);
		        }
		         
		         //TextView textView1 = (TextView)findViewById(R.id.textView1);
		         //textView1.setText(sb2.toString());
		         //Households emp2 = new Households("", sb.toString(), "");	       
		         //int households = dbHelper.getHousesCount(emp2);
		         //int householdnumber = households + 1;
				
		        //insert to database
				String sdate=null;
				Individuals emp=new Individuals(sb2.toString(),sb.toString(),PID,personname,bdate,sex,sdate);
				dbHelper.AddIndividual(emp);
				
				//get PID - count number of people of this householdnumber&village. PID = count + 1
				PID = PID + 1;
				
				
			Toast.makeText(AddHoushold.this, personname + " has been added!", Toast.LENGTH_LONG).show();
			editText1.setText("");
		
			
			//
			
	        radiogroup1.clearCheck();      
			}
		});
        
     // capture our View elements
        mDateDisplay = (TextView) findViewById(R.id.dateDisplay);
        mPickDate = (Button) findViewById(R.id.pickDate);

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

