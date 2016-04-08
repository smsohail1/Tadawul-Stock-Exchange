package com.testbatch3.appxone.tadawulproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by APPXONE on 1/5/2016.
 */
public class stock_list extends BaseAdapter {

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
    private String string_changes_fromat = "", string_percent_fromat = "";
    public static ArrayList<stocklistitem> navDrawerItems11;

    // boolean isErrorOccured = false;

    //  public DataBaseManager dbManager;
    GamesFragment gmm;
    DataBaseManager lk;

    String symbol = "", change = "", high = "", low = "", prevous = "", volume = "", postion = "";
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

    boolean check_bool;
    int yyy;
    Cursor c33;
    ArrayList<String> fav_list;
    Cursor c;

    public stock_list(Context context, ArrayList<stocklistitem> navDrawerItems) {
        this.context1 = context;
        this.navDrawerItems11 = navDrawerItems;
        fav_list = new ArrayList<String>();
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
        public ImageView im;
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
            Log.e("arr", "else");
            // viewHolder = (ViewHolder) convertView.getTag();
        }


        format = new DecimalFormat("0.00");
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon_updown);
        TextView txtTitleindex = (TextView) convertView.findViewById(R.id.BOP);

        ImageView share_stock = (ImageView) convertView.findViewById(R.id.info);

        TextView float_1 = (TextView) convertView.findViewById(R.id.float_value1);
        final TextView dot_plus = (TextView) convertView.findViewById(R.id.float_value);

        //TextView  float_plus = (TextView) convertView.findViewById(R.id.float_plus);

        final TextView percentage = (TextView) convertView.findViewById(R.id.percentage_stock);


        TextView high_value = (TextView) convertView.findViewById(R.id.high_value_stock);
        TextView low_value = (TextView) convertView.findViewById(R.id.low_value_stock);
        TextView volume_value = (TextView) convertView.findViewById(R.id.volume_value_stock);
        TextView previous_value = (TextView) convertView.findViewById(R.id.previous_value_stock);

        Typeface tf = Typeface.createFromAsset(this.context1.getAssets(), "fonts/AvenirLTStd-Roman.otf");
        txtTitleindex.setTypeface(tf);
        float_1.setTypeface(tf);
        dot_plus.setTypeface(tf);
        percentage.setTypeface(tf);

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

        viewHolder.im.setTag(symbol + "!" + change + "!" + high + "!" + low + "!" + volume + "!" + prevous + "!" + postion);
        Log.d("Tag", "getView " + symbol + "^" + change + "^" + high + "^" + low + "^" + volume + "^" + prevous + "^" + postion);


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


        viewHolder.im.setImageResource(R.drawable.watch_button_status);
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

                viewHolder.im.setImageResource(R.drawable.watching_button);
                // viewHolder.im.setImageResource(R.drawable.watching_button);
            }
//            else {
//               viewHolder.im.setImageResource(R.drawable.watch_button_status);
//            }

        }
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

                                    ((ImageView) v).setImageResource(R.drawable.watch_button_status);

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


                            ((ImageView) v).setImageResource(R.drawable.watching_button);

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
                        ((ImageView) v).setImageResource(R.drawable.watching_button);
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

        greater_str1 = navDrawerItems11.get(position).getwhole();
        greater_not1 = Double.parseDouble(greater_str1);


        get_previous_lcdp = navDrawerItems11.get(position).getprevious();
        get_int_prevoous = Double.parseDouble(get_previous_lcdp);


        check1 = (double) (greater_not1 / get_int_prevoous);


        //changes_format = Double.parseDouble(navDrawerItems.get(position).getwhole());

        string_changes_fromat = format.format(check1);


        //  float_1.setText(string_changes_fromat);

        // dot_plus.setTag(position);
        if (check1 < 0.0) {

            dot_plus.setText(String.valueOf(string_changes_fromat));
            // dot_plus.setText(String.valueOf(check1).charAt(0)+String.valueOf(String.valueOf(check1).charAt(1))+String.valueOf(check1).charAt(2)+String.valueOf(check1).charAt(3));

        } else if (check1 >= 0.0) {
            dot_plus.setText(String.valueOf("+" + string_changes_fromat));
            // dot_plus.setText(String.valueOf("+"+check1).charAt(0)+String.valueOf(String.valueOf(check1).charAt(1))+String.valueOf(check1).charAt(2)+String.valueOf(check1).charAt(3));
        }

        percent_double = check1 * 100.0;
        //percentage.setTag(position);
        string_percent_fromat = format.format(percent_double);
        if (percent_double < 0.0) {


            percentage.setText(String.valueOf(string_percent_fromat + "%"));
        } else {

            percentage.setText(String.valueOf("+" + string_percent_fromat + "%"));
        }
        if (check1 < 0.0) {

            imgIcon.setImageResource(R.drawable.red_trangle);
        } else if (check1 >= 0.0) {

            imgIcon.setImageResource(R.drawable.green_trangle);
        }


        //imgIcon.setImageResource(navDrawerItems.get(position).getIcon());

        txtTitleindex.setText(navDrawerItems11.get(position).getTitle());

        //format.format(check1);
        // changes_format   = Double.parseDouble(navDrawerItems.get(position).getwhole());


        float_1.setText(navDrawerItems11.get(position).getwhole());

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


                if (check1 < 0.0) {


                    share_data.putExtra(Intent.EXTRA_TEXT, "Company Name : " + navDrawerItems11.get(position).getTitle() + "\n"
                                    + "Change : " + navDrawerItems11.get(position).getwhole() + "\n" + "Ratio : " + String.valueOf(string_changes_fromat) + "\n" + "Percentage : " + String.valueOf(string_percent_fromat + "%") + "\n" + "High : " + navDrawerItems11.get(position).gethigh() + "\n" + "Low : " + navDrawerItems11.get(position).getlow() + "\n" + "Volume : " + navDrawerItems11.get(position).getvolume() + "\n" + "Previous : " + navDrawerItems11.get(position).getprevious() + "\n" + "Last Update : " + lastUpdate + "\n\n" + "Download app : " + "https://play.google.com/store/apps/details?id=com.appinhand.karachistockexchange"

                    );
                } else if (check1 >= 0.0) {

                    share_data.putExtra(Intent.EXTRA_TEXT, "Company Name : " + navDrawerItems11.get(position).getTitle() + "\n"
                                    + "Change : " + navDrawerItems11.get(position).getwhole() + "\n" + "Ratio : " + String.valueOf("+" + string_changes_fromat) + "\n" + "Percentage : " + String.valueOf("+" + string_percent_fromat + "%") + "\n" + "High : " + navDrawerItems11.get(position).gethigh() + "\n" + "Low : " + navDrawerItems11.get(position).getlow() + "\n" + "Volume : " + navDrawerItems11.get(position).getvolume() + "\n" + "Previous : " + navDrawerItems11.get(position).getprevious() + "\n" + "Last Update : " + lastUpdate + "\n\n" + "Download app : " + "https://play.google.com/store/apps/details?id=com.appinhand.karachistockexchange"

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

}