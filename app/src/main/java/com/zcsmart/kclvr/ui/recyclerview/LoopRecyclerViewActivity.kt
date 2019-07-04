package com.zcsmart.kclvr.ui.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.zcsmart.kclvr.R
import com.zcsmart.kclvr.arrayListOfNulls
import com.zcsmart.kclvr.view.LoopHorizontallyLayoutManager
import kotlinx.android.synthetic.main.activity_loop_recycler_view.*

class LoopRecyclerViewActivity : AppCompatActivity() {

    private lateinit var mAdapter: LoopAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loop_recycler_view)

        mAdapter = LoopAdapter()
        mAdapter.run {
            var datas = ArrayList<String>().arrayListOfNulls(10)
            addData(datas)
        }
        recyclerLoop.run {
            var lm = LoopHorizontallyLayoutManager()
            layoutManager = lm
            adapter = mAdapter
        }
    }


    inner class LoopAdapter(resId: Int = R.layout.item_looprv_layout): BaseQuickAdapter<String,BaseViewHolder>(resId){
        override fun convert(helper: BaseViewHolder?, item: String?) {
            helper?.setBackgroundColor(R.id.tvItemText,if(helper.position % 2 == 0)  resources.getColor(R.color.colorAccent) else resources.getColor(R.color.colorPrimary))
                ?.setText(R.id.tvItemText,"_${helper?.layoutPosition}")
        }

    }
}
