package com.aduech.www.deviceinfo;

import android.content.Context;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Connectivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connectivity);

        getSupportActionBar().setTitle("Connectivity Info");  // provide compatibility to all the versions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo;

        wifiInfo = wifi.getConnectionInfo();
        if (wifiInfo.getSupplicantState() == SupplicantState.COMPLETED) {
            String [] key = {"SSID :","Network Id :", "Link Speed :", "MAC Address :", "IP Address :", "Frequency :", "BSSID :" };
            String [] value = {wifiInfo.getSSID(), String.valueOf(wifiInfo.getNetworkId()), String.valueOf(wifiInfo.getLinkSpeed()),wifiInfo.getMacAddress(), String.valueOf(wifiInfo.getIpAddress()), String.valueOf(wifiInfo.getFrequency()),wifiInfo.getBSSID() }        ;
            setUpList(key, value);
        }
        else {
            String []key = new String[]{"WiFi"};
            String []value = new String[]{"Not Available"};
            setUpList(key, value);

        }

    }

    private void setUpList(String [] key, String [] value) {
        Litem[] items = new Litem[value.length];


        int count = key.length;
        for(int i = 0; i < count; i++) {
            items[i] = new Litem();
            items[i].setKey(key[i]);
            items[i].setValue(value[i]);
        }

        ListAdapter la = new CustomAdapter(this, items);
        ListView lv = (ListView) findViewById(R.id.listview);
        lv.setAdapter(la);


    }
}
