package com.broadvideo.smartlayout.data.bundle;

import com.broadvideo.smartlayout.data.zone.Zones;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by vinda on 2018/7/9.
 * Describe:
 * qq:1304314404
 */

public class BundleJsonModule implements Serializable{
//    "bundle_id":83,
//            "name":"按摩椅",
//            "touch_flag":"1",
//            "home_flag":"1",
//            "home_bundle_id":0,
//            "home_idle":0,
//            "width":1080,
//            "height":1920,
//            "bg_color":"#000000"
    public int bundle_id;
    public String name;
    public String touch_flag;
    public String home_flag;
    public int home_bundle_id;
    public int home_idle;
    public int width;
    public int height;
    public String bg_color;
    public ArrayList<Zones> zones;

    @Override
    public String toString() {
        return "BundleJsonModule{" +
                "bundle_id=" + bundle_id +
                ", name='" + name + '\'' +
                ", touch_flag='" + touch_flag + '\'' +
                ", home_flag='" + home_flag + '\'' +
                ", home_bundle_id=" + home_bundle_id +
                ", home_idle=" + home_idle +
                ", width=" + width +
                ", height=" + height +
                ", bg_color='" + bg_color + '\'' +
                ", zones=" + zones +
                '}';
    }
}
