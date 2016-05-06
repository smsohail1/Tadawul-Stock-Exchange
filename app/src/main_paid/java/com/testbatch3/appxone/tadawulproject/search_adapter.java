package com.testbatch3.appxone.tadawulproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import java.util.Locale;

/**
 * Created by APPXONE on 1/18/2016.
 */
public class search_adapter extends BaseAdapter {

    ArrayList<search_model> mStringFilterList;

    private Context context;

    // ValueFilter valueFilter;
    private ArrayList<search_model> navDrawerItemssa;
    private String current_value1 = "", chge_vle = "", hign_vl = "", low_vle1 = "";
    String current_vle, change_vle, hign_vle = "", low_vle;


    private ArrayList<search_model> arraylist;


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
//    public  static ArrayList<search_model> navDrawerItems11;


//    boolean isErrorOccured = false;
//    public static DataBaseManager dbManager;


    String symbol = "", change = "", high = "", low = "", prevous = "", volume = "", postion = "";
    int icon_updown;
    public static String query;
    boolean check_unchecked = true;
    public ImageView watchlist_btn;
    public int drawableId4;

    GamesFragment gmm;
    DataBaseManager lk;
    boolean rrr;
    boolean type_check;
    ArrayList<String> fav_list;
    Cursor c;


    public search_adapter(Context context, ArrayList<search_model> navDrawerItemsa) {
        this.context = context;
        this.navDrawerItemssa = navDrawerItemsa;
        this.arraylist = new ArrayList<search_model>();
        this.arraylist.addAll(navDrawerItemsa);

        fav_list = new ArrayList<String>();
        Log.e("cunstructor", "cunstructor");
        //  mStringFilterList = navDrawerItemsa;
    }

    @Override
    public int getCount() {
        return navDrawerItemssa.size();
    }

    @Override
    public Object getItem(int position) {
        return navDrawerItemssa.get(position);
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
        if (convertView == null) {
            gmm = new GamesFragment();
            lk = new DataBaseManager(this.context);
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.search_listvew, null);
            viewHolder = new ViewHolder();
            viewHolder.im = (ImageView) convertView.findViewById(R.id.watchlist);
            convertView.setTag(viewHolder);
//            dbManager = new DataBaseManager(this.context);
//            try {
//                dbManager.createDataBase();
//                Log.e("try", "sds1");
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


        symbol = navDrawerItemssa.get(position).getTitle();
        change = navDrawerItemssa.get(position).getwhole();
        high = navDrawerItemssa.get(position).gethigh1();
        low = navDrawerItemssa.get(position).getlow();
        volume = navDrawerItemssa.get(position).getvolume();
        prevous = navDrawerItemssa.get(position).getprevious();
        postion = navDrawerItemssa.get(position).getpositon();
        viewHolder.im.setTag(symbol + "!" + change + "!" + high + "!" + low + "!" + volume + "!" + prevous + "!" + postion);
        Log.d("Tag", "getView " + symbol + "," + change + "," + high + "," + low + "," + volume + "," + prevous + "!" + postion);


        symbol = navDrawerItemssa.get(position).getTitle();

        Log.e("arr", symbol + "");


        viewHolder.im.setImageResource(R.drawable.watch_button_stocks);
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
            if (fav_list.get(i).equalsIgnoreCase(navDrawerItemssa.get(position).getTitle())) {

                viewHolder.im.setImageResource(R.drawable.watching_button);
                // viewHolder.im.setImageResource(R.drawable.watching_button);
            }
//            else {
//               viewHolder.im.setImageResource(R.drawable.watch_button_status);
//            }

        }


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

                                    ((ImageView) v).setImageResource(R.drawable.watch_button_stocks);

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


        cc = this.context;


        format = new DecimalFormat("0.00");

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon_updown);
        TextView txtTitleindex = (TextView) convertView.findViewById(R.id.BOP);

        ImageView share_stock = (ImageView) convertView.findViewById(R.id.info1);

        TextView float_1 = (TextView) convertView.findViewById(R.id.float_value1);
        final TextView dot_plus = (TextView) convertView.findViewById(R.id.float_value);

        //TextView  float_plus = (TextView) convertView.findViewById(R.id.float_plus);

        final TextView percentage = (TextView) convertView.findViewById(R.id.percentage_stock);


        TextView high_value = (TextView) convertView.findViewById(R.id.high_value_stock);
        TextView low_value = (TextView) convertView.findViewById(R.id.low_value_stock);
        TextView volume_value = (TextView) convertView.findViewById(R.id.volume_value_stock);
        TextView previous_value = (TextView) convertView.findViewById(R.id.previous_value_stock);


        Typeface tf = Typeface.createFromAsset(this.context.getAssets(), "fonts/AvenirLTStd-Roman.otf");
        txtTitleindex.setTypeface(tf);
        float_1.setTypeface(tf);
        dot_plus.setTypeface(tf);
        percentage.setTypeface(tf);

        high_value.setTypeface(tf);
        low_value.setTypeface(tf);
        volume_value.setTypeface(tf);
        previous_value.setTypeface(tf);


        share_stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  int position = (int) v.getTag();

                Intent share_data = new Intent(Intent.ACTION_SEND);
                share_data.setType("text/plain");


//                greater_str1 = navDrawerItemssa.get(position).getwhole();
//                greater_not1 = Double.parseDouble(greater_str1);
//
//
//                get_previous_lcdp = navDrawerItemssa.get(position).getprevious();
//                get_int_prevoous = Double.parseDouble(get_previous_lcdp);
//
//
//                check1 = (double) (greater_not1 / get_int_prevoous);
//
//
//                //changes_format = Double.parseDouble(navDrawerItems.get(position).getwhole());
//
//                string_changes_fromat = format.format(check1);


//                if (check1 < 0.0) {
//
//                    dot_plus.setText(String.valueOf(string_changes_fromat));
//                    // dot_plus.setText(String.valueOf(check1).charAt(0)+String.valueOf(String.valueOf(check1).charAt(1))+String.valueOf(check1).charAt(2)+String.valueOf(check1).charAt(3));
//
//                } else if (check1 >= 0.0) {
//                    dot_plus.setText(String.valueOf("+" + string_changes_fromat));
//                    // dot_plus.setText(String.valueOf("+"+check1).charAt(0)+String.valueOf(String.valueOf(check1).charAt(1))+String.valueOf(check1).charAt(2)+String.valueOf(check1).charAt(3));
//                }


            //    percent_double = check1 * 100.0;
                // percentage.setTag(position);
              //  string_percent_fromat = format.format(percent_double);
//                if (percent_double < 0.0) {
//
//
//                    percentage.setText(String.valueOf(string_percent_fromat + "%"));
//                } else {
//
//                    percentage.setText(String.valueOf("+" + string_percent_fromat + "%"));
//                }


//share_data.putExtra(android.content.Intent.EXTRA_TEXT,String.valueOf("+" + string_changes_fromat)+ " dd "+String.valueOf("+" + string_percent_fromat + "%") );


                if (Double.valueOf(navDrawerItemssa.get(position).getwhole()) < 0.0) {


                    share_data.putExtra(Intent.EXTRA_TEXT, "Company Name : " + navDrawerItemssa.get(position).getTitle() + "\n"
                                    + "Current : " + navDrawerItemssa.get(position).getCurrent() + "\n" + "Change : " +  navDrawerItemssa.get(position).getwhole()+ "\n" + "Percentage : " + navDrawerItemssa.get(position).getchangePercent()+ "%" + "\n" + "High : " + navDrawerItemssa.get(position).gethigh1() + "\n" + "Low : " + navDrawerItemssa.get(position).getlow() + "\n" + "Volume : " + navDrawerItemssa.get(position).getvolume() + "\n" + "Previous : " + navDrawerItemssa.get(position).getprevious() + "\n\n" + "Download app : " + "https://play.google.com/store/apps/details?id=com.appinhand.saudistockexchangepaid"

                    );
                } else if (Double.valueOf(navDrawerItemssa.get(position).getwhole()) >= 0.0) {

                    share_data.putExtra(Intent.EXTRA_TEXT, "Company Name : " + navDrawerItemssa.get(position).getTitle() + "\n"
                                    + "Current : " + navDrawerItemssa.get(position).getCurrent() + "\n" + "Change : +" + navDrawerItemssa.get(position).getwhole()  + "\n" + "Percentage : +" +  navDrawerItemssa.get(position).getchangePercent()+ "%" + "\n" + "High : " + navDrawerItemssa.get(position).gethigh1() + "\n" + "Low : " + navDrawerItemssa.get(position).getlow() + "\n" + "Volume : " + navDrawerItemssa.get(position).getvolume() + "\n" + "Previous : " + navDrawerItemssa.get(position).getprevious() + "\n\n" + "Download app : " + "https://play.google.com/store/apps/details?id=com.appinhand.saudistockexchangepaid"

                    );
                }

                Intent share_via = Intent.createChooser(share_data, "Share via");
                cc.startActivity(share_via);


    }
});


        // watchlist_btn = (ImageView) convertView.findViewById(R.id.watchlist);
        // watchlist_btn.setTag(new Integer(position));


        //   TextView txtCount = (TextView) convertView.findViewById(R.id.counter);

//        greater_str1 = navDrawerItemssa.get(position).getwhole();
//        greater_not1 = Double.parseDouble(greater_str1);
//
//
//        get_previous_lcdp = navDrawerItemssa.get(position).getprevious();
//        get_int_prevoous = Double.parseDouble(get_previous_lcdp);


    //    check1 = (double) (greater_not1 / get_int_prevoous);


        //changes_format = Double.parseDouble(navDrawerItems.get(position).getwhole());

       // string_changes_fromat = format.format(check1);


        //  float_1.setText(string_changes_fromat);

        // dot_plus.setTag(position);
     //   if (check1 < 0.0) {

        if (Double.valueOf(navDrawerItemssa.get(position).getwhole())>=0.0) {
            dot_plus.setText("+"+navDrawerItemssa.get(position).getwhole());
        }
        else  if (Double.valueOf(navDrawerItemssa.get(position).getwhole())<0.0) {
            dot_plus.setText(navDrawerItemssa.get(position).getwhole());
        }
            // dot_plus.setText(String.valueOf(check1).charAt(0)+String.valueOf(String.valueOf(check1).charAt(1))+String.valueOf(check1).charAt(2)+String.valueOf(check1).charAt(3));
//
//        } else if (check1 >= 0.0) {
//            dot_plus.setText(String.valueOf("+" + string_changes_fromat));
//            // dot_plus.setText(String.valueOf("+"+check1).charAt(0)+String.valueOf(String.valueOf(check1).charAt(1))+String.valueOf(check1).charAt(2)+String.valueOf(check1).charAt(3));
//        }

       // percent_double = check1 * 100.0;
        //percentage.setTag(position);
      //  string_percent_fromat = format.format(percent_double);
        if (Double.valueOf(navDrawerItemssa.get(position).getchangePercent())>=0.0) {
            percentage.setText("+"+navDrawerItemssa.get(position).getchangePercent()+"%");
        }
        else if(Double.valueOf(navDrawerItemssa.get(position).getchangePercent())<0.0) {
            percentage.setText(navDrawerItemssa.get(position).getchangePercent()+"%");

        }

//        if (percent_double < 0.0) {
//
//
//            percentage.setText(String.valueOf(string_percent_fromat + "%"));
//        } else {
//
//            percentage.setText(String.valueOf("+" + string_percent_fromat + "%"));
//        }
        if (Double.valueOf(navDrawerItemssa.get(position).getwhole()) < 0.0) {

            imgIcon.setImageResource(R.drawable.red_trangle);
        }
        else if (Double.valueOf(navDrawerItemssa.get(position).getwhole()) >= 0.0) {

            imgIcon.setImageResource(R.drawable.green_trangle);
        }


        //imgIcon.setImageResource(navDrawerItems.get(position).getIcon());

        txtTitleindex.setText(navDrawerItemssa.get(position).getTitle());

        //format.format(check1);
        // changes_format   = Double.parseDouble(navDrawerItems.get(position).getwhole());


        float_1.setText(navDrawerItemssa.get(position).getCurrent());

        // float_plus.setText(navDrawerItems.get(position).getpercent());


        high_value.setText(navDrawerItemssa.get(position).gethigh1());

        low_value.setText(navDrawerItemssa.get(position).getlow());

        volume_value.setText(navDrawerItemssa.get(position).getvolume());


        previous_value.setText(navDrawerItemssa.get(position).getprevious());

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


    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        navDrawerItemssa.clear();
        if (charText.length() == 0) {

            navDrawerItemssa.addAll(arraylist);
        } else {
            for (search_model wp : arraylist) {
                if (wp.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    navDrawerItemssa.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

//    @Override
//    public Filter getFilter() {
//        if (valueFilter == null) {
//            valueFilter = new ValueFilter();
//        }
//        return valueFilter;
//    }
//
//
//
//    private class ValueFilter extends Filter {
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//            FilterResults results = new FilterResults();
//
//            if (constraint != null && constraint.length() > 0 && !constraint.equals("")) {
//
//                ArrayList<search_model> filterList = new ArrayList<search_model>();
////               if(constraint.equals(""))
//                for (int i = 0; i < navDrawerItemssa.size(); i++) {
//                    if ( (navDrawerItemssa.get(i).getTitle().toLowerCase() )
//                            .contains(constraint.toString().toLowerCase())) {
//
//                        search_model country = new search_model(navDrawerItemssa.get(i)
//                                .getTitle() ,  navDrawerItemssa.get(i)
//                                .getwhole(), navDrawerItemssa.get(i)
//                                .gethigh1(), navDrawerItemssa.get(i).getlow(),
//                                navDrawerItemssa.get(i).getvolume(),
//                                navDrawerItemssa.get(i).getprevious()
//                                );
//
//                        filterList.add(country);
//                    }
//                }
//                results.count = filterList.size();
//                results.values = filterList;
//            } else {
//
//                navDrawerItemssa.addAll(mStringFilterList);
//                results.count = navDrawerItemssa.size();
//                results.values = navDrawerItemssa;
//            }
//            return results;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint,
//                                      FilterResults results) {
//            navDrawerItemssa = (ArrayList<search_model>) results.values;
//            notifyDataSetChanged();
//        }
//
//    }


}
