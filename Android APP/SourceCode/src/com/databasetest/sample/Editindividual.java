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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
//import android.widget.TextView;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class Editindividual extends Activity{
	DatabaseHelper dbHelper;
	int households;
	TextView textView1;
	TextView editText1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	private int mYear;
	private int mMonth;
	private int mDay;
	static final int DATE_DIALOG_ID = 0;
	CheckBox checkBox1;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editindividual);
        dbHelper=new DatabaseHelper(this);
        
        Bundle extras = getIntent().getExtras();
    	final String village = extras.getString("village");
    	final String Personname = extras.getString("Personname");
        final int householdnumber = extras.getInt("householdnumber");
        final int PID=extras.getInt("PID");
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);
        
        editText1=(TextView)findViewById(R.id.editText1);
        checkBox1 = (CheckBox)findViewById(R.id.checkBox1);
        
        checkBox1.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( !isChecked )
                {
                	button3.setVisibility(View.GONE);
                	editText1.setVisibility(View.GONE);
                	button4.setVisibility(View.GONE);
                }
                else
                {
                	button3.setVisibility(View.VISIBLE);
                	editText1.setVisibility(View.VISIBLE);
                	button4.setVisibility(View.VISIBLE);
                	
                }

            }
        });
        //edit record
        button2.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
        		
        		Intent pancakes = new Intent(Editindividual.this, EditIndRecord.class);
			    pancakes.putExtra("village", village);
				pancakes.putExtra("householdnumber", householdnumber);
				pancakes.putExtra("PID", PID);
				startActivity(pancakes);
        	}
        });
        //mark as dead
        button4.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
        		//send data to db
        		String sdate = editText1.getText().toString();
        		
        		Individuals emp = new Individuals(String.valueOf(householdnumber), village, PID, Personname+"[deceased]", sdate);
        		dbHelper.markDead(emp);
        		//start intent on finish
        		Intent pancakes = new Intent(Editindividual.this, Tabs2.class);
			    pancakes.putExtra("village", village);
				pancakes.putExtra("householdnumber", householdnumber);
				startActivity(pancakes);
        	}
        });
        //delete
        button5.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
        		//send data to db
        		Individuals emp = new Individuals(String.valueOf(householdnumber), village, PID);
        		dbHelper.deleteIndividual(emp);
        		//start intent on finish
        		Intent pancakes = new Intent(Editindividual.this, Tabs2.class);
			    pancakes.putExtra("village", village);
				pancakes.putExtra("householdnumber", householdnumber);
				startActivity(pancakes);
        	}
        });
     // capture our View elements
        //N/A

        // add a click listener to the button
        button3.setOnClickListener(new View.OnClickListener() {
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
        editText1.setText(
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

