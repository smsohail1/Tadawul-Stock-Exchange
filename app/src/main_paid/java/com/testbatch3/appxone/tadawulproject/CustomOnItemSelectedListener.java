package com.testbatch3.appxone.tadawulproject;


import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

import java.text.DecimalFormat;

/**
 * Created by APPXONE on 3/8/2016.
 */
public class CustomOnItemSelectedListener implements OnItemSelectedListener {

    public static String values1="";
    DecimalFormat format;
    Double fre_double, wavevelocity_double, per_double, OUTPUT_WAVELENGTH;
    String wavevelocity, fre, per;
Double first_sub,first_two_sub,final_sub;
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//        Toast.makeText(parent.getContext(),
//                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
//                Toast.LENGTH_SHORT).show();
//        format = new DecimalFormat(".00");
        if (pos == 0) {
            values1 = "Greater than";
        } else if (pos == 1) {

            values1= "Less than";
        }
        //else if (pos == 2) {

//            values = 225000000;
//        } else if (pos == 3) {
//
//            values = 343;
//        } else if (pos == 4) {
//
//            values = 1600;
//        }



//
//        Frequencyconverter.wavevelocity = Frequencyconverter.wavvelocity_val.getText().toString();
//
//        fre = Frequencyconverter.frequency_val.getText().toString();
//        per = Frequencyconverter.period_val.getText().toString();
//        Frequencyconverter.fre_double = Double.parseDouble(Frequencyconverter.fre);
//        Frequencyconverter.per_double = Double.parseDouble(Frequencyconverter.per);
//        wavevelocity_double = Double.parseDouble(Frequencyconverter.wavevelocity);
//        OUTPUT_WAVELENGTH = wavevelocity_double / fre_double;
//        wavelength_val.setText(format.format(OUTPUT_WAVELENGTH).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}