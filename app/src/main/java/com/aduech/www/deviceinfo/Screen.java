package com.aduech.www.deviceinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        getSupportActionBar().setTitle("Screen Info");  // provide compatibility to all the versions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Display Information
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width=dm.widthPixels;
        int height=dm.heightPixels;
        double wi=(double)width/(double)dm.xdpi;
        double hi=(double)height/(double)dm.ydpi;
        double x = Math.pow(wi,2);
        double y = Math.pow(hi,2);
        double screenInches = Math.sqrt(x+y);
        int dpi = (int)(dm.density * 160f);

        String [] key = {"Width :", "Height :", "Screen Inches :", "DPI :", "Pixel :"};
        String [] value = {String.valueOf(wi), String.valueOf(hi), String.valueOf(screenInches), String.valueOf(dpi), width+" X "+height};


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
