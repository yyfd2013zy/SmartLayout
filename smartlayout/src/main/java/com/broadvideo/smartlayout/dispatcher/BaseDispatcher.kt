package com.broadvideo.smartlayout.dispatcher

import com.broadvideo.smartlayout.data.BundleJsonModule
import com.broadvideo.smartlayout.data.SchedulesResponse
import com.broadvideo.smartlayout.listener.DispatcherListener

/**
 *  DigitalBox2019
 *
 *  Created by Vinda on 2020/11/13
 *  Copyright © 2020年 BroadVideo. All rights reserved.
 *
 *  Describe:节目调度器基类
 */
abstract class BaseDispatcher() {
    //当前时间端应该播放的节目id集合
    var currentSchedules: SchedulesResponse? = null
    var mDispatcherListener: DispatcherListener? = null

    init {

    }

    fun setDispatcherListener(dispatcherListener: DispatcherListener){
        mDispatcherListener = dispatcherListener
    }

    fun startWork(){
        resultSchedulesDatas(false)
    }
    /**
     * 处理节目数据
     * @param isNotifyData 是否是实时更新的数据
     */
    abstract fun resultSchedulesDatas(isNotifyData:Boolean)

    /**
     * 检查当前时间端应该播放的节目
     */
    abstract fun checkNowTimePlaySchedule(): BundleJsonModule?

    /**
     * 创建节目
     */
    abstract fun createBundle()

    /**
     * 更新节目
     */
    abstract fun updateBundle()

    abstract fun  release()

}