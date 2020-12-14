package com.broadvideo.smartlayout.zone.view.factory

import android.content.Context
import android.provider.ContactsContract
import com.broadvideo.smartlayout.Constant
import com.broadvideo.smartlayout.data.bundle.BundleJsonModule
import com.broadvideo.smartlayout.data.zone.Zones
import com.broadvideo.smartlayout.zone.control.BaseZoneControl
import com.broadvideo.smartlayout.zone.control.ZoneNormalTextViewController
import com.broadvideo.smartlayout.zone.view.ZonesView
import com.broadvideo.smartlayout.zone.view.text.ZoneNormalTextView
import java.lang.IllegalStateException

/**
 *  SmartLayoutDemo
 *
 *  Created by Vinda on 2020/12/10
 *  Copyright © 2020年 BroadVideo. All rights reserved.
 *
 *  Describe:
 */
class ZonesFactory {

    companion object {
        /**
         * 构建Zone内的View
         */
        fun createZonesView(context: Context, zone: Zones, bundleJsonModule: BundleJsonModule): ZonesView {
            return when (zone.type) {
                Constant.ZONE_TEXT -> ZoneNormalTextView(context,zone,bundleJsonModule)
                else -> throw IllegalStateException("createZonesView failed")
            }
        }

        /**
         * 构建Zone播放控制类
         */
        fun createZonesPlayController(context: Context, zone: Zones,view:ZonesView): BaseZoneControl {
           return when (zone.type) {
                Constant.ZONE_TEXT -> ZoneNormalTextViewController(context,zone,view)
                else -> throw IllegalStateException("createZonesView failed")
            }
        }
    }
}