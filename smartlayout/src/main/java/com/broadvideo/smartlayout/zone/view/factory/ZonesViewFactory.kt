package com.broadvideo.smartlayout.zone.view.factory

import android.content.Context
import android.provider.ContactsContract
import com.broadvideo.smartlayout.Constant
import com.broadvideo.smartlayout.data.bundle.BundleJsonModule
import com.broadvideo.smartlayout.data.zone.Zones
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
class ZonesViewFactory {

    companion object AAA{
        fun createZonesView(context: Context, zone: Zones, bundleJsonModule: BundleJsonModule): ZonesView {
            return when (zone.type) {
                Constant.ZONE_TEXT -> ZoneNormalTextView(context,zone,bundleJsonModule)
                else -> throw IllegalStateException("createZonesView failed")
            }
        }
    }
}