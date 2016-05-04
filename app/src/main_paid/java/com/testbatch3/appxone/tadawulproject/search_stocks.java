package com.testbatch3.appxone.tadawulproject;

import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
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
import java.util.Locale;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by APPXONE on 1/18/2016.
 */
public class search_stocks extends Fragment {

    String publisherId = "ca-app-pub-9381472359687969/3170354534";
    String testingDeviceId = "359918043312594";
    EditText editText_watcher;
    TextWatcher textWatcher;
    View rootView1;
    String text, search1 = "";

    public ArrayList<search_model> marketItems1;
    SearchView search_view;
    String ff = "";
    public search_adapter adapter;
    public ListView marketList1;
    public ImageView search_icon;

    int check_status;
    public boolean isErrorOccured = false;

    public DataBaseManager dbManager;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    ArrayList<search_model> list;
    DualCache<search_model> cache;


    ArrayList<String> cacheKeys;
     ProgressDialog dialog;
    public Animation animation_home;
    ConnectivityManager connectivity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView1 = inflater.inflate(R.layout.search_layot, container, false);
        animation_home = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_img);
        dbManager = new DataBaseManager(getActivity());


//        Log.e("before", "sds1aaa");
//        try {
//            dbManager.createDataBase();
//
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


        search_icon = (ImageView) rootView1.findViewById(R.id.search_icon);
        marketList1 = (ListView) rootView1.findViewById(R.id.ist_market);
//        AdView mAdView = new AdView(getActivity(), null);
//        String ad_Id = publisherId;
//        final LinearLayout linearLayout = (LinearLayout) rootView1.findViewById(R.id.adLayout1);
//        linearLayout.addView(mAdView);
//        mAdView.setAdUnitId(ad_Id);
//        mAdView.setAdSize(AdSize.SMART_BANNER);
//        com.google.android.gms.ads.AdRequest adRequest = new com.google.android.gms.ads.AdRequest.Builder()
//                .build();
//        mAdView.loadAd(adRequest);
//
//        mAdView.setAdListener(new AdListener() {
//            @Override
//            public void onAdLoaded() {
//
//                linearLayout.setVisibility(View.VISIBLE);
//                Log.e("load", "111");
//            }
//
//            @Override
//            public void onAdFailedToLoad(int errorCode) {
//                Log.e("failed", "111");
//            }
//        });


        //   search_view = (SearchView) rootView1.findViewById(R.id.search_view);

//        int id = search_view.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
//        TextView textView = (TextView) search_view.findViewById(id);
//        textView.setTextColor(Color.parseColor("#c0392b"));
//        textView.setHintTextColor(Color.parseColor("#c0392b"));


        editText_watcher = (EditText) rootView1.findViewById(R.id.text_watcher1);


        editText_watcher.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub


                if (isConnectingToInternet()) {
                    String text = editText_watcher.getText().toString().toLowerCase(Locale.getDefault());
                    if(list==null)
                    {

                    }
                    else if(list!=null){
                        check_status=1;
                        if (text.equalsIgnoreCase("")) {
                            search_icon.setImageResource(R.drawable.icon_magnify_glass);
                        }
//                        if (!isConnectingToInternet() && marketItems1.size() >= 0) {
//                            editText_watcher.setEnabled(false);
//                            check_status = 0;
//
//                            //     Log.e("aa","aa");
//
//                        }
                        if (check_status == 1) {
                            adapter.filter(text);
                        }
                    }
//if(isConnectingToInternet() && adapter.isEmpty()) {
//    adapter.filter(text);
//}
////else if(marketItems1.size()>=0)
////{
////    adapter.filter(text);
////}
//                else
////{
////    Toast toast_connection = Toast.makeText(getActivity(), "Error Connection", Toast.LENGTH_SHORT);
////    toast_connection.show();
////}
//                if (isConnectingToInternet()) {
//                    if (!adapter.isEmpty() && marketItems1.size() >= 0) {
//
//                        adapter.filter(text);
//                    }
//                } else {
//                    Toast toast_connection = Toast.makeText(getActivity(), "Error Connection", Toast.LENGTH_SHORT);
//                    toast_connection.show();
//                }
//                else
//                {
//                    adapter.filter(text);
//                }


//                if (marketItems1.size()>0) {
//                    adapter.filter(text);
//                }
                }
                else if(!isConnectingToInternet())
                {
                    check_status=1;
                    String text = editText_watcher.getText().toString().toLowerCase(Locale.getDefault());
                    if(list==null)
                    {

                    }
                    else if(list!=null) {

                        if (check_status == 1) {
                            adapter.filter(text);
                        }
                    }
                }

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });


//        search_view.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                search_view.setFocusableInTouchMode(true);
//                return true;
//            }
//        });

        // search_view.setQueryHint(Html.fromHtml("<font color = #ffffff>" + getResources().getString(R.string.hintSearchMess) + "</font>"));
//        ImageView magImage = (ImageView)search_view.findViewById(android.support.v7.appcompat.R.id.search_mag_icon);
//        magImage.setVisibility(View.GONE);
//        int searchImgId = getActivity().getResources().getIdentifier("android:id/search_mag_icon", null, null);
//        ImageView searchImage = (ImageView) search_view.findViewById(searchImgId);
//
//        searchImage.setVisibility(View.GONE);

        // search_view.setIconified(false);
        //  search_view.isSubmitButtonEnabled(false);


        //editText_watcher = (EditText) rootView1.findViewById(R.id.text_watcher1);
//
//        editText_watcher.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                text = editText_watcher.getText().toString();
//                text=text.toLowerCase();
//                if (text.equalsIgnoreCase("")) {
//
//                  //  hitWebservice_kse1();
//                } else {
//                    Log.e("succes", "success");
//
//
//                    marketItems1.clear();
//                    for (int iie = 0; iie < marketItems1.size(); iie++) {
//                        search1 = marketItems1.get(iie).getTitle().toString();
//                        if (text.contains(search1.toLowerCase())) {
//
//
//
//                            marketItems1.add(new search_model(marketItems1.get(iie).getTitle().toString(), marketItems1.get(iie).getwhole(), "323", marketItems1.get(iie).gethigh1().toString(), marketItems1.get(iie).getlow().toString()));
//
//                            adapter = new search_adapter(getContext(), marketItems1);
//
//
//                           // adapter.notifyDataSetChanged();
//                            marketList1.setAdapter(adapter);
//
//                            //  marketList1.setAdapter(adapter);
//
//
//                        }
//                        else {
//
//                        }
//                    }
//
//
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });

//        editText_watcher.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                ff = editText_watcher.getText().toString();
//                ff = ff.toLowerCase();
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });


        marketItems1 = new ArrayList<search_model>();

        sharedpreferences = getActivity().getSharedPreferences("search_stocks",
                Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        DualCacheContextUtils.setContext(getActivity());
        cacheKeys = new ArrayList<>();
        cache = new DualCacheBuilder<search_model>("search_stocks", getVersionNumber(getActivity()), search_model.class)
                .useDefaultSerializerInRam(getMaxMemorySize(getActivity()))
                .useDefaultSerializerInDisk(getMaxMemorySize(getActivity()), true);
        DualCacheContextUtils.setContext(getActivity());
        if (isConnectingToInternet()) {
            MainActivity.Refresh_button.setEnabled(false);
           setCacheContact();

           // setStatusUpdate();
            hitWebservice_kse2();
        }
        else {

            Snackbar.make(getActivity().findViewById(android.R.id.content), "No Internet Connection", Snackbar.LENGTH_LONG)
                    // .setAction("Undo", mOnClickListener)
                    .setActionTextColor(Color.RED)
                    .show();
            setCacheContact();

           // setStatusUpdate();
        }

        //search_view.setOnQueryTextListener(this);
        return rootView1;
    }


//    public void setStatusUpdate() {
//        //  pref = getActivity().getSharedPreferences("pref_SoundDown", getActivity().MODE_PRIVATE);
//        String json_data = pref.getString("status", "");
//        String loop_inc = "";
//        for (int loop_format12 = 1; loop_format12 < json_data.length() - 1; loop_format12++) {
//            loop_inc += json_data.charAt(loop_format12);
//            //openOrNot.setText(String.valueOf(json_last.charAt(loop_format1)));
//
//        }
//        //dateTime.setText(loop_inc.toString());
//
//
////    String json_last= pref.getString("last", "");
////String che="";
////    for (int loop_format1 = 8; loop_format1 < json_last.length()-1; loop_format1++) {
////      che+=json_last.charAt(loop_format1);
////        //openOrNot.setText(String.valueOf(json_last.charAt(loop_format1)));
////
////    }
////    openOrNot.setText(che.toString());
//

//
//    }

    public void setCacheContact() {
        list = new ArrayList<>();
        String pref_list = sharedpreferences.getString("search_stocks", "");
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
        Type type = new TypeToken<ArrayList<search_model>>() {
        }.getType();
        String json = sharedpreferences.getString("search_stocks", "");
        list = new Gson().fromJson(json, type);
        if (list != null) {
            if (!list.isEmpty()) {
                this.marketItems1.clear();
                this.marketItems1.addAll(list);
                adapter = new search_adapter(getActivity(), marketItems1);
                marketList1.setAdapter(adapter);
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

//    @Override
//    public boolean onQueryTextChange(String newText) {
//        adapter.getFilter().filter(newText);
//        return false;
//    }
//
//    @Override
//    public boolean onQueryTextSubmit(String query) {
//        return false;
//    }


    public boolean isConnectingToInternet() {
        connectivity = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
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


        MainActivity.Refresh_button.startAnimation(animation_home);


        if (list == null) {
            editText_watcher.setEnabled(false);
            check_status = 0;
            dialog = new ProgressDialog(getActivity());
            dialog.setMessage("Please wait for few seconds...");
            dialog.setCanceledOnTouchOutside(false);
            try {
                dialog.show();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://appinhand.net/LiveApplications/tadawul").build();
        gitapi git = restAdapter.create(gitapi.class);

        git.kse2_fatch(new Callback<kse2_fatch>() {
            @Override
            public void success(kse2_fatch model1, Response response) {

                MainActivity.Refresh_button.setEnabled(true);
                MainActivity.Refresh_button.clearAnimation();

                if (list == null) {
                    //if (dialog.isShowing()) {
                    dialog.dismiss();
                    // }
                }


                marketItems1.clear();
                if (model1.getStatus().equalsIgnoreCase("true")) {
                    for (int i = 0; i < model1.getMerketSummary().size(); i++) {

                        marketItems1.add(new search_model(model1.getMerketSummary().get(i).getCompany(), model1.getMerketSummary().get(i).getChangevalue(), model1.getMerketSummary().get(i).getHigh(), model1.getMerketSummary().get(i).getLow(), model1.getMerketSummary().get(i).getVol(), model1.getMerketSummary().get(i).getOpen(), i + "",model1.getMerketSummary().get(i).getChangePercent(),model1.getMerketSummary().get(i).getPrice()));
                        Log.i("correct", "correct");

                    }


                    // time_date  =   model.getTime();
                    // data =convertDate(String.valueOf(time_date), "dd MMM yy hh:mm");
                    //  dateTime.setText(data);
                    //  open_value=  model.getStoke().getOpen();
                    // openOrNot.setText(open_value);



                    adapter = new search_adapter(getContext(), marketItems1);
                    marketList1.setAdapter(adapter);

                    String json = new Gson().toJson(marketItems1);
                    editor.putString("search_stocks", json).apply();


                    if (isConnectingToInternet() && marketItems1.size() >= 0) {
                        editText_watcher.setEnabled(true);
                        check_status = 1;
                    }


                } else {
                    Toast toast = Toast.makeText(getActivity(), "Error Connection", Toast.LENGTH_SHORT);
                    toast.show();

                }


            }

            @Override
            public void failure(RetrofitError error) {
                if (list == null) {
                    dialog.dismiss();
                }
            }
        });
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
//                .setEndpoint("http://hasanicollege.com/LiveApplications/KSE").build();
//        gitapi git = restAdapter.create(gitapi.class);
//
//        git.kse2_fatch(new Callback<kse2_fatch>() {
//            @Override
//            public void success(kse2_fatch model1, Response response) {
//
//                dialog.dismiss();
//
//
//                marketItems1.clear();
//                if (model1.getStatus().equalsIgnoreCase("true")) {
//                    for (int i = 0; i < model1.getMarkets().size(); i++) {
//
//                        marketItems1.add(new search_model(model1.getMarket().get(i).getSymbol(), model1.getMarket().get(i).getChanges(), model1.getMarket().get(i).getHigh(), model1.getMarket().get(i).getLow(), model1.getMarket().get(i).getVolume(), model1.getMarket().get(i).getLdcp()));
//
//                       // marketItems1.add(new search_model(model.getMarkets().get(i).getType(), model.getMarkets().get(i).getCurrent(), model.getMarkets().get(i).getChange(), model.getMarkets().get(i).getHigh(), model.getMarkets().get(i).getLow()));
//                    }
//
//
//                    marketList1 = (ListView) rootView1.findViewById(R.id.ist_market);
//                    adapter = new search_adapter(getContext(), marketItems1);
//                    marketList1.setAdapter(adapter);
//
//                } else {
//                    Toast toast1 = Toast.makeText(getActivity(), "Error Connection", Toast.LENGTH_SHORT);
//                    toast1.show();
//
//                }
//
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                dialog.dismiss();
//            }
//        });
//    }
}
