package com.zcsmart.kclvr.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.zcsmart.kclvr.R
import com.zcsmart.kclvr.adapter.HomeArticleAdapter
import com.zcsmart.kclvr.model.viewmodel.HomeViewModel
import com.zcsmart.kclvr.view.SpaceItemDecoration
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
class HomeFragment : Fragment() {


    private val mAdapter by lazy { HomeArticleAdapter() }

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initAdapter()
        initData()
    }

    private fun initView() {
        recyclerHomeF.run {
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(SpaceItemDecoration(20))
        }
    }

    private fun initAdapter() {
        recyclerHomeF.run {
            adapter = mAdapter
        }
        mAdapter.run {
            setOnItemClickListener { adapter, view, position ->

            }
        }

    }

    private fun initData() {
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel.getArticles(0)
        viewModel.articleList().observe(this, Observer {
            mAdapter.addData(it.datas)
        })
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
