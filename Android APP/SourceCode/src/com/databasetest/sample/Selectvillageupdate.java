package com.databasetest.sample;

import android.app.ListActivity;
//import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Selectvillageupdate extends ListActivity{
	DatabaseHelper dbHelper;
	@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        dbHelper=new DatabaseHelper(this);
	        //setContentView(R.layout.villageslist);
	        String[] names = new String[] {"Alara","Ywaya","Ulare", "Fundula", "Kondiek", "Ligose", "Mukwiro", "Ogero", "Oriang", "Umlunda", "Murumba", "Sega Town Central", "Sega Town East", "Sega Town Northeast", "Ugambe", "Odende", "Serowa"};
	        setListAdapter(new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1,names));
	        
	    }

		@Override
		protected void onListItemClick(ListView l, View v, int position, long id) {
			// TODO Auto-generated method stub
			super.onListItemClick(l, v, position, id);
			Object o = this.getListAdapter().getItem(position);
			String village = o.toString();
			
			Households emp = new Households("",village,"");
			  dbHelper.update(emp);
			
			Toast.makeText(this, "You have selected " + village, Toast.LENGTH_SHORT).show();
			 
			Intent pancakes = new Intent(Selectvillageupdate.this, Viewupdateweb.class);
				pancakes.putExtra("village", village);
		
				startActivity(pancakes);
		}
	}
