package com.testbatch3.appxone.tadawulproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by APPXONE on 1/12/2016.
 */
public class watclist_adapter extends BaseAdapter {

    DecimalFormat format;
    private Context context;
    public static ArrayList<watchlist_model> navDrawerItems111;
    private  String current_value1="",chge_vle="",hign_vl="",low_vle1="";
    String current_vle,change_vle,hign_vle="",low_vle;


    public double greater_not;
    public String greater_str = "";
    public String get_previous_lcdp = "";
    public double get_int_prevoous;
    public double check1;
    public double percent_double;
    private String string_changes_fromat = "", string_percent_fromat = "";

    public watclist_adapter(Context context, ArrayList<watchlist_model> navDrawerItems11){
        this.context = context;
        this.navDrawerItems111 = navDrawerItems11;
    }


    @Override
    public int getViewTypeCount() {
        // menu type count
        return 2;
    }




    @Override
    public int getCount() {
        return navDrawerItems111.size();
    }

    @Override
    public Object getItem(int position) {
        return navDrawerItems111.get(position);
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
            convertView = mInflater.inflate(R.layout.watch_layout, null);
        }




        format = new DecimalFormat("0.00");
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon_updown_watch);

        TextView txtTitleindex = (TextView) convertView.findViewById(R.id.BOP_watch);

        TextView whole1 = (TextView) convertView.findViewById(R.id.float_value_watch1_watch);
        TextView dot1 = (TextView) convertView.findViewById(R.id.float_value_watch);
        TextView  percentage1 = (TextView) convertView.findViewById(R.id.percentage_stock_watch);



        TextView  high_value11 = (TextView) convertView.findViewById(R.id.high_value_stock_watch);
        TextView  low_value11 = (TextView) convertView.findViewById(R.id.low_value_stock_watch);
        TextView  volume_value11 = (TextView) convertView.findViewById(R.id.volume_value_stock_watch);
        TextView  previous_value11 = (TextView) convertView.findViewById(R.id.previous_value_stock_watch);






        greater_str = navDrawerItems111.get(position).getwhole();
        greater_not = Double.parseDouble(greater_str);


        get_previous_lcdp = navDrawerItems111.get(position).getprevious();
        get_int_prevoous = Double.parseDouble(get_previous_lcdp);

        check1 = (double) (greater_not / get_int_prevoous);


        //changes_format = Double.parseDouble(navDrawerItems.get(position).getwhole());

        string_changes_fromat = format.format(check1);


        //  float_1.setText(string_changes_fromat);


        if (check1 < 0.0) {

            dot1.setText(String.valueOf(string_changes_fromat));
            // dot_plus.setText(String.valueOf(check1).charAt(0)+String.valueOf(String.valueOf(check1).charAt(1))+String.valueOf(check1).charAt(2)+String.valueOf(check1).charAt(3));

        } else if (check1 >= 0.0) {
            dot1.setText(String.valueOf("+" + string_changes_fromat));
            // dot_plus.setText(String.valueOf("+"+check1).charAt(0)+String.valueOf(String.valueOf(check1).charAt(1))+String.valueOf(check1).charAt(2)+String.valueOf(check1).charAt(3));
        }

        percent_double = check1 * 100.0;
        string_percent_fromat = format.format(percent_double);
        if (percent_double < 0.0) {

            percentage1.setText(String.valueOf(string_percent_fromat + "%"));
        } else {

            percentage1.setText(String.valueOf("+" + string_percent_fromat + "%"));
        }
        if (check1 < 0.0) {

            imgIcon.setImageResource(R.drawable.red_trangle);
        } else if (check1 >= 0.0) {

            imgIcon.setImageResource(R.drawable.green_trangle);
        }





        txtTitleindex.setText(navDrawerItems111.get(position).getTitle());

        //format.format(check1);
        // changes_format   = Double.parseDouble(navDrawerItems.get(position).getwhole());


        whole1.setText(navDrawerItems111.get(position).getwhole());

        // float_plus.setText(navDrawerItems.get(position).getpercent());


        high_value11.setText(navDrawerItems111.get(position).gethigh());

        low_value11.setText(navDrawerItems111.get(position).getlow());

        volume_value11.setText(navDrawerItems111.get(position).getvolume());


        previous_value11.setText(navDrawerItems111.get(position).getprevious());















        //  imgIcon.setImageResource(navDrawerItems.get(position).getIcon());
//        txtTitleindex.setText(navDrawerItems11.get(position).getTitle());
//
//
//        current_vle=  navDrawerItems11.get(position).getwhole();
//
//        //      current_vle=current_vle.substring(0, 1);
//        change_vle=  navDrawerItems11.get(position).getplusgloat();
////change_vle=change_vle.substring(0,1);
//
//        hign_vle= navDrawerItems11.get(position).gethigh();
//
//        //    hign_vle=hign_vle.substring(0,1);
//
//        low_vle=  navDrawerItems11.get(position).getlow();
//
//        //low_vle=low_vle.substring(0,1);
//
//
//        for (int i=7;i < navDrawerItems11.get(position).getwhole().length();i++)
//        {
//            current_value1+=String.valueOf(current_vle.charAt(i));
//        }
//        for (int ii=6;ii < navDrawerItems11.get(position).getplusgloat().length();ii++)
//        {
//            chge_vle+=String.valueOf(change_vle.charAt(ii));
//        }
//
////        for (int i1i=4;i1i < navDrawerItems.get(position).gethigh().length();i1i++)
////        {
////            hign_vl+=String.valueOf(low_vle.charAt(i1i));
////        }
//
//
//        for (int i13i=3;i13i < navDrawerItems11.get(position).getlow().length();i13i++)
//        {
//            low_vle1+=String.valueOf(low_vle.charAt(i13i));
//        }
//
//        whole1.setText(current_value1);
//        current_value1="";
//        dot1.setText(chge_vle);
//        chge_vle="";
//
//        //  percentage1.setText(navDrawerItems.get(position).getpercent());
//
//        high_value11.setText(hign_vl);
//        hign_vl="";
//        low_value11.setText(low_vle1);
//        low_vle1="";
//        //  volume_value11.setText(navDrawerItems.get(position).getvolume());


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
