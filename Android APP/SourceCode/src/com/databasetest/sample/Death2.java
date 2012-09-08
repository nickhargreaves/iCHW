package com.databasetest.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.RadioGroup;
import java.util.Calendar;
import java.util.List;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;
import android.widget.TextView;

public class Death2 extends Activity{
private TextView startDateDisplay;
private TextView endDateDisplay;
private Button startPickDate;
private Button endPickDate;
private Calendar startDate;
private Calendar endDate;
private int PID;
private DatabaseHelper dbHelper;

static final int DATE_DIALOG_ID = 0;

private TextView activeDateDisplay;
private Calendar activeDate;

	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.death);
        
 this.dbHelper = new DatabaseHelper(this);
        
        final TextView editText1 = (TextView) findViewById(R.id.editText1);
        final RadioButton radiomale = (RadioButton) findViewById(R.id.radioButton1);
        final RadioButton radiofemale = (RadioButton) findViewById(R.id.radioButton2);
        startDateDisplay = (TextView) findViewById(R.id.startDateDisplay);
        endDateDisplay = (TextView) findViewById(R.id.endDateDisplay);
        final RadioGroup radiogroup1 = (RadioGroup)findViewById(R.id.radioGroup1);
        Bundle extras = getIntent().getExtras();
    	final String village = extras.getString("village");
        final int householdnumber = extras.getInt("householdnumber");
	        
	    Individuals emp = new Individuals(String.valueOf(householdnumber), village);    
        int numberofmembers = dbHelper.getMembersCount(emp);
        PID = numberofmembers+1;
Button submitPerson =(Button) findViewById(R.id.button4);
        
        submitPerson.setOnClickListener(new View.OnClickListener() {
        	
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Object o = editText1.getText();
				String personname = o.toString();
				String bdate = startDateDisplay.getText().toString();
				String sdate = endDateDisplay.getText().toString();
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
				
		         	       
		               
		        
		        //
		         //final String village = sb.toString();
		         //final Households emp2 = new Households("", village, "");
		         //int householdnumber = dbHelper.getHousesCount(emp2);
					//householdnumber = householdnumber + 1;
					//String sb2=String.valueOf(householdnumber);
		     
		         
		         //TextView textView1 = (TextView)findViewById(R.id.textView1);
		         //textView1.setText(sb2.toString());
		         //Households emp2 = new Households("", sb.toString(), "");	       
		         //int households = dbHelper.getHousesCount(emp2);
		         //int householdnumber = households + 1;
				
		        //insert to database
				
				Individuals emp=new Individuals(String.valueOf(householdnumber), village,PID,personname,bdate,sex,sdate);
				dbHelper.AddIndividual(emp);
				
				//get PID - count number of people of this householdnumber&village. PID = count + 1
				PID = PID + 1;
				
				
			Toast.makeText(Death2.this, personname + " has been added!", Toast.LENGTH_LONG).show();
			editText1.setText("");
			  radiogroup1.clearCheck();  
			
			
	        //
	        
	       
			}
		});
	
ImageButton bSwitch = (ImageButton) findViewById(R.id.imageButton1);
        
        bSwitch.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent pancakes = new Intent(v.getContext(), Tabs.class);
				v.getContext().startActivity(pancakes);
			}
		});
       /*  capture our View elements for the start date function   */
   
    startPickDate = (Button) findViewById(R.id.startPickDate);

    /* get the current date */
    startDate = Calendar.getInstance();

    /* add a click listener to the button   */
    startPickDate.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            showDateDialog(startDateDisplay, startDate);
        }
    });

    /* capture our View elements for the end date function */
    
    endPickDate = (Button) findViewById(R.id.endPickDate);

    /* get the current date */
    endDate = Calendar.getInstance();

    /* add a click listener to the button   */
    endPickDate.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            showDateDialog(endDateDisplay, endDate);
        }
    });

    /* display the current date (this method is below)  */
    updateDisplay(startDateDisplay, startDate);
    updateDisplay(endDateDisplay, endDate);
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
