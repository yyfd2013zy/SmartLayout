package com.broadvideo.smartlayout.zone.control

import android.content.Context
import com.broadvideo.smartlayout.data.zone.Zones
import com.broadvideo.smartlayout.zone.view.ZonesView
import com.broadvideo.smartlayout.zone.view.text.ZoneNormalTextView

/**
 *  SmartLayoutDemo
 *
 *  Created by Vinda on 2020/12/14
 *  Copyright © 2020年 BroadVideo. All rights reserved.
 *
 *  Describe:
 */
public class ZoneNormalTextViewController(context: Context, zoneData: Zones, zoneView: ZonesView?):BaseZoneControl(context,zoneData,zoneView){
    var TAG = "ZoneNormalTextViewController"
    var normalTextView: ZoneNormalTextView ?=null

    init {
        //初始化View
        normalTextView = zoneView as ZoneNormalTextView?
        normalTextView?.setText(mZoneData.content)
    }

    override fun startPlay() {

    }

    override fun stopPlay() {

    }

    override fun release() {

    }
}