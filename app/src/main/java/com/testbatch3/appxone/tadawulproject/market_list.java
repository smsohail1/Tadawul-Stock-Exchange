package com.testbatch3.appxone.tadawulproject;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by APPXONE on 1/5/2016.
 */
public class market_list extends BaseAdapter {

    private Context context;
    private ArrayList<marketlistitem> navDrawerItemss;
    private String current_value1 = "", chge_vle = "", hign_vl = "", low_vle1 = "", percent_market = "", high_value_3 = "";
    String current_vle, change_vle, hign_vle = "", low_vle = "", high_vle = "";
    Double change_value = 0.0, percange_double = 0.0;
    String imga_value = "", img_out_space = "d";

    public market_list(Context context, ArrayList<marketlistitem> navDrawerItems) {
        this.context = context;
        this.navDrawerItemss = navDrawerItems;
    }

    @Override
    public int getCount() {
        return navDrawerItemss.size();
    }

    @Override
    public Object getItem(int position) {
        return navDrawerItemss.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.market_kse, null);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon_updown_market);
        TextView txtTitleindex = (TextView) convertView.findViewById(R.id.kse_index11);

        TextView high_value11 = (TextView) convertView.findViewById(R.id.high_value_stock);
        TextView low_value11 = (TextView) convertView.findViewById(R.id.low_value_stock);


        TextView high_value1_3 = (TextView) convertView.findViewById(R.id.high_value_stock_percentage);


        Typeface tf = Typeface.createFromAsset(this.context.getAssets(), "fonts/AvenirLTStd-Roman.otf");
        txtTitleindex.setTypeface(tf);
        high_value11.setTypeface(tf);
        low_value11.setTypeface(tf);
        high_value1_3.setTypeface(tf);


        change_value = Double.valueOf(navDrawerItemss.get(position).getplusgloat());
        hign_vle = navDrawerItemss.get(position).gethigh1();


//        if (imga_value.equalsIgnoreCase("")) {
//            img_out_space = "N/A";
//        } else {
//
//            for (int i = 4; i < imga_value.length(); i++) {
//                //   if (imga_value != "") {
//
//                img_out_space += imga_value.charAt(i);
//                // }
//            }
//        }


        txtTitleindex.setText(navDrawerItemss.get(position).getTitle());


        current_vle = navDrawerItemss.get(position).getwhole();

        high_value_3 = navDrawerItemss.get(position).gethigh1();

        //      current_vle=current_vle.substring(0, 1);
        change_vle = navDrawerItemss.get(position).getplusgloat();

        img_out_space = "";
        imga_value = navDrawerItemss.get(position).gethigh1();
        imga_value = imga_value.charAt(9) + "" + imga_value.charAt(10) + "" + imga_value.charAt(11) + "" + imga_value.charAt(12);

//        for (int i = imga_value.length(); i >0; i--) {
//                //   if (imga_value != "") {
//
//                img_out_space += imga_value.charAt(i);
//                // }
//            }


        Log.e("value_high", imga_value.length() + "  " + imga_value.charAt(9) + imga_value.charAt(10) + imga_value.charAt(11) + imga_value.charAt(12));
        img_out_space = "";

        if (current_vle.equalsIgnoreCase("")) {
            current_value1 = "N/A";
        } else {
            current_value1 = navDrawerItemss.get(position).getwhole();
        }


        if (hign_vle.equalsIgnoreCase("")) {
            high_vle = "N/A";
        } else {
            for (int i = 4; i < hign_vle.length(); i++) {
//                if (hign_vle != "") {
                high_vle += hign_vle.charAt(i);
                //}
            }


        }
        hign_vl = navDrawerItemss.get(position).getwhole();

        if (change_vle.equalsIgnoreCase("")) {
            low_vle1 = "N/A";
            high_value1_3.setText(high_vle.toString());
            high_vle = "";
        } else {
            low_vle1 = navDrawerItemss.get(position).getplusgloat();
            high_value1_3.setText(high_vle.toString());
            high_vle = "";
//            }
        }

//        percange_double = Double.valueOf(img_out_space);
//
//        if (percange_double >= 0.0) {
//            imgIcon.setImageResource(R.drawable.green_trangle);
//
//
//        } else {
//            imgIcon.setImageResource(R.drawable.red_trangle);
//
//        }


        high_value11.setText(hign_vl);


        //  hign_vl = "";
        low_value11.setText(low_vle1);


        //percantage_market1.setText(percent_market+"%");

        // low_vle1 = "";
        //  volume_value11.setText(navDrawerItems.get(position).getvolume());


        //previous_value11.setText(navDrawerItems.get(position).getprevious());


        // displaying count
        // check whether it set visible or not


//        if(navDrawerItems.get(position).getCounterVisibility()){
//            txtCount.setText(navDrawerItems.get(position).getCount());
//        }else{
//            // hide the counter view
//            txtCount.setVisibility(View.GONE);
//        }

        return convertView;
    }

}