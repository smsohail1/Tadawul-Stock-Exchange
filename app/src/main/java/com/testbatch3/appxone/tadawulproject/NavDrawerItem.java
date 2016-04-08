package com.testbatch3.appxone.tadawulproject;
public class NavDrawerItem {
    
    private String title;
    private int icon,icon1;
    private String count = "0";
    // boolean to set visiblity of the counter
    private boolean isCounterVisible = false;
     
    public NavDrawerItem(){}
 
    public NavDrawerItem(String title, int icon,int icon1){
        this.title = title;
        this.icon = icon;
        this.icon1 = icon1;
    }
     
    public NavDrawerItem(String title, int icon,int icon1, boolean isCounterVisible, String count){
        this.title = title;
        this.icon = icon;
        this.icon1 = icon1;
        this.isCounterVisible = isCounterVisible;
        this.count = count;
    }
     
    public String getTitle(){
        return this.title;
    }
     
    public int getIcon(){
        return this.icon;
    }

    public int getIcon_right(){
        return this.icon1;
    }

    public String getCount(){
        return this.count;
    }
     
    public boolean getCounterVisibility(){
        return this.isCounterVisible;
    }
     
    public void setTitle(String title){
        this.title = title;
    }
     
    public void setIcon(int icon){
        this.icon = icon;
    }


    public void setIcon_right(int icon1){
        this.icon1 = icon1;
    }
    public void setCount(String count){
        this.count = count;
    }




    public void setCounterVisibility(boolean isCounterVisible){
        this.isCounterVisible = isCounterVisible;
    }
}