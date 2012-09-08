package com.databasetest.sample;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
//import android.widget.TextView;
import android.widget.TextView;

public class Action1 extends Activity{
	DatabaseHelper dbHelper;
	int households;
	private String Tag = "UPLOADER";
    private String urlString = "http://segasiliconvalley.org/uploads.php";
    HttpURLConnection conn;
    String datetime;
    TextView textView1;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action2);
        dbHelper=new DatabaseHelper(this);
ImageButton bSwitch56 = (ImageButton) findViewById(R.id.imageButton2);
ImageButton export = (ImageButton) findViewById(R.id.imageButton1);     
ImageButton viewandupdate = (ImageButton) findViewById(R.id.imageButton4); 
viewandupdate.setOnClickListener(new View.OnClickListener() {
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent pancakes = new Intent(v.getContext(), Viewupdateweb.class);
		v.getContext().startActivity(pancakes);
		
	}

});

//get date time
Time today = new Time(Time.getCurrentTimezone());
today.setToNow();

datetime = String.valueOf(today.monthDay)+String.valueOf(today.month)+String.valueOf(today.year)+String.valueOf(today.format("%k%M%S"));


        bSwitch56.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try { 
                    File sd = Environment.getExternalStorageDirectory();
                    File data = Environment.getDataDirectory();

                    if (sd.canWrite()) {
                    	String currentDBPath = "\\data\\com.databasetest.sample\\databases\\Chw29";
                        String backupDBPath = datetime;

                        File currentDB = new File(data, currentDBPath);
                        File backupDB = new File(sd, backupDBPath);

                            FileChannel src = new FileInputStream(currentDB).getChannel();
                            FileChannel dst = new FileOutputStream(backupDB).getChannel();
                            dst.transferFrom(src, 0, src.size());
                            src.close();
                            dst.close();
                            Toast.makeText(getBaseContext(), "Data has been backed up at: "+backupDB.toString(), Toast.LENGTH_LONG).show();

                    }
                } catch (Exception e) {

                    Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_LONG).show();


                }
				


			}
		}); 
      
export.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String exsistingFileName = "data\\data\\com.databasetest.sample\\databases\\Chw29";

		        String lineEnd = "\r\n";
		        String twoHyphens = "--";
		        String boundary = "*****";
		        try {
		            // ------------------ CLIENT REQUEST

		            Log.e(Tag, "Inside second Method");

		            FileInputStream fileInputStream = new FileInputStream(new File(
		                    exsistingFileName));

		            // open a URL connection to the Servlet

		            URL url = new URL(urlString);

		            // Open a HTTP connection to the URL

		            conn = (HttpURLConnection) url.openConnection();

		            // Allow Inputs
		            conn.setDoInput(true);

		            // Allow Outputs
		            conn.setDoOutput(true);

		            // Don't use a cached copy.
		            conn.setUseCaches(false);

		            // Use a post method.
		            conn.setRequestMethod("POST");

		            conn.setRequestProperty("Connection", "Keep-Alive");

		            conn.setRequestProperty("Content-Type",
		                    "multipart/form-data;boundary=" + boundary);

		            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());

		            dos.writeBytes(twoHyphens + boundary + lineEnd);
		            dos
		                    .writeBytes("Content-Disposition: post-data; name=uploadedfile;filename="
		                            + exsistingFileName + "" + lineEnd);
		            dos.writeBytes(lineEnd);

		            Log.e(Tag, "Headers are written");

		            // create a buffer of maximum size

		            int bytesAvailable = fileInputStream.available();
		            int maxBufferSize = 1000;
		            // int bufferSize = Math.min(bytesAvailable, maxBufferSize);
		            byte[] buffer = new byte[bytesAvailable];

		            // read file and write it into form...

		            int bytesRead = fileInputStream.read(buffer, 0, bytesAvailable);

		            while (bytesRead > 0) {
		                dos.write(buffer, 0, bytesAvailable);
		                bytesAvailable = fileInputStream.available();
		                bytesAvailable = Math.min(bytesAvailable, maxBufferSize);
		                bytesRead = fileInputStream.read(buffer, 0, bytesAvailable);
		            }

		            // send multipart form data necesssary after file data...

		            dos.writeBytes(lineEnd);
		            dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

		            // close streams
		            Log.e(Tag, "File is written");
		            fileInputStream.close();
		            dos.flush();
		            dos.close();

		        } catch (MalformedURLException ex) {
		            Log.e(Tag, "error: " + ex.getMessage(), ex);
		        }

		        catch (IOException ioe) {
		            Log.e(Tag, "error: " + ioe.getMessage(), ioe);
		        Toast.makeText(Action1.this, "No Internet Connection!", Toast.LENGTH_LONG).show();
       		     
		        }

		        try {
		            BufferedReader rd = new BufferedReader(new InputStreamReader(conn
		                    .getInputStream()));
		            String line;
		            while ((line = rd.readLine()) != null) {
		                Log.e("Dialoge Box", "Message: " + line);
		                Toast.makeText(Action1.this, line, Toast.LENGTH_LONG).show();
		               
		                
		            } 
		            rd.close();

		        } catch (IOException ioex) {
		            Log.e("MediaPlayer", "error: " + ioex.getMessage(), ioex);
		        }
			}
		}); 
ImageButton bSwitch = (ImageButton) findViewById(R.id.imageButton6);
        
        bSwitch.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent pancakes = new Intent(v.getContext(), VillageList.class);
				v.getContext().startActivity(pancakes);
			}
		});        
ImageButton button5 = (ImageButton) findViewById(R.id.imageButton3);
        
        button5.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent pancakes = new Intent(v.getContext(), Tabs.class);
				v.getContext().startActivity(pancakes);
			}
		});
        
ImageButton bSwitch2 = (ImageButton) findViewById(R.id.imageButton5);
//TextView textView3 = (TextView) findViewById(R.id.textView3);

//
List<String> names = dbHelper.selectVillage();
StringBuilder sb = new StringBuilder();
 for (String Village : names) {
   sb.append(Village);
   
}
 final String village = sb.toString();	
 
 List<String> names01 = dbHelper.selectCHW();
 StringBuilder sb01 = new StringBuilder();
  for (String chw : names01) {
    sb01.append(chw);
    
 }
  final String chw = sb01.toString();
  
 final Households emp = new Households("", village, "");
households = dbHelper.getHousesCount(emp);
int households2 = dbHelper.getHousesCount1();
//display pending exports
textView1 = (TextView)findViewById(R.id.TextView05);
textView1.setText(String.valueOf(households2));

TextView textView2 = (TextView)findViewById(R.id.textView5);


TextView textView3 = (TextView)findViewById(R.id.TextView07);
textView3.setText(chw);

if(village.equals("0"))
{
bSwitch2.setEnabled(false);
textView2.setText("[None]");

}else{
	bSwitch2.setEnabled(true);

	textView2.setText(village);
}
        //textView3.setText("CHW: "+ chwname + " | Village: " + village);
        bSwitch2.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				households++;
				
				//household will be updated from getcount of total households ***IMPORTANT***
				String householdnumber = String.valueOf(households);
				Households emp = new Households(householdnumber,"","");
				
				
				//add new household
				Houses emp2 = new Houses(householdnumber, village, "", "", 0, 0, "", 0, 0, 0, "[Incomplete]");
				dbHelper.AddHouse(emp2);
				
				 dbHelper.update1(emp);
				  
				  List<String> names2 = dbHelper.selectHouseholdnumber();
					StringBuilder sb2 = new StringBuilder();
			         for (String HouseholdNumber : names2) {
			          sb2.append(HouseholdNumber);
			        }
			         
			         
			
		Intent pancakes2 = new Intent(v.getContext(), AddHoushold.class);
			v.getContext().startActivity(pancakes2);
		//		 TextView textView3 = (TextView)findViewById(R.id.textView3);
			//	 textView3.setText(sb2.toString());
			
			}
		});
    }
}
