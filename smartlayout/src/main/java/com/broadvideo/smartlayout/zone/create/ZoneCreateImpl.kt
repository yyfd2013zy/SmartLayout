package com.broadvideo.smartlayout.zone.create

import com.broadvideo.smartlayout.data.bundle.BundleJsonModule
import com.broadvideo.smartlayout.data.zone.Zones
import com.broadvideo.smartlayout.zone.view.factory.ZonesViewFactory
import java.util.*

/**
 * Created by Android Studio.
 * User: Vinda
 * Date: 2020/12/9
 * Time: 18:00
 * Describe:View 拼装实现类
 */
class ZoneCreateImpl(zoneCreateListener: ZoneCreateListenerBuilder.() -> Unit) :
    ZoneCreate(zoneCreateListener) {

    override fun createZone(bundleJsonModule: BundleJsonModule) {
        var zones: ArrayList<Zones> = bundleJsonModule.zones //新的要绘制的zone区域集合
        for (zone in zones) {
            zone.zoneView = ZonesViewFactory.createZonesView(zone.type)//区域内的view构建完毕，将该区域内的所有View赋值
            zoneCreateListener.mSingleZoneCreateOverAction?.invoke(zone)

        }
    }

    override fun updateZone() {

    }
}