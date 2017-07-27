package com.aduech.www.deviceinfo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.ListAdapter;
import android.widget.ListView;

public class SIM extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim);

        getSupportActionBar().setTitle("SIM Info");  // provide compatibility to all the versions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Get the instance of TelephonyManager
        TelephonyManager tm=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);

        //Get the phone type
        String phoneType="";
        int strphoneType=tm.getPhoneType();
        switch (strphoneType)
        {
            case (TelephonyManager.PHONE_TYPE_CDMA):
                phoneType="CDMA";
                break;
            case (TelephonyManager.PHONE_TYPE_GSM):
                phoneType="GSM";
                break;
            case (TelephonyManager.PHONE_TYPE_NONE):
                phoneType="NONE";
                break;
        }
        boolean Roaming=tm.isNetworkRoaming();

        String [] key = {"IMEI Number : ", "Subscriber ID : ","SIM Serial Number :","Network Country ISO : ","SIM Country ISO :","Software Version :","Voice Mail Number :","Phone Type :","Roaming :"};
        String [] value = {tm.getDeviceId(),tm.getDeviceId() ,tm.getSimSerialNumber(), tm.getNetworkCountryIso(), tm.getSimCountryIso(), tm.getDeviceSoftwareVersion(), tm.getVoiceMailNumber(), phoneType, String.valueOf(Roaming)};

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
