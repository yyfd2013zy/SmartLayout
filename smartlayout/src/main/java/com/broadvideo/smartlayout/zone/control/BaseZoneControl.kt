package com.broadvideo.smartlayout.zone.control

import android.content.Context
import com.broadvideo.smartlayout.data.zone.Zones
import com.broadvideo.smartlayout.zone.view.ZonesView

/**
 *  SmartLayoutDemo
 *
 *  Created by Vinda on 2020/12/14
 *  Copyright © 2020年 BroadVideo. All rights reserved.
 *
 *  Describe:
 */
public open abstract class BaseZoneControl (var mContext:Context,var mZoneData:Zones,var mZoneView:ZonesView?) {

    init {

    }

    /**
     * 开始播放
     */
    abstract fun startPlay()
    /**
     *停止播放
     */
    abstract fun stopPlay()
    /**
     *释放
     */
    abstract fun release()
}