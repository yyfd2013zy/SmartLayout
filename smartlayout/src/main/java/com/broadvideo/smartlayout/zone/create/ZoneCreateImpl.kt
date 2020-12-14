package com.broadvideo.smartlayout.zone.create

import android.content.Context
import com.broadvideo.smartlayout.data.bundle.BundleJsonModule
import com.broadvideo.smartlayout.data.zone.Zones
import com.broadvideo.smartlayout.zone.view.factory.ZonesFactory
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

    override fun createZone(mcontext:Context,bundleJsonModule: BundleJsonModule) {
        var zones: ArrayList<Zones> = bundleJsonModule.zones //新的要绘制的zone区域集合
        for (zone in zones) {
            zone.zoneView = ZonesFactory.createZonesView(mcontext,zone,bundleJsonModule)//区域内的view构建完毕，将该区域内的所有View赋值
            zone.zonePlayControl = ZonesFactory.createZonesPlayController(mcontext,zone,zone.zoneView)//构建Zone播放控制类
            zoneCreateListener.mSingleZoneCreateOverAction?.invoke(zone)
        }
        zoneCreateListener.mAllZoneZoneCreateOverAction?.invoke()//所有Zone创建完成
    }

    override fun updateZone() {

    }
}