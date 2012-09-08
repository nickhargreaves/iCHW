package com.databasetest.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener; 

import java.util.Calendar;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;
import android.widget.TextView;



public class under5 extends Activity{
	private TextView mDateDisplay;
	private TextView mDateDisplay1;
	private TextView mDateDisplay2;
	private Calendar penta1;
	private Calendar penta3;
	private Calendar measles;
	

	static final int DATE_DIALOG_ID = 0;
	private TextView activeDateDisplay;
	private Calendar activeDate;
	public final static String done ="com.databasetest.sample._doneunder5";
	public final static String b2en1 ="com.databasetest.sample._b2en1";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.under5);
        
        String name = getIntent().getStringExtra(Questioncategories.jina);
        final String b2en = getIntent().getStringExtra(Questioncategories.b2en);
        
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setText(name);
        
Button bSwitch = (Button) findViewById(R.id.button2);
        
        bSwitch.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent pancakes = new Intent(under5.this, Questioncategories.class);
				//v.getContext().startActivity(pancakes);
				
				pancakes.putExtra(b2en1, b2en);
				pancakes.putExtra(done, "1");
				startActivity(pancakes);
			}
		});
        /*  capture our View elements for penta1   */
        mDateDisplay = (TextView) findViewById(R.id.dateDisplay);
        CheckBox mPickDate = ( CheckBox ) findViewById( R.id.checkBox2 );
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
                }
                if (!isChecked)
                {
                // do nothing
                	mDateDisplay.setVisibility(View.GONE);
                }

            }
        });
        /*capture our view elements for penta3*/
        mDateDisplay1 = (TextView) findViewById(R.id.dateDisplay1);
        CheckBox mPickDate2 = ( CheckBox ) findViewById( R.id.checkBox3 );
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
                }
                if (!isChecked)
                {
                // do nothing
                	mDateDisplay1.setVisibility(View.GONE);
                }

            }
        });
        
        /*capture our view elements for measles*/
        mDateDisplay2 = (TextView) findViewById(R.id.editText3);
        CheckBox mPickDate3 = ( CheckBox ) findViewById( R.id.checkBox4 );
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
                }
                if (!isChecked)
                {
                // do nothing
                	mDateDisplay2.setVisibility(View.GONE);
                }

            }
        });
        
        /* display the current date (this method is below)  */
        updateDisplay(mDateDisplay, penta1);
        updateDisplay(mDateDisplay1, penta3);
        updateDisplay(mDateDisplay2, measles);
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
