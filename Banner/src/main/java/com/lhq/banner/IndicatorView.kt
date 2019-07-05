package com.lhq.banner

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

/**
 * @Date 2019/7/5 11:18
 * @auth lihuiqiang
 * @discription
 * 指示器
 */
class IndicatorView @JvmOverloads constructor(context: Context,attrs: AttributeSet? = null, defStyleAttr: Int = 0): View(context,attrs,defStyleAttr) {


    lateinit var iIndicatorItem:IIndicatorItem

    lateinit var cellBeans: ArrayList<CellBean>

    val defaultHeight = 50

    init {

    }

    override fun onDraw(canvas: Canvas?) {
        drawItem(canvas)
    }

    private fun drawItem(canvas: Canvas?){
        iIndicatorItem?.let {
                it.drawItem(canvas, CellBeanFactory.create(5))
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var wMode = MeasureSpec.getMode(widthMeasureSpec)
        var hMode = MeasureSpec.getMode(heightMeasureSpec)
        var wSize = MeasureSpec.getSize(widthMeasureSpec)
        var hSize = MeasureSpec.getSize(heightMeasureSpec)
        var h: Int = heightMeasureSpec
        var w: Int = widthMeasureSpec
        when(wMode){
            MeasureSpec.AT_MOST ->{
                w = wSize
            }
            MeasureSpec.EXACTLY ->{
                w = wSize
            }
        }

        when(hMode){
            MeasureSpec.AT_MOST ->{
                h = defaultHeight
            }
            MeasureSpec.EXACTLY ->{
                h = hSize
            }
        }
        setMeasuredDimension(w,h)
    }

}