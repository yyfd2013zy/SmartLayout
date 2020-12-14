package com.broadvideo.smartlayout

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Looper
import android.text.TextUtils
import android.widget.FrameLayout
import androidx.lifecycle.LifecycleOwner
import com.broadvideo.smartlayout.callback.LogCallBack
import com.broadvideo.smartlayout.callback.ScreenOrientationChangeCallBack
import com.broadvideo.smartlayout.data.bundle.BundleJsonModule
import com.broadvideo.smartlayout.data.bundle.BundleResponse
import com.broadvideo.smartlayout.dispatcher.BaseDispatcher
import com.broadvideo.smartlayout.lifeobserver.SmartLayoutLifeObserver
import com.broadvideo.smartlayout.listener.DispatcherListener
import com.broadvideo.smartlayout.utils.bundleDataIsOk
import com.broadvideo.smartlayout.utils.mlogCallBack
import com.broadvideo.smartlayout.zone.create.ZoneCreate
import com.broadvideo.smartlayout.zone.create.ZoneCreateImpl
import com.broadvideo.smartlayout.zone.manager.ZonesManager
import com.broadvideo.smartlayout.zone.manager.LayoutViewManager

/**
 *  DigitalBox2019
 *
 *  Created by Vinda on 2020/11/13
 *  Copyright © 2020年 BroadVideo. All rights reserved.
 *
 *  Describe:SmartLayout 外部调用类
 */
class SmartLayoutCore(context:Context,builder: Builder) : SmartLayoutLifeObserver, DispatcherListener,
        (ZoneCreate.ZoneCreateListenerBuilder) -> Unit {
    var LOG_TAG: String = "SmartLayoutCore"
    var mContext = context
    var mDispatcher: BaseDispatcher? = null
    var screenOrientationChangeCallBack:ScreenOrientationChangeCallBack?=null
    var contentView: FrameLayout? = null
    var bundleResponse: BundleResponse? = null//节目清单数据
    var bundleJsonModule: BundleJsonModule? = null//UI描述数据

    /**
     * ZonesViewManager 管理父View的初始化以及各个Zone区域的封装
     */
    var layoutViewManager: LayoutViewManager? = null

    /**
     * ZoneCreate负责Zone的创建
     */
    var zoneCreate:ZoneCreate?=null

    /**
     * 所有zone的管理类，管理缓存
     */
    var zonesManager:ZonesManager?=null

    init {
        LOG_TAG = if (TextUtils.isEmpty(builder.logTag)) "SmartLayoutCore" else builder.logTag
        mlogCallBack = builder.logCallBack//全局LogCallBack
        mDispatcher = builder.dispatcher
        contentView = builder.mFrameView
        screenOrientationChangeCallBack = builder.screenOrientationChangeCallBack
        builder.bundleData.let {
            bundleResponse = builder.bundleData
        }
        mDispatcher?.setDispatcherListener(this)
        layoutViewManager = LayoutViewManager(contentView,mContext)
        zoneCreate = ZoneCreateImpl(this)
        zonesManager = ZonesManager()
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
                mlogCallBack?.logE(LOG_TAG,"can not work at child thread!")
            }
        } else {
            mlogCallBack?.logE(LOG_TAG,"bundleData Error")
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


    /**
     * 1.拿到当前界面描述数据后，先对最外层框架布局进行绘制
     * 2.根据节目方向，调整Activity的方向
     * 3.开始创建Zone
     */
    override fun creatBundle(bundleJsonModule: BundleJsonModule?) {
        this.bundleJsonModule = bundleJsonModule
        //判断当前节目是横屏节目还是竖屏节目（在这个地方设置Activity的朝向）
        if (bundleJsonModule!!.width > bundleJsonModule!!.height) { //宽大于高，横屏节目
            screenOrientationChangeCallBack?.screenOrientationChanged(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
        } else { //竖屏节目
            screenOrientationChangeCallBack?.screenOrientationChanged(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        }
        layoutViewManager?.initDecordView(bundleJsonModule)
        //创建Zone
        zoneCreate?.createZone(mContext,bundleJsonModule)
    }

    override fun upDateBundle(bundleJsonModule: BundleJsonModule?) {

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
        internal var logTag: String = ""
        internal var bundleData: BundleResponse? = null
        internal var screenOrientationChangeCallBack:ScreenOrientationChangeCallBack?=null
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

        fun screenOrientationChangeCallBack(screenOrientationChangeCallBackBuild: ScreenOrientationChangeCallBack): Builder {
            screenOrientationChangeCallBack = screenOrientationChangeCallBackBuild
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

        fun build(c:Context): SmartLayoutCore {
            return SmartLayoutCore(c,this)
        }


    }

    /**
     * Zone创建函数
     */
    override fun invoke(p1: ZoneCreate.ZoneCreateListenerBuilder) {
        p1.SingleZoneCreateOver {zones ->
            zonesManager?.addZones(zones)
        }
        p1.AllZoneCreateOver {
            //1.对zone进行排序
            zonesManager?.zonesSort()
            //2.将View添加到底层布局显示出来
            layoutViewManager?.assembleView(zonesManager?.zonesList)
            //3.通知各个播放控制类，开始播放
            zonesManager?.startPlay()
        }
    }
}