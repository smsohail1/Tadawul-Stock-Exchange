package com.testbatch3.appxone.tadawulproject;

/**
 * Created by APPXONE on 1/18/2016.
 */
public class search_model {

    private String index;
    private int icon, id_stock_model;
    private String count = "0";

    private String float_value, plus_float, perecntage1;

    private String high_stock, low_stock, volume_stock, previous_stock,channgepercent,Current;
    // boolean to set visiblity of the counter
    private boolean isCounterVisible = false;
    private  String posn;

    public search_model() {
    }

    public search_model( String index, String float_value
            , String high_stock, String low_stock, String volume_stock, String previous_stock,String posn,String channgepercent,String Current) {

        // this.id_stock_model = id_stock_model;
        this.index = index;
        this.float_value = float_value;
this.posn=posn;
        this.channgepercent=channgepercent;
        this.Current=Current;

        // this.plus_float = plus_float;
        // this.perecntage1 = perecntage1;
        //this.icon = icon;


        this.high_stock = high_stock;

        this.low_stock = low_stock;

        this.volume_stock = volume_stock;
        this.previous_stock = previous_stock;


    }


    public search_model(String index, String float_value
            , String high_stock, String low_stock, String volume_stock, String previous_stock,String posn,String channgepercent,String Current,
                         boolean isCounterVisible, String count

    ) {

        //this.id_stock_model = id_stock_model;
        this.index = index;
        this.float_value = float_value;
        this.posn=posn;
        // this.plus_float = plus_float;
        // this.perecntage1 = perecntage1;
        //  this.icon = icon;
        this.channgepercent=channgepercent;
        this.Current=Current;

        this.high_stock = high_stock;

        this.low_stock = low_stock;

        this.volume_stock = volume_stock;
        this.previous_stock = previous_stock;


        this.isCounterVisible = isCounterVisible;
        this.count = count;
    }


//    public int get_id() {
//        return this.id_stock_model;
//    }
public  String getCurrent()
{
    return  this.Current;
}

    public  String getchangePercent()
    {
        return this.channgepercent;

    }


    public  String getpositon()
    {
        return this.posn;
    }
    public  void setposition()
    {
        this.posn=posn;
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


    public String gethigh1() {
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
