package com.broadvideo.smartlayout.listener

import com.broadvideo.smartlayout.data.BundleJsonModule

/**
 *  DigitalBox2019
 *
 *  Created by Vinda on 2020/11/13
 *  Copyright © 2020年 BroadVideo. All rights reserved.
 *
 *  Describe:调度器分发发
 */
interface DispatcherListener {
    fun creatBundle(bundleJsonModule: BundleJsonModule?) //创建

    fun upDateBundle(bundleJsonModule: BundleJsonModule?) //更新

}