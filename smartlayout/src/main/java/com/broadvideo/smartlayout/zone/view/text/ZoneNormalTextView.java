package com.broadvideo.smartlayout.zone.view.text;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.AbsoluteLayout;
import android.widget.TextView;

import com.broadvideo.smartlayout.Constant;
import com.broadvideo.smartlayout.data.bundle.BundleJsonModule;
import com.broadvideo.smartlayout.data.zone.Zones;
import com.broadvideo.smartlayout.zone.view.ZonesView;

/**
 * SmartLayoutDemo
 * <p>
 * Created by Vinda on 2020/12/10
 * Copyright © 2020年 BroadVideo. All rights reserved.
 * <p>
 * Describe:普通的文字View
 */
public class ZoneNormalTextView extends ZonesView {
    TextView textView = null;

    public ZoneNormalTextView(Context context, Zones zone, BundleJsonModule bundleJsonModule) {
        super(context, zone, bundleJsonModule);
        create();
    }

    @Override
    public void create() {
        textView = new TextView(getContext());
        AbsoluteLayout.LayoutParams params = new AbsoluteLayout.LayoutParams(
                scaledWidth, scaledHeight, scaledLeft, scaledTop);
        textView.setLayoutParams(params);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        if (!TextUtils.isEmpty(zone.content)) {
            textView.setText(zone.content);
        }
        float percent = 150f;
        if (Constant.Companion.getScreenIs4K()) {
            percent = 50.0f;
        }
        int scaledTextSize = (int) ((zone.size / percent) * zone.height);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(scaledTextSize);
        textView.setTextColor(Color.parseColor(zone.color));
        textView.setBackgroundColor(Color.parseColor(zone.bgcolor));//背景颜色
        addView(textView);
    }

    @Override
    public void destroy() {

    }

    /**
     * 设置文字
     */
    public void setText(String text) throws Exception {
        if (TextUtils.isEmpty(text)) {
            throw new Exception("text must not null!!");
        }
        textView.setText(text);
    }
}
