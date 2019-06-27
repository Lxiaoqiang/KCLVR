package com.zcsmart.kclvr.view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @Date 2019/6/27 17:46
 * @auth lihuiqiang
 * @discription
 *
 */
class SpaceItemDecoration(val space: Int): RecyclerView.ItemDecoration() {


    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        super.getItemOffsets(outRect, itemPosition, parent)
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = space
    }
}