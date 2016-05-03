package com.testbatch3.appxone.tadawulproject;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by APPXONE on 1/5/2016.
 */
public class stock_list extends BaseAdapter {

    private Activity context1;
    public Context cc;
    public double greater_not1;
    public String greater_str1 = "";
    public String get_previous_lcdp = "";
    public double get_int_prevoous;
    public double check1;
    DecimalFormat format;
    public double percent_double;
    public double changes_format;
    private String string_changes_fromat = "", string_percent_fromat = "";
    public static ArrayList<stocklistitem> navDrawerItems11;

    int status;
    // boolean isErrorOccured = false;

    //  public DataBaseManager dbManager;
    GamesFragment gmm;
    DataBaseManager lk;

    String symbol = "", change = "", high = "", low = "", prevous = "", volume = "", postion = "", current_web = "";
    int icon_updown;
    public static String query, query_notify, query_notify_delete;
    boolean check_unchecked = true;
    public ImageView watchlist_btn;
    public int drawableId4;
    Cursor c1;
    String[] select_item = new String[30];
    int ip;
    boolean rrr;
    boolean type_check, type_check_update;
    int ww;
    Cursor c22;
    Cursor c55;
    String[] ind = new String[700];

    boolean check_bool;
    int yyy;
    Cursor c33;
    ArrayList<String> fav_list, fav_notiflist;
    Cursor c, c_notify;

    LayoutInflater inflator;

    public Spinner greater_lesser;
    EditText values;
    ImageView ok_button, delete_button;
    String user_value;
    Dialog dialog_custom;
    TextView notify_header;
    String collection = "";
    String matched;
    View view;

    public stock_list(Activity context, ArrayList<stocklistitem> navDrawerItems) {
        this.context1 = context;
        this.navDrawerItems11 = navDrawerItems;
        fav_list = new ArrayList<String>();
        fav_notiflist = new ArrayList<String>();
        Log.e("cunstructor", "cunstructor");
//ww=0;
//         rrr = true;
//yyy=0;
//        check_bool=true;


    }

    @Override
    public int getCount() {
        return navDrawerItems11.size();
    }

    @Override
    public Object getItem(int position) {
        return navDrawerItems11.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public class ViewHolder {
        public ImageView im, NOTIFY_IMG;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;

        //viewHolder = null;
        if (convertView == null) {
            gmm = new GamesFragment();
            lk = new DataBaseManager(this.context1);
            LayoutInflater mInflater = (LayoutInflater)
                    context1.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.stock_kse, null);
            viewHolder = new ViewHolder();
            viewHolder.im = (ImageView) convertView.findViewById(R.id.watchlist);
            viewHolder.NOTIFY_IMG = (ImageView) convertView.findViewById(R.id.notifyme);


//            symbol = navDrawerItems11.get(position).getTitle();
//            change = navDrawerItems11.get(position).getwhole();
//            high = navDrawerItems11.get(position).gethigh();
//            low = navDrawerItems11.get(position).getlow();
//            volume = navDrawerItems11.get(position).getvolume();
//            prevous = navDrawerItems11.get(position).getprevious();
//            viewHolder.im.setTag(symbol+","+change+","+high+","+low+","+volume+","+prevous);
//            Log.d("Tag", "getView " + symbol + "," + change + "," + high + "," + low + "," + volume + "," + prevous);


            convertView.setTag(viewHolder);

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

        } else {
//            for(int iii=0;iii<navDrawerItems11.size();iii++)
//            {
//                ind[iii]="1";
//
//
//            }
            viewHolder = (ViewHolder) convertView.getTag();
        }

        inflator = (LayoutInflater) context1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflator.inflate(R.layout.popup_notification, null);

        greater_lesser = (Spinner) view.findViewById(R.id.greater_lesser);
        notify_header = (TextView) view.findViewById(R.id.notify_header);
        values = (EditText) view.findViewById(R.id.values);
        ok_button = (ImageView) view.findViewById(R.id.ok_button);
        delete_button = (ImageView) view.findViewById(R.id.delete_button);
        //  content = (RelativeLayout) view.findViewById(R.id.content1);


        dialog_custom = new Dialog(this.context1);
        dialog_custom.setCancelable(true);
        dialog_custom.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_custom.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_custom.setContentView(view);

        addItemsOnSpinner2();

        greater_lesser.setSelection(0);

        addListenerOnSpinnerItemSelection();

        Log.e("arr", "else");
        // viewHolder = (ViewHolder) convertView.getTag();

        //notify_header = (TextView) view.findViewById(R.id.notify_header);

        format = new DecimalFormat("0.00");
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon_updown);
        TextView txtTitleindex = (TextView) convertView.findViewById(R.id.BOP);

        ImageView share_stock = (ImageView) convertView.findViewById(R.id.info);

        TextView float_1 = (TextView) convertView.findViewById(R.id.float_value1);
        final TextView dot_plus = (TextView) convertView.findViewById(R.id.float_value);

        //TextView  float_plus = (TextView) convertView.findViewById(R.id.float_plus);

        final TextView percentage = (TextView) convertView.findViewById(R.id.percentage_stock);
        //   Button notify= (Button) convertView.findViewById(R.id.notify);

        TextView high_value = (TextView) convertView.findViewById(R.id.high_value_stock);
        TextView low_value = (TextView) convertView.findViewById(R.id.low_value_stock);
        TextView volume_value = (TextView) convertView.findViewById(R.id.volume_value_stock);
        TextView previous_value = (TextView) convertView.findViewById(R.id.previous_value_stock);

        Typeface tf = Typeface.createFromAsset(this.context1.getAssets(), "fonts/AvenirLTStd-Roman.otf");
        txtTitleindex.setTypeface(tf);
        float_1.setTypeface(tf);
        dot_plus.setTypeface(tf);
        percentage.setTypeface(tf);
        notify_header.setTypeface(tf);

        high_value.setTypeface(tf);
        low_value.setTypeface(tf);
        volume_value.setTypeface(tf);
        previous_value.setTypeface(tf);


        symbol = navDrawerItems11.get(position).getTitle();
        change = navDrawerItems11.get(position).getwhole();
        high = navDrawerItems11.get(position).gethigh();
        low = navDrawerItems11.get(position).getlow();
        volume = navDrawerItems11.get(position).getvolume();
        prevous = navDrawerItems11.get(position).getprevious();
        postion = navDrawerItems11.get(position).getpos();
        current_web = navDrawerItems11.get(position).getCurrent();

        viewHolder.im.setTag(symbol + "!" + change + "!" + high + "!" + low + "!" + volume + "!" + prevous + "!" + postion);
        Log.d("Tag", "getView " + symbol + "^" + change + "^" + high + "^" + low + "^" + volume + "^" + prevous + "^" + postion);


        viewHolder.NOTIFY_IMG.setTag(symbol + "!" + change + "!" + high + "!" + low + "!" + volume + "!" + prevous + "!" + postion + "!" + current_web);
        Log.d("Tag", "getView " + symbol + "^" + change + "^" + high + "^" + low + "^" + volume + "^" + prevous + "^" + postion + "!" + current_web);


        //viewHolder.im.setTag(position);


//
//        if(navDrawerItems11.contains(position))
//            viewHolder.im.setImageResource(R.drawable.watching_button);
//        else
//            viewHolder.im.setImageResource(R.drawable.watch_button_status);


//        stocklistitem stocklistitem1 = navDrawerItems11.get(position);

//            change = navDrawerItems11.get(position).getwhole();
//            high = navDrawerItems11.get(position).gethigh();
//            low = navDrawerItems11.get(position).getlow();
//            volume = navDrawerItems11.get(position).getvolume();
//            prevous = navDrawerItems11.get(position).getprevious();

//            query = "SELECT * FROM '" + AppSettings.DATABASE_TABLE + "'";
//            Log.e("SELECT QUERY", query);

        //  Cursor c = stock_list.dbManager.selectQuery(query);

        //  Cursor rr=  dbManager.selectQuery(query);

//            String companyname12=    c55.getString(c55
//                    .getColumnIndex(AppSettings.KEY_NAME)).toString();

//        if (!isErrorOccured) {
//            Log.e("error ocore true", "sds1");
//
//            symbol = navDrawerItems11.get(position).getTitle();
//                if (c55 != null && c55.moveToFirst() && c55.getCount() > 0) {
//                     do {
//
//                    String companyname1 = c55.getString(c55
//                            .getColumnIndex(AppSettings.KEY_NAME)).toString();
//
//                    if (companyname1.equalsIgnoreCase(symbol)) {
//                        viewHolder.im.setImageResource(R.drawable.watching_button);
////break;
//                    } else {
//                        viewHolder.im.setImageResource(R.drawable.watch_button_status);
////break;
//                    }
//                  //  c55.moveToNext();
//                      } while (c55.moveToNext());
//                }
//
//            }

//        for(int tt=0;tt<navDrawerItems11.size();tt++) {
//            if (ind[position]==position)
//            {
//                viewHolder.im.setImageResource(R.drawable.watching_button);
//        }
//        else
//            {
//                viewHolder.im.setImageResource(R.drawable.watch_button_status);
//            }
//        for(int iu=0;iu<navDrawerItems11.size();iu++) {


//if(check_bool) {
        //  int uuu=0;
        //  for (int iu = 0; iu < navDrawerItems11.size(); iu++) {

        // viewHolder.im.setTag(Integer.toString(position));


        // Object objectItem = getItem(position);
        //  objectItem.


        symbol = navDrawerItems11.get(position).getTitle();

//        if (ind[position] == symbol.toString()) {
//
//            viewHolder.im.setImageResource(R.drawable.watching_button);
//        } else if (ind[position] == null) {
//            viewHolder.im.setImageResource(R.drawable.watch_button_status);
//            // uuu=1;
//        }
        Log.e("arr", symbol + "");


//        String q = "SELECT * FROM video_record";
//
//        Cursor c = db.selectQuery(q);


        viewHolder.im.setImageResource(R.drawable.icon_watch_plus_normal_paid);
        viewHolder.NOTIFY_IMG.setImageResource(R.drawable.notify_normal_paid);
        fav_list.clear();
        query = "SELECT * FROM '" + AppSettings.DATABASE_TABLE + "'";
        Log.e("SELECT QUERY", query);

        c = lk.selectQuery(query);

        // for traversing
        try {
            if (c.getCount() > 0) {
                if (c.moveToFirst()) {
                    do {
                        // int i = c33.getInt(0);

                        String it = c.getString(c.getColumnIndex(AppSettings.KEY_NAME));
                        fav_list.add(it);

                    } while (c.moveToNext());
                }
            }
        } finally {
            c.close();
        }
//        lk.insert_update(query);

        //fetchDataBase();
//
        for (int i = 0; i < fav_list.size(); i++) {
            if (fav_list.get(i).equalsIgnoreCase(navDrawerItems11.get(position).getTitle())) {

                viewHolder.im.setImageResource(R.drawable.watch_pressed_paid);
                // viewHolder.im.setImageResource(R.drawable.watching_button);
            }
//            else {
//               viewHolder.im.setImageResource(R.drawable.watch_button_status);
//            }

        }

//for notify
        fav_notiflist.clear();
        query_notify = "SELECT * FROM '" + AppSettings.DATABASE_TABLE_NOTIFY + "'";
        Log.e("SELECT QUERY", query_notify);

        c_notify = lk.selectQuery(query_notify);

        // for traversing WATCHLIST
        try {
            if (c_notify.getCount() > 0) {
                if (c_notify.moveToFirst()) {
                    do {
                        // int i = c33.getInt(0);

                        String it = c_notify.getString(c_notify.getColumnIndex(AppSettings.KEY_NAME));
                        fav_notiflist.add(it);

                    } while (c_notify.moveToNext());
                }
            }
        } finally {
            c_notify.close();
        }

        for (int i = 0; i < fav_notiflist.size(); i++) {
            if (fav_notiflist.get(i).equalsIgnoreCase(navDrawerItems11.get(position).getTitle())) {

                viewHolder.NOTIFY_IMG.setImageResource(R.drawable.notifying_normal_paid);
            }

        }


        final View finalConvertView = convertView;
        viewHolder.NOTIFY_IMG.setOnClickListener(new View.OnClickListener() {
                                                     @Override
                                                     public void onClick(final View v1) {

                                                         //   values.requestFocus();
                                                         //  hideSoftKeyboard();
//                                                         if(values.hasFocus())
//                                                         {
//                                                             Log.e("shown","shown");
//
//
//                                                         }
//                                                         else
//                                                         {
//
//                                                             Log.e("not shown"," not shown");
//                                                         }

                                                         String[] as = ((String) v1.getTag()).split("!");
                                                         symbol = as[0];
                                                         change = as[1];
                                                         high = as[2];
                                                         low = as[3];
                                                         volume = as[4];
                                                         prevous = as[5];
                                                         postion = as[6];
                                                         current_web = as[7];
//select
                                                         query_notify = "SELECT * FROM '" + AppSettings.DATABASE_TABLE_NOTIFY + "'";
                                                         // for update
                                                         //   query_notify = "SELECT * FROM '" + AppSettings.DATABASE_TABLE_NOTIFY + "'"+" WHERE ";
                                                         Log.e("SELECT QUERY", query_notify);

                                                         c_notify = lk.selectQuery(query_notify);
                                                         if (c_notify != null && c_notify.moveToFirst()) {
                                                             Log.e("if ", "database");

                                                             try {
                                                                 do {


                                                                     String companyname = c_notify.getString(c_notify
                                                                             .getColumnIndex(AppSettings.KEY_NAME)).toString();
                                                                     String gtr_lsr_edittext = c_notify.getString(c_notify
                                                                             .getColumnIndex(AppSettings.KEY_GTR_LSR)).toString();

                                                                     String current_edittext = c_notify.getString(c_notify
                                                                             .getColumnIndex(AppSettings.KEY_CURRENT)).toString();

                                                                     if (companyname.equalsIgnoreCase(symbol)) {
                                                                         if (gtr_lsr_edittext.equalsIgnoreCase("Greater than")) {
                                                                             greater_lesser.setSelection(0);
                                                                         } else if (gtr_lsr_edittext.equalsIgnoreCase("Less than")) {
                                                                             greater_lesser.setSelection(1);
                                                                         }
                                                                         //   ((ImageView) v1).setImageResource(R.drawable.notify_normal_home_stk);

                                                                         values.setText(current_edittext.toString());
//                                                                         query_notify = "DELETE FROM " + AppSettings.DATABASE_TABLE_NOTIFY + " WHERE " + AppSettings.KEY_NAME + " = " + "'" + companyname + "'";
//                                                                         Log.e("query", "" + query_notify);
//                                                                         lk.insert_update(query_notify);
//                                                                         type_check_notify = false;
                                                                         break;
                                                                     } else {
                                                                         greater_lesser.setSelection(0);
                                                                         values.setText("");

                                                                         // type_check_notify = true;

                                                                     }


                                                                 } while (c_notify.moveToNext());
                                                             } finally {
                                                                 c_notify.close();
                                                             }
                                                         } else {
                                                             Log.e("else ", "else null");
                                                             values.setText("");
                                                         }


                                                         dialog_custom.show();


                                                         ok_button.setOnClickListener(new View.OnClickListener() {
                                                             @Override
                                                             public void onClick(View v) {

                                                                 //  context1.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

//                                                                 if(values.hasFocus())
//                                                                 {
//                                                                     Log.e("shown","shown");
//
//
//                                                                 }
//                                                                 else
//                                                                 {
//
//                                                                     Log.e("not shown"," not shown");
//                                                                 }
                                                                 //  hideSoftKeyboard();

                                                                 collection = "";
                                                                 String length = values.getText().toString();
                                                                 for (int i = 0; i < length.length(); i++) {
                                                                     if (length.charAt(i) == '.') {


                                                                         collection += length.charAt(i);
                                                                     }
                                                                 }


                                                                 if (values.getText().toString().equalsIgnoreCase("") || CustomOnItemSelectedListener.values1 == "") {
                                                                     //View view = context1.getCurrentFocus();
                                                                     //if (view != null) {
//                                                                         InputMethodManager imm = (InputMethodManager) context1.getSystemService(Context.INPUT_METHOD_SERVICE);
//                                                                         imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//                                                                   //  }

                                                                     //  Snackbar.make()
                                                                     Snackbar.make(context1.findViewById(android.R.id.content), "Please Enter Some Value", Snackbar.LENGTH_LONG)
                                                                             // .setAction("Undo", mOnClickListener)
                                                                             .setActionTextColor(Color.RED)
                                                                             .show();
                                                                     // hideSoftKeyboard();
                                                                     //    Toast toast = Toast.makeText(context1, "Please Enter Some Value", Toast.LENGTH_SHORT);
                                                                     //  toast.show();
                                                                 } else if (length.equalsIgnoreCase(".")) {

                                                                     //View view = context1.getCurrentFocus();
                                                                     //  if (view != null) {
//                                                                         InputMethodManager imm = (InputMethodManager) context1.getSystemService(Context.INPUT_METHOD_SERVICE);
//                                                                         imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//                                                                   //  }
                                                                     Snackbar.make(context1.findViewById(android.R.id.content), "Invalid Digit", Snackbar.LENGTH_LONG)
                                                                             // .setAction("Undo", mOnClickListener)
                                                                             .setActionTextColor(Color.RED)
                                                                             .show();
                                                                     //  hideSoftKeyboard();
//                                                                    Toast toast = Toast.makeText(context1, "Invalid Digit", Toast.LENGTH_SHORT);
//                                                                     toast.show();
                                                                 } else if (collection.length() > 1) {

                                                                     //View view = context1.getCurrentFocus();
//                                                                    // if (view != null) {
//                                                                         InputMethodManager imm = (InputMethodManager) context1.getSystemService(Context.INPUT_METHOD_SERVICE);
//                                                                         imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//                                                                    // }
                                                                     Snackbar.make(context1.findViewById(android.R.id.content), "Invalid Digit", Snackbar.LENGTH_LONG)
                                                                             // .setAction("Undo", mOnClickListener)
                                                                             .setActionTextColor(Color.RED)
                                                                             .show();
                                                                     //  hideSoftKeyboard();
//                                                                     Toast toast = Toast.makeText(context1, "Invalid Digit", Toast.LENGTH_SHORT);
//                                                                     toast.show();
                                                                 } else {


                                                                     String selected_item = CustomOnItemSelectedListener.values1;

                                                                     user_value = values.getText().toString();

                                                                     if (!gmm.isErrorOccured) {
                                                                         Log.e("error ocore true", "sds1");


                                                                         query_notify = "SELECT * FROM '" + AppSettings.DATABASE_TABLE_NOTIFY + "'";
                                                                         Log.e("SELECT QUERY", query_notify);

                                                                         c_notify = lk.selectQuery(query_notify);
                                                                         if (c_notify != null && c_notify.moveToFirst()) {
                                                                             try {
                                                                                 do {
//                                                                                     symbol = as[0];
//                                                                                     change = as[1];
//                                                                                     high = as[2];
//                                                                                     low = as[3];
//                                                                                     volume = as[4];
//                                                                                     prevous = as[5];
//                                                                                     postion = as[6];
//                                                                                     current_web = as[7];

                                                                                     String companyname = c_notify.getString(c_notify
                                                                                             .getColumnIndex(AppSettings.KEY_NAME)).toString();

                                                                                     //String POS = c1.getString(c1
                                                                                     //       .getColumnIndex(AppSettings.KEY_POSITION));
//
                                                                                     if (companyname.equalsIgnoreCase(symbol)) {

                                                                                         ((ImageView) v1).setImageResource(R.drawable.notifying_normal_paid);
                                                                                         //  ((ImageView) v1).setImageResource(R.drawable.notify_normal_home_stk);
                                                                                         status = 0;
                                                                                         //query update
                                                                                         query_notify = "UPDATE " + AppSettings.DATABASE_TABLE_NOTIFY + " SET " + AppSettings.KEY_GTR_LSR + " = " + "'" + selected_item + "'" +
                                                                                                 "," + AppSettings.KEY_CURRENT + " = " + "'" + user_value + "'" + "," + AppSettings.KEY_bookmark + " = " + status
                                                                                                 + " WHERE " + AppSettings.KEY_NAME + " = " + "'" + symbol + "'";
                                                                                         Log.e("query_update", "" + query_notify);
                                                                                         lk.insert_update(query_notify);

//                                                                                                 ","+AppSettings.KEY_CHANGES+ " = "+change+","+AppSettings.KEY_RATIO+ " = "+"ratio"+
//                                                                                                 ","+AppSettings.KEY_ICON+ " = "+R.drawable.icon_menu+","+AppSettings.KEY_PERCANTAGE+ " = "+"56.4%"+
//                                                                                                 ","+AppSettings.KEY_HIGH+ " = "+high+","+AppSettings.KEY_LOW+ " = "+low+
//                                                                                                 ","+AppSettings.KEY_VOLUME+ " = "+volume

                                                                                         //   hideSoftKeyboard();
//                                                query_notify = "DELETE FROM " + AppSettings.DATABASE_TABLE_NOTIFY + " WHERE " + AppSettings.KEY_NAME + " = " + "'" + companyname + "'";
//                                                Log.e("query", "" + query_notify);
//                                                lk.insert_update(query_notify);
//                                                type_check_notify = false;

                                                                                         type_check_update = false;
                                                                                         break;
                                                                                     } else {
                                                                                         type_check_update = true;

                                                                                     }


                                                                                     //else {
//                                                type_check_notify = true;
//
//                                            }

                                                                                 }
                                                                                 while (c_notify.moveToNext());
                                                                             } finally {
                                                                                 c_notify.close();
                                                                             }


                                                                             if (type_check_update) {
                                                                                 status = 0;
                                                                                 //insert
                                                                                 ((ImageView) v1).setImageResource(R.drawable.notifying_normal_paid);
                                                                                 query_notify = "INSERT INTO \"" + AppSettings.DATABASE_TABLE_NOTIFY
                                                                                         + "\" ( '" + AppSettings.KEY_NAME + "','" + AppSettings.KEY_CHANGES + "','" + AppSettings.KEY_RATIO + "','"
                                                                                         + AppSettings.KEY_ICON + "','" + AppSettings.KEY_PERCANTAGE + "','" + AppSettings.KEY_HIGH + "','" + AppSettings.KEY_LOW + "','" + AppSettings.KEY_VOLUME + "','" + AppSettings.KEY_PREVIOUS + "','" + AppSettings.KEY_bookmark + "','" + AppSettings.KEY_POSITION + "','" + AppSettings.KEY_GTR_LSR + "','" + AppSettings.KEY_CURRENT + "','" + AppSettings.KEY_CURRENT_WEB + "') VALUES (" + "'" + symbol + "'" + "," + "'" + change + "'" + "," + "'" + "ratio" + "'" + "," + R.drawable.icon_menu + "," + "'" + "56.4%" + "'" + "," + "'" + high + "'" + "," + "'" + low + "'" + "," + "'" + volume + "'" + "," + "'" + prevous + "'" + "," + status + "," + "'" + postion + "'" + "," + "'" + selected_item + "'" + "," + "'" + user_value + "'" + "," + "'" + current_web + "'" + ")";


                                                                                 Log.e("query", "" + query_notify);
                                                                                 lk.insert_update(query_notify);
                                                                                 //  hideSoftKeyboard();

                                                                             }
                                                                         } else {
                                                                             status = 0;
                                                                             ((ImageView) v1).setImageResource(R.drawable.notifying_normal_paid);
                                                                             query_notify = "INSERT INTO \"" + AppSettings.DATABASE_TABLE_NOTIFY
                                                                                     + "\" ( '" + AppSettings.KEY_NAME + "','" + AppSettings.KEY_CHANGES + "','" + AppSettings.KEY_RATIO + "','"
                                                                                     + AppSettings.KEY_ICON + "','" + AppSettings.KEY_PERCANTAGE + "','" + AppSettings.KEY_HIGH + "','" + AppSettings.KEY_LOW + "','" + AppSettings.KEY_VOLUME + "','" + AppSettings.KEY_PREVIOUS + "','" + AppSettings.KEY_bookmark + "','" + AppSettings.KEY_POSITION + "','" + AppSettings.KEY_GTR_LSR + "','" + AppSettings.KEY_CURRENT + "','" + AppSettings.KEY_CURRENT_WEB + "') VALUES (" + "'" + symbol + "'" + "," + "'" + change + "'" + "," + "'" + "ratio" + "'" + "," + R.drawable.icon_menu + "," + "'" + "56.4%" + "'" + "," + "'" + high + "'" + "," + "'" + low + "'" + "," + "'" + volume + "'" + "," + "'" + prevous + "'" + "," + status + "," + "'" + postion + "'" + "," + "'" + selected_item + "'" + "," + "'" + user_value + "'" + "," + "'" + current_web + "'" + ")";


                                                                             Log.e("query", "" + query_notify);
                                                                             lk.insert_update(query_notify);
                                                                             //   hideSoftKeyboard();

                                                                         }

//
//                                    if (type_check_notify) {
////
//
//
//                                        ((ImageView) v1).setImageResource(R.drawable.notifying_normal_stk);
//
//                                        query_notify = "INSERT INTO \"" + AppSettings.DATABASE_TABLE_NOTIFY
//                                                + "\" ( '" + AppSettings.KEY_NAME + "','" + AppSettings.KEY_CHANGES + "','" + AppSettings.KEY_RATIO + "','"
//                                                + AppSettings.KEY_ICON + "','" + AppSettings.KEY_PERCANTAGE + "','" + AppSettings.KEY_HIGH + "','" + AppSettings.KEY_LOW + "','" + AppSettings.KEY_VOLUME + "','" + AppSettings.KEY_PREVIOUS + "','" + AppSettings.KEY_bookmark + "','" + AppSettings.KEY_POSITION + "','" + AppSettings.KEY_GTR_LSR + "','" + AppSettings.KEY_CURRENT + "','" + AppSettings.KEY_CURRENT_WEB + "') VALUES (" + "'" + symbol + "'" + "," + "'" + change + "'" + "," + "'" + "ratio" + "'" + "," + R.drawable.icon_menu + "," + "'" + "56.4%" + "'" + "," + "'" + high + "'" + "," + "'" + low + "'" + "," + "'" + volume + "'" + "," + "'" + prevous + "'" + "," + "'" + rrr + "'" + "," + "'" + postion + "'" + "," + "'" + selected_item + "'" + "," + "'" + user_value + "'" + "," + "'" + current_web + "'" + ")";
//
//
//                                        Log.e("query", "" + query_notify);
//                                        lk.insert_update(query_notify);
//
//
//                                    }
//
//
//
//                                }


//                                else {

                                                                         //insert query


                                                                         //   }


                                                                     }

//                                                                     if (!isMyServiceRunning(Myservice.class)) {
//                                                                         context1.startService(new Intent(context1, Myservice.class));
//
//                                                                         Log.e("hogya", "onetime");
//                                                                     } else {
//                                                                         Log.e("hogya", "again and again");
//                                                                     }

//                                                                     pref_stocks = context1.getSharedPreferences("notify_alert", context1.MODE_PRIVATE);
//
//
//                                                                     String notify_or_not = pref_stocks.getString("notify_value", "");
//                                                                     if (notify_or_not.equalsIgnoreCase("")) {
//                                                                         Log.e("hogya", "onetime");
//                                                                         context1.startService(new Intent(context1, Myservice.class));
//
//                                                                     }
//
//                                                                     pref = context1.getSharedPreferences("notify_alert", context1.MODE_PRIVATE);
//                                                                     edit = pref.edit();
//                                                                     edit.putString("notify_value", "notify");
//                                                                     edit.apply();
//                                                                     Log.e("hogya", "again and again");
                                                                     // notifyDataSetChanged();
                                                                     dialog_custom.dismiss();
                                                                 }

                                                             }
                                                         });


                                                         delete_button.setOnClickListener(new View.OnClickListener() {
                                                             @Override
                                                             public void onClick(View v) {
                                                                 //  context1.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

//                                                                 if(values.hasFocus())
//                                                                 {
//                                                                     Log.e("shown","shown");
//
//
//                                                                 }
//                                                                 else
//                                                                 {
//
//                                                                     Log.e("not shown"," not shown");
//                                                                 }
                                                                 //   hideSoftKeyboard();


                                                                 if (!gmm.isErrorOccured) {
                                                                     Log.e("error ocore true", "sds1");

//                            query_notify = "SELECT * FROM '" + AppSettings.DATABASE_TABLE_NOTIFY + "'";
//                                Log.e("SELECT QUERY", query_notify);
//
//                                c_notify = lk.selectQuery(query_notify);
//                                if (c_notify != null && c_notify.moveToFirst()) {
//
//                                }
                                                                     matched = "";
                                                                     query_notify_delete = "SELECT * FROM '" + AppSettings.DATABASE_TABLE_NOTIFY + "'";
                                                                     Log.e("SELECT QUERY", query_notify_delete);

                                                                     c_notify = lk.selectQuery(query_notify_delete);
                                                                     if (c_notify != null && c_notify.moveToFirst()) {
                                                                         try {
                                                                             do {


                                                                                 String companyname = c_notify.getString(c_notify
                                                                                         .getColumnIndex(AppSettings.KEY_NAME)).toString();

                                                                                 if (companyname.equalsIgnoreCase(symbol)) {
                                                                                     matched = "matched";

                                                                                     ((ImageView) v1).setImageResource(R.drawable.notify_normal_paid);


                                                                                     query_notify_delete = "DELETE FROM " + AppSettings.DATABASE_TABLE_NOTIFY + " WHERE " + AppSettings.KEY_NAME + " = " + "'" + companyname + "'";
                                                                                     Log.e("query", "" + query_notify_delete);
                                                                                     lk.insert_update(query_notify_delete);
                                                                                     //  type_check_notify = false;
                                                                                     // break;
                                                                                 }
//                                        else {
//                                            type_check_notify = true;
//
//                                        }


                                                                             }
                                                                             while (c_notify.moveToNext());
                                                                             if (matched.equalsIgnoreCase("")) {
                                                                                 Log.e("deleter", "deltee");

//                                                                                 View view = context1.getCurrentFocus();
//                                                                                 if (view != null) {
//                                                                                     InputMethodManager imm = (InputMethodManager) context1.getSystemService(Context.INPUT_METHOD_SERVICE);
//                                                                                     imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//                                                                                 }


                                                                                 Snackbar.make(context1.findViewById(android.R.id.content), "Please first Notify", Snackbar.LENGTH_LONG)
                                                                                         // .setAction("Undo", mOnClickListener)
                                                                                         .setActionTextColor(Color.RED)
                                                                                         .show();
                                                                                 //  hideSoftKeyboard();
//                                                                                 Toast t = Toast.makeText(context1, "Please first Notify", Toast.LENGTH_SHORT);
//                                                                                 t.show();
                                                                             } else if (matched.equalsIgnoreCase("matched")) {
                                                                                 dialog_custom.dismiss();
                                                                             }
                                                                         } finally {
                                                                             c_notify.close();
                                                                         }
                                                                     } else {
                                                                         Log.e("deleter", "deltee_null");

//                                                                         View view = context1.getCurrentFocus();
//                                                                         if (view != null) {
//                                                                             InputMethodManager imm = (InputMethodManager) context1.getSystemService(Context.INPUT_METHOD_SERVICE);
//                                                                             imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//                                                                         }

                                                                         Snackbar.make(context1.findViewById(android.R.id.content), "Please first Notify", Snackbar.LENGTH_LONG)
                                                                                 // .setAction("Undo", mOnClickListener)
                                                                                 .setActionTextColor(Color.RED)
                                                                                 .show();
                                                                         // hideSoftKeyboard();
//                                                                         Toast t = Toast.makeText(context1, "Please first Notify", Toast.LENGTH_SHORT);
//                                                                         t.show();

                                                                     }
                                                                 }


                                                             }
                                                         });


                                                     }
                                                 }


        );


//            else
//            {
//                viewHolder.im.setImageResource(R.drawable.watching_button);
//            }


//
//        symbol = navDrawerItems11.get(position).getTitle();
//        if (ind[position] == symbol.toString()) {
//            viewHolder.im.setImageResource(R.drawable.watching_button);
//        } else if (ind[position] == null) {
//            viewHolder.im.setImageResource(R.drawable.watch_button_status);
//           // uuu=1;
//        }
//        Log.e("arr",symbol+"");


        //  }
        //check_bool=false;
//}


        //       yyy++;
//    }


//        for(int tt=0;tt<navDrawerItems11.size();tt++)
//        {
//            if(ind[tt]==position) {
//                ind[tt] = position;
//            }
//                else {
//                ind[tt]=-1;
//            }
//        }


        //ip=0;
//


//            query = "SELECT * FROM '" + AppSettings.DATABASE_TABLE + "'";
//            Log.e("SELECT QUERY", query);
//
//            Cursor c1 = dbManager.selectQuery(query);


//        if (c1 != null && c1.moveToFirst()) {
//            // do {
//            // int id = c.getInt(c.getColumnIndex(AppSettings.KEY_ICON));
//
//            String name11 = c1.getString(c1
//                    .getColumnIndex(AppSettings.KEY_NAME));
//            if (name11.equalsIgnoreCase(symbol)) {
//                viewHolder.im.setImageResource(R.drawable.watching_button);
//
//            } else {
//                viewHolder.im.setImageResource(R.drawable.watchlist_button);
//            }
////
////c1.moveToNext();
//            //   Toast.makeText(getActivity(), "[LOW:" + low1 + "], [name: " + name1 + "], [high: "
//            //         + high1 + "]", Toast.LENGTH_LONG).show();
//            c1.moveToNext();
//            //  } while (c1.moveToNext());
//        }


        //   Object objectItem = getItem(position);;

        //      final Object item = getItem(position);
        //  viewHolder.im.setImageResource(R.drawable.watchlist_button);

//        ViewHolder finalViewHolder3 = viewHolder;
//        finalViewHolder3.im.setTag(R.drawable.watchlist_button);
//         drawableId4 = (Integer) finalViewHolder3.im.getTag();
//        finalViewHolder3.im.setImageResource(drawableId4);
//
//        final ViewHolder finalViewHolder = viewHolder;
//        final ViewHolder finalViewHolder1 = viewHolder;
//        final ViewHolder finalViewHolder2 = viewHolder;


//        final ViewHolder finalViewHolder = viewHolder;


        viewHolder.im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!gmm.isErrorOccured) {
                    Log.e("error ocore true", "sds1");
//                    int position = (int) v.getTag();

//                    symbol = navDrawerItems11.get(position).getTitle();
//                    change = navDrawerItems11.get(position).getwhole();
//                    high = navDrawerItems11.get(position).gethigh();
//                    low = navDrawerItems11.get(position).getlow();
//                    volume = navDrawerItems11.get(position).getvolume();
//                    prevous = navDrawerItems11.get(position).getprevious();
                    String[] as = ((String) v.getTag()).split("!");
                    symbol = as[0];
                    change = as[1];
                    high = as[2];
                    low = as[3];
                    volume = as[4];
                    prevous = as[5];
                    postion = as[6];
                    //   int selection=  (int)  v.getTag();


                    query = "SELECT * FROM '" + AppSettings.DATABASE_TABLE + "'";
                    Log.e("SELECT QUERY", query);

                    c = lk.selectQuery(query);
                    if (c != null && c.moveToFirst()) {
                        try {
                            do {

                                // query = "SELECT * FROM '" + AppSettings.DATABASE_TABLE + "'" + " WHERE " + AppSettings.KEY_bookmark;
                                //Log.e("SELECT QUERY", query);

                                //Cursor c1 = dbManager.selectQuery(query);

                                // int id = c1.getInt(c1.getColumnIndex(AppSettings.KEY_ICON));
                                //boolean ss = c1.getString(c1.getColumnIndex(AppSettings.KEY_bookmark)).equals("false");


//                             select_item[ip]=c1.getString(c1
//                                     .getColumnIndex(AppSettings.KEY_NAME)).toString();
//                             ip++;

                                String companyname = c.getString(c
                                        .getColumnIndex(AppSettings.KEY_NAME)).toString();

                                if (companyname.equalsIgnoreCase(symbol)) {
//                                    finalViewHolder.im.setImageResource(R.drawable.watch_button_status);
//                                    navDrawerItems11.remove((Integer) v.getTag());

                                    ((ImageView) v).setImageResource(R.drawable.icon_watch_plus_normal_paid);

                                    // pos = watclist_adapter.navDrawerItems111.get(ir).get_id();

                                    query = "DELETE FROM " + AppSettings.DATABASE_TABLE + " WHERE " + AppSettings.KEY_NAME + " = " + "'" + companyname + "'";
                                    Log.e("query", "" + query);
                                    lk.insert_update(query);
                                    type_check = false;
                                    break;
                                } else {
                                    type_check = true;

                                }


                            } while (c.moveToNext());
                        } finally {
                            c.close();
                        }
//                        String name1 = c1.getString(c1
//                                .getColumnIndex(AppSettings.KEY_NAME)).toString();

//                        if (ss) {
//
//
//                            finalViewHolder.im.setImageResource(R.drawable.watchlist_button);
//                            // pos = watclist_adapter.navDrawerItems111.get(ir).get_id();
//
//                            query = "DELETE FROM " + AppSettings.DATABASE_TABLE + " WHERE " + AppSettings.KEY_bookmark;
//                            Log.e("query", "" + query);
//                            dbManager.insert_update(query);
//                            //  break;
                        //    }
                        if (type_check) {
//                            ind[ww] = symbol;
//                            ww++;
//                                finalViewHolder.im.setImageResource(R.drawable.watching_button);
//                                navDrawerItems11.remove((Integer)v.getTag());


                            ((ImageView) v).setImageResource(R.drawable.watch_pressed_paid);

                            query = "INSERT INTO \"" + AppSettings.DATABASE_TABLE
                                    + "\" ( '" + AppSettings.KEY_NAME + "','" + AppSettings.KEY_CHANGES + "','" + AppSettings.KEY_RATIO + "','"
                                    + AppSettings.KEY_ICON + "','" + AppSettings.KEY_PERCANTAGE + "','" + AppSettings.KEY_HIGH + "','" + AppSettings.KEY_LOW + "','" + AppSettings.KEY_VOLUME + "','" + AppSettings.KEY_PREVIOUS + "','" + AppSettings.KEY_bookmark + "','" + AppSettings.KEY_POSITION + "') VALUES (" + "'" + symbol + "'" + "," + "'" + change + "'" + "," + "'" + "ratio" + "'" + "," + R.drawable.icon_menu + "," + "'" + "56.4%" + "'" + "," + "'" + high + "'" + "," + "'" + low + "'" + "," + "'" + volume + "'" + "," + "'" + prevous + "'" + "," + "'" + rrr + "'" + "," + "'" + postion + "'" + ")";


// VALUES ('Nadeem Iqbal','dddd',1,'42104646546565465')"
                            Log.e("query", "" + query);
                            lk.insert_update(query);

//break;
                        }

                        //   Toast.makeText(getActivity(), "[LOW:" + low1 + "], [name: " + name1 + "], [high: "
                        //         + high1 + "]", Toast.LENGTH_LONG).show();

                        // } while (c.moveToNext());


                    } else {
//                        ind[ww] = symbol;
//                        ww++;
                        ((ImageView) v).setImageResource(R.drawable.watch_pressed_paid);
                        query = "INSERT INTO \"" + AppSettings.DATABASE_TABLE
                                + "\" ( '" + AppSettings.KEY_NAME + "','" + AppSettings.KEY_CHANGES + "','" + AppSettings.KEY_RATIO + "','"
                                + AppSettings.KEY_ICON + "','" + AppSettings.KEY_PERCANTAGE + "','" + AppSettings.KEY_HIGH + "','" + AppSettings.KEY_LOW + "','" + AppSettings.KEY_VOLUME + "','" + AppSettings.KEY_PREVIOUS + "','" + AppSettings.KEY_bookmark + "','" + AppSettings.KEY_POSITION + "') VALUES (" + "'" + symbol + "'" + "," + "'" + change + "'" + "," + "'" + "ratio" + "'" + "," + R.drawable.icon_menu + "," + "'" + "56.4%" + "'" + "," + "'" + high + "'" + "," + "'" + low + "'" + "," + "'" + volume + "'" + "," + "'" + prevous + "'" + "," + "'" + rrr + "'" + "," + "'" + postion + "'" + ")";


// VALUES ('Nadeem Iqbal','dddd',1,'42104646546565465')"
                        Log.e("query", "" + query);
                        lk.insert_update(query);

                    }


                }


            }
        });
////                finalViewHolder2.im.setTag(R.drawable.watching_button);
////                int drawableId = (Integer) finalViewHolder2.im.getTag();
////                finalViewHolder.im.setImageResource(drawableId);
//
//                if(drawableId4==R.drawable.watchlist_button)
//                {
//                    finalViewHolder2.im.setTag(R.drawable.watching_button);
//                    int drawableId = (Integer) finalViewHolder2.im.getTag();
//                    finalViewHolder.im.setImageResource(drawableId);
//
//
//
//                    finalViewHolder2.im.setTag(R.drawable.watching_button);
//                    drawableId4 = (Integer) finalViewHolder2.im.getTag();
//
//                    //drawableId4=drawableId4;
//
////                    Toast t=  Toast.makeText(cc,"fdddf",Toast.LENGTH_SHORT);
////                       t.show();
//
//                  //  if(check_unchecked) {
//                    if(check_unchecked) {
//
//                        if (!isErrorOccured) {
//                            Log.e("error ocore true", "sds1");
//
//                            symbol = navDrawerItems11.get(position).getTitle();
//                            change = navDrawerItems11.get(position).getwhole();
//                            high = navDrawerItems11.get(position).gethigh();
//                            low = navDrawerItems11.get(position).getlow();
//                            volume = navDrawerItems11.get(position).getvolume();
//                            prevous = navDrawerItems11.get(position).getprevious();
//
//                            query = "INSERT INTO \"" + AppSettings.DATABASE_TABLE
//                                    + "\" ( '" + AppSettings.KEY_NAME + "','" + AppSettings.KEY_CHANGES + "','" + AppSettings.KEY_RATIO + "','"
//                                    + AppSettings.KEY_ICON + "','" + AppSettings.KEY_PERCANTAGE + "','" + AppSettings.KEY_HIGH + "','" + AppSettings.KEY_LOW + "','" + AppSettings.KEY_VOLUME + "','" + AppSettings.KEY_PREVIOUS
//                                    + "') VALUES (" + "'" + symbol + "'" + "," + "'" + change + "'" + "," + "'" + "ratio" + "'" + "," + R.drawable.icon_menu + "," + "'" + "56.4%" + "'" + "," + "'" + high + "'" + "," + "'" + low + "'" + "," + "'" + volume + "'" + "," + "'" + prevous + "'" + ")";
//
//
//// VALUES ('Nadeem Iqbal','dddd',1,'42104646546565465')"
//                            Log.e("query", "" + query);
//                            check_unchecked = false;
//                            dbManager.insert_update(query);
//
////                    query = "SELECT * FROM '" + AppSettings.DATABASE_TABLE + "'";
////                    Log.e("SELECT QUERY", query);
////
////                    Cursor c = dbManager.selectQuery(query);
////
////                    if (c != null) {
////                        do {
////                           // int id = c.getInt(c.getColumnIndex(AppSettings.KEY_ICON));
////                            String low1 = c.getString(c
////                                    .getColumnIndex(AppSettings.KEY_LOW));
////                            String name = c.getString(c
////                                    .getColumnIndex(AppSettings.KEY_NAME));
////                            String cnic = c.getString(c
////                                    .getColumnIndex(AppSettings.KEY_HIGH));
////
////                            Toast.makeText(cc,"[LOW:" + low1 + "], [name: " + name + "], [high: "
////                                            + cnic + "]", Toast.LENGTH_LONG).show();
////
////                        } while (c.moveToNext());
////                    }
//                            //   check_unchecked=false;
//                        }
//
//                    }
//                    else
//                    {
//                        check_unchecked=false;
//
//                    }
//
//                   // }
//                 //   else
//                  //  {
////                        finalViewHolder2.im.setTag(R.drawable.watchlist_button);
////                        int drawableId11 = (Integer) finalViewHolder2.im.getTag();
////                        finalViewHolder.im.setImageResource(drawableId11);
//                     //   check_unchecked=true;
//                  //  }
//
//
//              //  }
////else {
////                    finalViewHolder2.im.setTag(R.drawable.watching_button);
////                    int drawableId44 = (Integer) finalViewHolder2.im.getTag();
////                   // finalViewHolder.im.setImageResource(drawableId44);
////                    if (drawableId4 == drawableId44) {
////                        finalViewHolder.im.setImageResource(R.drawable.watchlist_button);
////                    }
////                    else
////                    {
////
////                    }
//if(check_unchecked) {
//    if (!isErrorOccured) {
//        Log.e("error ocore true", "sds1");
//
//        symbol = navDrawerItems11.get(position).getTitle();
//        change = navDrawerItems11.get(position).getwhole();
//        high = navDrawerItems11.get(position).gethigh();
//        low = navDrawerItems11.get(position).getlow();
//        volume = navDrawerItems11.get(position).getvolume();
//        prevous = navDrawerItems11.get(position).getprevious();
//
//        query = "INSERT INTO \"" + AppSettings.DATABASE_TABLE
//                + "\" ( '" + AppSettings.KEY_NAME + "','" + AppSettings.KEY_CHANGES + "','" + AppSettings.KEY_RATIO + "','"
//                + AppSettings.KEY_ICON + "','" + AppSettings.KEY_PERCANTAGE + "','" + AppSettings.KEY_HIGH + "','" + AppSettings.KEY_LOW + "','" + AppSettings.KEY_VOLUME + "','" + AppSettings.KEY_PREVIOUS
//                + "') VALUES (" + "'" + symbol + "'" + "," + "'" + change + "'" + "," + "'" + "ratio" + "'" + "," + R.drawable.icon_menu + "," + "'" + "56.4%" + "'" + "," + "'" + high + "'" + "," + "'" + low + "'" + "," + "'" + volume + "'" + "," + "'" + prevous + "'" + ")";
//
//
//// VALUES ('Nadeem Iqbal','dddd',1,'42104646546565465')"
//        Log.e("query", "" + query);
//
//        dbManager.insert_update(query);
//
////                    query = "SELECT * FROM '" + AppSettings.DATABASE_TABLE + "'";
////                    Log.e("SELECT QUERY", query);
////
////                    Cursor c = dbManager.selectQuery(query);
////
////                    if (c != null) {
////                        do {
////                           // int id = c.getInt(c.getColumnIndex(AppSettings.KEY_ICON));
////                            String low1 = c.getString(c
////                                    .getColumnIndex(AppSettings.KEY_LOW));
////                            String name = c.getString(c
////                                    .getColumnIndex(AppSettings.KEY_NAME));
////                            String cnic = c.getString(c
////                                    .getColumnIndex(AppSettings.KEY_HIGH));
////
////                            Toast.makeText(cc,"[LOW:" + low1 + "], [name: " + name + "], [high: "
////                                            + cnic + "]", Toast.LENGTH_LONG).show();
////
////                        } while (c.moveToNext());
////                    }
//        //   check_unchecked=false;
//    }
//
//
//}
//
//                    check_unchecked=true;
//                    finalViewHolder2.im.setTag(R.drawable.watchlist_button);
//                    drawableId4 = (Integer) finalViewHolder2.im.getTag();
//
//                }
////                if ((int)finalViewHolder1.im.getTag(position)==position)
////                {
////
////                    Toast t=  Toast.makeText(cc,"fdddf",Toast.LENGTH_SHORT);
////                     t.show();
////
////                }
//               //Toast t=  Toast.makeText(cc,finalViewHolder1.im.getTag(position).toString(),Toast.LENGTH_SHORT);
//               // t.show();
//
////                if(check_unchecked) {
////
////
////                    if (!isErrorOccured) {
////                        Log.e("error ocore true", "sds1");
////
////                        symbol = navDrawerItems11.get(position).getTitle();
////                        change = navDrawerItems11.get(position).getwhole();
////                        high = navDrawerItems11.get(position).gethigh();
////                        low = navDrawerItems11.get(position).getlow();
////                        volume = navDrawerItems11.get(position).getvolume();
////                        prevous = navDrawerItems11.get(position).getprevious();
////
////                        query = "INSERT INTO \"" + AppSettings.DATABASE_TABLE
////                                + "\" ( '" + AppSettings.KEY_NAME + "','" + AppSettings.KEY_CHANGES + "','" + AppSettings.KEY_RATIO + "','"
////                                + AppSettings.KEY_ICON + "','" + AppSettings.KEY_PERCANTAGE + "','" + AppSettings.KEY_HIGH + "','" + AppSettings.KEY_LOW + "','" + AppSettings.KEY_VOLUME + "','" + AppSettings.KEY_PREVIOUS
////                                + "') VALUES (" + "'" + symbol + "'" + "," + "'" + change + "'" + "," + "'" + "ratio" + "'" + "," + R.drawable.icon_menu + "," + "'" + "56.4%" + "'" + "," + "'" + high + "'" + "," + "'" + low + "'" + "," + "'" + volume + "'" + "," + "'" + prevous + "'" + ")";
////
////
////// VALUES ('Nadeem Iqbal','dddd',1,'42104646546565465')"
////                        Log.e("query", "" + query);
////                        check_unchecked = false;
////                        dbManager.insert_update(query);
////
//////                    query = "SELECT * FROM '" + AppSettings.DATABASE_TABLE + "'";
//////                    Log.e("SELECT QUERY", query);
//////
//////                    Cursor c = dbManager.selectQuery(query);
//////
//////                    if (c != null) {
//////                        do {
//////                           // int id = c.getInt(c.getColumnIndex(AppSettings.KEY_ICON));
//////                            String low1 = c.getString(c
//////                                    .getColumnIndex(AppSettings.KEY_LOW));
//////                            String name = c.getString(c
//////                                    .getColumnIndex(AppSettings.KEY_NAME));
//////                            String cnic = c.getString(c
//////                                    .getColumnIndex(AppSettings.KEY_HIGH));
//////
//////                            Toast.makeText(cc,"[LOW:" + low1 + "], [name: " + name + "], [high: "
//////                                            + cnic + "]", Toast.LENGTH_LONG).show();
//////
//////                        } while (c.moveToNext());
//////                    }
////
////                    }
////                }
////                else
////                {
////
////                }
//
//
//
//            }
//        });
        cc = this.context1;


        format = new DecimalFormat("0.00");

//        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon_updown);
//        TextView txtTitleindex = (TextView) convertView.findViewById(R.id.BOP);
//
//        ImageView share_stock = (ImageView) convertView.findViewById(R.id.info);
//
//        TextView float_1 = (TextView) convertView.findViewById(R.id.float_value1);
//        final TextView dot_plus = (TextView) convertView.findViewById(R.id.float_value);
//
//        //TextView  float_plus = (TextView) convertView.findViewById(R.id.float_plus);
//
//        final TextView percentage = (TextView) convertView.findViewById(R.id.percentage_stock);
//
//
//        TextView high_value = (TextView) convertView.findViewById(R.id.high_value_stock);
//        TextView low_value = (TextView) convertView.findViewById(R.id.low_value_stock);
//        TextView volume_value = (TextView) convertView.findViewById(R.id.volume_value_stock);
//        TextView previous_value = (TextView) convertView.findViewById(R.id.previous_value_stock);

        //  watchlist_btn = (ImageView) convertView.findViewById(R.id.watchlist);
        // watchlist_btn.setTag(new Integer(position));


        //   TextView txtCount = (TextView) convertView.findViewById(R.id.counter);

        // greater_str1 = navDrawerItems11.get(position).getwhole();
        // greater_not1 = Double.parseDouble(greater_str1);


        //get_previous_lcdp = navDrawerItems11.get(position).getprevious();
        // get_int_prevoous = Double.parseDouble(get_previous_lcdp);


        // check1 = (double) (greater_not1 / get_int_prevoous);


        //changes_format = Double.parseDouble(navDrawerItems.get(position).getwhole());

        //string_changes_fromat = format.format(check1);


        //  float_1.setText(string_changes_fromat);

        // dot_plus.setTag(position);
        // if (Double.valueOf(navDrawerItems11.get(position).getwhole()) < 0.0) {

        dot_plus.setText(navDrawerItems11.get(position).getwhole());
        // dot_plus.setText(String.valueOf(check1).charAt(0)+String.valueOf(String.valueOf(check1).charAt(1))+String.valueOf(check1).charAt(2)+String.valueOf(check1).charAt(3));

        // } else if (check1 >= 0.0) {
        //   dot_plus.setText(navDrawerItems11.get(position).getwhole());
        // dot_plus.setText(String.valueOf("+"+check1).charAt(0)+String.valueOf(String.valueOf(check1).charAt(1))+String.valueOf(check1).charAt(2)+String.valueOf(check1).charAt(3));
        //}

        // percent_double = check1 * 100.0;
        //percentage.setTag(position);
        // string_percent_fromat = format.format(percent_double);
        // if (percent_double < 0.0) {


        percentage.setText(navDrawerItems11.get(position).getchangePercent());
        //  } else {

        //  percentage.setText(navDrawerItems11.get(position).getchangePercent());
        //  }
        if (Double.valueOf(navDrawerItems11.get(position).getwhole()) < 0.00) {

            imgIcon.setImageResource(R.drawable.red_trangle);
        } else if (Double.valueOf(navDrawerItems11.get(position).getwhole()) >= 0.00) {

            imgIcon.setImageResource(R.drawable.green_trangle);
        }


        //imgIcon.setImageResource(navDrawerItems.get(position).getIcon());

        txtTitleindex.setText(navDrawerItems11.get(position).getTitle());

        //format.format(check1);
        // changes_format   = Double.parseDouble(navDrawerItems.get(position).getwhole());


        float_1.setText(navDrawerItems11.get(position).getCurrent());

        // float_plus.setText(navDrawerItems.get(position).getpercent());


        high_value.setText(navDrawerItems11.get(position).gethigh());

        low_value.setText(navDrawerItems11.get(position).getlow());

        volume_value.setText(navDrawerItems11.get(position).getvolume());


        previous_value.setText(navDrawerItems11.get(position).getprevious());

//        watchlist_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                Log.e("onclikebefore", "sds1gggg");
////
////
//              Toast t=  Toast.makeText(cc,"Added In Watchlist",Toast.LENGTH_SHORT);
//                t.show();
////                watchlist_btn.setImageResource(R.drawable.watching_button);
//
//
//
//
////                if (check_unchecked) {
//              //  Favorite o = (Favorite) this.getListAdapter().getItem(position);
//
////                View parentRow = (View) v.getParent();
////
////                ListView listView = (ListView) parentRow.getParent();
////
////                final int position = listView.getPositionForView(parentRow);
//
//                   // watchlist_btn.setImageResource(R.drawable.watching_button);
//
//                    if (!isErrorOccured) {
//                        Log.e("error ocore true", "sds1");
//
//                        symbol = navDrawerItems11.get(position).getTitle();
//                        change = navDrawerItems11.get(position).getwhole();
//                        high = navDrawerItems11.get(position).gethigh();
//                        low = navDrawerItems11.get(position).getlow();
//                        volume = navDrawerItems11.get(position).getvolume();
//                        prevous = navDrawerItems11.get(position).getprevious();
//
//                        query = "INSERT INTO \"" + AppSettings.DATABASE_TABLE
//                                + "\" ( '" + AppSettings.KEY_NAME + "','" + AppSettings.KEY_CHANGES + "','" + AppSettings.KEY_RATIO + "','"
//                                + AppSettings.KEY_ICON + "','" + AppSettings.KEY_PERCANTAGE + "','" + AppSettings.KEY_HIGH + "','" + AppSettings.KEY_LOW + "','" + AppSettings.KEY_VOLUME + "','" + AppSettings.KEY_PREVIOUS
//                                + "') VALUES (" + "'" + symbol + "'" + "," + "'" + change + "'" + "," + "'" + "ratio" + "'" + "," + R.drawable.icon_menu + "," + "'" + "56.4%" + "'" + "," + "'" + high + "'" + "," + "'" + low + "'" + "," + "'" + volume + "'" + "," + "'" + prevous + "'" + ")";
//
//
//// VALUES ('Nadeem Iqbal','dddd',1,'42104646546565465')"
//                        Log.e("query", "" + query);
//                        check_unchecked = false;
//                        dbManager.insert_update(query);
//
////                    query = "SELECT * FROM '" + AppSettings.DATABASE_TABLE + "'";
////                    Log.e("SELECT QUERY", query);
////
////                    Cursor c = dbManager.selectQuery(query);
////
////                    if (c != null) {
////                        do {
////                           // int id = c.getInt(c.getColumnIndex(AppSettings.KEY_ICON));
////                            String low1 = c.getString(c
////                                    .getColumnIndex(AppSettings.KEY_LOW));
////                            String name = c.getString(c
////                                    .getColumnIndex(AppSettings.KEY_NAME));
////                            String cnic = c.getString(c
////                                    .getColumnIndex(AppSettings.KEY_HIGH));
////
////                            Toast.makeText(cc,"[LOW:" + low1 + "], [name: " + name + "], [high: "
////                                            + cnic + "]", Toast.LENGTH_LONG).show();
////
////                        } while (c.moveToNext());
////                    }
//
//                    }
////                } else {
////                    watchlist_btn.setImageResource(R.drawable.watch_button_status);
////
////                    check_unchecked = true;
////                    Log.e("else", "else_else");
////
////                }
//
//
//            }
//        });


        share_stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  int position = (int) v.getTag();

                Intent share_data = new Intent(Intent.ACTION_SEND);
                share_data.setType("text/plain");

                //  share_data.putExtra(Intent.EXTRA_SUBJECT, "PSX App - "+navDrawerItems11.get(position).getTitle());
                SharedPreferences sharedpreferences1 = context1.getSharedPreferences("dateTime", Context.MODE_PRIVATE);
                String lastUpdate = sharedpreferences1.getString("lastUpdate", "N/A");
                greater_str1 = navDrawerItems11.get(position).getwhole();
                greater_not1 = Double.parseDouble(greater_str1);


                get_previous_lcdp = navDrawerItems11.get(position).getprevious();
                get_int_prevoous = Double.parseDouble(get_previous_lcdp);


                check1 = (double) (greater_not1 / get_int_prevoous);


                //changes_format = Double.parseDouble(navDrawerItems.get(position).getwhole());

                string_changes_fromat = format.format(check1);


//                if (check1 < 0.0) {
//
//                    dot_plus.setText(String.valueOf(string_changes_fromat));
//                    // dot_plus.setText(String.valueOf(check1).charAt(0)+String.valueOf(String.valueOf(check1).charAt(1))+String.valueOf(check1).charAt(2)+String.valueOf(check1).charAt(3));
//
//                } else if (check1 >= 0.0) {
//                    dot_plus.setText(String.valueOf("+" + string_changes_fromat));
//                    // dot_plus.setText(String.valueOf("+"+check1).charAt(0)+String.valueOf(String.valueOf(check1).charAt(1))+String.valueOf(check1).charAt(2)+String.valueOf(check1).charAt(3));
//                }


                percent_double = check1 * 100.0;
                // percentage.setTag(position);
                string_percent_fromat = format.format(percent_double);
//                if (percent_double < 0.0) {
//
//
//                    percentage.setText(String.valueOf(string_percent_fromat + "%"));
//                } else {
//
//                    percentage.setText(String.valueOf("+" + string_percent_fromat + "%"));
//                }


//share_data.putExtra(android.content.Intent.EXTRA_TEXT,String.valueOf("+" + string_changes_fromat)+ " dd "+String.valueOf("+" + string_percent_fromat + "%") );


                if (Double.valueOf(navDrawerItems11.get(position).getwhole()) < 0.00) {


                    share_data.putExtra(Intent.EXTRA_TEXT, "Company Name : " + navDrawerItems11.get(position).getTitle() + "\n"
                                    + "Current : " + navDrawerItems11.get(position).getCurrent() + "\n" + "Change : " + navDrawerItems11.get(position).getwhole() + "\n" + "Percentage : " + navDrawerItems11.get(position).getchangePercent() + "%" + "\n" + "High : " + navDrawerItems11.get(position).gethigh() + "\n" + "Low : " + navDrawerItems11.get(position).getlow() + "\n" + "Volume : " + navDrawerItems11.get(position).getvolume() + "\n" + "Previous : " + navDrawerItems11.get(position).getprevious() + "\n" + "Last Update : " + lastUpdate + "\n\n" + "Download app : " + "https://play.google.com/store/apps/details?id=com.appinhand.saudistockexchange"

                    );
                } else if (Double.valueOf(navDrawerItems11.get(position).getwhole()) >= 0.00) {

                    share_data.putExtra(Intent.EXTRA_TEXT, "Company Name : " + navDrawerItems11.get(position).getTitle() + "\n"
                                    + "Current : " + navDrawerItems11.get(position).getCurrent() + "\n" + "Change : " + navDrawerItems11.get(position).getwhole() + "\n" + "Percentage : " + navDrawerItems11.get(position).getchangePercent() + "%" + "\n" + "High : " + navDrawerItems11.get(position).gethigh() + "\n" + "Low : " + navDrawerItems11.get(position).getlow() + "\n" + "Volume : " + navDrawerItems11.get(position).getvolume() + "\n" + "Previous : " + navDrawerItems11.get(position).getprevious() + "\n" + "Last Update : " + lastUpdate + "\n\n" + "Download app : " + "https://play.google.com/store/apps/details?id=com.appinhand.saudistockexchange"

                    );
                }

                Intent share_via = Intent.createChooser(share_data, "Share via");
                cc.startActivity(share_via);


            }
        });
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

    public void addItemsOnSpinner2() {

        //  spinner1 = (Spinner) findViewById(R.id.spinner_quantity);
        List<String> list = new ArrayList<String>();
        list.clear();
        list.add("Greater than");
        list.add("Less than");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(context1, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        greater_lesser.setAdapter(dataAdapter);


    }

    public void addListenerOnSpinnerItemSelection() {
        // spinner1 = (Spinner) findViewById(R.id.spinner_quantity);
        greater_lesser.setOnItemSelectedListener(new CustomOnItemSelectedListener());


    }

}