package com.broadvideo.smartlayout.data.zone;

import com.broadvideo.smartlayout.zone.control.BaseZoneControl;
import com.broadvideo.smartlayout.zone.view.ZonesView;

import java.util.ArrayList;

/**
 * Created by vinda on 2018/7/9.
 * Describe:
 * qq:1304314404
 */

public class Zones {
    public int zone_id;//区域id
    public String main_flag;
    public int width;
    public int height;
    public int top;
    public int left;
    public int zindex;
    public int type;
    public int sleep;
    public int interval;
    public int speed;
    public String color;
    public String bgcolor;
    public int size;
    public String date_format;
    public int fit_flag;
    public int volume;
    public String animation;//转场特效
    public String content;
    public String advert_place;//对应广告位ID
    public int touch_type;//"0-返回 1-跳转首页 2-跳转子页 3-播放 4-跳转APK 9-屏蔽"
    public int touch_bundle_id;//int)跳转的节目id
    public ArrayList<Zonedtls> zonedtls;//当前播放资源定义

    public ZonesView zoneView;//当前zone内的View
    public BaseZoneControl zonePlayControl;//当前Zone播放控制类

    public boolean needRefresh = false;//当前区域播放是否需要刷新



    //用来判断新旧两个类是否相同
    @Override
    public String toString() {
        String z = "";
        for (Zonedtls zonedtls1 : zonedtls) {
            z = z + "Zonedtls{" +
                    "id=" + zonedtls1.id +
                    ", type='" + zonedtls1.type + '\'' +
                    '}';
        }
        return "Zones{" +
                "zone_id=" + zone_id +
                ", main_flag='" + main_flag + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", top=" + top +
                ", left=" + left +
                ", zindex=" + zindex +
                ", type=" + type +
                ", sleep=" + sleep +
                ", interval=" + interval +
                ", speed=" + speed +
                ", color='" + color + '\'' +
                ", bgcolor='" + bgcolor + '\'' +
                ", size=" + size +
                ", date_format=" + date_format +
                ", fit_flag=" + fit_flag +
                ", volume=" + volume +
                ", animation='" + animation + '\'' +
                ", touch_type='" + touch_type + '\'' +
                ", touch_bundle_id='" + touch_bundle_id + '\'' +
                ", content='" + content + '\'' +
                ", zonedtls=" + z +
                '}';
    }
}
