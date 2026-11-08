package com.nexus.mobile;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.JavascriptInterface;
import android.view.WindowManager;
import android.graphics.Color;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends Activity {
  private WebView web;
  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getWindow().setStatusBarColor(Color.rgb(13,12,20));
    getWindow().setNavigationBarColor(Color.rgb(13,12,20));
    getWindow().getDecorView().setSystemUiVisibility(0);
    web=new WebView(this); web.setBackgroundColor(Color.rgb(13,12,20));
    web.getSettings().setJavaScriptEnabled(true);
    web.getSettings().setDomStorageEnabled(true);
    web.setWebViewClient(new WebViewClient());
    web.addJavascriptInterface(new Bridge(),"NexusAndroid");
    setContentView(web); web.loadUrl("file:///android_asset/index.html");
  }
  @Override public void onBackPressed(){ web.evaluateJavascript("window.nexusBack && window.nexusBack()",null); }
  public class Bridge {
    @JavascriptInterface public String getApps(){
      JSONArray arr=new JSONArray();
      try {
        PackageManager pm=getPackageManager();
        Intent i=new Intent(Intent.ACTION_MAIN); i.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> apps=pm.queryIntentActivities(i,0);
        Collections.sort(apps,new ResolveInfo.DisplayNameComparator(pm));
        for(ResolveInfo a:apps){
          JSONObject o=new JSONObject(); o.put("name",a.loadLabel(pm).toString());o.put("pkg",a.activityInfo.packageName);arr.put(o);
        }
      }catch(Exception e){} return arr.toString();
    }
    @JavascriptInterface public void launch(String pkg){
      runOnUiThread(()->{ try { Intent i=getPackageManager().getLaunchIntentForPackage(pkg); if(i!=null) startActivity(i); }catch(Exception e){} });
    }
    @JavascriptInterface public void openSettings(){runOnUiThread(()->startActivity(new Intent(Settings.ACTION_SETTINGS)));}
    @JavascriptInterface public void openWifi(){runOnUiThread(()->startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS)));}
    @JavascriptInterface public void openBluetooth(){runOnUiThread(()->startActivity(new Intent(Settings.ACTION_BLUETOOTH_SETTINGS)));}
    @JavascriptInterface public void openDisplay(){runOnUiThread(()->startActivity(new Intent(Settings.ACTION_DISPLAY_SETTINGS)));}
    @JavascriptInterface public void openSound(){runOnUiThread(()->startActivity(new Intent(Settings.ACTION_SOUND_SETTINGS)));}
    @JavascriptInterface public void openCamera(){
      runOnUiThread(()->{try{Intent i=new Intent("android.media.action.IMAGE_CAPTURE");startActivity(i);}catch(Exception e){} });
    }
    @JavascriptInterface public void openDialer(){runOnUiThread(()->startActivity(new Intent(Intent.ACTION_DIAL)));}
    @JavascriptInterface public void openSms(){runOnUiThread(()->{try{startActivity(new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_APP_MESSAGING));}catch(Exception e){} });}
  }
}
