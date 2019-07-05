package com.lhq.banner

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView

/**
 * @Date 2019/7/5 11:12
 * @auth lihuiqiang
 * @discription
 *
 */
class BannerView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0): View(context,attrs,defStyleAttr) {


    val recyclerView = RecyclerView(context)

    init {

//        addView(recyclerView)
    }



    private inner class BannerAdapter : RecyclerView.Adapter<BannerAdapter.ViewHolder>(){
        override fun getItemCount(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        }
    }
}