package com.aduech.www.deviceinfo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



public class CustomAdapter extends ArrayAdapter<Litem>{

    public CustomAdapter(@NonNull Context context, Litem[] items ) {
        super(context, R.layout.custom_row, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater lf = LayoutInflater.from(getContext());
        View customview = lf.inflate(R.layout.custom_row, parent, false);

        Litem single_item = getItem(position);
        String s1 = (String)single_item.getKey();
        String s2 = (String)single_item.getValue();

        TextView tv1 = (TextView) customview.findViewById(R.id.tv1);
        TextView tv2 = (TextView) customview.findViewById(R.id.tv2);


        tv1.setText(s1);
        tv2.setText(s2);

        return  customview;
    }
}
