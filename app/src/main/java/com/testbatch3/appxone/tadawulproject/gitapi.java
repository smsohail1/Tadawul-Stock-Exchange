package com.testbatch3.appxone.tadawulproject;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by APPXONE on 1/6/2016.
 */
public interface gitapi {

    @GET("/Indices_fetch.php")
    public void kse1_fatch(Callback<kse1_fetch> response);

    @GET("/tadawul_fetch.php")
    public void kse2_fatch(Callback<kse2_fatch> response);


}
