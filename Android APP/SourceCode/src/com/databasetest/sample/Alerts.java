package com.databasetest.sample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class Alerts {

static public void CatchError(Context con, String Exception)
{
	Dialog diag=new Dialog(con);
	diag.setTitle("Error");
	TextView txt=new TextView(con);
	txt.setText(Exception);
	diag.setContentView(txt);
	diag.show();
}


}


