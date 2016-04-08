package com.testbatch3.appxone.tadawulproject;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.ads.AdRequest;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;


@SuppressLint("NewApi")
public class HomeFragments extends Fragment implements
        ActionBar.TabListener {

    String publisherId = "ca-app-pub-9381472359687969/1657257730";
    String testingDeviceId = "359918043312594";
    Fragment fragment2;
    LayoutInflater getLayoutInflater1;
    boolean check1;
    private int[] tabs = {R.drawable.market_button, R.drawable.stocks_button};
    private int[] im = {R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,};
    public ViewPager viewPager;

    private TabsPagerAdapter mAdapter;
    public ActionBar actionBar1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        actionBar1 = ((ActionBarActivity) getActivity()).getSupportActionBar();
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

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


        viewPager = (ViewPager) rootView.findViewById(R.id.pager);
        mAdapter = new TabsPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(mAdapter);

        for (int tab_name : tabs) {
            actionBar1.addTab(actionBar1.newTab().setIcon(tab_name).setTabListener(this));
        }


//        final ActionBar.Tab firstTab = actionBar1.newTab()
//                .setText("Market")
//                .setCustomView(R.id.market_custom_tab);
//        actionBar1.addTab(firstTab);


//MainActivity.Refresh_button.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//
//
//        int u = actionBar1.getSelectedNavigationIndex();
//        actionBar1.setSelectedNavigationItem(u);
//
//
//        fragment2 = null;
//        fragment2 = new HomeFragments();
//        if (fragment2 != null) {
//
//            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//
//            fragmentManager.beginTransaction()
//                    .replace(R.id.frame_container1, fragment2).commit();
//
//            // update selected item and title, then close the drawer
//
//        } else {
//            // error in creating fragment
//            Log.e("MainActivity", "Error in creating fragment");
//        }
//
//
//
//
//    }
//});


        actionBar1.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


//            for (String tab_name : tabs) {
//                actionBar.addTab(actionBar.newTab().setText(tab_name)
//                        .setTabListener(this));
//
//                //  actionBar.setIcon(R.drawable.ic_launcher);
//
//            }


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar1.setSelectedNavigationItem(position);

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });


        return rootView;

    }

    @Override
    public void onDestroy() {
        actionBar1.removeAllTabs();
        actionBar1.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        super.onDestroy();
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {

    }

}