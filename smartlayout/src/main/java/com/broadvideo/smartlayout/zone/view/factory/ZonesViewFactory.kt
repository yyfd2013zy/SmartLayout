package com.broadvideo.smartlayout.zone.view.factory

import com.broadvideo.smartlayout.ZONE_TEXT
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
        fun createZonesView(type: Int): ZonesView {
            return when (type) {
                ZONE_TEXT -> ZoneNormalTextView()
                else -> throw IllegalStateException("createZonesView failed")
            }
        }
    }
}