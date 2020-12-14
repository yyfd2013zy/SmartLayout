package com.broadvideo.smartlayout.dispatcher

import android.content.Context
import com.alibaba.fastjson.JSON
import com.broadvideo.smartlayout.Constant.Companion.nowPlayBundleIndex
import com.broadvideo.smartlayout.Constant.Companion.nowPlayerBundleIds
import com.broadvideo.smartlayout.Constant.Companion.nowPlayerBundleJsons
import com.broadvideo.smartlayout.Constant.Companion.schedulesWithTime
import com.broadvideo.smartlayout.data.bundle.BundleJsonModule
import com.broadvideo.smartlayout.utils.mlogCallBack
import com.broadvideo.smartlayout.utils.readLocalJson


/**
 *  DigitalBox2019
 *
 *  Created by Vinda on 2020/11/13
 *  Copyright © 2020年 BroadVideo. All rights reserved.
 *
 *  Describe:BroadVideo项目中使用到的节目调度器,默认节目调度器
 */
class CommonScheduleDispatcher constructor(context: Context) : BaseDispatcher() {
    val TAG = "CommonScheduleDispatcher"
    var mContext: Context? = null
    var mFilePath = ""
    val Home_FLAG = "1"

    init {
        mlogCallBack?.logD(TAG, "CommonScheduleDispatcher init!")
        mContext = context
    }

    fun setSaveJsonDataFilePath(filePath: String) {
        mFilePath = filePath
    }

    override fun resultSchedulesDatas(isNotifyData: Boolean) {
        schedulesWithTime?.let {
            when (schedulesWithTime?.size) {
                1 -> {
                    mlogCallBack?.logD(
                        TAG,
                        "there is only one bundle schedule  in the  current period "
                    )
                    currentSchedules = schedulesWithTime?.get(0)
                    //对当前节目计划内的节目组进行赋值
                    nowPlayerBundleIds = currentSchedules?.getBundle_ids()
                    mlogCallBack?.logD(
                        TAG, " InstanceMemory.nowPlayerBundleIds.size = " + nowPlayerBundleIds?.size
                    )
                    resultSchedulesBundleJsonData() //处理schedule内的bundle的json描述数据
                    mlogCallBack?.logD(
                        TAG,
                        "通知创建节目计划，当前节目时段 start=" + currentSchedules?.getStart_time() + " end =" + currentSchedules?.getEnt_time()
                                + " 节目ID集合：" + currentSchedules?.getBundle_ids().toString()
                    )
                    if (isNotifyData) {
                        mDispatcherListener?.upDateBundle(checkNowTimePlaySchedule()) //通知创建或更新节目
                    } else {
                        mDispatcherListener?.creatBundle(checkNowTimePlaySchedule()) //通知创建或更新节目
                    }
                }
                else -> {

                }
            }
        } ?: let {
            mlogCallBack?.logE(TAG, "InstanceMemory.schedulesWithTime == null! return")
        }

    }

    override fun checkNowTimePlaySchedule(): BundleJsonModule? {
        var bundleResponse: BundleJsonModule? = null
        val json: String? = nowPlayerBundleJsons?.get(nowPlayBundleIndex)
        for (b in JSON.parseArray(json, BundleJsonModule::class.java)) {
            if (b.home_flag==Home_FLAG) { //主区域
                //互动节目首页
                mlogCallBack?.logD(TAG, "checkNowBundleData, now bundle json data: $json")
                bundleResponse = b
            }else{
                mlogCallBack?.logD(TAG, "checkNowBundleData,error! not find home data!!")
            }
        }
        return bundleResponse
    }


    //将当前的节目json设置到缓存数据当中去
    private fun resultSchedulesBundleJsonData() {
        nowPlayerBundleJsons?.clear() //清空数据
        for (id in nowPlayerBundleIds!!) {
            //设置当前节目的json描述文件
            val json: String = readLocalJson(mContext, mFilePath + "/" + id + ".txt").toString()
            mlogCallBack?.logD(TAG, "bundle json data:$json")
            nowPlayerBundleJsons?.add(json)
        }
    }


    override fun createBundle() {
    }

    override fun updateBundle() {
    }

    override fun release() {
    }

}