package com.testbatch3.appxone.tadawulproject;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by APPXONE on 1/5/2016.
 */
public class market_list extends BaseAdapter {

    private Context context;
    private ArrayList<marketlistitem> navDrawerItemss;
    private String current_value1 = "", chge_vle = "", hign_vl = "", low_vle1 = "", percent_market = "", high_value_3 = "";
    String current_vle, change_vle, hign_vle = "", low_vle = "", high_vle = "";
    double change_value = 0.0,percange_double=0.0;

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


        //TextView percantage_market1 = (TextView) convertView.findViewById(R.id.percantage_market);
        // TextView whole1 = (TextView) convertView.findViewById(R.id.whole);


        TextView high_value11 = (TextView) convertView.findViewById(R.id.high_value_stock);
        TextView low_value11 = (TextView) convertView.findViewById(R.id.low_value_stock);

        //    TextView change_market = (TextView) convertView.findViewById(R.id.change_market);

        TextView high_value1_3 = (TextView) convertView.findViewById(R.id.high_value_stock_percentage);


        Typeface tf = Typeface.createFromAsset(this.context.getAssets(), "fonts/AvenirLTStd-Roman.otf");
        txtTitleindex.setTypeface(tf);
        //whole1.setTypeface(tf);
        high_value11.setTypeface(tf);
        low_value11.setTypeface(tf);
        //percantage_market1.setTypeface(tf);
        // change_market.setTypeface(tf);
        high_value1_3.setTypeface(tf);


        //  TextView  volume_value11 = (TextView) convertView.findViewById(R.id.volume_value1);
        // TextView  previous_value11 = (TextView) convertView.findViewById(R.id.previous_value1);


        //  imgIcon.setImageResource(navDrawerItems.get(position).getIcon());

        change_value= Double.valueOf(navDrawerItemss.get(position).getplusgloat());
        hign_vle=  navDrawerItemss.get(position).gethigh1();
      //  percange_double = Double.valueOf(navDrawerItemss.get(position).gethigh1());



        txtTitleindex.setText(navDrawerItemss.get(position).getTitle());


        current_vle = navDrawerItemss.get(position).getwhole();
        high_value_3 = navDrawerItemss.get(position).gethigh1();
        //      current_vle=current_vle.substring(0, 1);
        change_vle = navDrawerItemss.get(position).getplusgloat();
//change_vle=change_vle.substring(0,1);



        //    hign_vle=hign_vle.substring(0,1);


        //
        //  low_vle = navDrawerItemss.get(position).getlow();


//        percent_market="";
//        percent_market = navDrawerItemss.get(position).getpercent11();

        //low_vle=low_vle.substring(0,1);

        if (current_vle.equalsIgnoreCase("")) {
            current_value1 = "N/A";
        } else {
//            for (int i = 7; i < navDrawerItemss.get(position).getwhole().length(); i++) {
//                current_value1 += String.valueOf(current_vle.charAt(i));
            current_value1 = navDrawerItemss.get(position).getwhole();
//            }
        }


        if (high_value_3.equalsIgnoreCase("")) {
            high_vle = "N/A";
        } else {
//            for (int i = 7; i < navDrawerItemss.get(position).getwhole().length(); i++) {
//                current_value1 += String.valueOf(current_vle.charAt(i));
            high_vle = navDrawerItemss.get(position).gethigh1();
//            }
        }


//        if (change_vle.equalsIgnoreCase("")) {
//            chge_vle = "N/A";
//        }
//        else if(change_vle.equalsIgnoreCase("Change"))
//        {
//            chge_vle="N/A";
//        }
//        else {
//            for (int ii = 6; ii < navDrawerItemss.get(position).getplusgloat().length(); ii++) {
//                chge_vle += String.valueOf(change_vle.charAt(ii));
//            }
//        }
        if (hign_vle.equalsIgnoreCase("")) {
            hign_vl = "N/A";
        } else {
//            for (int i1i = 4; i1i < navDrawerItemss.get(position).gethigh1().length(); i1i++) {
//                hign_vl += String.valueOf(hign_vle.charAt(i1i));
//            }
            hign_vl = navDrawerItemss.get(position).getwhole();
        }

        if (change_vle.equalsIgnoreCase("")) {
            low_vle1 = "N/A";
        } else {
//            for (int i13i = 3; i13i < navDrawerItemss.get(position).getlow().length(); i13i++) {
//                low_vle1 += String.valueOf(low_vle.charAt(i13i));
            low_vle1 = navDrawerItemss.get(position).getplusgloat();
//            }
        }

//        if (navDrawerItemss.get(position).getpercent11().equalsIgnoreCase("")) {
//            percent_market = "N/A";
//        } else {
//            percent_market = navDrawerItemss.get(position).getpercent11();
//        }
//        whole1.setText(current_value1);
        // current_value1 = "";

        //  dot1.setText(chge_vle);
        //chge_vle = "";

        //  percentage1.setText(navDrawerItems.get(position).getpercent());

//        percange_double= Double.valueOf(hign_vle);
//        if(percange_double>=0.0)
//        {
          imgIcon.setImageResource(R.drawable.green_trangle);
//
//
//        }
//        else {
//            imgIcon.setImageResource(R.drawable.red_trangle);
//
//        }

        high_value11.setText(hign_vl);
        //  hign_vl = "";
        low_value11.setText(low_vle1);
        //percantage_market1.setText(percent_market+"%");
        high_value1_3.setText(high_vle.toString());
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