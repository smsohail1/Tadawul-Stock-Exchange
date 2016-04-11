package com.testbatch3.appxone.tadawulproject;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class NavDrawerListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<NavDrawerItem> navDrawerItems;
    int lastPos = -1;


    int posn;


    SharedPreferences pref_stocks;
    SharedPreferences.Editor edit_stocks;

    public NavDrawerListAdapter(Context context, ArrayList<NavDrawerItem> navDrawerItems) {
        this.context = context;
        this.navDrawerItems = navDrawerItems;
    }

    @Override
    public int getCount() {
        return navDrawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return navDrawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.drawer_list_item, null);


        }
        int drawer_pos = GetValueFromPrefrencesForInt(context, "pref_SoundDown", "drawer_pos");
        Log.e("Adapter POS", "" + drawer_pos);


//        pref_stocks = this.context.getSharedPreferences("drawer_pos", this.context.MODE_PRIVATE);
//
//        posn = pref_stocks.getInt("position", 0);


        RelativeLayout layout = (RelativeLayout) convertView.findViewById(R.id.holder);

        layout.setTag(position);

        final ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        final TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
        final ImageView imgIcon_right = (ImageView) convertView.findViewById(R.id.right_icon);

        if (drawer_pos == 0) {
            setIconsFor0(position);
        } else if (drawer_pos == 1) {
            setIconsFor1(position);
        } else if (drawer_pos == 2) {
            setIconsFor2(position);
        } else if (drawer_pos == 3) {
            setIconsFor3(position);
        } else if (drawer_pos == 4) {
            setIconsFor4(position);
        } else if (drawer_pos == 5) {
            setIconsFor5(position);
        } else if (drawer_pos == 6) {
            setIconsFor6(position);
        }

        if (drawer_pos == position) {

            txtTitle.setTextColor(Color.parseColor("#1992ce"));
        } else {
            txtTitle.setTextColor(Color.parseColor("#a1a1a1"));
        }

        imgIcon.setImageResource(navDrawerItems.get(position).getIcon());
        txtTitle.setText(navDrawerItems.get(position).getTitle());
        imgIcon_right.setImageResource(navDrawerItems.get(position).getIcon_right());


        final TypedArray navMenuIcons = context.getResources()
                .obtainTypedArray(R.array.nav_drawer_icons_pressed);


        final TypedArray navMenuIcons_right = context.getResources()
                .obtainTypedArray(R.array.nav_drawer_right_pressed);

//        Toast t = Toast.makeText(this.context, posn + "", Toast.LENGTH_SHORT);
//        t.show();


        // imgIcon.setImageResource(navMenuIcons.getResourceId(posn, -1));
        // imgIcon_right.setImageResource(navMenuIcons_right.getResourceId(posn, -1));


        final TypedArray navMenuIconsPressed = context.getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);


        final TypedArray navMenuIcons_right_pressed = context.getResources()
                .obtainTypedArray(R.array.nav_drawer_right);

//
//        final TypedArray color_pressed = context.getResources()
//                .obtainTypedArray(R.array.color_pressed);
//
//
//        final TypedArray color_unpressed = context.getResources()
//                .obtainTypedArray(R.array.color_unpressed);

        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int position = (int) v.getTag();

                if (lastPos != -1) {
                    ViewGroup lastView = (ViewGroup) v.getParent().getParent();
                    ImageView lastImg = (ImageView) ((ViewGroup) ((ViewGroup) lastView.getChildAt(lastPos)).getChildAt(0)).getChildAt(0);
                    TextView lastTitle = (TextView) (((ViewGroup) ((ViewGroup) lastView.getChildAt(lastPos)).getChildAt(0)).getChildAt(1));
                    ImageView lastImgRight = (ImageView) (((ViewGroup) ((ViewGroup) lastView.getChildAt(lastPos)).getChildAt(0)).getChildAt(2));


                    lastImg.setImageResource(navMenuIconsPressed.getResourceId(lastPos, -1));
                    lastImgRight.setImageResource(navMenuIcons_right_pressed.getResourceId(lastPos, -1));


                    //int aab=color_unpressed.getResourceId(lastPos, -1);
                    //lastTitle.setTextColor(Color.parseColor("#a1a1a1"));

                    lastTitle.setTextColor(Color.parseColor("#a1a1a1"));


                    //txtTitle.setTextColor(Color.parseColor("#a1a1a1"));
                }
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // int aa=color_pressed.getResourceId(position, -1);


                    txtTitle.setTextColor(Color.parseColor("#1992ce"));

                    imgIcon.setImageResource(navMenuIcons.getResourceId(position, -1));
                    imgIcon_right.setImageResource(navMenuIcons_right.getResourceId(position, -1));
                } else {

                    imgIcon.setImageResource(navMenuIconsPressed.getResourceId(position, -1));
                    imgIcon_right.setImageResource(navMenuIcons_right_pressed.getResourceId(position, -1));

//                    imgIcon.setImageResource(navMenuIcons.getResourceId(posn, -1));
//                    imgIcon_right.setImageResource(navMenuIcons_right.getResourceId(posn, -1));
                }
                lastPos = position;

                return false;
            }
        });


        Typeface tf = Typeface.createFromAsset(this.context.getAssets(), "fonts/AvenirLTStd-Roman.otf");
        txtTitle.setTypeface(tf);

        // imgIcon.setImageResource(navDrawerItems.get(position).getIcon());


        //  txtTitle.setText(navDrawerItems.get(position).getTitle());
        //imgIcon_right.setImageResource(navDrawerItems.get(position).getIcon_right());
        return convertView;
    }

    void setIconsFor0(int position) {
        navDrawerItems.get(0).setIcon(R.drawable.icon_home_pressed);
        navDrawerItems.get(1).setIcon(R.drawable.icon_market);
        navDrawerItems.get(2).setIcon(R.drawable.icon_magnify_glass);
        navDrawerItems.get(3).setIcon(R.drawable.gray_watch);
        navDrawerItems.get(4).setIcon(R.drawable.icon_feedback);
        navDrawerItems.get(5).setIcon(R.drawable.icon_share);
        navDrawerItems.get(6).setIcon(R.drawable.icon_about_us);


      //   navDrawerItems.get(0).setIcon_right(R.drawable.icon_forward);

         navDrawerItems.get(0).setIcon_right(R.drawable.icon_forward);
        navDrawerItems.get(1).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(2).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(3).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(4).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(5).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(6).setIcon_right(R.drawable.icon_forward_gray);
    }

    void setIconsFor1(int position) {
        navDrawerItems.get(0).setIcon(R.drawable.icon_home);
        navDrawerItems.get(1).setIcon(R.drawable.icon_market_pressed);
        navDrawerItems.get(2).setIcon(R.drawable.icon_magnify_glass);
        navDrawerItems.get(3).setIcon(R.drawable.gray_watch);
        navDrawerItems.get(4).setIcon(R.drawable.icon_feedback);
        navDrawerItems.get(5).setIcon(R.drawable.icon_share);
        navDrawerItems.get(6).setIcon(R.drawable.icon_about_us);


        navDrawerItems.get(0).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(1).setIcon_right(R.drawable.icon_forward);

      //  navDrawerItems.get(1).setIcon_right(R.drawable.icon_forward_pressed);
        navDrawerItems.get(2).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(3).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(4).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(5).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(6).setIcon_right(R.drawable.icon_forward_gray);
    }

    void setIconsFor2(int position) {
        navDrawerItems.get(0).setIcon(R.drawable.icon_home);
        navDrawerItems.get(1).setIcon(R.drawable.icon_market);
        navDrawerItems.get(2).setIcon(R.drawable.icon_magnify_glass_pressed);
        navDrawerItems.get(3).setIcon(R.drawable.gray_watch);
        navDrawerItems.get(4).setIcon(R.drawable.icon_feedback);
        navDrawerItems.get(5).setIcon(R.drawable.icon_share);
        navDrawerItems.get(6).setIcon(R.drawable.icon_about_us);


        navDrawerItems.get(0).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(1).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(2).setIcon_right(R.drawable.icon_forward);
//        navDrawerItems.get(2).setIcon_right(R.drawable.icon_forward_pressed);
        navDrawerItems.get(3).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(4).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(5).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(6).setIcon_right(R.drawable.icon_forward_gray);
    }

    void setIconsFor3(int position) {
        navDrawerItems.get(0).setIcon(R.drawable.icon_home);
        navDrawerItems.get(1).setIcon(R.drawable.icon_market);
        navDrawerItems.get(2).setIcon(R.drawable.icon_magnify_glass);
        navDrawerItems.get(3).setIcon(R.drawable.blue_watch);
        navDrawerItems.get(4).setIcon(R.drawable.icon_feedback);
        navDrawerItems.get(5).setIcon(R.drawable.icon_share);
        navDrawerItems.get(6).setIcon(R.drawable.icon_about_us);


        navDrawerItems.get(0).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(1).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(2).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(3).setIcon_right(R.drawable.icon_forward);

       // navDrawerItems.get(3).setIcon_right(R.drawable.icon_forward_pressed);
        navDrawerItems.get(4).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(5).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(6).setIcon_right(R.drawable.icon_forward_gray);
    }

    void setIconsFor4(int position) {
        navDrawerItems.get(0).setIcon(R.drawable.icon_home);
        navDrawerItems.get(1).setIcon(R.drawable.icon_market);
        navDrawerItems.get(2).setIcon(R.drawable.icon_magnify_glass);
        navDrawerItems.get(3).setIcon(R.drawable.gray_watch);
        navDrawerItems.get(4).setIcon(R.drawable.icon_feedback_pressed);
        navDrawerItems.get(5).setIcon(R.drawable.icon_share);
        navDrawerItems.get(6).setIcon(R.drawable.icon_about_us);


        navDrawerItems.get(0).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(1).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(2).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(3).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(4).setIcon_right(R.drawable.icon_forward);

      //  navDrawerItems.get(4).setIcon_right(R.drawable.icon_forward_pressed);
        navDrawerItems.get(5).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(6).setIcon_right(R.drawable.icon_forward_gray);
    }

    void setIconsFor5(int position) {
        navDrawerItems.get(0).setIcon(R.drawable.icon_home);
        navDrawerItems.get(1).setIcon(R.drawable.icon_market);
        navDrawerItems.get(2).setIcon(R.drawable.icon_magnify_glass);
        navDrawerItems.get(3).setIcon(R.drawable.gray_watch);
        navDrawerItems.get(4).setIcon(R.drawable.icon_feedback);
        navDrawerItems.get(5).setIcon(R.drawable.icon_share_pressed);
        navDrawerItems.get(6).setIcon(R.drawable.icon_about_us);


        navDrawerItems.get(0).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(1).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(2).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(3).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(4).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(5).setIcon_right(R.drawable.icon_forward);

        // navDrawerItems.get(5).setIcon_right(R.drawable.icon_forward_pressed);
        navDrawerItems.get(6).setIcon_right(R.drawable.icon_forward_gray);
    }

    void setIconsFor6(int position) {
        navDrawerItems.get(0).setIcon(R.drawable.icon_home);
        navDrawerItems.get(1).setIcon(R.drawable.icon_market);
        navDrawerItems.get(2).setIcon(R.drawable.icon_magnify_glass);
        navDrawerItems.get(3).setIcon(R.drawable.gray_watch);
        navDrawerItems.get(4).setIcon(R.drawable.icon_feedback);
        navDrawerItems.get(5).setIcon(R.drawable.icon_share);
        navDrawerItems.get(6).setIcon(R.drawable.icon_about_us_pressed);


        navDrawerItems.get(0).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(1).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(2).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(3).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(4).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(5).setIcon_right(R.drawable.icon_forward_gray);
        navDrawerItems.get(6).setIcon_right(R.drawable.icon_forward);

//        navDrawerItems.get(6).setIcon_right(R.drawable.icon_forward_pressed);
    }


    public static void WriteToPrefrencesForBoolean(Context context,
                                                   String prefName, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(prefName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean(key, value);
        edit.commit();
    }

    public static Boolean GetValueFromPrefrencesForBoolean(Context context,
                                                           String prefName, String key) {
        SharedPreferences sp = context.getSharedPreferences(prefName,
                Context.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

    public static String GetValueFromPrefrencesForString(Context context,
                                                         String prefName, String key) {
        SharedPreferences sp = context.getSharedPreferences(prefName,
                Context.MODE_PRIVATE);
        return sp.getString(key, "");
    }

    public static Integer GetValueFromPrefrencesForInt(Context context,
                                                       String prefName, String key) {
        SharedPreferences sp = context.getSharedPreferences(prefName,
                Context.MODE_PRIVATE);
        return sp.getInt(key, 0);
    }

    public static void WriteToPrefrencesForString(Context context,
                                                  String prefName, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(prefName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key, value);
        edit.commit();
    }
}