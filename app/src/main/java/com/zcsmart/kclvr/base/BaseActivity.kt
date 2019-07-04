package com.zcsmart.kclvr.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import com.zcsmart.kclvr.vo.LoadingManager

/**
 * @Date 2019/7/4 17:18
 * @auth lihuiqiang
 * @discription
 *
 */
abstract class BaseActivity<VM: BaseViewModel> : AppCompatActivity(){

    private lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId())
        initViewModel()
    }

    abstract fun layoutResId(): Int

    private fun initViewModel(){
        providerVM()?.let {
            ViewModelProviders.of(this).get(it)
        }
    }

    open fun providerVM(): Class<VM>? = null

    protected fun showLoadingDialog(){
        LoadingManager.showLoading(this)
    }

    protected fun dismissLoadingDialog(){
        LoadingManager.dismiss()
    }
}