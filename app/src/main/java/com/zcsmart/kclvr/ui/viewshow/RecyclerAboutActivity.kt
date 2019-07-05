package com.zcsmart.kclvr.ui.viewshow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zcsmart.kclvr.R
import kotlinx.android.synthetic.main.activity_recycler_about.*

class RecyclerAboutActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_about)

        btnPagerRecyclerView.setOnClickListener{
            var intent = Intent(RecyclerAboutActivity@this,ViewpagerActivity::class.java)
            startActivity(intent)
        }
        btnLoopRecyclerView.setOnClickListener {
            var intent = Intent(RecyclerAboutActivity@this,LoopRecyclerViewActivity::class.java)
            startActivity(intent)
        }
        btnBannerView.setOnClickListener{
            var intent = Intent(RecyclerAboutActivity@this,BannerActivity::class.java)
            startActivity(intent)
        }
    }


}
