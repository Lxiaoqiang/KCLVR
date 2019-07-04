package com.zcsmart.kclvr.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import androidx.recyclerview.widget.PagerSnapHelper


/**
 * @Date 2019/7/1 17:55
 * @auth lihuiqiang
 * @discription
 *
 * banner
 */
class LoopHorizontallyBannerLayoutManager : RecyclerView.LayoutManager() {

    private val TAG = "LoopHorizontallyBannerLayoutManager"
    private var looperEnable = true

    private val pagerSnapHelper = PagerSnapHelper()

    override fun onAttachedToWindow(view: RecyclerView?) {
        super.onAttachedToWindow(view)
        //IllegalStateException: An instance of OnFlingListener already set.
        view?.onFlingListener = null
        pagerSnapHelper.attachToRecyclerView(view)
    }

    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun canScrollHorizontally(): Boolean {
        return true
    }

    override fun canScrollVertically(): Boolean {
        return false
    }

    override fun onLayoutChildren(recycler: RecyclerView.Recycler, state: RecyclerView.State) {
        if (itemCount <= 0 || state.isPreLayout) {
            return
        }
        //先将视图分离，放入缓存
        detachAndScrapAttachedViews(recycler)
        var autualWidth = 0
        for (i in 0 until itemCount) {
            var view = recycler.getViewForPosition(i)
            addView(view)
            measureChildWithMargins(view, 0, 0)
            var childViewHeight = getDecoratedMeasuredHeight(view)
            var childViewWidth = getDecoratedMeasuredWidth(view)
            //布局子view
            layoutDecoratedWithMargins(view, childViewWidth * i, 0, childViewWidth * i + childViewWidth, childViewHeight)
            autualWidth += childViewWidth
            //超出屏幕不进行布局
            if (autualWidth  > width){
                break
            }
        }
    }

    override fun scrollHorizontallyBy(dx: Int, recycler: RecyclerView.Recycler, state: RecyclerView.State): Int {
        if (itemCount <= 0 || state.isPreLayout) return 0

        var travel = fill(dx, recycler)
        offsetChildrenHorizontal(-travel)

        recyclerHideView(dx,recycler)
        return travel
    }

    /**
     * 左右滑动的时候，填充
     */
    private fun fill(dx: Int, recycler: RecyclerView.Recycler): Int {
        if (dx > 0) {
            //向左滑动
            var lastView: View = getChildAt(childCount -1) ?: return 0
            var lastPos = getPosition(lastView)
            if (lastView.right <= width) {
                //当最后一个view完全显示，将第一个view添加到最后
                var scrapView = if (lastPos == itemCount - 1) {
                    recycler.getViewForPosition(0)
                }else{
                    recycler.getViewForPosition(lastPos + 1)
                }
                addView(scrapView)
                measureChildWithMargins(scrapView,0,0)
                var vh = getDecoratedMeasuredHeight(scrapView)
                var vw = getDecoratedMeasuredWidth(scrapView)
                layoutDecoratedWithMargins(scrapView,lastView.right,0,lastView.right + vw,vh)
            } else {

            }
        } else {
            //向右滑动
            var firstView: View = getChildAt(0) ?: return 0
            var firstPos = getPosition(firstView)
            if (firstView.left >= 0) {
                var scrapView = if (firstPos == 0) {
                    recycler.getViewForPosition(itemCount - 1)
                } else {
                    recycler.getViewForPosition(firstPos - 1)
                }
                addView(scrapView,0)
                measureChildWithMargins(scrapView, 0, 0)
                var vh = getDecoratedMeasuredHeight(scrapView)
                var vw = getDecoratedMeasuredWidth(scrapView)
                layoutDecoratedWithMargins(scrapView, firstView.left - vw, 0, firstView.left, vh)
            }
        }
        return dx
    }


    private fun recyclerHideView(dx: Int, recycler: RecyclerView.Recycler) {
        for (i in 0 until childCount) {
            var itemView: View = getChildAt(i) ?: continue
            if (dx > 0) {
                if (itemView.right < 0) {
                    removeAndRecycleView(itemView, recycler)
                }
            } else {
                if (itemView.left > width) {
                    removeAndRecycleView(itemView, recycler)
                }
            }
        }
    }

}