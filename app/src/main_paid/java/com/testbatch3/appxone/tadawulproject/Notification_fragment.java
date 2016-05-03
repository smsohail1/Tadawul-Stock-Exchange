package com.testbatch3.appxone.tadawulproject;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nhaarman.listviewanimations.appearance.AnimationAdapter;
import com.vincentbrison.openlibraries.android.dualcache.lib.DualCache;
import com.vincentbrison.openlibraries.android.dualcache.lib.DualCacheBuilder;
import com.vincentbrison.openlibraries.android.dualcache.lib.DualCacheContextUtils;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by APPXONE on 4/13/2016.
 */
public class Notification_fragment extends Fragment {
    //  View root_View;

    public ArrayList<notify_model> stockItems_notify;
    public Notify_class adapter;
    public SwipeMenuListView stockList1;
    TextView dateTime, status, last_updated;
    TextView openOrNot;
    View rootView;
    public double percent_double;
    int img_drawable;

    long time_date;
    String data = "", open_value = "";
    public String date_time1 = "";
    public String close_not1 = "";
    public int id_stock = 0;
    String symbol1 = "";
    DecimalFormat format,format_current;
    public double check1;
    private AnimationAdapter mAnimAdapter;

    public ActionBar actionBar11;
    public boolean isErrorOccured = false;

    public DataBaseManager dbManager11;
    String publisherId = "ca-app-pub-9381472359687969/1657257730";
    String testingDeviceId = "359918043312594";


    String mydate = "";
    String string_changes_fromat = "", string_changes = "", string_percent_fromat = "", percantage_string = "";


    public DataBaseManager dbm;
    int posn;


    SharedPreferences pref_stocks;
    SharedPreferences.Editor edit_stocks;

    Context ctx;
    SharedPreferences pref;
    SharedPreferences.Editor edit;

    SharedPreferences pref1;
    SharedPreferences.Editor edit1;

    DualCache<stocklistitem> cache;
    ArrayList<String> cacheKeys;
    SharedPreferences.Editor editor;
    SharedPreferences sharedpreferences;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.notfification_fragment, container, false);

        dbm = new DataBaseManager(getActivity());

        ctx = getActivity();

        pref_stocks = getActivity().getSharedPreferences("drawer_pos", getActivity().MODE_PRIVATE);

        edit_stocks = pref_stocks.edit();

        String position = pref_stocks.getString("position", "0");


        posn = pref_stocks.getInt("position", 0);


//        dbManager11 = new DataBaseManager(getActivity());
//
//        Log.e("before", "sds1aaa");
//        try {
//            dbManager11.createDataBase();
//
//
//            Log.e("try111", "sds1aaa");
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            isErrorOccured = true;
//            Log.e("catch", "sds1");
//

//        }

        actionBar11 = ((ActionBarActivity) getActivity()).getSupportActionBar();


        format = new DecimalFormat("0.000");
        format_current=new DecimalFormat("0.000");
        stockItems_notify = new ArrayList<notify_model>();


        adapter = new Notify_class(getContext(), stockItems_notify);

        stockList1 = (SwipeMenuListView) rootView.findViewById(R.id.notify_stocks);


        sharedpreferences = getActivity().getSharedPreferences("notify_pref",
                Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();


        DualCacheContextUtils.setContext(getActivity());
        cacheKeys = new ArrayList<>();
        cache = new DualCacheBuilder<stocklistitem>("notify_pref", getVersionNumber(getActivity()), stocklistitem.class)
                .useDefaultSerializerInRam(getMaxMemorySize(getActivity()))
                .useDefaultSerializerInDisk(getMaxMemorySize(getActivity()), true);


        DualCacheContextUtils.setContext(getActivity());
        if (isConnectingToInternet()) {


//            hitWebservice_kse1();
            setCacheContact();
            load_database();
            //setStatusUpdate();
            // hitWebservice_kse2();

        } else {


            setCacheContact();
            //setStatusUpdate();

        }


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

        stockList1.setMenuCreator(creator);


        stockList1.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int ir, SwipeMenu swipeMenu, int index) {
                switch (index) {
                    case 0:
                        // open


                        break;
                    case 1:
                        // delete
                        int pos = Notify_class.navDrawerItems111.get(ir).getid();

                        stock_list.query = "DELETE FROM " + AppSettings.DATABASE_TABLE_NOTIFY + " WHERE " + AppSettings.KEY_ID + " = " + pos;
                        Log.e("query", "" + stock_list.query + pos);
                        dbm.insert_update(stock_list.query);

                        stockItems_notify.remove(ir);
                        adapter.notifyDataSetChanged();


                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }

        });


        return rootView;
    }

    public void setCacheContact() {
        ArrayList<notify_model> list = new ArrayList<>();
        String pref_list = sharedpreferences.getString("notify_pref", "");
//        String [] pref_list_arr = new String[pref_list.length()];
//        if (!pref_list.equals(""))
//            pref_list_arr = pref_list.split(",");
//
//        Collections.addAll(cacheKeys,pref_list_arr);
//        //cacheKeys  = (ArrayList<String>) Arrays.asList(pref_list_arr);
//        if (cacheKeys == null)
//            cacheKeys = new ArrayList<>();
//        if (cacheKeys == null) {
//            return;
//        }
//        if (!cacheKeys.isEmpty()) {
//            for (String key : cacheKeys) {
//                stocklistitem item = cache.get(key);
//                list.add(item);
//            }
////            Collections.sort(list, new Comparator<stocklistitem>() {
////                @Override
////                public int compare(stocklistitem chatMessage, stocklistitem t1) {
////                    return chatMessage.getTitle().compareTo(t1.getTitle());
////                }
////            });
//        }
        Type type = new TypeToken<ArrayList<notify_model>>() {
        }.getType();
        String json = sharedpreferences.getString("notify_pref", "");
        list = new Gson().fromJson(json, type);
        if (list != null) {
            if (!list.isEmpty()) {
                this.stockItems_notify.clear();
                this.stockItems_notify.addAll(list);
                adapter = new Notify_class(getContext(), stockItems_notify);
                stockList1.setAdapter(adapter);
            }
        }
    }

    public static int getVersionNumber(Context context) {
        int versionName = 0;
        try {
            versionName = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionName;
    }


    public static int getMaxMemorySize(Context context) {
        ActivityManager manager =
                (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        int max = manager.getLargeMemoryClass() * 1024;

        return max / 16;
    }

//    private void setAlphaAdapter() {
////        if (!(mAnimAdapter instanceof AlphaInAnimationAdapter)) {
////            mAnimAdapter = new AlphaInAnimationAdapter(adapter);
////            mAnimAdapter.setAbsListView(stockList1);
////            stockList1.setAdapter(mAnimAdapter);
////        }
//
//        if (!(mAnimAdapter instanceof SwingBottomInAnimationAdapter)) {
//            mAnimAdapter = new SwingBottomInAnimationAdapter(adapter);
//            mAnimAdapter.setAbsListView(stockList1);
//            stockList1.setAdapter(mAnimAdapter);
//        }
//    }


    public void load_database() {

        stockItems_notify.clear();

        stock_list.query = "SELECT * FROM '" + AppSettings.DATABASE_TABLE_NOTIFY + "'";
        Log.e("SELECT QUERY", stock_list.query);

        Cursor c1 = dbm.selectQuery(stock_list.query);

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

        //list.add(0);
        // Collections.sort(list , Collections.reverseOrder());
        try {
            if (c1 != null && c1.moveToLast()) {
                do {
                    String POS = c1.getString(c1
                            .getColumnIndex(AppSettings.KEY_POSITION));
                    int pos_int = Integer.parseInt(POS);

                    int id_stock1 = c1.getInt(c1.getColumnIndex(AppSettings.KEY_ID));

                    String low1 = c1.getString(c1
                            .getColumnIndex(AppSettings.KEY_LOW));
                    String name1 = c1.getString(c1.getColumnIndex(AppSettings.KEY_NAME));

                    String high1 = c1.getString(c1
                            .getColumnIndex(AppSettings.KEY_HIGH));
                    String changes1 = c1.getString(c1
                            .getColumnIndex(AppSettings.KEY_CHANGES));


                    String volume1 = c1.getString(c1
                            .getColumnIndex(AppSettings.KEY_VOLUME));
                    String previous1 = c1.getString(c1
                            .getColumnIndex(AppSettings.KEY_PREVIOUS));

                    String current_Web = c1.getString(c1
                            .getColumnIndex(AppSettings.KEY_CURRENT_WEB));
                    double greater_not1 = Double.parseDouble(changes1);
                    if(Double.valueOf(changes1)>0.0)
                    {
                        changes1="+"+changes1;
                      //  dot_plus.setText("+"+navDrawerItems11.get(position).getwhole());

                    }
                    else if(Double.valueOf(changes1)<=0.0){
                        changes1=changes1;

                      //  dot_plus.setText(navDrawerItems11.get(position).getwhole());
                    }

                    double get_int_prevoous = Double.parseDouble(previous1);

                    check1 = (double) (greater_not1 / get_int_prevoous);


                    string_changes_fromat = String.valueOf(check1);


                    if (check1 < 0.0) {
                        string_changes = string_changes_fromat;

                    } else if (check1 >= 0.0) {
                        string_changes = "+" + string_changes_fromat;
                    }

                    percent_double = check1 * 100.0;
                    string_percent_fromat = format.format(percent_double);
                    if (Double.parseDouble(string_percent_fromat) < 0.0) {

                        if(format_current.format(check1).equalsIgnoreCase("-0.000") || format_current.format(check1).equalsIgnoreCase("0.000") ||format_current.format(check1).equalsIgnoreCase(".000"))
                        {
                            percantage_string="-0.00%";
                           // percentage.setText(String.valueOf("-0.00" + "%"));

                        }
                        else  if (string_percent_fromat.charAt(1) == '.') {
                          //  percentage.setText(String.valueOf("0" + string_percent_fromat + "%"));

                            percantage_string="0" + string_percent_fromat + "%";
                        } else {
                            percantage_string=string_percent_fromat+"%";
                            //percentage.setText(String.valueOf(string_percent_fromat + "%"));
                        }

                     //   percantage_string = string_percent_fromat + "%";
                    }

                    else  if (Double.parseDouble(string_percent_fromat) >= 0.0)  {

                        if(format_current.format(check1).equalsIgnoreCase("+0.000") || format_current.format(check1).equalsIgnoreCase("0.000") ||format_current.format(check1).equalsIgnoreCase(".000"))
                        {
                            percantage_string="+0.00" + "%";
                          //  percentage.setText(String.valueOf("+0.00" + "%"));

                        }
                        else  if (string_percent_fromat.charAt(1) == '.') {
                            percantage_string="+" + string_percent_fromat + "%";
                           // percentage.setText(String.valueOf("+" + string_percent_fromat + "%"));

                        } else {
                            percantage_string="+" + string_percent_fromat + "%";
                          //  percentage.setText(String.valueOf("+" + string_percent_fromat + "%"));
                        }

                        //percantage_string = "+" + string_percent_fromat + "%";

                    }
                    if (Double.valueOf(string_changes_fromat) < 0.0) {
                        img_drawable = R.drawable.red_trangle;
                    } else if (Double.valueOf(string_changes_fromat) >= 0.0) {
                        img_drawable = R.drawable.green_trangle;

                    }


                    stockItems_notify.add(new notify_model(id_stock1, name1, changes1, string_changes, img_drawable, percantage_string, high1, low1, volume1, previous1, pos_int + "", current_Web));
                    string_changes = "";
                    percantage_string = "";

                } while (c1.moveToPrevious());
            }

        } finally {
            c1.close();
        }

//                    watchAdapter = new watclist_adapter(getContext(), watch_item);
//                    watch_list_data.setAdapter(watchAdapter);

        //   stockList1 = (ListView) rootView.findViewById(R.id.notify_stocks);
        adapter = new Notify_class(getContext(), stockItems_notify);
        //  setAlphaAdapter();
        stockList1.setAdapter(adapter);

        String json_notify = new Gson().toJson(stockItems_notify);
        editor.putString("notify_pref", json_notify).apply();


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


    public void setStatusUpdate() {
        //  pref = getActivity().getSharedPreferences("pref_SoundDown", getActivity().MODE_PRIVATE);
//        String json_data = pref.getString("status", "");
//        String loop_inc = "";
//        for (int loop_format12 = 1; loop_format12 < json_data.length() - 1; loop_format12++) {
//            loop_inc += json_data.charAt(loop_format12);
//            //openOrNot.setText(String.valueOf(json_last.charAt(loop_format1)));
//
//        }
//        dateTime.setText(loop_inc.toString());


//        String json_last = pref.getString("last", "");
//        String che = "";
//        for (int loop_format1 = 8; loop_format1 < json_last.length() - 1; loop_format1++) {
//            che += json_last.charAt(loop_format1);
//            //openOrNot.setText(String.valueOf(json_last.charAt(loop_format1)));
//
//        }
//
//        openOrNot.setText(che.toString());

        // openOrNot.setText(json_last);

        // edit = pref.edit();
        //edit.putInt("drawer_pos", position);
        //edit.apply();
    }

//    public static int getVersionNumber(Context context) {
//        int versionName = 0;
//        try {
//            versionName = context.getPackageManager()
//                    .getPackageInfo(context.getPackageName(), 0).versionCode;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return versionName;
//    }

//    public static int getMaxMemorySize(Context context) {
//        ActivityManager manager =
//                (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
//
//        int max = manager.getLargeMemoryClass() * 1024;
//
//        return max / 16;
//    }

    String s = "";

//    public void
//    addCacheContact(notify_model item) {
//        item.setTitle(item.getTitle().trim().toLowerCase().replace(" ", "").replace("-", "").replace("-", "").replace(".", "").replace("(", "").replace(")", "").replace("&", ""));
//        if (cacheKeys.contains(item.getTitle())) {
//            cache.delete(item.getTitle());
//            cache.put(item.getTitle(), item);
//        } else {
//            cacheKeys.add(item.getTitle());
//            cache.put(item.getTitle(), item);
//        }
//
//        s = s.equals("") ? item.getTitle() : s + "," + item.getTitle();
//        editor.putString("stocks", s).apply();
//
//
//    }

//    public void setCacheContact() {
//        ArrayList<notify_model> list = new ArrayList<>();
//        String pref_list = sharedpreferences.getString("stocks", "");
//
//        Type type = new TypeToken<ArrayList<notify_model>>() {
//        }.getType();
//        String json = sharedpreferences.getString("stocks", "");
//        list = new Gson().fromJson(json, type);
//        if (list != null) {
//            if (!list.isEmpty()) {
//                this.stockItems.clear();
//                this.stockItems.addAll(list);
//                adapter = new Notify_class(getContext(), stockItems);
//                stockList1.setAdapter(adapter);
//            }
//        }
//    }


    public boolean isConnectingToInternet() {
        ConnectivityManager connectivity = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }

        }
        return false;
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
//                Log.e("url", response.getUrl().toString());
//                stockItems.clear();
//
////                cache = new DualCacheBuilder<>(StorageUtils.CHAT, num, stocklistitem.class)
////                        .useDefaultSerializerInRam(StorageUtils.getMaxMemorySize(getActivity()))
////                        .useDefaultSerializerInDisk(StorageUtils.getMaxMemorySize(getActivity()),
////                                true);
//
//                if (model1.getStatus().equalsIgnoreCase("true")) {
//                    for (int i = 0; i < model1.getMarket().size(); i++) {
//
//                        stockItems.add(new notify_model(model1.getMarket().get(i).getSymbol(), model1.getMarket().get(i).getChanges(), model1.getMarket().get(i).getHigh(), model1.getMarket().get(i).getLow(), model1.getMarket().get(i).getVolume(), model1.getMarket().get(i).getLdcp(), i + ""));
//                        Log.i("correct", "correct");
//
//                    }
//
//                    adapter = new Notify_class(getContext(), stockItems);
//                    stockList1.setAdapter(adapter);
//
////               Toast t=Toast.makeText(getActivity().getApplicationContext(),stockItems.get(model1.getMarket().size()-1).gethigh(),Toast.LENGTH_SHORT);
////                    t.show();
//
////                    date_time1 = model1.getStoke().get(0).getValue();
////                    close_not1 = model1.getStoke().get(1).getValue();
////
////                    SimpleDateFormat srcDf = new SimpleDateFormat(
////                            "yyyy-MM-dd hh:mm:ss");
////
////                    try {
////                        Date date = srcDf.parse(date_time1);
////                        SimpleDateFormat destDf = new SimpleDateFormat("dd MMM,yy HH:mm");
////                        mydate = destDf.format(date);
////                    } catch (ParseException e) {
////                        e.printStackTrace();
////                    }
////
////
////                    dateTime.setText(mydate);
//
////                    String gg = "";
////                    for (int loop_format1 = 8; loop_format1 < close_not1.length(); loop_format1++) {
////                        gg += close_not1.charAt(loop_format1);
////
////                        // openOrNot.append(String.valueOf(close_not1.charAt(loop_format1)));
////                    }
////                    openOrNot.setText(gg);
//
//
////                    try {
//
////                    SharedPreferences sharedpreferences = ctx.getSharedPreferences("dateTime", Context.MODE_PRIVATE);
////                    SharedPreferences.Editor editor = sharedpreferences.edit();
////                    editor.putString("lastUpdate", mydate);
////                    editor.commit();
//
////                    } catch (Exception e) {
////
////                    }
//
//
//                    // openOrNot.setText(close_not1);
//
////
////                    Date date = new Date(date_time1);
////                    DateFormat dateFormat = android.text.DateFormat.getDateFormat(getActivity());
////                    mTimeText.setText("Time: " + dateFormat.format(date));
//
////                    Date date = new Date(date_time1);
////                    java.text.DateFormat dateFormat =
////                            android.text.format.DateFormat.getDateFormat(getActivity());
////                    dateTime.setText("Time: " + dateFormat.format(date));
//
//
////                   // Date today = Calendar.getInstance().getTime();
////
////                    // (2) create a date "formatter" (the date format we want)
////                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
////
////                    // (3) create a new String using the date format we want
////                    String folderName = formatter.format(date_time1);
//
//
////                    SimpleDateFormat srcDf = new SimpleDateFormat(
////                            "yyyy-mm-dd hh:mm:ss");
////
////                    try {
////                        Date date = srcDf.parse(date_time1);
////                        SimpleDateFormat destDf = new SimpleDateFormat("dd MMM,yy  HH:mm");
////                        mydate = destDf.format(date);
////                    } catch (ParseException e) {
////                        e.printStackTrace();
////                    }
//
//
////
////                    SimpleDateFormat simpleDate =  new SimpleDateFormat("dd/MM/yy hh:mm");
////
////                    String strDt = simpleDate.format(date_time1);
//
//
//                    // time_date  =   model.getTime();
//                    // data =convertDate(String.valueOf(time_date), "dd MMM yy hh:mm");
//                    //  dateTime.setText(data);
//                    //  open_value=  model.getStoke().getOpen();
//                    // openOrNot.setText(open_value);
//
////Log.e("arrulist",stockItems.toString());
////                    adapter = new Notify_class(getContext(), stockItems);
////                    stockList1.setAdapter(adapter);
//
////
////                    String json = new Gson().toJson(stockItems);
////                    editor.putString("stocks", json).apply();
//
//
////                    String json_last_update = new Gson().toJson(mydate);
////                    edit.putString("status", json_last_update).apply();
////
////                    String json_status = new Gson().toJson(close_not1);
////                    edit.putString("last", json_status).apply();
//
////                    for (stocklistitem item : sto
//// ckItems) {
////                        addCacheContact(item);
////                    }
//
//
////                   String query = "SELECT * FROM '" + AppSettings.DATABASE_TABLE + "'";
////                    Log.e("SELECT QUERY", query);
////
////                    Cursor c = stock_list.dbManager.selectQuery(query);
////
////    for(int loop=0;loop<stock_list.navDrawerItems11.size();loop++) {
////      symbol1 = stock_list.navDrawerItems11.get(loop).getTitle();
////
////
////     if (c != null && c.moveToFirst()) {
////      //  do {
////
////            //stock_list.viewHolder.im.setImageResource(R.drawable.watching_button);
////
////       // } while (c.moveToNext());
////     }
////    }
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
//            }
//        });
//    }


    public static String convertDate(String dateInMilliseconds, String dateFormat) {
        return DateFormat.format(dateFormat, Long.parseLong(dateInMilliseconds)).toString();
    }
}
