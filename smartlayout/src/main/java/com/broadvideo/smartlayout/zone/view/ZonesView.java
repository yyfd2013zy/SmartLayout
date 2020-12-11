package com.broadvideo.smartlayout.zone.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.broadvideo.smartlayout.Constant;
import com.broadvideo.smartlayout.data.bundle.BundleJsonModule;
import com.broadvideo.smartlayout.data.zone.Zones;


/**
 * SmartLayoutDemo
 * <p>
 * Created by Vinda on 2020/12/10
 * Copyright © 2020年 BroadVideo. All rights reserved.
 * <p>
 * Describe:
 */
public abstract class ZonesView extends RelativeLayout {
    //View谓一id,这里采用时间戳进行标记，用于标记这个
    public long viewID;
    public Zones zone;
    public BundleJsonModule bundleJsonModule;
    public int scaledWidth = 0;
    public int scaledHeight = 0;
    public int scaledLeft = 0;
    public int scaledTop = 0;

    public ZonesView(Context context) {
        super(context);
    }

    public ZonesView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ZonesView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public ZonesView(Context context, Zones zone, BundleJsonModule bundleJsonModule) {
        this(context);
        this.zone = zone;
        this.bundleJsonModule = bundleJsonModule;
        resultViewParams();
    }

    private void resultViewParams() {
        viewID = System.currentTimeMillis();
        scaledWidth = (int) ((float) (zone.width * 1.0 / bundleJsonModule.width) * Constant.Companion.getScreenWidth());
        scaledHeight = (int) ((float) (zone.height * 1.0 / bundleJsonModule.height) * Constant.Companion.getScreenHeight());
        scaledLeft = (int) ((float) (zone.left * 1.0 / bundleJsonModule.width) * Constant.Companion.getScreenWidth());
        scaledTop = (int) ((float) (zone.top * 1.0 / bundleJsonModule.height) * Constant.Companion.getScreenHeight());
    }


    public abstract void create();

    public abstract void destroy();
}
