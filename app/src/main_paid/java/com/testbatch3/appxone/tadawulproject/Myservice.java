package com.testbatch3.appxone.tadawulproject;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by APPXONE on 4/13/2016.
 */
public class Myservice extends Service {
    String gtr_lsr;
    public static boolean comingfromMinactivity;
    Cursor c1;
    String query;
    String notification_msg;
    DecimalFormat format;
    Double currentuser_double, currenr_web_double;
    String str_format;

    Double double_current_user, currenrt_web_db_double;
    int Unique_Integer_Number = 0;

    String current_Web;
    NotificationManager mNotificationManager;
    Bundle b;
    int status;
    Intent i;
    String query_notify;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        //  Toast t = Toast.makeText(Myservice.this, "service bind", Toast.LENGTH_SHORT);
        // t.show();
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        ScheduledExecutorService scheduler =
                Executors.newSingleThreadScheduledExecutor();


        scheduler.scheduleAtFixedRate
                (new Runnable() {
                    public void run() {

                        mNotificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

                        i = new Intent(Myservice.this, MainActivity.class);

                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        b = new Bundle();

                        i.putExtras(b);

                        format = new DecimalFormat(".00");
                        if (isConnectingToInternet()) {
                            hitWebservice_kse2();
                        } else {
                            Log.e("not connected", "not connected");
                        }


//
//                        NotificationManager mNotificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
//                        Intent i;
//                        i = new Intent(Myservice.this, MainActivity.class);
//
//                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                        Bundle b = new Bundle();
//
//                        i.putExtras(b);
//
//                        query = "SELECT * FROM '" + AppSettings.DATABASE_TABLE_NOTIFY + "'";
//                        Log.e("SELECT QUERY", query);
//
//                        c1 = dbmgr.selectQuery(query);
//
//
//                        try {
//                            if (c1 != null && c1.moveToFirst()) {
//                                do {
//
//                                    String KEY_SYMBOL = c1.getString(c1
//                                            .getColumnIndex(AppSettings.KEY_NAME));
//                                    String KEY_GTR_LSR = c1.getString(c1
//                                            .getColumnIndex(AppSettings.KEY_GTR_LSR));
//                                    String current = c1.getString(c1
//                                            .getColumnIndex(AppSettings.KEY_CURRENT));
//                                    String current_Web = c1.getString(c1
//                                            .getColumnIndex(AppSettings.KEY_CURRENT_WEB));
//
//                                    currentuser_double = Double.parseDouble(current);
//
//                                    str_format = format.format(currentuser_double);
//
//                                    double_current_user = Double.valueOf(str_format);
//
//                                    currenr_web_double = Double.parseDouble(current_Web);
//
//
//                                    if (KEY_GTR_LSR.equalsIgnoreCase("Greater than")) {
//                                        if (double_current_user > currenr_web_double) {
//
//                                            notification_msg = KEY_SYMBOL + " has been " + KEY_GTR_LSR + " " + current + "\n New Value:" + current_Web;
//
////                                            <Stock Name> has been <greater than> / <less than>  17.65
////                                            New  Value: 18.01
//                                            comingfromMinactivity = true;
//                                            PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0, i, PendingIntent.FLAG_CANCEL_CURRENT);
//                                            NotificationCompat.Builder mBuilder =
//                                                    new NotificationCompat.Builder(getApplicationContext())
//                                                            .setSmallIcon(R.drawable.app_icon)
//                                                            .setContentTitle("PSX PRO")
//                                                            .setAutoCancel(true)
//                                                            .setTicker("PSX PRO")
//                                                            .setDefaults(Notification.DEFAULT_ALL)
//                                                            .setContentText(notification_msg);
//                                            mBuilder.setContentIntent(contentIntent);
//                                            Unique_Integer_Number++;
//                                            mNotificationManager.notify(Unique_Integer_Number, mBuilder.build());
//
////                                              comingfromMinactivity=true;
//
//                                        }
//                                        //gtr_lsr="Greater than";
//                                    } else if (KEY_GTR_LSR.equalsIgnoreCase("Less than")) {
//                                        //gtr_lsr="Less than";
//                                        if (double_current_user < currenr_web_double) {
//                                            comingfromMinactivity = true;
//                                            notification_msg = KEY_SYMBOL + " has been " + KEY_GTR_LSR + " " + current + "\n New Value:" + current_Web;
//                                            PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0, i, PendingIntent.FLAG_CANCEL_CURRENT);
//                                            NotificationCompat.Builder mBuilder =
//                                                    new NotificationCompat.Builder(getApplicationContext())
//                                                            .setSmallIcon(R.drawable.app_icon)
//                                                            .setContentTitle("PSX PRO")
//                                                            .setAutoCancel(true)
//                                                            .setTicker("PSX PRO")
//                                                            .setDefaults(Notification.DEFAULT_ALL)
//                                                            .setContentText(notification_msg);
//                                            mBuilder.setContentIntent(contentIntent);
//                                            Unique_Integer_Number++;
//                                            mNotificationManager.notify(Unique_Integer_Number, mBuilder.build());
//                                            //comingfromMinactivity=true;
//                                        }
//                                    }
//
//
//                                } while (c1.moveToNext());
//                            }
//
//                        } finally {
//                            c1.close();
//                        }


//                        Toast t = Toast.makeText(Myservice.this, "service started", Toast.LENGTH_SHORT);
//                        t.show();

                        // call service

                    }
                }, 0, 60, TimeUnit.MINUTES);

//60, TimeUnit.MINUTES
//        Toast t = Toast.makeText(Myservice.this, "service started", Toast.LENGTH_SHORT);
//        t.show();

        return START_STICKY;
        //  return super.onStartCommand(intent, flags, startId);
    }

    public boolean isConnectingToInternet() {

        ConnectivityManager connectivity = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        Log.e("connected", "connected");
                        return true;
                    }

        }


        return false;
    }

    public void hitWebservice_kse2() {

        final DataBaseManager dbmgr;
        dbmgr = new DataBaseManager(getApplicationContext());
        query = "SELECT * FROM '" + AppSettings.DATABASE_TABLE_NOTIFY + "'";
        Log.e("SELECT QUERY", query);

        c1 = dbmgr.selectQuery(query);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://appinhand.net/LiveApplications/psx").build();
        gitapi git = restAdapter.create(gitapi.class);

        git.kse2_fatch(new Callback<kse2_fatch>() {
                           @Override
                           public void success(kse2_fatch model1, Response response) {

                               //  dialog.dismiss();


                               if (model1.getStatus().equalsIgnoreCase("true")) {
                                   try {
                                       if (c1 != null && c1.moveToFirst()) {
                                           do {
                                               Log.e("agya", "agya");
                                               String POS = c1.getString(c1
                                                       .getColumnIndex(AppSettings.KEY_POSITION));
                                               int pos_int = Integer.parseInt(POS);

                                               current_Web = model1.getMerketSummary().get(pos_int).getPrice();


                                               // String name1 = c1.getString(c1.getColumnIndex(AppSettings.KEY_NAME));


                                              // String KEY_SYMBOL = c1.getString(c1
                                                  //     .getColumnIndex(AppSettings.KEY_NAME));
                                               String KEY_GTR_LSR = c1.getString(c1
                                                       .getColumnIndex(AppSettings.KEY_GTR_LSR));
                                               String current = c1.getString(c1
                                                       .getColumnIndex(AppSettings.KEY_CURRENT));

                                               String SYMBOL = c1.getString(c1
                                                       .getColumnIndex(AppSettings.KEY_NAME));

                                               boolean STATUS = c1.getInt(c1
                                                       .getColumnIndex(AppSettings.KEY_bookmark)) > 0;


                                            //   String current_Web_db = c1.getString(c1.getColumnIndex(AppSettings.KEY_CURRENT_WEB));
                                           //    currenrt_web_db_double = Double.parseDouble(current_Web_db);
                                             //  String str_currrent_db = format.format(currenrt_web_db_double);
                                              // Double double_current_db = Double.valueOf(str_currrent_db);


                                               currentuser_double = Double.parseDouble(current);
                                               str_format = format.format(currentuser_double);

                                               double_current_user = Double.valueOf(str_format);

                                               currenr_web_double = Double.parseDouble(current_Web);
                                               String str_current_web = format.format(currenr_web_double);
                                               Double double_current_web = Double.valueOf(str_current_web);

                                               if (KEY_GTR_LSR.equalsIgnoreCase("Greater than")) {


                                                   //  Log.e("nothing to do", "No notifictaion");


                                                   if (double_current_web > double_current_user) {

                                                       if (STATUS) {
                                                           Log.e("true status", STATUS + "do nothing");
                                                       } else {


                                                           //  if (double_current_db == double_current_web) {
//                                                       if(current_Web_db.equalsIgnoreCase(current_Web))
//                                                       {
//                                                           Log.e("equal ", "equal no notigufation");
                                                           // Log.e("not equal ", current_Web_db + "" + double_current_web + "");
//                                                          // Log.e("equal ", double_current_db + double_current_web+"");
//                                                       }

                                                           //    else {
//                                                           Log.e("equal ", double_current_db+ ""+ double_current_web+"");
//                                                           Log.e("notify", "notifictaion_grater");
//                                                           query_notify = "UPDATE " + AppSettings.DATABASE_TABLE_NOTIFY + " SET " + AppSettings.KEY_CURRENT_WEB + " = " + "'" + current_Web + "'"
//                                                                   + " WHERE " + AppSettings.KEY_NAME + " = " + "'" + SYMBOL + "'";
//                                                           Log.e("query_update", "" + query_notify);
//                                                           dbmgr.insert_update(query_notify);

                                                           // }
                                                           //  if (current_Web_db <= currenr_web_double || ) {
                                                           //  else {
                                                           notification_msg = SYMBOL + " has been " + "greater than " + " " + current + "\n New Value:" + current_Web;

//                                            <Stock Name> has been <greater than> / <less than>  17.65
//                                            New  Value: 18.01
                                                           comingfromMinactivity = true;
                                                           PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0, i, PendingIntent.FLAG_CANCEL_CURRENT);
                                                           NotificationCompat.Builder mBuilder =
                                                                   new NotificationCompat.Builder(getApplicationContext())
                                                                           .setSmallIcon(R.drawable.app_icon)
                                                                           .setContentTitle("PSX PRO")
                                                                           .setAutoCancel(true)
                                                                           .setTicker("PSX PRO")
                                                                           .setDefaults(Notification.DEFAULT_ALL)
                                                                           .setContentText(notification_msg);
                                                           mBuilder.setContentIntent(contentIntent);
                                                           Unique_Integer_Number++;
                                                           mNotificationManager.notify(Unique_Integer_Number, mBuilder.build());

                                                           Log.e("notify", "notifictaion_grater");
                                                           status = 1;
                                                           query_notify = "UPDATE " + AppSettings.DATABASE_TABLE_NOTIFY + " SET " + AppSettings.KEY_bookmark + " = " + status
                                                                   + " WHERE " + AppSettings.KEY_NAME + " = " + "'" + SYMBOL + "'";
                                                           Log.e("query_update", "" + query_notify);
                                                           // Log.e("equal ", current_Web_db + "" + double_current_web + "");
                                                           dbmgr.insert_update(query_notify);

                                                           Log.e("false status", STATUS + "");
//                                                           stock_list.query = "DELETE FROM " + AppSettings.DATABASE_TABLE_NOTIFY + " WHERE " + AppSettings.KEY_NAME + " = " + "'" + KEY_SYMBOL + "'";
//                                                           Log.e("query", "" + stock_list.query + "" + KEY_SYMBOL);
//                                                           dbmgr.insert_update(stock_list.query);

                                                       }
//                                                           query_notify = "UPDATE " + AppSettings.DATABASE_TABLE_NOTIFY + " SET " + AppSettings.KEY_CURRENT_WEB + " = " + "'" + current_Web + "'"
//                                                                   + " WHERE " + AppSettings.KEY_NAME + " = " + "'" + SYMBOL + "'";
//                                                           Log.e("query_update", "" + query_notify);
//                                                           Log.e("equal ", current_Web_db + "" + double_current_web + "");
//                                                           dbmgr.insert_update(query_notify);


//

                                                       //  }
                                                   }


                                                 else  if (double_current_web < double_current_user) {

                                                       if (STATUS) {
                                                           status = 0;
                                                           query_notify = "UPDATE " + AppSettings.DATABASE_TABLE_NOTIFY + " SET " + AppSettings.KEY_bookmark + " = " + status
                                                                   + " WHERE " + AppSettings.KEY_NAME + " = " + "'" + SYMBOL + "'";
                                                           Log.e("query_update", "" + query_notify);
                                                           // Log.e("equal ", current_Web_db + "" + double_current_web + "");
                                                           dbmgr.insert_update(query_notify);

                                                       } else {


                                                       }
                                                   }


                                               }
                                               //gtr_lsr="Greater than";
                                               //  }

                                               else if (KEY_GTR_LSR.equalsIgnoreCase("Less than")) {
                                                   //gtr_lsr="Less than";
//                                    if(current_Web.equalsIgnoreCase(current_Web_db))
//                                    {
//                                        Log.e("nothing to do", "No notifictaion");
//
//                                    }

                                                   if (double_current_web < double_current_user) {

                                                       if (STATUS) {
                                                           Log.e("true status", STATUS + "do nothing");
                                                       } else {


//                                                       if (current_Web_db.equalsIgnoreCase(current_Web)) {
//                                                           Log.e("equal ", "equal no notigufation");
//                                                           Log.e("not equal lesser", current_Web_db+ ""+ double_current_web+"");
//                                                       }

                                                           //  if (current_Web_db <= currenr_web_double || ) {
                                                           //  else {
                                                           comingfromMinactivity = true;
                                                           notification_msg = SYMBOL + " has been " + "Less than " + " " + current + "\n New Value:" + current_Web;
                                                           PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0, i, PendingIntent.FLAG_CANCEL_CURRENT);
                                                           NotificationCompat.Builder mBuilder =
                                                                   new NotificationCompat.Builder(getApplicationContext())
                                                                           .setSmallIcon(R.drawable.app_icon)
                                                                           .setContentTitle("PSX PRO")
                                                                           .setAutoCancel(true)
                                                                           .setTicker("PSX PRO")
                                                                           .setDefaults(Notification.DEFAULT_ALL)
                                                                           .setContentText(notification_msg);
                                                           mBuilder.setContentIntent(contentIntent);
                                                           Unique_Integer_Number++;
                                                           mNotificationManager.notify(Unique_Integer_Number, mBuilder.build());
                                                           Log.e("notify", "notifictaion_lesser");

//                                        stock_list.query = "DELETE FROM " + AppSettings.DATABASE_TABLE_NOTIFY + " WHERE " + AppSettings.KEY_NAME + " = " + "'" + KEY_SYMBOL + "'";
//                                        Log.e("query", "" + stock_list.query + "" + KEY_SYMBOL);
//                                        dbmgr.insert_update(stock_list.query);

                                                           status = 1;
                                                           query_notify = "UPDATE " + AppSettings.DATABASE_TABLE_NOTIFY + " SET " + AppSettings.KEY_bookmark + " = " + status
                                                                   + " WHERE " + AppSettings.KEY_NAME + " = " + "'" + SYMBOL + "'";
                                                           Log.e("query_update", "" + query_notify);
                                                         //  Log.e("equal ", current_Web_db + "" + double_current_web + "");
                                                           dbmgr.insert_update(query_notify);

                                                           Log.e("false status", STATUS + "");
                                                           //comingfromMinactivity=true;
                                                           // }
                                                       }
                                                   }

                                                   else if (double_current_web > double_current_user) {

                                                       if (STATUS) {
                                                           status = 0;
                                                           query_notify = "UPDATE " + AppSettings.DATABASE_TABLE_NOTIFY + " SET " + AppSettings.KEY_bookmark + " = " + status
                                                                   + " WHERE " + AppSettings.KEY_NAME + " = " + "'" + SYMBOL + "'";
                                                           Log.e("query_update", "" + query_notify);
                                                          // Log.e("equal ", current_Web_db + "" + double_current_web + "");
                                                           dbmgr.insert_update(query_notify);
                                                           Log.e("true status", STATUS + "do ");
                                                       }
                                                       else {
                                                           Log.e("false status", STATUS + "do nothing");
                                                       }

                                                   }


                                                   //      int id_stock1 = c1.getInt(c1.getColumnIndex(AppSettings.KEY_ID));
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


                                                   //    watch_item.add(new watchlist_model(id_stock1, model1.getMarket().get(pos_int).getSymbol(), model1.getMarket().get(pos_int).getChanges(), string_changes, img_drawable, percantage_string, model1.getMarket().get(pos_int).getHigh(), model1.getMarket().get(pos_int).getLow(), model1.getMarket().get(pos_int).getVolume(), model1.getMarket().get(pos_int).getLdcp(), pos_int + "", model1.getMarket().get(pos_int).getCurrent()));

                                                   //  watch_item.add(new watchlist_model(id_stock1, name1, changes1, ratio1, icon1, percantage1, high1, low1, volume1, previous1));


                                                   //   Toast.makeText(getActivity(), "[LOW:" + low1 + "], [name: " + name1 + "], [high: "
                                                   //         + high1 + "]", Toast.LENGTH_LONG).show();
                                                   //  }
                                               }
                                           }
                                           while (c1.moveToNext());

                                       }
                                   } finally {
                                       c1.close();
                                   }

//                    watchAdapter = new watclist_adapter(getContext(), watch_item);
//                    watch_list_data.setAdapter(watchAdapter);


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
                                   Toast toast = Toast.makeText(getApplicationContext(), "Error Connection", Toast.LENGTH_SHORT);
                                   toast.show();

                               }


                           }

                           @Override
                           public void failure(RetrofitError error) {
                               //   dialog.dismiss();

                           }
                       }

        );
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        Toast t = Toast.makeText(Myservice.this, "service create", Toast.LENGTH_SHORT);
//        t.show();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        Toast t = Toast.makeText(Myservice.this, "service destroy", Toast.LENGTH_SHORT);
//        t.show();
    }
}
