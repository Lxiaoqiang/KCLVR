package com.zcsmart.kclvr.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.zcsmart.kclvr.R
import com.zcsmart.kclvr.model.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() ,NavigationView.OnNavigationItemSelectedListener{

    private val TAG = "HomeActivity"

    private val mTitles = arrayOf("首页","最新项目","体系","导航","效果")

    private var fragments = arrayListOf<Fragment>()


    init {
        fragments.add(HomeFragment.newInstance())
        fragments.add(ProjectFragment.newInstance())
        fragments.add(SystemFragment.newInstance())
        fragments.add(NavigationFragment.newInstance())
        fragments.add(AnimaDemoFragment.newInstance())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initViewPager()
        initTabLayout()
    }

    private fun initViewPager(){
        viewpagerHome.run {
            adapter = object : FragmentPagerAdapter(supportFragmentManager) {
                override fun getItem(position: Int): Fragment {
                    return fragments[position]
                }

                override fun getCount(): Int {
                    return mTitles.size
                }

                override fun getPageTitle(position: Int): CharSequence? {
                    return mTitles[position]
                }
            }
        }
    }

    private fun initTabLayout(){
        tablayoutHome.run {
            tabMode = TabLayout.MODE_FIXED
            setupWithViewPager(viewpagerHome)
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        return false
    }


}
