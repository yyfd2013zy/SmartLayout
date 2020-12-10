package com.broadvideo.smartlayout.zone.manager

import android.content.Context
import android.graphics.Color
import android.view.ContextMenu
import android.view.View
import android.widget.AbsoluteLayout
import android.widget.FrameLayout
import com.broadvideo.smartlayout.data.bundle.BundleJsonModule
import com.broadvideo.smartlayout.screenHeight
import com.broadvideo.smartlayout.screenWidth

/**
 * Created by Android Studio.
 * User: Vinda
 * Date: 2020/12/9
 * Time: 18:03
 * Describe:Zone内的View的管理类，主要负责View的操作
 */
class ZonesViewManager(var baseView: FrameLayout?, var context: Context) {

  private var decordView: AbsoluteLayout? = null

  fun initDecordView(bundleJsonModule: BundleJsonModule?) {
    val scaledWidth = ((bundleJsonModule!!.width * 1.0 / bundleJsonModule!!.width).toFloat() * screenWidth) as Int
    val scaledHeight = ((bundleJsonModule!!.height * 1.0 / bundleJsonModule!!.height).toFloat() * screenHeight) as Int
    val scaledLeft = ((0 * 1.0 / bundleJsonModule!!.width).toFloat() * screenWidth) as Int
    val scaledTop = ((0 * 1.0 / bundleJsonModule!!.height).toFloat() * screenHeight) as Int
    decordView = AbsoluteLayout(context)
    decordView?.setBackgroundColor(Color.parseColor(bundleJsonModule!!.bg_color))
    val params = AbsoluteLayout.LayoutParams(
      scaledWidth, scaledHeight, scaledLeft, scaledTop
    )
    baseView?.addView(decordView)
  }

}