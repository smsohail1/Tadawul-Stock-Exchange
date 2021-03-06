package com.testbatch3.appxone.tadawulproject;

import com.google.gson.annotations.Expose;

/**
 * Created by APPXONE on 4/13/2016.
 */
public class notify_model {
    @Expose
    private String index;
    @Expose
    private int icon;
    @Expose
    private int id_stock_model;
    @Expose
    private String count = "0";
    @Expose
    private String float_value;
    @Expose
    private String plus_float;
    @Expose
    private String perecntage1;

    @Expose
    private String high_stock;
    @Expose
    private String low_stock;
    @Expose
    private String volume_stock;
    @Expose
    private String previous_stock;
    // boolean to set visiblity of the counter
    @Expose
    private boolean isCounterVisible = false;
    @Expose
    private String pos, perecentage;
    @Expose
    private String current, change,current_web;

    public notify_model() {
    }

    public notify_model(int id_stock_model, String index, String changes, String float_value, int icon, String percentage
            , String high_stock, String low_stock, String volume_stock, String previous_stock, String pos,String current_web) {

        this.id_stock_model = id_stock_model;
        this.index = index;
        // this.current=current;
        this.float_value = float_value;
        this.current_web=current_web;
        this.pos = pos;
        // this.plus_float = plus_float;

        this.perecentage = percentage;

        this.icon = icon;
        this.change = changes;


        this.high_stock = high_stock;

        this.low_stock = low_stock;

        this.volume_stock = volume_stock;
        this.previous_stock = previous_stock;


    }


    public notify_model(int id_stock_model, String index, String changes, String float_value, int icon, String percentage
            , String high_stock, String low_stock, String volume_stock, String previous_stock, String pos,String current_web,
                        boolean isCounterVisible, String count

    ) {

//        this.current=current;
        this.current_web=current_web;

        this.icon = icon;
        this.perecentage = percentage;

        this.change = changes;
        this.id_stock_model = id_stock_model;
        this.index = index;
        this.float_value = float_value;
        this.pos = pos;
        // this.plus_float = plus_float;
        // this.perecntage1 = perecntage1;
        //  this.icon = icon;


        this.high_stock = high_stock;

        this.low_stock = low_stock;

        this.volume_stock = volume_stock;
        this.previous_stock = previous_stock;


        this.isCounterVisible = isCounterVisible;
        this.count = count;
    }

    public int getid()
    {
        return  this.id_stock_model;
    }
    public String getpercent() {

        return this.perecentage;
    }

//    public int get_id() {
//        return this.id_stock_model;
//    }

       public String getCurrent_web()
    {
        return  this.current_web;

    }
    public String getchanges()
    {
        return this.change;
    }
    public int getimg()

    {
        return this.icon;
    }

    public String getpos() {
        return this.pos;

    }

    public void setpos(String pos) {
        this.pos = pos;
    }

    public String getTitle() {
        return this.index;
    }

    public String getwhole() {
        return this.float_value;
    }


    public String getplusgloat() {
        return this.plus_float;
    }


    //  public int getIcon() {
    //    return this.icon;
    //  }

    //  public String getpercent() {
    //    return     this.perecntage1;
    //}


    public String gethigh() {
        return this.high_stock;
    }


    public String getlow() {
        return this.low_stock;
    }

    public String getvolume() {
        return this.volume_stock;
    }

    public String getprevious() {
        return this.previous_stock;
    }

    public String getCount() {
        return this.count;
    }

    public boolean getCounterVisibility() {
        return this.isCounterVisible;
    }


//    public void set_id(int id_inc) {
//        this.id_stock_model = id_inc;
//    }

    public void setTitle(String title) {
        this.index = title;
    }


    public void setwhole(String row1_value11) {
        this.float_value = row1_value11;
    }

    public void setplusgloat(String row1_value22) {
        this.plus_float = row1_value22;
    }

    //  public void setpercent(String row1_value44) {
    //    this.perecntage1= row1_value44;
    // }


    public void sethigh(String row3_value11) {
        this.high_stock = row3_value11;
    }


    public void setlow(String row3_value22) {
        this.low_stock = row3_value22;
    }

    public void setvolume(String row3_value33) {
        this.volume_stock = row3_value33;
    }

    public void setprevious(String row3_value44) {
        this.previous_stock = row3_value44;
    }


    //  public void setIcon(int icon) {
    //    this.icon = icon;
    // }


    public void setCount(String count) {
        this.count = count;
    }

    public void setCounterVisibility(boolean isCounterVisible) {
        this.isCounterVisible = isCounterVisible;
    }

}
