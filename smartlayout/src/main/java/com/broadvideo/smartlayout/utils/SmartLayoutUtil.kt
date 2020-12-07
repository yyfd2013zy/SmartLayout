package com.broadvideo.smartlayout.utils

import android.content.Context
import com.broadvideo.smartlayout.callback.LogCallBack
import com.broadvideo.smartlayout.data.bundle.BundleResponse
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
import java.text.SimpleDateFormat
import java.util.*

/**
 *  DigitalBox2019
 *
 *  Created by Vinda on 2020/11/13
 *  Copyright © 2020年 BroadVideo. All rights reserved.
 *
 *  Describe:SmartLayout 工具类 top level
 */

//String时间转换为时间戳
fun getLongTimeFromString(time: String): Long {
    val sourceStrArray = time.split(":".toRegex()).toTypedArray()
    return (sourceStrArray[0].toInt() * (60 * 60 * 1000)
            + sourceStrArray[1].toInt() * (60 * 1000)
            + sourceStrArray[2].toInt() * 60).toLong()
}
//根据指定格式获取时间戳
fun getNowTime(): Long {
    val format1 = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    val currentDate = Date()
    val displayTime1 = format1.format(currentDate)
    val sourceStrArray = displayTime1.split(":".toRegex()).toTypedArray()
    return (sourceStrArray[0].toInt() * (60 * 60 * 1000)
            + sourceStrArray[1].toInt() * (60 * 1000)
            + sourceStrArray[2].toInt() * 60).toLong()
}

fun readLocalJson(context: Context?, fileName: String?): String? {
    var jsonString = ""
    try {
        val fis = FileInputStream(fileName)
        val br = BufferedReader(InputStreamReader(fis))
        val sb = StringBuilder()
        var line: String? = null
        while (br.readLine().also { line = it } != null) {
            sb.append(line)
        }
        jsonString = sb.toString()
        br.close()
    } catch (e: Exception) {
        val error = e.message
    }
    return jsonString
}


/**
 * 校验节目数据是否正常
 * @param bundleResponse
 * @return
 */
public fun bundleDataIsOk(bundleResponse: BundleResponse?): Boolean {
    if (bundleResponse == null|| bundleResponse.getBundles() == null||bundleResponse.getBundles().size === 0) {
        return false
    }
    return true
}

var mlogCallBack:LogCallBack?=null

