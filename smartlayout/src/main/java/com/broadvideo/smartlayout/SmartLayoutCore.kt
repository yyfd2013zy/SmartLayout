package com.broadvideo.smartlayout

import android.view.View
import com.broadvideo.smartlayout.callback.LogCallBack
import com.broadvideo.smartlayout.data.BundleJsonModule
import com.broadvideo.smartlayout.dispatcher.BaseDispatcher
import com.broadvideo.smartlayout.listener.DispatcherListener
import com.broadvideo.smartlayout.utils.mlogCallBack

/**
 *  DigitalBox2019
 *
 *  Created by Vinda on 2020/11/13
 *  Copyright © 2020年 BroadVideo. All rights reserved.
 *
 *  Describe:SmartLayout 外部调用类
 */
class SmartLayoutCore (builder:Builder) : DispatcherListener {
    var mDispatcher:BaseDispatcher?=null
    var frameView:View?=null

    init {
        mlogCallBack = builder.logCallBack
        mDispatcher = builder.dispatcher
        mDispatcher?.setDispatcherListener(this)
    }





    class Builder {
        internal var dispatcher: BaseDispatcher? = null
        internal var  logCallBack: LogCallBack?= null
        internal var  mFrameView: View?= null

        fun mFrameView( mFrameViewBuild: View): Builder {
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

}