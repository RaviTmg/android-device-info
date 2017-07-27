package com.aduech.www.deviceinfo;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Device  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);

        getSupportActionBar().setTitle("Basic Device Info");  // provide compatibility to all the versions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] value = {Build.VERSION.RELEASE, Build.VERSION.INCREMENTAL, String.valueOf(Build.VERSION.SDK_INT), Build.BOARD, Build.BOOTLOADER, Build.BRAND, Build.DISPLAY, Build.FINGERPRINT,
                Build.HARDWARE, Build.HOST, Build.ID, Build.MANUFACTURER, Build.MODEL, Build.PRODUCT, Build.SERIAL, Build.TAGS, String.valueOf(Build.TIME), Build.TYPE,  Build.USER};
        String[] key = {"VERSION.RELEASE : ", "VERSION.INCREMENTAL : ", "VERSION.SDK.NUMBER : ", "BOARD : ", "BOOTLOADER : ", "BRAND :", "DISPLAY :", "FINGERPRINT :", "HARDWARE : ", "HOST : ",
                "ID : ", "MANUFACTURER : ", "MODEL :", "PRODUCT :", "SERIAL : ", "TAGS : ", "TIME : ", "TYPE :  ", "USER : "};

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