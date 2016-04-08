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
import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by APPXONE on 12/31/2015.
 */
public class TopRatedFragment extends Fragment {


    String publisherId = "ca-app-pub-9381472359687969/1657257730";
    String testingDeviceId = "359918043312594";

    TextView openOrClose;
    View rootView;
    TextView date, status1, last_updated1;
    public ArrayList<marketlistitem> marketItems;
    public String date__time = "";
    public String close_not = "";

    public market_list adapter;
    public ListView marketList;

    String mydate = "";


    DualCache<stocklistitem> cache;
    ArrayList<String> cacheKeys;
    SharedPreferences.Editor editor;
    SharedPreferences sharedpreferences;


    SharedPreferences pref;
    SharedPreferences.Editor edit;

    SharedPreferences pref1;
    SharedPreferences.Editor edit1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_top_rated, container, false);


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

        marketList = (ListView) rootView.findViewById(R.id.ist_market);
        openOrClose = (TextView) rootView.findViewById(R.id.open_not);
        date = (TextView) rootView.findViewById(R.id.date);
        status1 = (TextView) rootView.findViewById(R.id.status1);
        last_updated1 = (TextView) rootView.findViewById(R.id.Last_update1);


        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "fonts/AvenirLTStd-Roman.otf");
        openOrClose.setTypeface(tf);
        date.setTypeface(tf);
        status1.setTypeface(tf);
        last_updated1.setTypeface(tf);


        marketItems = new ArrayList<marketlistitem>();

        adapter = new market_list(getContext(), marketItems);


        sharedpreferences = getActivity().getSharedPreferences("markets",
                Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();


        pref = getActivity().getSharedPreferences("status_market",
                Context.MODE_PRIVATE);
        edit = pref.edit();

        pref1 = getActivity().getSharedPreferences("last_market",
                Context.MODE_PRIVATE);
        edit1 = pref1.edit();
//        editor.putString("stocks","").apply();

        DualCacheContextUtils.setContext(getActivity());
        cacheKeys = new ArrayList<>();
        cache = new DualCacheBuilder<stocklistitem>("markets", getVersionNumber(getActivity()), stocklistitem.class)
                .useDefaultSerializerInRam(getMaxMemorySize(getActivity()))
                .useDefaultSerializerInDisk(getMaxMemorySize(getActivity()), true);


        DualCacheContextUtils.setContext(getActivity());
        if (isConnectingToInternet()) {


            hitWebservice_kse1();
            setCacheContact();
            setStatusUpdate();
        } else {


            setCacheContact();
            setStatusUpdate();

        }


//        marketItems.add(new marketlistitem("KSE 100 index","32,396.05","+686.69","+2.17%",R.drawable.green_trangle,"32,397.71",
//"31,236.23","105.42M","31,700.36"
//        ));
//
//
//        marketItems.add(new marketlistitem("KSE 101 index","32,396.05","686.69","+2.17%",R.drawable.green_trangle,"32,397.71",
//                "31,236.23","105.42M","31,700.36"
//        ));
//
//        marketItems.add(new marketlistitem("KSE 102 index","32,396.05","686.69","+2.17%",R.drawable.green_trangle,"32,397.71",
//                "31,236.23","105.42M","31,700.36"
//        ));
//
//
//
//        marketItems.add(new marketlistitem("KSE 103 index","32,396.05","686.69","+2.17%",R.drawable.green_trangle,"32,397.71",
//                "31,236.23","105.42M","31,700.36"
//        ));
//
//
//        marketItems.add(new marketlistitem("KSE 104 index","32,396.05","686.69","+2.17%",R.drawable.green_trangle,"32,397.71",
//                "31,236.23","105.42M","31,700.36"
//        ));
//
//
//        marketItems.add(new marketlistitem("KSE 105 index","32,396.05","686.69","+2.17%",R.drawable.green_trangle,"32,397.71",
//                "31,236.23","105.42M","31,700.36"
//        ));
//
//
//        marketItems.add(new marketlistitem("KSE 106 index","32,396.05","686.69","+2.17%",R.drawable.green_trangle,"32,397.71",
//                "31,236.23","105.42M","31,700.36"
//        ));


        //openOrClose.setText();
//
//        marketList = (ListView) rootView.findViewById(R.id.ist_market);
//        adapter = new market_list(getContext(), marketItems);
//        marketList.setAdapter(adapter);


        return rootView;
    }


    public void setStatusUpdate() {
        //  pref = getActivity().getSharedPreferences("pref_SoundDown", getActivity().MODE_PRIVATE);
        String json_data = pref.getString("status_market", "");
        String loop_inc = "";
        for (int loop_format12 = 1; loop_format12 < json_data.length() - 1; loop_format12++) {
            loop_inc += json_data.charAt(loop_format12);
            //openOrNot.setText(String.valueOf(json_last.charAt(loop_format1)));

        }
        date.setText(json_data.toString());


//        String json_last = pref.getString("last_market", "");
//        String che = "";
//        for (int loop_format1 = 8; loop_format1 < json_last.length() - 1; loop_format1++) {
//            che += json_last.charAt(loop_format1);
//            //openOrNot.setText(String.valueOf(json_last.charAt(loop_format1)));
//
//        }
//        openOrClose.setText(che.toString());


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


    public static int getMaxMemorySize(Context context) {
        ActivityManager manager =
                (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        int max = manager.getLargeMemoryClass() * 1024;

        return max / 16;
    }


    String s = "";

//    public void
//    addCacheContact(marketlistitem item) {
//        item.setTitle(item.getTitle().trim().toLowerCase().replace(" ", "").replace("-","").replace("-","").replace(".","").replace("(","").replace(")","").replace("&",""));
//        if (cacheKeys.contains(item.getTitle())) {
//            cache.delete(item.getTitle());
//            cache.put(item.getTitle(), item);
//        } else {
//            cacheKeys.add(item.getTitle());
//            cache.put(item.getTitle(),item);
//        }
//
////            for (String key : cacheKeys) {
//        s = s.equals("") ? item.getTitle() : s +  ","+ item.getTitle();
////            }
//        //   Log.e("data",s);
//        editor.putString("markets", s).apply();
//
//        //storage.putKey("Stocks", item.getTitle());
//        //cache.put(item.getTitle(), item);
//
//    }


    public void setCacheContact() {
        ArrayList<marketlistitem> list = new ArrayList<>();
        String pref_list = sharedpreferences.getString("markets", "");
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
        Type type = new TypeToken<ArrayList<marketlistitem>>() {
        }.getType();
        String json = sharedpreferences.getString("markets", "");
        list = new Gson().fromJson(json, type);
        if (list != null) {
            if (!list.isEmpty()) {
                this.marketItems.clear();
                this.marketItems.addAll(list);
                adapter = new market_list(getContext(), marketItems);
                marketList.setAdapter(adapter);
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


    public void hitWebservice_kse1() {

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
                .setEndpoint("http://appinhand.net/LiveApplications/tadawul").build();
        gitapi git = restAdapter.create(gitapi.class);

        git.kse1_fatch(new Callback<kse1_fetch>() {
            @Override
            public void success(kse1_fetch model, Response response) {

                dialog.dismiss();


                marketItems.clear();
                if (model.getStatus().equalsIgnoreCase("true")) {
                    for (int i = 0; i < model.getIndices().size(); i++) {

                        marketItems.add(new marketlistitem(model.getIndices().get(i).getCompany(), model.getIndices().get(i).getValu(), model.getIndices().get(i).getNetchange(), model.getIndices().get(i).getPerchange()));
                    }
                    date__time = model.getTime();
                    //  close_not = model.getStock().get(1).getValue();


//                    SimpleDateFormat srcDf = new SimpleDateFormat(
//                            "dd/MMyyyy/ hh:mm:ss am");
//
//                    try {
//                        Date date = srcDf.parse(date__time);
//                        SimpleDateFormat destDf = new SimpleDateFormat("dd MMM,yy HH:mm");
//                        mydate = destDf.format(date);
//                    } catch (ParseException e) {
//                        e.printStackTrace();
//                    }

                    date.setText(date__time);


//                    String gg="";
//                    for (int loop_format = 8; loop_format < close_not.length(); loop_format++) {
//                        gg+=close_not.charAt(loop_format);
//                      //  openOrClose.append(String.valueOf(close_not.charAt(loop_format)));
//                    }
//
//                    openOrClose.setText(gg);

                    adapter = new market_list(getContext(), marketItems);
                    marketList.setAdapter(adapter);


                    String json = new Gson().toJson(marketItems);
                    editor.putString("markets", json).apply();


                    String json_last_update = new Gson().toJson(mydate);
                    edit.putString("status_market", json_last_update).apply();

//                    String json_status = new Gson().toJson(close_not);
//                    edit.putString("last_market",json_status).apply();


                } else {
                    Toast toast1 = Toast.makeText(getActivity(), "Error Connection", Toast.LENGTH_SHORT);
                    toast1.show();

                }

            }

            @Override
            public void failure(RetrofitError error) {
                dialog.dismiss();
            }
        });
    }


}

