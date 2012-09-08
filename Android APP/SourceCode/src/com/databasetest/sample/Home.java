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
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends Activity{
	DatabaseHelper dbHelper;
	int households;
	private String Tag = "UPLOADER";
    private String urlString = "http://segasiliconvalley.org/uploads.php";
    HttpURLConnection conn;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        dbHelper=new DatabaseHelper(this);
        
        households = dbHelper.getHousesCount1();
        Button bSwitch56 = (Button) findViewById(R.id.button3);
        Button export = (Button) findViewById(R.id.button4);       
                bSwitch56.setOnClickListener(new View.OnClickListener() {
        			
        			public void onClick(View v) {
        				// TODO Auto-generated method stub
        				try {
                            File sd = Environment.getExternalStorageDirectory();
                            File data = Environment.getDataDirectory();

                            if (sd.canWrite()) {
                            	String currentDBPath = "\\data\\com.databasetest.sample\\databases\\Chw14";
                                String backupDBPath = "Chw14";

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
        				String exsistingFileName = "data\\data\\com.databasetest.sample\\databases\\Chw14";

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
        		            Toast.makeText(Home.this, "No Internet Connection!", Toast.LENGTH_LONG).show();
        		        }

        		        try {
        		            BufferedReader rd = new BufferedReader(new InputStreamReader(conn
        		                    .getInputStream()));
        		            String line;
        		            while ((line = rd.readLine()) != null) {
        		                Log.e("Dialoge Box", "Message: " + line);
        		                Toast.makeText(Home.this, line, Toast.LENGTH_LONG).show();
        		            } 
        		            rd.close();

        		        } catch (IOException ioex) {
        		            Log.e("MediaPlayer", "error: " + ioex.getMessage(), ioex);
        		        }
        			}
        		}); 
        //display pending exports
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        Button button2 = (Button)findViewById(R.id.button2);
        if(households>0)
        {
        	//List<String> houses = dbHelper.selectHouses();
        	//StringBuilder sb1 = new StringBuilder();
        	//int i=0;
            // for (String name : houses) {
            //	 i++;
              // sb1.append(i+". "+name+"\n");
               
              // }
             //textView1.setText(sb1.toString());
        	
        	textView1.setVisibility(View.GONE);
        	button2.setVisibility(View.VISIBLE);
        	bSwitch56.setVisibility(View.VISIBLE);
        	export.setVisibility(View.VISIBLE);
        }
        else
        {
        	textView1.setVisibility(View.VISIBLE);
        	button2.setVisibility(View.GONE);
        	bSwitch56.setVisibility(View.GONE);
        	export.setVisibility(View.GONE);
         }   
Button bSwitch = (Button) findViewById(R.id.button1);
        
        bSwitch.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent pancakes = new Intent(v.getContext(), VillageList.class);
				v.getContext().startActivity(pancakes);
			}
		});
        
        button2.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent pancakes = new Intent(v.getContext(), Tabs.class);
				v.getContext().startActivity(pancakes);
			}
		});
    }
}
