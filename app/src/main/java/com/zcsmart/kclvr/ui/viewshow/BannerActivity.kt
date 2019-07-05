package com.zcsmart.kclvr.ui.viewshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lhq.banner.DefaultIndicatorItem
import com.zcsmart.kclvr.R
import kotlinx.android.synthetic.main.activity_banner.*



class BannerActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banner)
        indicatorView.iIndicatorItem = DefaultIndicatorItem(5,20.toFloat(), arrayOf(R.color.colorAccent,
            R.color.colorPrimary))


    }
}
