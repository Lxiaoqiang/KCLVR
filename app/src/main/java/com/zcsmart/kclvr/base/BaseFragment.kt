package com.zcsmart.kclvr.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.zcsmart.kclvr.vo.LoadingManager

/**
 * @Date 2019/7/3 17:14
 * @auth lihuiqiang
 * @discription
 *
 */
abstract class BaseFragment<VM: BaseViewModel> :Fragment(){

    protected lateinit var mViewModel: VM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutResId(),container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        initVM()

        super.onViewCreated(view, savedInstanceState)
    }

    private fun initVM(){
        providerVMClass()?.let { it ->
            mViewModel = ViewModelProviders.of(this).get(it)
        }
    }

    open fun providerVMClass(): Class<VM>? = null

    abstract fun initView():Unit

    abstract fun layoutResId():Int



    //-----------------------------------------view operator----------------------------------------------

    protected fun showLoadingDialog(){
        LoadingManager.showLoading(context)
    }

    protected fun dismissLoadingDialog(){
        LoadingManager.dismiss()
    }
}