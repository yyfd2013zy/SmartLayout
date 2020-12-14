package com.broadvideo.smartlayout.zone.manager

import com.broadvideo.smartlayout.data.zone.Zones
import com.broadvideo.smartlayout.zone.view.ZonesView
import java.util.*

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
    //当前界面上需要显示的ZoneView集合
    var zonesViewList = arrayListOf<ZonesView>()

    fun addZones(zone: Zones) {
        zonesList.add(zone)
    }


    //清空
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

    /**
     *因为节目UI是有层级关系的 ,根据zIndex（Z轴坐标）进行排序
     */
    fun zonesSort() {
        Collections.sort(zonesList, comparator) //从小到大排序，小的在前面，先添加
    }

    /**
     * 开始播放
     */
    fun startPlay() {
        for (z in zonesList) {
            z.zonePlayControl.startPlay()
        }
    }

    /**
     * 停止播放
     */
    fun stopPlay(){
        for (z in zonesList) {
            z.zonePlayControl.stopPlay()
        }
    }

    /**
     * 释放资源
     */
    fun release(){
        for (z in zonesList) {
            z.zonePlayControl.release()
        }
    }

    /**
     * 从小到大排序
     */
    var comparator: Comparator<Zones?> = object : Comparator<Zones?> {
        override fun compare(p0: Zones?, p1: Zones?): Int {
            println("Zones 排序")
            return if (p0!!.zindex >= p1!!.zindex) { //o1属性小于等于o2属性时，返回1
                1
            } else {
                -1
            }
        }
    }


}