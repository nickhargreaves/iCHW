package com.databasetest.sample;





import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DatabaseTestActivity extends Activity {
	DatabaseHelper dbHelper;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        dbHelper=new DatabaseHelper(this);
        Button submitPerson =(Button) findViewById(R.id.button1);
        final TextView cn =(TextView) findViewById(R.id.editText1);
        final TextView ps =(TextView) findViewById(R.id.editText2);
       // final TextView cn =(TextView) findViewById(R.id.editText3);
        //final TextView tv =(TextView) findViewById(R.id.textView2);
        
        submitPerson.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String chwname = cn.getText().toString();
				String password = ps.getText().toString();
				//String chwname = cn.getText().toString();
				
				if(chwname.equals("pamela2")&&password.equals("pam739"))
				{
					dbHelper.deleteAll();
					//insert data to database
					Households emp=new Households("0", "0", chwname);
					dbHelper.AddHouseholds(emp);
					Toast.makeText(DatabaseTestActivity.this, "You have been logged in as "+ chwname, Toast.LENGTH_SHORT).show();
					
					//start home activity
					Intent pancakes = new Intent(v.getContext(), Action1.class);
					v.getContext().startActivity(pancakes);
				
				}
				else
				{
					Toast.makeText(DatabaseTestActivity.this, "Incorrect login and/or password", Toast.LENGTH_SHORT).show();
				}
	        }
		});
    }
}