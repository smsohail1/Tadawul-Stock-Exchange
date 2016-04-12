package com.testbatch3.appxone.tadawulproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

@SuppressLint("NewApi")
public class FindPeopleFragment extends Fragment {


    String publisherId = "ca-app-pub-9381472359687969/3170354534";
    String testingDeviceId = "359918043312594";
TextView devlopment_team,designer_name,developer_name,supervisor_name,designer_title,developer_title,supervisor_title,rate_share,version,app_name1,powered_by;
    ImageButton  share_about;
    Intent go_web;
RelativeLayout logo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //	actionBar =((ActionBarActivity) getActivity()).getSupportActionBar();


        //	actionBar.setIcon(R.drawable.header_bg);
        View root_Views = inflater.inflate(R.layout.about_us, container, false);

        logo = (RelativeLayout) root_Views.findViewById(R.id.logo_appxone);
        share_about = (ImageButton) root_Views.findViewById(R.id.share_about1);
        devlopment_team = (TextView) root_Views.findViewById(R.id.Development_title);
        powered_by = (TextView) root_Views.findViewById(R.id.powered_title);
        version = (TextView) root_Views.findViewById(R.id.version_app);
        app_name1 = (TextView) root_Views.findViewById(R.id.app_name);
        designer_name = (TextView) root_Views.findViewById(R.id.designer_name);

        developer_name = (TextView) root_Views.findViewById(R.id.developer_name);
       // designer_name = (TextView) root_Views.findViewById(R.id.designer_name);


        supervisor_name = (TextView) root_Views.findViewById(R.id.supervisor_name11);
        designer_title = (TextView) root_Views.findViewById(R.id.designer_title);


        developer_title = (TextView) root_Views.findViewById(R.id.supervisor_name1);

        supervisor_title = (TextView) root_Views.findViewById(R.id.supervisor_title);

        rate_share = (TextView) root_Views.findViewById(R.id.rate_share);


        Typeface tf=Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirLTStd-Roman.otf");
        devlopment_team.setTypeface(tf);
        powered_by.setTypeface(tf);
        version.setTypeface(tf);
        app_name1.setTypeface(tf);


        designer_name.setTypeface(tf);
        developer_name.setTypeface(tf);


        supervisor_name.setTypeface(tf);
        designer_title.setTypeface(tf);


        developer_title.setTypeface(tf);
        supervisor_title.setTypeface(tf);
        rate_share.setTypeface(tf);


        AdView mAdView = new AdView(getActivity(), null);
        String ad_Id = publisherId;
        final LinearLayout linearLayout = (LinearLayout) root_Views.findViewById(R.id.adLayout);
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


        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_web = new Intent(Intent.ACTION_VIEW, Uri.parse("http://appxone.com/home/"));
                startActivity(go_web);

            }
        });
        share_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share_data = new Intent(Intent.ACTION_SEND);
                share_data.setType("text/plain");
                share_data.putExtra(Intent.EXTRA_TEXT, "I am using this app.\n"+"https://play.google.com/store/apps/details?id=com.appinhand.saudistockexchange");
                Intent share_via = Intent.createChooser(share_data, "Share Via");
                startActivity(share_via);
            }
        });

        return root_Views;


    }

}
