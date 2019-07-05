package com.zcsmart.kclvr.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.zcsmart.kclvr.R
import com.zcsmart.kclvr.adapter.HomeArticleAdapter
import com.zcsmart.kclvr.base.BaseFragment
import com.zcsmart.kclvr.model.viewmodel.HomeViewModel
import com.zcsmart.kclvr.util.CustomToast
import com.zcsmart.kclvr.view.SpaceItemDecoration
import com.zcsmart.kclvr.vo.Loadingve
import kotlinx.android.synthetic.main.fragment_home.*

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class HomeFragment : BaseFragment<HomeViewModel>() {

    private val mAdapter by lazy { HomeArticleAdapter() }

    private var currentPage = 0

    override fun layoutResId() = R.layout.fragment_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initAdapter()
        initData()
    }

    override fun initView() {
        recyclerHomeF.run {
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(SpaceItemDecoration(20))
            adapter = mAdapter
        }
        swipeRefreshHome.run {
            setOnRefreshListener {
                currentPage = 0
                mViewModel.getArticles(true,currentPage)
            }
        }
    }

    private fun initAdapter() {
        mAdapter.run {
            setOnItemClickListener { adapter, view, position ->

            }
            setOnLoadMoreListener({
                mViewModel.getArticles(false,currentPage)

            }, recyclerHomeF)
        }
    }

    private fun initData() {
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        mViewModel.run {
            getArticles(true,currentPage)
            articleList().observe(this@HomeFragment, Observer {
                mAdapter.run {
                    if (swipeRefreshHome.isRefreshing) {
                        replaceData(it.datas)
                    } else {
                        addData(it.datas)
                        loadMoreEnd()
                    }
                }
                currentPage++
            })

            getMTip().observe(this@HomeFragment, Observer {
                CustomToast.toast(context!!,it.message)
            })

            getMLoading().observe(this@HomeFragment, Observer {
                when(it.MS){
                    Loadingve.REFRESH_SHOW ->{
                        swipeRefreshHome.isRefreshing = true
                    }
                    Loadingve.HIDE ->{
                        swipeRefreshHome.isRefreshing = false
                        mAdapter.loadMoreComplete()
                    }
                }
            })
        }

    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
