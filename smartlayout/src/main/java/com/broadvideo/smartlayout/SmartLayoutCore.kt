package com.broadvideo.smartlayout

import android.view.View
import androidx.lifecycle.LifecycleOwner
import com.broadvideo.smartlayout.callback.LogCallBack
import com.broadvideo.smartlayout.data.bundle.BundleJsonModule
import com.broadvideo.smartlayout.data.bundle.BundleResponse
import com.broadvideo.smartlayout.dispatcher.BaseDispatcher
import com.broadvideo.smartlayout.lifeobserver.SmartLayoutLifeObserver
import com.broadvideo.smartlayout.listener.DispatcherListener
import com.broadvideo.smartlayout.utils.bundleDataIsOk
import com.broadvideo.smartlayout.utils.mlogCallBack

/**
 *  DigitalBox2019
 *
 *  Created by Vinda on 2020/11/13
 *  Copyright © 2020年 BroadVideo. All rights reserved.
 *
 *  Describe:SmartLayout 外部调用类
 */
class SmartLayoutCore(builder: Builder) : SmartLayoutLifeObserver, DispatcherListener {
    var LOG_TAG: String? = null
    var mDispatcher: BaseDispatcher? = null
    var contentView: View? = null
    var bundleResponse: BundleResponse? = null//节目清单数据

    init {
        mlogCallBack = builder.logCallBack//全局LogCallBack
        mDispatcher = builder.dispatcher
        contentView = builder.mFrameView
        builder.logTag.let {
            LOG_TAG = builder.logTag
        }?.let {
            LOG_TAG = "SmartLayoutCore"
        }
        builder.bundleData.let {
            bundleResponse = builder.bundleData
        }
        mDispatcher?.setDispatcherListener(this)
        log("SmartLayoutCore init")
    }

    /**
     * 开始工作
     */
    fun startWork() {
        log("startWork")
        if (bundleDataIsOk(bundleResponse)){
            mDispatcher?.resultSchedulesDatas(false)
        }else{
           log("bundleData error , please check data!!!")
        }

    }

    /**
     * 设置节目清单数据
     */
    fun setBundleResponseData(bundleData: BundleResponse){
        bundleResponse = bundleData
    }


    class Builder {
        internal var dispatcher: BaseDispatcher? = null
        internal var logCallBack: LogCallBack? = null
        internal var mFrameView: View? = null
        internal var logTag: String? = null
        internal var  bundleData: BundleResponse? = null
        fun mFrameView(mFrameViewBuild: View): Builder {
            mFrameView = mFrameViewBuild
            return this
        }

        fun dispatcher(dispatcherBuild: BaseDispatcher): Builder {
            dispatcher = dispatcherBuild
            return this
        }

        fun logCallBack(logCallBackBuild: LogCallBack): Builder {
            logCallBack = logCallBackBuild
            return this
        }

        fun logTag(tag: String): Builder {
            logTag = tag
            return this
        }

        fun bundleData(bundle: BundleResponse): Builder {
            bundleData = bundle
            return this
        }

        fun build(): SmartLayoutCore {
            return SmartLayoutCore(this)
        }


    }

    override fun creatBundle(bundleJsonModule: BundleJsonModule?) {
        TODO("Not yet implemented")
    }

    override fun upDateBundle(bundleJsonModule: BundleJsonModule?) {
        TODO("Not yet implemented")
    }

    override fun onCreate(owner: LifecycleOwner) {
        log("onCreate")
    }

    override fun onResume(owner: LifecycleOwner) {
        log("onResume")
        startWork()
    }

    override fun onPause(owner: LifecycleOwner) {
        log("onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        log("onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        log("onDestroy")
    }

    private fun log(msg: String) {
        mlogCallBack?.logD(LOG_TAG!!, msg)
    }
}