package com.testbatch3.appxone.tadawulproject;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {


    // private String[] tabs = {"Top Rated", "Games", "Movies"};
//
   String publisherId = "ca-app-pub-9381472359687969/3170354534";
//    String testingDeviceId = "359918043312594";
//
//    AdRequest request;
//    AdView adView;
//
//    LinearLayout adlayout;


    TextView Title_actionbar;
    ImageView Drawer_button;
    public static ImageView Refresh_button;
    public DrawerLayout mDrawerLayout;
    public static ListView mDrawerList;
    public ActionBarDrawerToggle mDrawerToggle;

    // nav drawer title
    public CharSequence mDrawerTitle;

    // used to store app title
    public CharSequence mTitle;

    // slide menu items
    public String[] navMenuTitles;
    public TypedArray navMenuIcons;
    public TypedArray navMenuIcons_right;
    public ArrayList<NavDrawerItem> navDrawerItems;
    public NavDrawerListAdapter adapter;
    boolean market_stocks;
    int long_check;
//
    //private ViewPager viewPager;
    //private TabsPagerAdapter mAdapter;


    Fragment fragment;
    ActionBar actionBar;
    SharedPreferences pref;
    SharedPreferences.Editor edit;
    RelativeLayout mDrawerRelativeLayout;
    private int[] tabs = {R.drawable.market_button, R.drawable.stocks_button};
    // Tab titles
    // private String[] tabs = {"Top Rated", "Games", "Movies"};
    // private int[] im = {R.drawable.ic_launcher, R.drawable.ic_launcher, R.drawable.ic_launcher,};


    //    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);

//        pref = getSharedPreferences("pref_SoundDown", MODE_PRIVATE);
//        edit = pref.edit();

        mDrawerRelativeLayout = (RelativeLayout) findViewById(R.id.left_drawer);
        market_stocks = true;

//        try {
//            // Admob
//
//            adlayout = (LinearLayout) findViewById(R.id.adLayout);
//            // Get Screen
//            Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE))
//                    .getDefaultDisplay();
//            int screenWidth = display.getWidth();
//            Log.e("Screen Width", "" + screenWidth);
//
//            // AdMob Size Initialisations
//            if (screenWidth > 300 && screenWidth <= 320)
//                adView = new AdView(this, AdSize.SMART_BANNER, publisherId);
//            else
//                adView = new AdView(this, AdSize.SMART_BANNER, publisherId);
//            // else if (screenWidth > 320 && screenWidth <= 468)
//            // adView = new AdView(this, AdSize.IAB_BANNER, publisherId);
//            // else if (screenWidth > 468)
//            // adView = new AdView(this, AdSize.IAB_LEADERBOARD, publisherId);
//
//            adlayout.addView(adView);
//
//            // AdMob Request
//            request = new AdRequest();
//
//            // only for testing Devices
//            request.addTestDevice(AdRequest.TEST_EMULATOR);
//            request.addTestDevice(testingDeviceId);
//
//
//            // load Ad
//            adView.loadAd(request);
//
//            Log.i("bfr", "111before");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        adView.setAdListener(new AdListener() {
//            @Override
//            public void onReceiveAd(Ad ad) {
//                adlayout.setVisibility(View.VISIBLE);
//                Log.i("aaa","111");
//            }
//
//            @Override
//            public void onFailedToReceiveAd(Ad ad, AdRequest.ErrorCode errorCode) {
//                Log.i("falief","falied");
//
//            }
//
//            @Override
//            public void onPresentScreen(Ad ad) {
//
//            }
//
//            @Override
//            public void onDismissScreen(Ad ad) {
//
//            }
//
//            @Override
//            public void onLeaveApplication(Ad ad) {
//
//            }
//        });


//












//        AdView mAdView = new AdView(getApplicationContext(),null);
//        String ad_Id = publisherId;
//        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.adLayout);
//        linearLayout.addView(mAdView);
//        mAdView.setAdUnitId(ad_Id);
//        mAdView.setAdSize(AdSize.SMART_BANNER);
//        AdRequest adRequest = new AdRequest.Builder()
//                .build();
//        mAdView.loadAd(adRequest);
//
//        mAdView.setAdListener(new AdListener() {
//            @Override
//            public void onAdLoaded() {
//
//
//                linearLayout.setVisibility(View.VISIBLE);
//Log.e("load","111");
//            }
//
//            @Override
//            public void onAdFailedToLoad(int errorCode) {
//              //  linearLayout.setVisibility(View.GONE);
//                Log.e("failed","111");
//            }
//        });


        mTitle = mDrawerTitle = getTitle();

        actionBar = getSupportActionBar();
        // load slide menu items
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        // nav drawer icons from resources
        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);


        navMenuIcons_right = getResources()
                .obtainTypedArray(R.array.nav_drawer_right);

        mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

        navDrawerItems = new ArrayList<NavDrawerItem>();

        // adding nav drawer items to array
        // Home
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1), navMenuIcons_right.getResourceId(0, -1)));
        // Find People
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1), navMenuIcons_right.getResourceId(1, -1)));
        // Photos
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1), navMenuIcons_right.getResourceId(2, -1)));


        navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1), navMenuIcons_right.getResourceId(2, -1)));


        navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1), navMenuIcons_right.getResourceId(2, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(5, -1), navMenuIcons_right.getResourceId(2, -1)));


        navDrawerItems.add(new NavDrawerItem(navMenuTitles[6], navMenuIcons.getResourceId(6, -1), navMenuIcons_right.getResourceId(2, -1)));

        // Communities, Will add a counter here
        //  navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1), true, "22"));
        // Pages
        //navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));
        // What's hot, We  will add a counter here
        //navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(5, -1), true, "50+"));


        // Recycle the typed array
        navMenuIcons.recycle();
        navMenuIcons_right.recycle();


        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

        // setting the nav drawer list adapter
        adapter = new NavDrawerListAdapter(getApplicationContext(), navDrawerItems);
        mDrawerList.setAdapter(adapter);

        // getActionBar().setDisplayHomeAsUpEnabled(true);


//         actionBar.setHomeButtonEnabled(true);
//        BitmapDrawable background = new BitmapDrawable(BitmapFactory.decodeResource(getResources(), R.drawable.header_bg));
//        background.setTileModeX(android.graphics.Shader.TileMode.REPEAT);
//        actionBar.setBackgroundDrawable(background);


        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.custom_bar, null);
        Title_actionbar = (TextView) mCustomView.findViewById(R.id.Title_action);

        Refresh_button = (ImageView) mCustomView.findViewById(R.id.refresh);

        Drawer_button = (ImageView) mCustomView.findViewById(R.id.drawer_button);


        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/AvenirLTStd-Roman.otf");
        Title_actionbar.setTypeface(tf);


        Refresh_button.setVisibility(View.VISIBLE);
        //to set same background color on entire actiobar
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_menu));

        //to display custom layout with same BG color
        ActionBar.LayoutParams layout = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
        getSupportActionBar().setCustomView(mCustomView, layout);
        Toolbar parent = (Toolbar) mCustomView.getParent();
        parent.setContentInsetsAbsolute(0, 0);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        Refresh_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (market_stocks) {
                    fragment = null;
                    fragment = new GamesFragment();
                    if (fragment != null) {

                        FragmentManager fragmentManager = getSupportFragmentManager();

                        fragmentManager.beginTransaction()
                                .replace(R.id.frame_container, fragment).commit();

                        // update selected item and title, then close the drawer

                        mDrawerList.setItemChecked(0, true);
                        mDrawerList.setSelection(0);
                        setTitle(navMenuTitles[0]);
                       // mDrawerLayout.closeDrawers();

                        mDrawerLayout.closeDrawer(mDrawerRelativeLayout);

                     //   mDrawerLayout.closeDrawer(mDrawerList);
                    } else {
                        // error in creating fragment
                        Log.e("MainActivity", "Error in creating fragment");
                    }
                } else if (long_check == 0) {
                    fragment = null;
                    fragment = new search_stocks();
                    if (fragment != null) {

                        FragmentManager fragmentManager = getSupportFragmentManager();

                        fragmentManager.beginTransaction()
                                .replace(R.id.frame_container, fragment).commit();

                        // update selected item and title, then close the drawer
                        mDrawerList.setItemChecked(2, true);
                        mDrawerList.setSelection(2);
                        setTitle(navMenuTitles[2]);
                       // mDrawerLayout.closeDrawers();
                        mDrawerLayout.closeDrawer(mDrawerRelativeLayout);


                        //mDrawerLayout.closeDrawer(mDrawerList);
                    } else {
                        // error in creating fragment
                        Log.e("MainActivity", "Error in creating fragment");
                    }

                } else {
                    fragment = null;
                    fragment = new TopRatedFragment();
                    if (fragment != null) {

                        FragmentManager fragmentManager = getSupportFragmentManager();

                        fragmentManager.beginTransaction()
                                .replace(R.id.frame_container, fragment).commit();

                        // update selected item and title, then close the drawer
                        mDrawerList.setItemChecked(1, true);
                        mDrawerList.setSelection(1);
                        setTitle(navMenuTitles[1]);
                       // mDrawerLayout.closeDrawers();
                        mDrawerLayout.closeDrawer(mDrawerRelativeLayout);

                       // mDrawerLayout.closeDrawer(mDrawerList);
                    } else {
                        // error in creating fragment
                        Log.e("MainActivity", "Error in creating fragment");
                    }
                }

            }
        });


        Drawer_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//
                if (mDrawerLayout.isDrawerOpen(GravityCompat.START))
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                else
                    mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });


        //LayoutInflater getLayoutInflater1= LayoutInflater.from(this);
        // actionBar.setDisplayShowCustomEnabled(true);
//        View customView = getLayoutInflater1.inflate(R.layout.custom_bar, null);
//
//        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_HOME_AS_UP);
//        Refresh_button= (ImageView) customView.findViewById(R.id.refresh);
//        Title_actionbar= (TextView) customView.findViewById(R.id.Title_action);
//        Drawer_button= (ImageView) customView.findViewById(R.id.drawer_button);


//        actionBar.setCustomView(customView);
//        actionBar.setDisplayShowCustomEnabled(true);
//        actionBar.setDisplayHomeAsUpEnabled(true);


        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.icon_menu, //nav menu toggle icon
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        ) {
            public void onDrawerClosed(View view) {
                //actionBar.setTitle(mTitle);
                Title_actionbar.setText(mTitle.toString());


                // calling onPrepareOptionsMenu() to show action bar icons
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                // actionBar.setTitle(mDrawerTitle);
                Title_actionbar.setText(mDrawerTitle.toString());
                // calling onPrepareOptionsMenu() to hide action bar icons
                invalidateOptionsMenu();
            }
        };


        mDrawerLayout.setDrawerListener(mDrawerToggle);

        // Drawer_button.setImageResource(R.drawable.icon_menu);
        // actionBar.setDisplayHomeAsUpEnabled(true);
        if (savedInstanceState == null) {
            // on first time display view for first nav item

            displayView(0);
        }


//        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());


//        viewPager = (ViewPager) findViewById(R.id.pager);
//        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
//
//        viewPager.setAdapter(mAdapter);


        //actionBar.setHomeButtonEnabled(false);


//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//
//        // Adding Tabs

//        for (String tab_name : tabs) {
//            actionBar.addTab(actionBar.newTab().setText(tab_name)
//                    .setTabListener(this));
//
//            //  actionBar.setIcon(R.drawable.ic_launcher);
//
//        }


//        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//
//            @Override
//            public void onPageSelected(int position) {
//                // on changing the page
//                // make respected tab selected
//                actionBar.setSelectedNavigationItem(position);
//            }
//
//            @Override
//            public void onPageScrolled(int arg0, float arg1, int arg2) {
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int arg0) {
//            }
//        });
    }


    private void rateYesNo() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Do you like this app?")
                .setCancelable(true)
                .setPositiveButton("Like", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {


                        Intent intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("market://details?id=" + MainActivity.this.getPackageName()));
                        startActivity(intent);

                        // RateApp();
                    }
                }).setNegativeButton("Dislike", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Fragment fragment1 = null;
                dialog.dismiss();

                fragment1 = new FB_Fragment();
                if (fragment1 != null) {

                    FragmentManager fragmentManager = getSupportFragmentManager();

                    fragmentManager.beginTransaction()
                            .replace(R.id.frame_container, fragment1).commit();

                    // update selected item and title, then close the drawer
                    mDrawerList.setItemChecked(4, true);
                    mDrawerList.setSelection(4);
                    setTitle(navMenuTitles[4]);
                  //  mDrawerLayout.closeDrawers();
                    mDrawerLayout.closeDrawer(mDrawerRelativeLayout);
                } else {
                    // error in creating fragment
                    Log.e("MainActivity", "Error in creating fragment");
                }

            }
        })
        ;

        final AlertDialog alert = builder.create();
        alert.show();
    }


//    @Override
//    public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {
//        HomeFragments.viewPager.setCurrentItem(tab.getPosition());
//    }
//
//    @Override
//    public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {
//
//    }
//
//    @Override
//    public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {
//
//    }


    public class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {


            // display view for selected nav drawer item
            displayView(position);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar actions click
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        // if nav drawer is opened, hide the action items
//        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
//        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
//        return super.onPrepareOptionsMenu(menu);
//    }


    public void displayView(int position) {
        // update the main content by replacing fragments
        pref = MainActivity.this.getSharedPreferences("pref_SoundDown", MainActivity.this.MODE_PRIVATE);
        edit = pref.edit();
        edit.putInt("drawer_pos", position);
        edit.apply();

        fragment = null;
        switch (position) {
            case 0:

//                pref = MainActivity.this.getSharedPreferences("pref_SoundDown", MainActivity.this.MODE_PRIVATE);
//                edit = pref.edit();
//                edit.putInt("drawer_pos", position);
//                edit.apply();
                long_check = 1;
                market_stocks = true;
                Refresh_button.setVisibility(View.VISIBLE);
                fragment = new GamesFragment();


//                actionBar.setDisplayShowHomeEnabled(true);

                //              actionBar.setDisplayShowTitleEnabled(true);


                //  actionBar.setHomeButtonEnabled(true);
//HomeFragments.actionBar.show();


                break;
            case 1:
//
//                pref = MainActivity.this.getSharedPreferences("pref_SoundDown", MainActivity.this.MODE_PRIVATE);
//                edit = pref.edit();
//                edit.putInt("position", position);
//                edit.apply();

                long_check = 1;
                market_stocks = false;
                Refresh_button.setVisibility(View.VISIBLE);
                fragment = new TopRatedFragment();

                break;
            case 4:
//
////                pref = MainActivity.this.getSharedPreferences("pref_SoundDown", MainActivity.this.MODE_PRIVATE);
////                edit = pref.edit();
////                edit.putInt("position", position);
////                edit.apply();
//
                Refresh_button.setVisibility(View.GONE);
                rateYesNo();
                break;
                 // fragment = new FB_Fragment();
//
//
//                //    actionBar.setHomeButtonEnabled(false);
//                //actionBar.removeAllTabs();
//                //actionBar.hide();
//
//                // actionBar.removeAllTabs();
//                actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
//                //  actionBar.removeAllTabs();
//                //actionBar.hide();
//
//                break;


           case 5:
////                pref = MainActivity.this.getSharedPreferences("pref_SoundDown", MainActivity.this.MODE_PRIVATE);
////                edit = pref.edit();
////                edit.putInt("position", position);
////                edit.apply();
               Refresh_button.setVisibility(View.GONE);

                Intent share_data_drawer = new Intent(Intent.ACTION_SEND);
                share_data_drawer.setType("text/plain");
                share_data_drawer.putExtra(Intent.EXTRA_TEXT, "I am using this app.\n https://play.google.com/store/apps/details?id=com.appinhand.saudistockexchange");
                Intent share_via = Intent.createChooser(share_data_drawer, "Share Via");
                startActivity(share_via);
                break;

           case 6:
////                pref = MainActivity.this.getSharedPreferences("pref_SoundDown", MainActivity.this.MODE_PRIVATE);
////                edit = pref.edit();
////                edit.putInt("position", position);
////                edit.apply();
                Refresh_button.setVisibility(View.GONE);
                fragment = new FindPeopleFragment();
//                //  actionBar.removeAllTabs();
//                // actionBar.hide();
//
//                //  actionBar.removeAllTabs();
//                actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
//                //  actionBar.removeAllTabs();
//                //actionBar.hide();
//
              break;

            case 2:
//                pref = MainActivity.this.getSharedPreferences("pref_SoundDown", MainActivity.this.MODE_PRIVATE);
//                edit = pref.edit();
//                edit.putInt("position", position);
//                edit.apply();
                Refresh_button.setVisibility(View.VISIBLE);

                market_stocks = false;
                long_check = 0;
                fragment = new search_stocks();
                actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
                break;
            case 3:
//                pref = MainActivity.this.getSharedPreferences("pref_SoundDown", MainActivity.this.MODE_PRIVATE);
//                edit = pref.edit();
//                edit.putInt("position", position);
//                edit.apply();

                Refresh_button.setVisibility(View.GONE);
                fragment = new watchlist();
                actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
                break;
            default:
                break;
        }

        if (fragment != null) {

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, fragment).commit();

            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(navMenuTitles[position]);
          //  mDrawerLayout.closeDrawers();
            mDrawerLayout.closeDrawer(mDrawerRelativeLayout);
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }


    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        actionBar.setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


}
