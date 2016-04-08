package com.testbatch3.appxone.tadawulproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("NewApi")
public class PhotosFragment extends Fragment {


    public View onCreateView(LayoutInflater inflator, ViewGroup container, Bundle saveinstanceinstate) {
        return inflator.inflate(R.layout.people_frag, container, false);


    }

}
