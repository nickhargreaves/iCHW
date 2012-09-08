package com.databasetest.sample;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class GeneralInformation extends Activity{
	public final static String done ="com.databasetest.sample._done";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generalinformation);
        
Button bSwitch = (Button) findViewById(R.id.button2);
String name = getIntent().getStringExtra(Questioncategories.jina);
TextView textView1 = (TextView)findViewById(R.id.textView1);
textView1.setText(name);
        bSwitch.setOnClickListener(new View.OnClickListener() {
			
		
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent pancakes = new Intent(GeneralInformation.this, Questioncategories.class);
				//v.getContext().startActivity(pancakes);
						
				pancakes.putExtra(done, "1");
				startActivity(pancakes);
			}
		});
	}
}