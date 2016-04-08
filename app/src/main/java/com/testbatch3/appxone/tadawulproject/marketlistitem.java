package com.testbatch3.appxone.tadawulproject;

import com.google.gson.annotations.Expose;

/**
 * Created by APPXONE on 1/5/2016.
 */
public class marketlistitem {

    @Expose
    private String index;
    @Expose
    private int icon;
    @Expose
    private String count = "0";
    @Expose
    private String row1_value1;
    @Expose
    private String row1_value2;
    @Expose
    private String row1_value4;
    @Expose
    private String row3_value1;
    @Expose
    private String row3_value2;
    @Expose
    private String row3_value3;
    @Expose
    private String row3_value4;
    // boolean to set visiblity of the counter
    @Expose
    private boolean isCounterVisible = false;
    private String percenatge1;

    public marketlistitem() {
    }

    public marketlistitem(String index, String row1_value1, String row1_value2
            , String row3_value1) {
        this.index = index;
        this.row1_value1 = row1_value1;

        this.row1_value2 = row1_value2;
        this.row1_value4 = row1_value4;
        this.icon = icon;

        //  this.percenatge1 = percenatge;
        this.row3_value1 = row3_value1;

        this.row3_value2 = row3_value2;

        this.row3_value3 = row3_value3;
        this.row3_value4 = row3_value4;


    }

    public marketlistitem(String index, String row1_value1, String row1_value2
            , String row3_value1,
                          boolean isCounterVisible, String count

    ) {
        this.index = index;
        this.row1_value1 = row1_value1;

        this.row1_value2 = row1_value2;
        //  this.percenatge1 = percenatge;
        this.icon = icon;


        this.row3_value1 = row3_value1;

        this.row3_value2 = row3_value2;

        this.row3_value3 = row3_value3;
        this.row3_value4 = row3_value4;


        this.isCounterVisible = isCounterVisible;
        this.count = count;
    }

    public String getTitle() {
        return this.index;
    }

    public String getwhole() {
        return this.row1_value1;
    }


    public String getplusgloat() {
        return this.row1_value2;
    }


    public int getIcon() {
        return this.icon;
    }

    public String getpercent11() {
        return this.percenatge1;
    }

    public void setpercent(String percenatge) {
        this.percenatge1 = percenatge;

    }

    public String gethigh1() {
        return this.row3_value1;
    }


    public String getlow() {
        return this.row3_value2;
    }

    public String getvolume() {
        return this.row3_value3;
    }

    public String getprevious() {
        return this.row3_value4;
    }

    public String getCount() {
        return this.count;
    }

    public boolean getCounterVisibility() {
        return this.isCounterVisible;
    }


    public void setTitle(String title) {
        this.index = title;
    }


    public void setwhole(String row1_value11) {
        this.row1_value1 = row1_value11;
    }

    public void setplusgloat(String row1_value22) {
        this.row1_value2 = row1_value22;
    }

    // public void setpercent(String row1_value44) {
    //   this.row1_value4 = row1_value44;
    //  }


    public void sethigh(String row3_value11) {
        this.row3_value1 = row3_value11;
    }


    public void setlow(String row3_value22) {
        this.row3_value2 = row3_value22;
    }

    public void setvolume(String row3_value33) {
        this.row3_value3 = row3_value33;
    }

    public void setprevious(String row3_value44) {
        this.row3_value4 = row3_value44;
    }


    public void setIcon(int icon) {
        this.icon = icon;
    }


    public void setCount(String count) {
        this.count = count;
    }

    public void setCounterVisibility(boolean isCounterVisible) {
        this.isCounterVisible = isCounterVisible;
    }

//    public void getrow1_value1(String row1_value1) {
//        this.row1_value1 =  row1_value1;
//    }
//    public void getrow1_value2(String row1_value2) {
//        this.row1_value2 =  row1_value2;
//    }
//    public void getrow1_value4(String row1_value4) {
//        this.row1_value4 =  row1_value4;
//    }


//
//    public void getrow3_value1(String row3_value1) {
//        this.row3_value1 =  row3_value1;
//    }
//
//
//    public void getrow3_value2(String row3_value2) {
//        this.row3_value2 =  row3_value2;
//    }
//
//
//    public void getrow3_value3(String row3_value3) {
//        this.row3_value3 =  row3_value3;
//    }
//
//
//    public void getrow3_value4(String row3_value4) {
//        this.row3_value4 =  row3_value4;
//    }

}
