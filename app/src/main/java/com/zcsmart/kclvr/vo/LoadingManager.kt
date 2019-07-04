package com.zcsmart.kclvr.vo

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.zcsmart.kclvr.R

/**
 * @Date 2019/7/4 16:45
 * @auth lihuiqiang
 * @discription
 * 加载框
 */
object LoadingManager {

    lateinit var dialog: AlertDialog

    fun showLoading(context: Context?){
        context?.let {
            var builder = AlertDialog.Builder(context)
            builder.setView(R.layout.loading_layout)
            dialog = builder.create()
            dialog.show()
        }
    }

    fun dismiss(){
        dialog?.run {
            if (isShowing){
                dismiss()
            }
        }
    }
}