package com.testbatch3.appxone.tadawulproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class FB_Fragment extends Fragment {

    TextView hint_txt;
    RelativeLayout r1;
    Toast y;
    ImageButton send_button;
    View rootView;
    EditText comment;
    //	public  ActionBar  actionBar;
    LayoutInflater getLayoutInflater;

    String publisherId = "ca-app-pub-9381472359687969/1657257730";
    String testingDeviceId = "359918043312594";

    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveinstanceinstate) {

         rootView = inflater.inflate(R.layout.fb_fragment, container, false);



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


        send_button= (ImageButton) rootView.findViewById(R.id.send_button);
        comment= (EditText) rootView.findViewById(R.id.detail);
//
        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(comment.getText().toString().equalsIgnoreCase(""))
                {
y=Toast.makeText(getActivity(),"Please write your feedback",Toast.LENGTH_SHORT);
                    y.show();

                }
                else
                {
                    comment.setText("");
                    comment.setHint("");
                    y=Toast.makeText(getActivity(),"Thanks for your feedback",Toast.LENGTH_SHORT);
                    y.show();
                }
            }
        });
















//        hint_txt = (TextView) rootView.findViewById(R.id.hint_text);
//
//       // r1 = (RelativeLayout) rootView.findViewById(R.id.txt_relative);
//        send_button = (ImageView) rootView.findViewById(R.id.send_button);
//        r1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//               // hint_txt.setHint("");
//            }
//        });
//
//        send_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        //setDynamicHeightWidths();
        //actionBar =((ActionBarActivity) getActivity()).getSupportActionBar();
//	actionBar.setDisplayShowCustomEnabled(true);
//	View customView=getLayoutInflater.inflate(R.layout.yourlayout, null);
//	actionBar.setCustomView(customView);
//actionBar.setIcon(R.drawable.header_bg);

        return rootView;


    }




//    private void setDynamicHeightWidths() {
//        Drawable d = getResources().getDrawable(R.drawable.text_field);
//        int h = d.getIntrinsicHeight();
//        int w = d.getIntrinsicWidth();
//
//        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, h);
//        ScrollView scrl = (ScrollView) rootView.findViewById(R.id.scrl);
//        scrl.setLayoutParams(lparams);
//    }

}