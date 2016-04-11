package com.testbatch3.appxone.tadawulproject;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by APPXONE on 1/12/2016.
 */
public class watchlist extends Fragment {
    View root_View;
    SwipeMenuListView watch_list_data;
    ArrayList<watchlist_model> watch_item;
    watclist_adapter watchAdapter;
    int pos;
    DataBaseManager dbm;
    String publisherId = "ca-app-pub-9381472359687969/3170354534";
    String testingDeviceId = "359918043312594";
    Cursor c1;
    DecimalFormat format;
    public double check1;
    public double percent_double;
    String string_percent_fromat = "", string_changes_fromat = "";
    String string_changes = "", percantage_string = "";
    int img_drawable;
    ArrayList<Integer> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dbm = new DataBaseManager(getActivity());
        //	actionBar =((ActionBarActivity) getActivity()).getSupportActionBar();


        //	actionBar.setIcon(R.drawable.header_bg);

        root_View = inflater.inflate(R.layout.watch_list, container, false);


        format = new DecimalFormat("0.00");
        AdView mAdView = new AdView(getActivity(), null);
        String ad_Id = publisherId;
        final LinearLayout linearLayout = (LinearLayout) root_View.findViewById(R.id.adLayout);
        linearLayout.addView(mAdView);
        mAdView.setAdUnitId(ad_Id);
        mAdView.setAdSize(AdSize.SMART_BANNER);
        com.google.android.gms.ads.AdRequest adRequest = new com.google.android.gms.ads.AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {

                linearLayout.setVisibility(View.VISIBLE);
                Log.e("load", "111");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.e("failed", "111");
            }
        });

        list=new ArrayList<Integer>();
        watch_list_data = (SwipeMenuListView) root_View.findViewById(R.id.list_watchlist);
        watch_item = new ArrayList<watchlist_model>();
        load_database();
       // hitWebservice_kse2();

        watch_list_data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View rowView, int positon, long id) {

                //   Toast.makeText(rowView.getContext(), "" + positon, Toast.LENGTH_LONG).show();
                //  removeListItem(rowView, positon);
            }
        });


        SwipeMenuCreator creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu swipeMenu) {

                SwipeMenuItem openItem = new SwipeMenuItem(
                        getActivity());
                // set item background
//                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
//                        0xCE)));
//                // set item width
//                openItem.setWidth(120);
//                // set item title
//                openItem.setTitle("Open");
//                // set item title fontsize
//                openItem.setTitleSize(18);
//                // set item title font color
//                openItem.setTitleColor(Color.WHITE);
//                // add to menu

                swipeMenu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getActivity());
                // set item background
//                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
//                        0x3F, 0x25)));
                // set item width
                //  deleteItem.setWidth(110);
                deleteItem.setWidth(ActionBar.LayoutParams.MATCH_PARENT);
                // set a icon
                deleteItem.setIcon(R.drawable.delete_button_slide);

                // add to menu
                swipeMenu.addMenuItem(deleteItem);

            }
        };

        watch_list_data.setMenuCreator(creator);

        watch_list_data.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int ir, SwipeMenu swipeMenu, int index) {
                switch (index) {
                    case 0:
                        // open


                        break;
                    case 1:
                        // delete
                        pos = watclist_adapter.navDrawerItems111.get(ir).get_id();

                        stock_list.query = "DELETE FROM " + AppSettings.DATABASE_TABLE + " WHERE " + AppSettings.KEY_ID + " = " + pos;
                        Log.e("query", "" + stock_list.query + pos);
                        dbm.insert_update(stock_list.query);

                        watch_item.remove(ir);
                        watchAdapter.notifyDataSetChanged();


                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }

        });

        watch_list_data.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);
        //  load_database();

//        stock_list.query = "SELECT * FROM '" + AppSettings.DATABASE_TABLE + "'";
//        Log.e("SELECT QUERY", stock_list.query);
//
//        c1 = dbm.selectQuery(stock_list.query);

        return root_View;


    }


//    public void hitWebservice_kse2() {
//
//        final ProgressDialog dialog;
//        dialog = new ProgressDialog(getActivity());
//        dialog.setMessage("Please wait for few seconds...");
//        dialog.setCanceledOnTouchOutside(false);
//        try {
//            dialog.show();
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//
//        RestAdapter restAdapter = new RestAdapter.Builder()
//                .setEndpoint("http://appinhand.net/LiveApplications/psx").build();
//        gitapi git = restAdapter.create(gitapi.class);
//
//        git.kse2_fatch(new Callback<kse2_fatch>() {
//            @Override
//            public void success(kse2_fatch model1, Response response) {
//
//                dialog.dismiss();
//
//
//                // watch_item.clear();
//                if (model1.getStatus().equalsIgnoreCase("true")) {
//                    for (int i = 0; i < model1.getMarket().size(); i++) {
//                        // watch_item.add(new watchlist_model(model1.getMarket().get(i).getSymbol(), model1.getMarket().get(i).getChanges(), model1.getMarket().get(i).getHigh(), model1.getMarket().get(i).getLow(), model1.getMarket().get(i).getVolume(), model1.getMarket().get(i).getLdcp()));
//
//                        //watch_item.add(new search_model(model1.getMarket().get(i).getSymbol(), model1.getMarket().get(i).getChanges(), model1.getMarket().get(i).getHigh(), model1.getMarket().get(i).getLow(), model1.getMarket().get(i).getVolume(), model1.getMarket().get(i).getLdcp()));
//                        Log.i("correct", "correct");
//
//                    }
//
//
////                    try {
////                        if (c1 != null && c1.moveToFirst()) {
////                            do {
////
////                                int id_stock1 = c1.getInt(c1.getColumnIndex(AppSettings.KEY_ID));
////
////                                String low1 = c1.getString(c1
////                                        .getColumnIndex(AppSettings.KEY_LOW));
////                                String name1 = c1.getString(c1.getColumnIndex(AppSettings.KEY_NAME));
////                                String high1 = c1.getString(c1
////                                        .getColumnIndex(AppSettings.KEY_HIGH));
////                                String changes1 = c1.getString(c1
////                                        .getColumnIndex(AppSettings.KEY_CHANGES));
////                                String ratio1 = c1.getString(c1
////                                        .getColumnIndex(AppSettings.KEY_RATIO));
////                                int icon1 = c1.getInt(c1.getColumnIndex(AppSettings.KEY_ICON));
////                                String percantage1 = c1.getString(c1
////                                        .getColumnIndex(AppSettings.KEY_PERCANTAGE));
////
////                                String volume1 = c1.getString(c1
////                                        .getColumnIndex(AppSettings.KEY_VOLUME));
////                                String previous1 = c1.getString(c1
////                                        .getColumnIndex(AppSettings.KEY_PREVIOUS));
////                             //   for (int i = 0; i < model1.getMarket().size(); i++) {
////                                 //   if (model1.getMarket().get(i).getSymbol() == name1) {
////                                        watch_item.add(new watchlist_model(id_stock1, name1, changes1, ratio1, icon1, percantage1, high1, low1, volume1, previous1));
//
//                    //   }
//
//
//                    //watch_item.add(new search_model(model1.getMarket().get(i).getSymbol(), model1.getMarket().get(i).getChanges(), model1.getMarket().get(i).getHigh(), model1.getMarket().get(i).getLow(), model1.getMarket().get(i).getVolume(), model1.getMarket().get(i).getLdcp()));
//                    //   Log.i("correct", "correct");
//
//                    // }
//
//                    // int id = c.getInt(c.getColumnIndex(AppSettings.KEY_ICON));
//
//
////                                int id_stock1 = c1.getInt(c1.getColumnIndex(AppSettings.KEY_ID));
////
////                                String low1 = c1.getString(c1
////                                        .getColumnIndex(AppSettings.KEY_LOW));
////                                String name1 = c1.getString(c1.getColumnIndex(AppSettings.KEY_NAME));
////                                String high1 = c1.getString(c1
////                                        .getColumnIndex(AppSettings.KEY_HIGH));
////                                String changes1 = c1.getString(c1
////                                        .getColumnIndex(AppSettings.KEY_CHANGES));
////                                String ratio1 = c1.getString(c1
////                                        .getColumnIndex(AppSettings.KEY_RATIO));
////                                int icon1 = c1.getInt(c1.getColumnIndex(AppSettings.KEY_ICON));
////                                String percantage1 = c1.getString(c1
////                                        .getColumnIndex(AppSettings.KEY_PERCANTAGE));
////
////                                String volume1 = c1.getString(c1
////                                        .getColumnIndex(AppSettings.KEY_VOLUME));
////                                String previous1 = c1.getString(c1
////                                        .getColumnIndex(AppSettings.KEY_PREVIOUS));
//
//                    // watch_item.add(new watchlist_model(id_stock1, name1, changes1, ratio1, icon1, percantage1, high1, low1, volume1, previous1));
//
//
//                    //   Toast.makeText(getActivity(), "[LOW:" + low1 + "], [name: " + name1 + "], [high: "
//                    //         + high1 + "]", Toast.LENGTH_LONG).show();
//
//
////                            } while (c1.moveToNext());
////                        }
////                    } finally {
////                        c1.close();
////                    }
//
//
//                    // time_date  =   model.getTime();
//                    // data =convertDate(String.valueOf(time_date), "dd MMM yy hh:mm");
//                    //  dateTime.setText(data);
//                    //  open_value=  model.getStoke().getOpen();
//                    // openOrNot.setText(open_value);
//
//
//                    //marketList1 = (ListView) rootView1.findViewById(R.id.ist_market);
//                    //adapter = new search_adapter(getContext(), marketItems1);
//                    //marketList1.setAdapter(adapter);
//                    //   watchAdapter = new watclist_adapter(getContext(), watch_item);
//
//                    //  watchAdapter = new watclist_adapter(getContext(), watch_item);
//                    //  watch_list_data.setAdapter(watchAdapter);
//
//
//                    //  watch_item.get(0).getTitle();
//                    //   watch_list_data.setAdapter(watchAdapter);
//
////                    if (isConnectingToInternet() && marketItems1.size() >= 0) {
////                        editText_watcher.setEnabled(true);
////                        check_status = 1;
////                    }
//
//
//                } else {
//                    Toast toast = Toast.makeText(getActivity(), "Error Connection", Toast.LENGTH_SHORT);
//                    toast.show();
//
//                }
//
//
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                dialog.dismiss();
//
//            }
//        });
//    }


//    protected void removeListItem(View rowView, final int positon) {
//
//        final Animation animation = AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_out_right);
//        rowView.startAnimation(animation);
//        Handler handle = new Handler();
//        handle.postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//
//                pos = watclist_adapter.navDrawerItems111.get(positon).get_id();
//
//                stock_list.query = "DELETE FROM " + AppSettings.DATABASE_TABLE + " WHERE " + AppSettings.KEY_ID + " = " + pos;
//                Log.e("query", "" + stock_list.query + pos);
//                stock_list.dbManager.insert_update(stock_list.query);
//
//                watch_item.remove(positon);
//                watchAdapter.notifyDataSetChanged();
//
//
//                // watch_list_data.noti
//                // listAdapter.notifyDataSetChanged();
//                animation.cancel();
//            }
//        }, 1000);
//
//    }

    public void load_database() {

        watch_item.clear();

        stock_list.query = "SELECT * FROM '" + AppSettings.DATABASE_TABLE + "'";
        Log.e("SELECT QUERY", stock_list.query);

        final Cursor c1 = dbm.selectQuery(stock_list.query);

        final ProgressDialog dialog;
        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("Please wait for few seconds...");
        dialog.setCanceledOnTouchOutside(false);
        try {
            dialog.show();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://appinhand.net/LiveApplications/psx").build();
        gitapi git = restAdapter.create(gitapi.class);

        git.kse2_fatch(new Callback<kse2_fatch>() {
            @Override
            public void success(kse2_fatch model1, Response response) {

                dialog.dismiss();


                // watch_item.clear();
                if (model1.getStatus().equalsIgnoreCase("true")) {
//                    for (int i = 0; i < model1.getMarket().size(); i++) {
//                        // watch_item.add(new watchlist_model(model1.getMarket().get(i).getSymbol(), model1.getMarket().get(i).getChanges(), model1.getMarket().get(i).getHigh(), model1.getMarket().get(i).getLow(), model1.getMarket().get(i).getVolume(), model1.getMarket().get(i).getLdcp()));
//
//                        //watch_item.add(new search_model(model1.getMarket().get(i).getSymbol(), model1.getMarket().get(i).getChanges(), model1.getMarket().get(i).getHigh(), model1.getMarket().get(i).getLow(), model1.getMarket().get(i).getVolume(), model1.getMarket().get(i).getLdcp()));
//                        Log.i("correct", "correct");
//
//                    }

                    //list.add(0);
                   // Collections.sort(list , Collections.reverseOrder());
                    try {
                        if (c1 != null && c1.moveToLast()) {
                            do {
                                // int id = c.getInt(c.getColumnIndex(AppSettings.KEY_ICON));
                                String POS = c1.getString(c1
                                        .getColumnIndex(AppSettings.KEY_POSITION));
                              //  String name1 = c1.getString(c1.getColumnIndex(AppSettings.KEY_NAME));
                                int pos_int = Integer.parseInt(POS);
                             //   String company_name = model1.getMarket().get(pos_int).getSymbol();

                                //if (company_name == name1) {


                                // if(name1==)
//int pos_int=Integer.parseInt(POS);
                                int id_stock1 = c1.getInt(c1.getColumnIndex(AppSettings.KEY_ID));
//
//                    String low1 = c1.getString(c1
//                            .getColumnIndex(AppSettings.KEY_LOW));
//                    String name1 = c1.getString(c1.getColumnIndex(AppSettings.KEY_NAME));
//                                if(name1==)
//                    String high1 = c1.getString(c1
//                            .getColumnIndex(AppSettings.KEY_HIGH));
//                    String changes1 = c1.getString(c1
//                            .getColumnIndex(AppSettings.KEY_CHANGES));

                              //  String ratio1 = c1.getString(c1
                               //         .getColumnIndex(AppSettings.KEY_RATIO));
                               // int icon1 = c1.getInt(c1.getColumnIndex(AppSettings.KEY_ICON));
                                //String percantage1 = c1.getString(c1
                                  //      .getColumnIndex(AppSettings.KEY_PERCANTAGE));
//
//                    String volume1 = c1.getString(c1
//                            .getColumnIndex(AppSettings.KEY_VOLUME));
//                    String previous1 = c1.getString(c1
//                            .getColumnIndex(AppSettings.KEY_PREVIOUS));


                                //greater_str1 = navDrawerItems11.get(position).getwhole();
                                //  greater_not1 = Double.parseDouble(greater_str1);
                                String changes = model1.getMarket().get(pos_int).getChanges();
                                double greater_not1 = Double.parseDouble(changes);

                                String prevoius = model1.getMarket().get(pos_int).getLdcp();
                                double get_int_prevoous = Double.parseDouble(prevoius);

                                //  get_previous_lcdp = navDrawerItems11.get(position).getprevious();
                                // get_int_prevoous = Double.parseDouble(get_previous_lcdp);


                                check1 = (double) (greater_not1 / get_int_prevoous);


                                //changes_format = Double.parseDouble(navDrawerItems.get(position).getwhole());

                                string_changes_fromat = format.format(check1);


                                //  float_1.setText(string_changes_fromat);

                                // dot_plus.setTag(position);
                                if (check1 < 0.0) {
                                    string_changes = string_changes_fromat;
                                    // dot_plus.setText(String.valueOf(string_changes_fromat));

                                    // dot_plus.setText(String.valueOf(check1).charAt(0)+String.valueOf(String.valueOf(check1).charAt(1))+String.valueOf(check1).charAt(2)+String.valueOf(check1).charAt(3));

                                } else if (check1 >= 0.0) {
                                    string_changes = "+" + string_changes_fromat;

                                    // dot_plus.setText(String.valueOf("+" + string_changes_fromat));
                                    // dot_plus.setText(String.valueOf("+"+check1).charAt(0)+String.valueOf(String.valueOf(check1).charAt(1))+String.valueOf(check1).charAt(2)+String.valueOf(check1).charAt(3));
                                }

                                percent_double = check1 * 100.0;
                                //percentage.setTag(position);
                                string_percent_fromat = format.format(percent_double);
                                if (percent_double < 0.0) {

                                    percantage_string = string_percent_fromat + "%";
                                    // percentage.setText(String.valueOf(string_percent_fromat + "%"));
                                } else {
                                    percantage_string = "+" + string_percent_fromat + "%";

                                    //  percentage.setText(String.valueOf("+" + string_percent_fromat + "%"));
                                }
                                if (check1 < 0.0) {
                                    img_drawable = R.drawable.red_trangle;
                                    //  imgIcon.setImageResource(R.drawable.red_trangle);
                                } else if (check1 >= 0.0) {
                                    img_drawable = R.drawable.green_trangle;

                                    // imgIcon.setImageResource(R.drawable.green_trangle);
                                }


                                watch_item.add(new watchlist_model(id_stock1, model1.getMarket().get(pos_int).getSymbol(), model1.getMarket().get(pos_int).getChanges(), string_changes, img_drawable, percantage_string, model1.getMarket().get(pos_int).getHigh(), model1.getMarket().get(pos_int).getLow(), model1.getMarket().get(pos_int).getVolume(), model1.getMarket().get(pos_int).getLdcp()));

                                //  watch_item.add(new watchlist_model(id_stock1, name1, changes1, ratio1, icon1, percantage1, high1, low1, volume1, previous1));


                                //   Toast.makeText(getActivity(), "[LOW:" + low1 + "], [name: " + name1 + "], [high: "
                                //         + high1 + "]", Toast.LENGTH_LONG).show();
                                //  }
                            } while (c1.moveToPrevious());
                        }

                    } finally {
                        c1.close();
                    }

                    watchAdapter = new watclist_adapter(getContext(), watch_item);
                    watch_list_data.setAdapter(watchAdapter);


//                    try {
//                        if (c1 != null && c1.moveToFirst()) {
//                            do {
//
//                                int id_stock1 = c1.getInt(c1.getColumnIndex(AppSettings.KEY_ID));
//
//                                String low1 = c1.getString(c1
//                                        .getColumnIndex(AppSettings.KEY_LOW));
//                                String name1 = c1.getString(c1.getColumnIndex(AppSettings.KEY_NAME));
//                                String high1 = c1.getString(c1
//                                        .getColumnIndex(AppSettings.KEY_HIGH));
//                                String changes1 = c1.getString(c1
//                                        .getColumnIndex(AppSettings.KEY_CHANGES));
//                                String ratio1 = c1.getString(c1
//                                        .getColumnIndex(AppSettings.KEY_RATIO));
//                                int icon1 = c1.getInt(c1.getColumnIndex(AppSettings.KEY_ICON));
//                                String percantage1 = c1.getString(c1
//                                        .getColumnIndex(AppSettings.KEY_PERCANTAGE));
//
//                                String volume1 = c1.getString(c1
//                                        .getColumnIndex(AppSettings.KEY_VOLUME));
//                                String previous1 = c1.getString(c1
//                                        .getColumnIndex(AppSettings.KEY_PREVIOUS));
//                             //   for (int i = 0; i < model1.getMarket().size(); i++) {
//                                 //   if (model1.getMarket().get(i).getSymbol() == name1) {
//                                        watch_item.add(new watchlist_model(id_stock1, name1, changes1, ratio1, icon1, percantage1, high1, low1, volume1, previous1));

                    //   }


                    //watch_item.add(new search_model(model1.getMarket().get(i).getSymbol(), model1.getMarket().get(i).getChanges(), model1.getMarket().get(i).getHigh(), model1.getMarket().get(i).getLow(), model1.getMarket().get(i).getVolume(), model1.getMarket().get(i).getLdcp()));
                    //   Log.i("correct", "correct");

                    // }

                    // int id = c.getInt(c.getColumnIndex(AppSettings.KEY_ICON));


//                                int id_stock1 = c1.getInt(c1.getColumnIndex(AppSettings.KEY_ID));
//
//                                String low1 = c1.getString(c1
//                                        .getColumnIndex(AppSettings.KEY_LOW));
//                                String name1 = c1.getString(c1.getColumnIndex(AppSettings.KEY_NAME));
//                                String high1 = c1.getString(c1
//                                        .getColumnIndex(AppSettings.KEY_HIGH));
//                                String changes1 = c1.getString(c1
//                                        .getColumnIndex(AppSettings.KEY_CHANGES));
//                                String ratio1 = c1.getString(c1
//                                        .getColumnIndex(AppSettings.KEY_RATIO));
//                                int icon1 = c1.getInt(c1.getColumnIndex(AppSettings.KEY_ICON));
//                                String percantage1 = c1.getString(c1
//                                        .getColumnIndex(AppSettings.KEY_PERCANTAGE));
//
//                                String volume1 = c1.getString(c1
//                                        .getColumnIndex(AppSettings.KEY_VOLUME));
//                                String previous1 = c1.getString(c1
//                                        .getColumnIndex(AppSettings.KEY_PREVIOUS));

                    // watch_item.add(new watchlist_model(id_stock1, name1, changes1, ratio1, icon1, percantage1, high1, low1, volume1, previous1));


                    //   Toast.makeText(getActivity(), "[LOW:" + low1 + "], [name: " + name1 + "], [high: "
                    //         + high1 + "]", Toast.LENGTH_LONG).show();


//                            } while (c1.moveToNext());
//                        }
//                    } finally {
//                        c1.close();
//                    }


                    // time_date  =   model.getTime();
                    // data =convertDate(String.valueOf(time_date), "dd MMM yy hh:mm");
                    //  dateTime.setText(data);
                    //  open_value=  model.getStoke().getOpen();
                    // openOrNot.setText(open_value);


                    //marketList1 = (ListView) rootView1.findViewById(R.id.ist_market);
                    //adapter = new search_adapter(getContext(), marketItems1);
                    //marketList1.setAdapter(adapter);
                    //   watchAdapter = new watclist_adapter(getContext(), watch_item);

                    //  watchAdapter = new watclist_adapter(getContext(), watch_item);
                    //  watch_list_data.setAdapter(watchAdapter);


                    //  watch_item.get(0).getTitle();
                    //   watch_list_data.setAdapter(watchAdapter);

//                    if (isConnectingToInternet() && marketItems1.size() >= 0) {
//                        editText_watcher.setEnabled(true);
//                        check_status = 1;
//                    }


                } else {
                    Toast toast = Toast.makeText(getActivity(), "Error Connection", Toast.LENGTH_SHORT);
                    toast.show();

                }


            }

            @Override
            public void failure(RetrofitError error) {
                dialog.dismiss();

            }
        });


        // for (int i = 0; i < model.getMarkets().size(); i++) {


        //    watch_item.add(new watchlist_model(model.getMarkets().get(i).getType(),model.getMarkets().get(i).getCurrent(),model.getMarkets().get(i).getChange(),model.getMarkets().get(i).getHigh(),model.getMarkets().get(i).getLow()));
        //  }


//        stock_list.query = "SELECT * FROM '" + AppSettings.DATABASE_TABLE + "'";
//        Log.e("SELECT QUERY", stock_list.query);
//
//        Cursor c1 = dbm.selectQuery(stock_list.query);


//
//        try {
//            if (c1 != null && c1.moveToFirst()) {
//                do {
//                    // int id = c.getInt(c.getColumnIndex(AppSettings.KEY_ICON));
//                    String POS = c1.getString(c1
//                            .getColumnIndex(AppSettings.KEY_POSITION));
//
////                    int id_stock1 = c1.getInt(c1.getColumnIndex(AppSettings.KEY_ID));
////
////                    String low1 = c1.getString(c1
////                            .getColumnIndex(AppSettings.KEY_LOW));
////                    String name1 = c1.getString(c1.getColumnIndex(AppSettings.KEY_NAME));
////                    String high1 = c1.getString(c1
////                            .getColumnIndex(AppSettings.KEY_HIGH));
////                    String changes1 = c1.getString(c1
////                            .getColumnIndex(AppSettings.KEY_CHANGES));
////                    String ratio1 = c1.getString(c1
////                            .getColumnIndex(AppSettings.KEY_RATIO));
////                    int icon1 = c1.getInt(c1.getColumnIndex(AppSettings.KEY_ICON));
////                    String percantage1 = c1.getString(c1
////                            .getColumnIndex(AppSettings.KEY_PERCANTAGE));
////
////                    String volume1 = c1.getString(c1
////                            .getColumnIndex(AppSettings.KEY_VOLUME));
////                    String previous1 = c1.getString(c1
////                            .getColumnIndex(AppSettings.KEY_PREVIOUS));
//
//                    watch_item.add(new watchlist_model(id_stock1, name1, changes1, ratio1, icon1, percantage1, high1, low1, volume1, previous1));
//
//
//                    //   Toast.makeText(getActivity(), "[LOW:" + low1 + "], [name: " + name1 + "], [high: "
//                    //         + high1 + "]", Toast.LENGTH_LONG).show();
//
//                } while (c1.moveToNext());
//            }
//        } finally {
//            c1.close();
//        }
//
//        watchAdapter = new watclist_adapter(getContext(), watch_item);
//        watch_list_data.setAdapter(watchAdapter);


    }
}
