package com.databasetest.sample;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnDismissListener;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;

public class GridList2 extends Activity {
	DatabaseHelper dbHelper;
	static public GridView grid;
	String village;
	int householdnumber;
	Spinner spinDept1;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        setContentView(R.layout.gridview2);
        
        Bundle extras = getIntent().getExtras();
    	village = extras.getString("village");
        householdnumber = extras.getInt("householdnumber");
        
        grid=(GridView)findViewById(R.id.grid);
       
Button bSwitch = (Button) findViewById(R.id.button1);
        
        bSwitch.setOnClickListener(new View.OnClickListener() {
    		
    		public void onClick(View v) {
    			// TODO Auto-generated method stub
    			Intent pancakes = new Intent(v.getContext(),Action1.class);
    			v.getContext().startActivity(pancakes);
    						}
    	});
        
        try
        {
        grid.setOnItemClickListener(new OnItemClickListener()
        {

        	@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
				// TODO Auto-generated method stub
				try
				{
			
				SQLiteCursor cr=(SQLiteCursor)parent.getItemAtPosition(position);
				int PID=cr.getInt(cr.getColumnIndex(DatabaseHelper.colIndPID));
				String Personname=cr.getString(cr.getColumnIndex(DatabaseHelper.colIndName));
				//int householdnumber=cr.getInt(cr.getColumnIndex(DatabaseHelper.householdnumber));
				//String village=cr.getString(cr.getColumnIndex(DatabaseHelper.village));
				//Employee emp=new Employee(name, age,db.GetDeptID(Dept));
				//emp.SetID((int)id);
				//start intent
				Intent pancakes = new Intent(GridList2.this, Editindividual.class);
			    pancakes.putExtra("village", village);
				pancakes.putExtra("householdnumber", householdnumber);
				pancakes.putExtra("PID", PID);
				pancakes.putExtra("Personname", Personname);
				startActivity(pancakes);
				}
				catch(Exception ex)
				{
					Alerts.CatchError(GridList2.this, ex.toString());
				}
			}

			
        }
        );
        }
        catch(Exception ex)
        {
        	
        }

    }
    
    @Override
    public void onStart()
    {
    	super.onStart();
    	LoadGrid();
    }
    
    public void LoadGrid()
    {
    	dbHelper=new DatabaseHelper(this);
    	try
    	{
    		//Cursor c=dbHelper.getAllEmployees();
    		//View v=spinDept1.getSelectedView();
			//TextView txt=(TextView)v.findViewById(R.id.txtDeptName);
			//String Dept=String.valueOf(1);
    		Individuals emp = new Individuals(String.valueOf(householdnumber), village);
    		
    		Cursor c=dbHelper.getHouseholdMembers(emp);
    		startManagingCursor(c);
    		
    		String [] from=new String []{DatabaseHelper.colIndName, DatabaseHelper.colIndBd,DatabaseHelper.colIndSex};
    		int [] to=new int [] {R.id.colName,R.id.colAge, R.id.colDept};
    		SimpleCursorAdapter sca=new SimpleCursorAdapter(this,R.layout.gridrow2,c,from,to);
    		grid.setAdapter(sca);
    		
    		
    		
    	}
    	
    	catch(Exception ex)
    	{
    		AlertDialog.Builder b=new AlertDialog.Builder(this);
    		b.setMessage(ex.toString());
    		b.show();
    	}
    }
	
}
