package com.broadvideo.smartlayout.zone.create

/**
 * Created by Android Studio.
 * User: Vinda
 * Date: 2020/12/9
 * Time: 17:54
 * Describe:
 */
abstract class ZoneCreate {
    abstract fun createZone()

    abstract fun updateZone()

    abstract fun removeZone()

    /**
     * 清空当前所有的Zone
     */
    fun clearAllZone(){

    }
}