package com.testbatch3.appxone.tadawulproject;

import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vincentbrison.openlibraries.android.dualcache.lib.DualCache;
import com.vincentbrison.openlibraries.android.dualcache.lib.DualCacheBuilder;
import com.vincentbrison.openlibraries.android.dualcache.lib.DualCacheContextUtils;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by APPXONE on 12/31/2015.
 */
public class GamesFragment extends Fragment {


    public ArrayList<stocklistitem> stockItems;
    public stock_list adapter;
    public ListView stockList;
    TextView dateTime, status, last_updated;
    TextView openOrNot;
    View rootView;
    long time_date;
    String data = "", open_value = "";
    public String date_time1 = "";
    public String close_not1 = "";
    public int id_stock = 0;
    String symbol1 = "";
    public ActionBar actionBar11;
    public boolean isErrorOccured = false;

    public DataBaseManager dbManager;
    String publisherId = "ca-app-pub-9381472359687969/1657257730";
    String testingDeviceId = "359918043312594";

    DualCache<stocklistitem> cache;
    String mydate = "";

    ArrayList<String> cacheKeys;
    SharedPreferences.Editor editor;
    SharedPreferences sharedpreferences;

int posn;


    SharedPreferences pref_stocks;
    SharedPreferences.Editor edit_stocks;


    SharedPreferences pref;
    SharedPreferences.Editor edit;

    SharedPreferences pref1;
    SharedPreferences.Editor edit1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        pref_stocks = getActivity().getSharedPreferences("drawer_pos", getActivity().MODE_PRIVATE);
       // edit_stocks = pref_stocks.edit();

//       String position= pref_stocks.getString("position", "0");

      posn=  pref_stocks.getInt("position",0);


        rootView = inflater.inflate(R.layout.fragment_games, container, false);


        dbManager = new DataBaseManager(getActivity());

        Log.e("before", "sds1aaa");
        try {
            dbManager.createDataBase();


            Log.e("try111", "sds1aaa");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            isErrorOccured = true;
            Log.e("catch", "sds1");

        }

        actionBar11 = ((ActionBarActivity) getActivity()).getSupportActionBar();


        AdView mAdView = new AdView(getActivity(), null);
        String ad_Id = publisherId;
        final LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.adLayout);
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

        stockList = (ListView) rootView.findViewById(R.id.list_stock);
        stockItems = new ArrayList<stocklistitem>();
        openOrNot = (TextView) rootView.findViewById(R.id.open_value);
        dateTime = (TextView) rootView.findViewById(R.id.date_Time);
        status = (TextView) rootView.findViewById(R.id.status);
        last_updated = (TextView) rootView.findViewById(R.id.Last_update);

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "fonts/AvenirLTStd-Roman.otf");
        openOrNot.setTypeface(tf);
        dateTime.setTypeface(tf);
        status.setTypeface(tf);
        last_updated.setTypeface(tf);

        adapter = new stock_list(getContext(), stockItems);



//        stockItems.add(new stocklistitem("BOP1","8.72","+0.33","+2.17%",R.drawable.green_trangle,"32,397.71",
//                "31,236.23","105.42M","31,700.36"
//        ));
//
//
//        stockItems.add(new stocklistitem("BOP2","8.72","+0.33","+2.17%",R.drawable.green_trangle,"32,397.71",
//                "31,236.23","105.42M","31,700.36"
//        ));
//        stockItems.add(new stocklistitem("BOP3","8.72","+0.33","+2.17%",R.drawable.green_trangle,"32,397.71",
//                "31,236.23","105.42M","31,700.36"
//        ));
//        stockItems.add(new stocklistitem("BOP4","8.72","+0.33","+2.17%",R.drawable.green_trangle,"32,397.71",
//                "31,236.23","105.42M","31,700.36"
//        ));
//        stockItems.add(new stocklistitem("BOP5","8.72","+0.33","+2.17%",R.drawable.green_trangle,"32,397.71",
//                "31,236.23","105.42M","31,700.36"
//        ));
//        stockItems.add(new stocklistitem("BOP6","8.72","+0.33","+2.17%",R.drawable.green_trangle,"32,397.71",
//                "31,236.23","105.42M","31,700.36"
//        ));
//        stockItems.add(new stocklistitem("BOP6","8.72","+0.33","+2.17%",R.drawable.green_trangle,"32,397.71",
//                "31,236.23","105.42M","31,700.36"
//        ));
//        stockItems.add(new stocklistitem("BOP6","8.72","+0.33","+2.17%",R.drawable.green_trangle,"32,397.71",
//                "31,236.23","105.42M","31,700.36"
//        ));
//        stockItems.add(new stocklistitem("BOP9","8.72","+0.33","+2.17%",R.drawable.green_trangle,"32,397.71",
//                "31,236.23","105.42M","31,700.36"
//        ));
//        stockItems.add(new stocklistitem("BOP10","8.72","+0.33","+2.17%",R.drawable.green_trangle,"32,397.71",
//                "31,236.23","105.42M","31,700.36"
//        ));
//        stockItems.add(new stocklistitem("BOP11","8.72","+0.33","+2.17%",R.drawable.green_trangle,"32,397.71",
//                "31,236.23","105.42M","31,700.36"
//        ));
//        stockItems.add(new stocklistitem("BOP12","8.72","+0.33","+2.17%",R.drawable.green_trangle,"32,397.71",
//                "31,236.23","105.42M","31,700.36"
//        ));
//        stockItems.add(new stocklistitem("BOP13","8.72","+0.33","+2.17%",R.drawable.green_trangle,"32,397.71",
//                "31,236.23","105.42M","31,700.36"
//        ));
//
//
        sharedpreferences = getActivity().getSharedPreferences("stocks",
                Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();


        pref = getActivity().getSharedPreferences("status",
                Context.MODE_PRIVATE);
        edit = pref.edit();

        pref1 = getActivity().getSharedPreferences("last",
                Context.MODE_PRIVATE);
        edit1 = pref1.edit();

//        editor.putString("stocks","").apply();

        DualCacheContextUtils.setContext(getActivity());
        cacheKeys = new ArrayList<>();
        cache = new DualCacheBuilder<stocklistitem>("stocks", getVersionNumber(getActivity()), stocklistitem.class)
                .useDefaultSerializerInRam(getMaxMemorySize(getActivity()))
                .useDefaultSerializerInDisk(getMaxMemorySize(getActivity()), true);

//collection.asslist


//        String pref_list = sharedpreferences.getString("stocks","");
//        String [] pref_list_arr  = pref_list.split(",");
//        Collections.addAll(cacheKeys,pref_list_arr);
//        if (cacheKeys == null)
//            cacheKeys = new ArrayList<>();
        DualCacheContextUtils.setContext(getActivity());
       if(isConnectingToInternet()){


           hitWebservice_kse2();
          setCacheContact();

           setStatusUpdate();
       //    hitWebservice_kse2();
        }
        else
       {

           setCacheContact();

           setStatusUpdate();
       }


//        stockList = (ListView) rootView.findViewById(R.id.list_stock);
//        adapter = new stock_list(getContext(), stockItems);
//        stockList.setAdapter(adapter);



////        editor.putBoolean(key, value);
////

     //   Map<String,?> keys = sharedPreferences.getAll();

//        editor.commit();






//
//
//        Map.Entry<String, ?> entry: sharedPreferences.getAll();
    return rootView;
    }

public  void setStatusUpdate()
{
  //  pref = getActivity().getSharedPreferences("pref_SoundDown", getActivity().MODE_PRIVATE);
   String json_data= pref.getString("status", "");
String loop_inc="";
    for (int loop_format12 = 1; loop_format12 < json_data.length()-1; loop_format12++) {
        loop_inc+=json_data.charAt(loop_format12);
        //openOrNot.setText(String.valueOf(json_last.charAt(loop_format1)));

    }
    dateTime.setText(loop_inc.toString());


    String json_last= pref.getString("last", "");
String che="";
    for (int loop_format1 = 8; loop_format1 < json_last.length()-1; loop_format1++) {
      che+=json_last.charAt(loop_format1);
        //openOrNot.setText(String.valueOf(json_last.charAt(loop_format1)));

    }
    openOrNot.setText(che.toString());
   // openOrNot.setText(json_last);

   // edit = pref.edit();
    //edit.putInt("drawer_pos", position);
    //edit.apply();
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

    public static int getMaxMemorySize(Context context){
        ActivityManager manager =
                (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        int max = manager.getLargeMemoryClass() * 1024;

        return max/16;
    }

    String s = "";

    public void
    addCacheContact(stocklistitem item) {
        item.setTitle(item.getTitle().trim().toLowerCase().replace(" ", "").replace("-","").replace("-","").replace(".","").replace("(","").replace(")","").replace("&",""));
        if (cacheKeys.contains(item.getTitle())) {
            cache.delete(item.getTitle());
            cache.put(item.getTitle(), item);
        } else {
            cacheKeys.add(item.getTitle());
            cache.put(item.getTitle(),item);
        }

//            for (String key : cacheKeys) {
                s = s.equals("") ? item.getTitle() : s +  ","+ item.getTitle();
//            }
         //   Log.e("data",s);
            editor.putString("stocks", s).apply();

            //storage.putKey("Stocks", item.getTitle());
            //cache.put(item.getTitle(), item);

    }





    public void setCacheContact() {
        ArrayList<stocklistitem> list = new ArrayList<>();
        String pref_list = sharedpreferences.getString("stocks", "");
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
        Type type = new TypeToken<ArrayList<stocklistitem>>(){}.getType();
        String json = sharedpreferences.getString("stocks","");
        list = new Gson().fromJson(json, type);
        if (list!=null) {
            if (!list.isEmpty()) {
                this.stockItems.clear();
                this.stockItems.addAll(list);
                adapter = new stock_list(getContext(), stockItems);
                stockList.setAdapter(adapter);
            }
        }
    }





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
    public void hitWebservice_kse2() {

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

              Log.e("url", response.getUrl().toString());
                stockItems.clear();

//                cache = new DualCacheBuilder<>(StorageUtils.CHAT, num, stocklistitem.class)
//                        .useDefaultSerializerInRam(StorageUtils.getMaxMemorySize(getActivity()))
//                        .useDefaultSerializerInDisk(StorageUtils.getMaxMemorySize(getActivity()),
//                                true);

                if (model1.getStatus().equalsIgnoreCase("true")) {
                    for (int i = 0; i < model1.getMarket().size(); i++) {

                        stockItems.add(new stocklistitem(model1.getMarket().get(i).getSymbol(), model1.getMarket().get(i).getChanges(), model1.getMarket().get(i).getHigh(), model1.getMarket().get(i).getLow(), model1.getMarket().get(i).getVolume(), model1.getMarket().get(i).getLdcp(),i+""));
                        Log.i("correct", "correct");

                    }

                    date_time1 = model1.getStoke().get(0).getValue();
                    close_not1 = model1.getStoke().get(1).getValue();

                    SimpleDateFormat srcDf = new SimpleDateFormat(
                            "yyyy-MM-dd hh:mm:ss");

                    try {
                        Date date = srcDf.parse(date_time1);
                        SimpleDateFormat destDf = new SimpleDateFormat("dd MMM,yy HH:mm");
                        mydate = destDf.format(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    dateTime.setText(mydate);

String gg="";
                    for (int loop_format1 = 8; loop_format1 < close_not1.length(); loop_format1++) {
                        gg+=close_not1.charAt(loop_format1);

                        // openOrNot.append(String.valueOf(close_not1.charAt(loop_format1)));
                    }
                    openOrNot.setText(gg);

                    SharedPreferences sharedpreferences = getActivity().getSharedPreferences("dateTime", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("lastUpdate",mydate);
                    editor.commit();


                    // openOrNot.setText(close_not1);

//
//                    Date date = new Date(date_time1);
//                    DateFormat dateFormat = android.text.DateFormat.getDateFormat(getActivity());
//                    mTimeText.setText("Time: " + dateFormat.format(date));

//                    Date date = new Date(date_time1);
//                    java.text.DateFormat dateFormat =
//                            android.text.format.DateFormat.getDateFormat(getActivity());
//                    dateTime.setText("Time: " + dateFormat.format(date));


//                   // Date today = Calendar.getInstance().getTime();
//
//                    // (2) create a date "formatter" (the date format we want)
//                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
//
//                    // (3) create a new String using the date format we want
//                    String folderName = formatter.format(date_time1);


//                    SimpleDateFormat srcDf = new SimpleDateFormat(
//                            "yyyy-mm-dd hh:mm:ss");
//
//                    try {
//                        Date date = srcDf.parse(date_time1);
//                        SimpleDateFormat destDf = new SimpleDateFormat("dd MMM,yy  HH:mm");
//                        mydate = destDf.format(date);
//                    } catch (ParseException e) {
//                        e.printStackTrace();
//                    }


//
//                    SimpleDateFormat simpleDate =  new SimpleDateFormat("dd/MM/yy hh:mm");
//
//                    String strDt = simpleDate.format(date_time1);


                    // time_date  =   model.getTime();
                    // data =convertDate(String.valueOf(time_date), "dd MMM yy hh:mm");
                    //  dateTime.setText(data);
                    //  open_value=  model.getStoke().getOpen();
                    // openOrNot.setText(open_value);



                    adapter = new stock_list(getContext(), stockItems);
                    stockList.setAdapter(adapter);


                    String json = new Gson().toJson(stockItems);
                    editor.putString("stocks",json).apply();

                    String json_last_update = new Gson().toJson(mydate);
                    edit.putString("status",json_last_update).apply();

                    String json_status = new Gson().toJson(close_not1);
                    edit.putString("last",json_status).apply();

//                    for (stocklistitem item : stockItems) {
//                        addCacheContact(item);
//                    }



//                   String query = "SELECT * FROM '" + AppSettings.DATABASE_TABLE + "'";
//                    Log.e("SELECT QUERY", query);
//
//                    Cursor c = stock_list.dbManager.selectQuery(query);
//
//    for(int loop=0;loop<stock_list.navDrawerItems11.size();loop++) {
//      symbol1 = stock_list.navDrawerItems11.get(loop).getTitle();
//
//
//     if (c != null && c.moveToFirst()) {
//      //  do {
//
//            //stock_list.viewHolder.im.setImageResource(R.drawable.watching_button);
//
//       // } while (c.moveToNext());
//     }
//    }


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
    }


    public static String convertDate(String dateInMilliseconds, String dateFormat) {
        return DateFormat.format(dateFormat, Long.parseLong(dateInMilliseconds)).toString();
    }


}
