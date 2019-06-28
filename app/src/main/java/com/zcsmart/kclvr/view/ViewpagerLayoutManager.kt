package com.zcsmart.kclvr.view

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

/**
 * @Date 2019/6/28 16:53
 * @auth lihuiqiang
 * @discription
 *
 */
class ViewpagerLayoutManager(context: Context, @RecyclerView.Orientation orientation: Int) : LinearLayoutManager(context,orientation,false){

    private val pagerSnapHelper = PagerSnapHelper()


    override fun onAttachedToWindow(view: RecyclerView?) {
        super.onAttachedToWindow(view)
        //IllegalStateException: An instance of OnFlingListener already set.
        view?.onFlingListener = null
        pagerSnapHelper.attachToRecyclerView(view)
    }
}