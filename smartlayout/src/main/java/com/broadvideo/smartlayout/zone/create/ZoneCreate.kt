package com.broadvideo.smartlayout.zone.create

import com.broadvideo.smartlayout.data.bundle.BundleJsonModule
import com.broadvideo.smartlayout.data.zone.Zones

/**
 * Created by Android Studio.
 * User: Vinda
 * Date: 2020/12/9
 * Time: 17:54
 * Describe:
 */
abstract class ZoneCreate(zoneCreateListener: ZoneCreateListenerBuilder.() -> Unit) {


    abstract fun createZone(bundleJsonModule: BundleJsonModule)

    abstract fun updateZone()



    //lamda 回调的拓展函数
    public lateinit var zoneCreateListener: ZoneCreateListenerBuilder

    inner class ZoneCreateListenerBuilder {
        internal var mSingleZoneCreateOverAction: ((Zones) -> Unit)? = null
        internal var mAllZoneZoneCreateOverAction: (() -> Unit)? = null

        fun SingleZoneCreateOver(action: (Zones) -> Unit) {
            mSingleZoneCreateOverAction = action
        }

        fun AllZoneCreateOver(action: () -> Unit) {
            mAllZoneZoneCreateOverAction = action
        }
    }
}