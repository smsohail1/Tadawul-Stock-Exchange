package com.testbatch3.appxone.tadawulproject;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by APPXONE on 4/13/2016.
 */
public class Notify_class extends BaseAdapter {

    private Context context1;
    public Context cc;
    public double greater_not1;
    public String greater_str1 = "";
    public String get_previous_lcdp = "";
    public double get_int_prevoous;
    public double check1;
    DecimalFormat format;
    public double percent_double;
    public double changes_format;
    private String string_changes_fromat = "", string_percent_fromat = "", getpercent = "";
    public static ArrayList<notify_model> navDrawerItems111;

    // boolean isErrorOccured = false;

    //  public DataBaseManager dbManager;
    // GamesFragment gmm;
    DataBaseManager lk;

    String symbol = "", change = "", high = "", low = "", prevous = "", volume = "", postion = "", float_value = "";
    int icon_updown;
    public static String query;
    boolean check_unchecked = true;
    public ImageView watchlist_btn;
    public int drawableId4;
    Cursor c1;
    String[] select_item = new String[30];
    int ip;
    boolean rrr;
    boolean type_check;
    int ww;
    Cursor c22;
    Cursor c55;
    String[] ind = new String[700];

    Spinner greater_lesser;
    TextView values;
    ImageView ok_button;
    boolean check_bool;
    int yyy;
    Cursor c33;
    ArrayList<String> fav_list;
    Cursor c;
    Dialog dialog_custom;
    int icon;
    LayoutInflater inflator;

    public Notify_class(Context context, ArrayList<notify_model> navDrawerItems) {
        this.context1 = context;
        this.navDrawerItems111 = navDrawerItems;
        //  fav_list = new ArrayList<String>();
        Log.e("cunstructor", "cunstructor");
//ww=0;
//         rrr = true;
//yyy=0;
//        check_bool=true;


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

//
//    public class ViewHolder {
//        public ImageView im;
//    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        //ViewHolder viewHolder = null;

        //viewHolder = null;
        if (convertView == null) {
            //  gmm = new GamesFragment();
            // lk = new DataBaseManager(context1);
            LayoutInflater mInflater = (LayoutInflater)
                    context1.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.notify_row_layout, null);

        }
//            Toast t=Toast.makeText(context1,"if",Toast.LENGTH_SHORT);
//            t.show();

        // viewHolder = new ViewHolder();

        //viewHolder.im = (ImageView) convertView.findViewById(R.id.watchlist);


        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon_updown);
        TextView txtTitleindex = (TextView) convertView.findViewById(R.id.BOP);


        TextView float_1 = (TextView) convertView.findViewById(R.id.float_value1);
         TextView dot_plus = (TextView) convertView.findViewById(R.id.float_value);


         TextView percentage = (TextView) convertView.findViewById(R.id.percentage_stock);


        TextView high_value = (TextView) convertView.findViewById(R.id.high_value_stock);
        TextView low_value = (TextView) convertView.findViewById(R.id.low_value_stock);
        TextView volume_value = (TextView) convertView.findViewById(R.id.volume_value_stock);
        TextView previous_value = (TextView) convertView.findViewById(R.id.previous_value_stock);


        symbol = navDrawerItems111.get(position).getTitle();

        float_value = navDrawerItems111.get(position).getchanges();
        icon = navDrawerItems111.get(position).getimg();
        high = navDrawerItems111.get(position).gethigh();
        low = navDrawerItems111.get(position).getlow();
        volume = navDrawerItems111.get(position).getvolume();
        prevous = navDrawerItems111.get(position).getprevious();
        getpercent = navDrawerItems111.get(position).getpercent();


        txtTitleindex.setText(symbol.toString());
        dot_plus.setText(float_value.toString());
        imgIcon.setImageResource(icon);
        float_1.setText(navDrawerItems111.get(position).getCurrent_web());


        percentage.setText(getpercent.toString());
        high_value.setText(high.toString());
        low_value.setText(low.toString());
        volume_value.setText(volume.toString());
        previous_value.setText(prevous.toString());


        //  viewHolder.im.setTag(symbol+","+change+","+high+","+low+","+volume+","+prevous);
//            Log.d("Tag", "getView " + symbol + "," + change + "," + high + "," + low + "," + volume + "," + prevous);


        // convertView.setTag(viewHolder);

//            dbManager = new DataBaseManager(this.context1);
//
//            Log.e("before", "sds1aaa");
//            try {
//                dbManager.createDataBase();
//
//
//
//                Log.e("try111", "sds1aaa");
//            } catch (Exception e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//                isErrorOccured = true;
//                Log.e("catch", "sds1");
//
//            }

//            inflator = (LayoutInflater) context1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//            View view = inflator.inflate(R.layout.popup_notification, null);
//
//            greater_lesser = (Spinner) view.findViewById(R.id.greater_lesser);
//
//            values = (TextView) view.findViewById(R.id.values);
//            ok_button = (ImageView) view.findViewById(R.id.ok_button);
//
//
//            dialog_custom = new Dialog(this.context1);
//            dialog_custom.setCancelable(true);
//            dialog_custom.setContentView(view);


//        else {
////            for(int iii=0;iii<navDrawerItems11.size();iii++)
////            {
////                ind[iii]="1";
////
////
////            }
//            viewHolder = (ViewHolder) convertView.getTag();
//            Log.e("arr", "else");
//            // viewHolder = (ViewHolder) convertView.getTag();
//        }


//           Toast t=Toast.makeText(context1,"else",Toast.LENGTH_SHORT);
//                    t.show();

//        format = new DecimalFormat("0.00");
//        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon_updown);
//        TextView txtTitleindex = (TextView) convertView.findViewById(R.id.BOP);

//
//        TextView float_1 = (TextView) convertView.findViewById(R.id.float_value1);
//        final TextView dot_plus = (TextView) convertView.findViewById(R.id.float_value);
//
//
//        final TextView percentage = (TextView) convertView.findViewById(R.id.percentage_stock);
//
//
//        TextView high_value = (TextView) convertView.findViewById(R.id.high_value_stock);
//        TextView low_value = (TextView) convertView.findViewById(R.id.low_value_stock);
//        TextView volume_value = (TextView) convertView.findViewById(R.id.volume_value_stock);
//        TextView previous_value = (TextView) convertView.findViewById(R.id.previous_value_stock);

//        Typeface tf = Typeface.createFromAsset(this.context1.getAssets(), "fonts/AvenirLTStd-Roman.otf");
//        txtTitleindex.setTypeface(tf);
//        float_1.setTypeface(tf);
//        dot_plus.setTypeface(tf);
//        percentage.setTypeface(tf);
//
//        high_value.setTypeface(tf);
//        low_value.setTypeface(tf);
//        volume_value.setTypeface(tf);
//        previous_value.setTypeface(tf);

//
//        symbol = navDrawerItems111.get(position).getTitle();
//        change = navDrawerItems111.get(position).getwhole();
//        high = navDrawerItems111.get(position).gethigh();
//        low = navDrawerItems111.get(position).getlow();
//        volume = navDrawerItems111.get(position).getvolume();
//        prevous = navDrawerItems111.get(position).getprevious();
//        postion = navDrawerItems111.get(position).getpos();


//        cc = this.context1;
//
//
//        format = new DecimalFormat("0.00");

//
//        greater_str1 = navDrawerItems111.get(position).getwhole();
//        greater_not1 = Double.parseDouble(greater_str1);
//
//
//        get_previous_lcdp = navDrawerItems111.get(position).getprevious();
//        get_int_prevoous = Double.parseDouble(get_previous_lcdp);
//
//
//        check1 = (double) (greater_not1 / get_int_prevoous);
//
//
//
//        string_changes_fromat = format.format(check1);
//
//        if (check1 < 0.0) {
//
//            dot_plus.setText(String.valueOf(string_changes_fromat));
//
//        } else if (check1 >= 0.0) {
//            dot_plus.setText(String.valueOf("+" + string_changes_fromat));
//        }
//
//        percent_double = check1 * 100.0;
//        string_percent_fromat = format.format(percent_double);
//        if (percent_double < 0.0) {
//
//
//            percentage.setText(String.valueOf(string_percent_fromat + "%"));
//        } else {
//
//            percentage.setText(String.valueOf("+" + string_percent_fromat + "%"));
//        }
//        if (check1 < 0.0) {
//
//            imgIcon.setImageResource(R.drawable.red_trangle);
//        } else if (check1 >= 0.0) {
//
//            imgIcon.setImageResource(R.drawable.green_trangle);
//        }


//        txtTitleindex.setText(navDrawerItems111.get(position).getTitle());
//
//     //   Toast t=Toast.makeText(context1,navDrawerItems111.get(position).gethigh(),Toast.LENGTH_SHORT);
//       //            t.show();
//       // float_1.setText(navDrawerItems111.get(position).getwhole());
//
//
//
//        high_value.setText(navDrawerItems111.get(position).gethigh());
//
//        low_value.setText(navDrawerItems111.get(position).getlow());
//
//        volume_value.setText(navDrawerItems111.get(position).getvolume());
//
//
//        previous_value.setText(navDrawerItems111.get(position).getprevious());
//        Log.e("high", navDrawerItems111.get(position).gethigh());


        return convertView;
    }

}
