package com.broadvideo.smartlayoutdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import com.broadvideo.smartlayout.SmartLayoutCore
import com.broadvideo.smartlayout.callback.LogCallBack
import com.broadvideo.smartlayout.dispatcher.CommonScheduleDispatcher
import kotlin.math.log

class MainActivity : AppCompatActivity(), LogCallBack {
    lateinit var flMain: FrameLayout
    lateinit  var smartLayoutCore: SmartLayoutCore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        flMain = findViewById(R.id.fl_main)
        initLayoutCore()

    }

    private fun initLayoutCore() {
        smartLayoutCore = SmartLayoutCore.Builder()
            .mFrameView(flMain)
            .dispatcher(CommonScheduleDispatcher(this))
            .logCallBack(this)
            .build()
        getLifecycle().addObserver(smartLayoutCore)//注册生命周期监听器

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    override fun logD(TAG: String, info: String) {
        Log.d(TAG, info)
    }

    override fun logE(TAG: String, info: String) {

    }
}