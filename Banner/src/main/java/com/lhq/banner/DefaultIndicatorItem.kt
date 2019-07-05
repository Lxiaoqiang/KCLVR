package com.lhq.banner

import android.graphics.Canvas
import android.graphics.Paint
import java.lang.IllegalArgumentException

/**
 * @Date 2019/7/5 11:29
 * @auth lihuiqiang
 * @discription
 *
 */
class DefaultIndicatorItem(count: Int,radius: Float = 10.toFloat(),colors: Array<Int>): IIndicatorItem{

    private var mCount = count

    private var mColors = colors

    private var mRadius = radius

    private val space = 30

    private val mPaint = Paint()

    init {
        if (colors == null || colors.isEmpty())
            throw IllegalArgumentException("the colors not allow null")
        mPaint.color = mColors[0]
        mPaint.isDither = true
        mPaint.isAntiAlias = true
    }

    override fun drawItem(canvas: Canvas?,cellBeans: ArrayList<CellBean>) {
        canvas?.let {
            for (cell in cellBeans){

            }
            for (i in 0 until cellBeans.size){
                it.drawCircle(mRadius + mRadius * i + space * 2 * i,mRadius,mRadius,mPaint)
            }
        }
    }

}