package com.broadvideo.smartlayout.zone.manager

import com.broadvideo.smartlayout.data.zone.Zones

/**
 *  SmartLayoutDemo
 *
 *  Created by Vinda on 2020/12/10
 *  Copyright © 2020年 BroadVideo. All rights reserved.
 *
 *  Describe:所有Zones的管理类
 */
class ZonesManager() {
    //维护当前创建的Zones
    var zonesList = arrayListOf<Zones>()

    fun addZones(zone: Zones) {
        zonesList.add(zone)
    }

    fun clearZones() {
        zonesList.clear()
    }

    fun removeZones(zonId: Int) {
        for (z in zonesList) {
            if (zonId == z.zone_id) {
                zonesList.remove(z)
                break
            }
        }
    }

}