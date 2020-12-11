package com.broadvideo.smartlayout

import com.broadvideo.smartlayout.data.SchedulesResponse
import com.broadvideo.smartlayout.zone.view.ZonesView

/**
 *  DigitalBox2019
 *
 *  Created by Vinda on 2020/11/13
 *  Copyright © 2020年 BroadVideo. All rights reserved.
 *
 *  Describe:top level
 */
class Constant {
    companion object {
        var screenWidth = 0//屏幕宽
        var screenHeight = 0//屏幕高
        var screenIs4K = false//是否是4K屏幕

        var schedulesWithTime: ArrayList<SchedulesResponse>? = ArrayList() //按时间段播放的节目计划数据
        var nowPlayerBundleIds: ArrayList<Int>? = ArrayList<Int>() //当前播放的节目ID集合
        var nowPlayerBundleJsons: ArrayList<String>? = ArrayList<String>() //当前播放的节目描述文件集合
        var nowPlayBundleIndex = 0 //当前时间段，所播放节目的索引


        //ZoneType
        var ZONE_TYPE_ADVERT: Int = 0 //广告区域
        var ZONE_TYPE_PLAY = 1 //播放区域
        var ZONE_WEB = 2 //网页,采用原生webview
        var ZONE_TEXT = 3 //文本
        var ZONE_SCROOLLING_TEXT = 4 //文字滚动区域
        var ZONE_TIME = 5 //时间
        var ZONE_WEATHER = 6 //天气
        var ZONE_KEY_BUTTON = 7 //按键区域
        var ZONE_NAVIGATION = 10 //按摩椅导航条
        var ZONE_RSS = 12 //RSS区域
        var ZONE_AUDOI = 13 //音频播放区域
        var ZONE_VIDEO_STREAM = 14 //视频流
        var ZONE_TYPE_CHAIR_QRCODE = 101 //按摩椅二维码，支付
        var ZONE_TYPE_CHAIR_CONTROL = 102 //按摩椅二维码控制类
        //播放类型(view类型,也可以看做媒体资源类型)
        var ZONEDTLS_TYPE_IMAGE = "image"
        var ZONEDTLS_TYPE_VIDEO = "video"
        var ZONEDTLS_TYPE_AUDIO = "audio"
        var ZONEDTLS_TYPE_STREAM = "stream" //视频流


        //ViewType
        val VIEW_TYPE_TEXTVIEW = 0 //普通文字
        val VIEW_TYPE_IMAGEVIEW = 1 //图片
        val VIEW_TYPE_TEXTUREVIEW = 2 //播放视频的surfaceview
        val VIEW_TYPE_QRVIEW = 3 //二维码界面
        val VIEW_TYPE_CHAIRCONTROLVIEW = 4 //按摩椅控制View
        val VIEW_TYPE_NAVIGATIONVIEW = 5 //导航条View
        val VIEW_TYPE_SCROOLING_TEXTVIEW = 6 //走马灯滚动
        val VIEW_TYPE_WEBVIEW = 7 //webview
        val VIEW_TYPE_WEATHER = 8 //天气
        val VIEW_TYPE_TIME = 9 //时间
        val VIEW_TYPE_ADVERT = 10 //自定义广告VIEW
        val VIEW_TYPE_KEYBUTTON = 11 //互动按键
        val VIEW_TYPE_RSS = 12 //Rss
        val VIEW_TYPE_VIDEO_STREAM = 13 //视频流
        val VIEW_TYPE_AUDIO = 14 //音频播放区域
    }

}







