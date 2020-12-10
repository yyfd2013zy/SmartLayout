package com.broadvideo.smartlayout

import android.os.Looper
import android.text.TextUtils
import android.view.View
import android.widget.FrameLayout
import androidx.lifecycle.LifecycleOwner
import com.broadvideo.smartlayout.callback.LogCallBack
import com.broadvideo.smartlayout.data.bundle.BundleJsonModule
import com.broadvideo.smartlayout.data.bundle.BundleResponse
import com.broadvideo.smartlayout.dispatcher.BaseDispatcher
import com.broadvideo.smartlayout.lifeobserver.SmartLayoutLifeObserver
import com.broadvideo.smartlayout.listener.DispatcherListener
import com.broadvideo.smartlayout.utils.bundleDataIsOk
import com.broadvideo.smartlayout.utils.mlogCallBack
import com.broadvideo.smartlayout.zone.manager.ZonesViewManager

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
    var contentView: FrameLayout? = null
    var bundleResponse: BundleResponse? = null//节目清单数据
    var bundleJsonModule: BundleJsonModule? = null//UI描述数据
    var zonesViewManager: ZonesViewManager? = null

    init {
        mlogCallBack = builder.logCallBack//全局LogCallBack
        mDispatcher = builder.dispatcher
        contentView = builder.mFrameView
        LOG_TAG = if (TextUtils.isEmpty(builder.logTag)) "SmartLayoutCore" else builder.logTag
        builder.bundleData.let {
            bundleResponse = builder.bundleData
        }
        mDispatcher?.setDispatcherListener(this)
        zonesViewManager = ZonesViewManager(contentView)
        log("SmartLayoutCore init")
    }

    /**
     * 开始工作
     */
    fun startWork() {
        log("startWork")
        if (bundleDataIsOk(bundleResponse)) {
            if (checkCurrentThread()) {
                mDispatcher?.resultSchedulesDatas(false)
            } else {
                throw Exception("can not work at child thread!")
            }
        } else {
            throw Exception("check bundle data error!")
        }

    }

    private fun checkCurrentThread(): Boolean {
        return Looper.myLooper() == Looper.getMainLooper()
    }

    /**
     * 设置节目清单数据
     */
    fun setBundleResponseData(bundleData: BundleResponse) {
        bundleResponse = bundleData
    }


    override fun creatBundle(bundleJsonModule: BundleJsonModule?) {
        this.bundleJsonModule = bundleJsonModule
        zonesViewManager?.initDecordView(bundleJsonModule)

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


    class Builder {
        internal var dispatcher: BaseDispatcher? = null
        internal var logCallBack: LogCallBack? = null
        internal var mFrameView: FrameLayout? = null
        internal var logTag: String? = null
        internal var bundleData: BundleResponse? = null
        fun mFrameView(mFrameViewBuild: FrameLayout): Builder {
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
}