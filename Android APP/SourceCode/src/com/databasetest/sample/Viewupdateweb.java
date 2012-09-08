package com.databasetest.sample;

import java.util.List;

import android.app.Activity;

//import android.content.ContentValues;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class Viewupdateweb extends Activity{
	WebView webview;
	DatabaseHelper dbHelper;
	@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.viewupdateweb);
	        dbHelper=new DatabaseHelper(this);
	        
	        List<String> names = dbHelper.selectVillage();
	        StringBuilder sb = new StringBuilder();
	         for (String Village : names) {
	           sb.append(Village);
	           
	        }
	         String village = sb.toString();
	    	
	  
	    	webview = (WebView) findViewById(R.id.webView1);
	    	 webview.setWebViewClient(new HelloWebViewClient());
	    	webview.getSettings().setJavaScriptEnabled(true);
	    	webview.loadUrl("http://www.segasiliconvalley.org/goal4/chwapp/help.php");
	    	
	}
	private class HelloWebViewClient extends WebViewClient {
	    @Override
	    public boolean shouldOverrideUrlLoading(WebView view, String url) {
	        view.loadUrl(url);
	        return true;
	    }
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
	        webview.goBack();
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}
	
}