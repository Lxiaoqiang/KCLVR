package com.zcsmart.kclvr.ui.recyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.zcsmart.kclvr.R
import com.zcsmart.kclvr.arrayListOfNulls
import com.zcsmart.kclvr.view.ViewpagerLayoutManager
import kotlinx.android.synthetic.main.activity_viewpager.*
import java.util.*
import kotlin.collections.ArrayList

class ViewpagerActivity : AppCompatActivity() {

    private val mAdapter by lazy { PagerAdapter() }

    companion object{

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)

        rvPager.run {
            layoutManager = ViewpagerLayoutManager(context,RecyclerView.VERTICAL)
            adapter = mAdapter
        }
        mAdapter.run {
            var strings = ArrayList<String>().arrayListOfNulls(10)
            addData(strings)
        }
    }

    inner class PagerAdapter(layoutResId: Int = R.layout.item_pager_layout) : BaseQuickAdapter<String,BaseViewHolder>(layoutResId){
        override fun convert(helper: BaseViewHolder?, item: String?) {
            helper?.setBackgroundColor(R.id.llPagerItem,if(helper.position % 2 == 0)  resources.getColor(R.color.colorAccent) else resources.getColor(R.color.colorPrimary))
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(1,1,1,"vertical")
        menu?.add(2,2,2,"horizontal")

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            1 ->{
                rvPager.layoutManager = ViewpagerLayoutManager(ViewpagerActivity@this,RecyclerView.VERTICAL)
            }
            2 ->{
                rvPager.layoutManager = ViewpagerLayoutManager(ViewpagerActivity@this,RecyclerView.HORIZONTAL)
            }
        }
        return true
    }
    override fun onMenuOpened(featureId: Int, menu: Menu?): Boolean {
        return super.onMenuOpened(featureId, menu)
    }

}
