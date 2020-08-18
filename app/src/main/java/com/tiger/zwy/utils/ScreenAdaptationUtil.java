package com.tiger.zwy.utils;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

import androidx.annotation.NonNull;
//ScreenAdaptationUtil.setDensityByWidth(this, getApplication());
public class ScreenAdaptationUtil {
    private static float sCompatDensity;
    private static float sCompatScaledDensity;
    //默认假设 设计图宽360dp 我们根据设计设计图的尺寸修改
    private static int designWidth=360;
    //默认假设 设计图高640dp 我们根据实际设计图的尺寸修改
    private static int designHeight=640;


    public static void initDesignSize(int width,int height){
        designHeight=height;
        designWidth=width;
    }
    private static void setCustomDensity(Activity activity, final Application application,boolean isWidth){
        DisplayMetrics displayMetrics=application.getResources().getDisplayMetrics();
        if(sCompatDensity==0){
            sCompatDensity=displayMetrics.density;
            sCompatScaledDensity=displayMetrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(@NonNull Configuration newConfig) {
                   if(newConfig!=null&&newConfig.fontScale>0){
                       sCompatScaledDensity=application.getResources().getDisplayMetrics().scaledDensity;
                   }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }
        float targetDensity;
        if(isWidth){
            //根据宽度适配
            targetDensity=displayMetrics.widthPixels/designWidth;
        }else {
            targetDensity=displayMetrics.heightPixels/designHeight;
        }
        float targetScaleDensity=targetDensity*(sCompatScaledDensity/sCompatDensity);
        int targetDensityDpi=(int)(160*targetDensity);
        displayMetrics.density=targetDensity;
        displayMetrics.scaledDensity=targetScaleDensity;
        displayMetrics.densityDpi=targetDensityDpi;
        DisplayMetrics activityDisplayMetrics=activity.getResources().getDisplayMetrics();
        activityDisplayMetrics.density=targetDensity;
        activityDisplayMetrics.scaledDensity=targetScaleDensity;
        activityDisplayMetrics.densityDpi=targetDensityDpi;
    }

    /**
     * 根据设计图宽度设定density
     */
    public static void setDensityByWidth(Activity activity,final Application application){
        setCustomDensity(activity,application,true);
    }

    /**
     * 根据设计图高设定density
     */
    public static void setDensityByHeight(Activity activity,final Application application){
       setCustomDensity(activity,application,false);
    }
}
