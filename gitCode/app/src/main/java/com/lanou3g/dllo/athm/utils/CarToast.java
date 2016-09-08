package com.lanou3g.dllo.athm.utils;

import android.widget.Toast;

import com.lanou3g.dllo.athm.controler.app.CarApp;

/**
 * Created by dllo on 16/9/8.
 */
public class CarToast {

    private CarToast(){}

    private  static boolean isDebug = true;
    //短吐司的简易方法
    public  static  void shortMsg(String msg){
        if (isDebug){
            Toast.makeText(CarApp.getContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }
    //长吐司的简易方法
    public  static  void longMsg(String msg){
        if (isDebug){
            Toast.makeText(CarApp.getContext(), msg, Toast.LENGTH_LONG).show();
        }
    }

}
