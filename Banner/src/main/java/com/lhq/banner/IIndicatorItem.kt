package com.lhq.banner

import android.graphics.Canvas

/**
 * @Date 2019/7/5 11:41
 * @auth lihuiqiang
 * @discription
 *
 */
interface IIndicatorItem {
    fun drawItem(canvas: Canvas?,cellBeans: ArrayList<CellBean>)
}