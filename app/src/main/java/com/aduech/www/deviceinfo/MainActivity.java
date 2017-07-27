package com.aduech.www.deviceinfo;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t1 = (TextView) findViewById(R.id.i1);
        TextView t2 = (TextView) findViewById(R.id.i2);
        TextView t3 = (TextView) findViewById(R.id.i3);
        TextView t4 = (TextView) findViewById(R.id.i4);
        TextView t5 = (TextView) findViewById(R.id.i5);
    }


    public void onClick(View v) {
        if (v.getId() == R.id.i1) {
            Intent intent = new Intent(MainActivity.this,
                    Device.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.i2) {
            Intent intent = new Intent(MainActivity.this,
                    Connectivity.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.i3) {
            Intent intent = new Intent(MainActivity.this,
                    SIM.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.i4) {
            Intent intent = new Intent(MainActivity.this,
                    Screen.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.i5) {
            Intent intent = new Intent(MainActivity.this,
                    Memory.class);
            startActivity(intent);
        }
        else if (v.getId() == R.id.i6) {
            Intent intent = new Intent(MainActivity.this,
                    Battery.class);
            startActivity(intent);
        }

    }



}
