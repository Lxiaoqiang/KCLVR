package com.zcsmart.kclvr.util

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.text.TextUtils
import android.widget.Toast

/**
 * @Date 2019/7/4 11:25
 * @auth lihuiqiang
 * @discription
 *
 */
object CustomToast {

    private val mHandler = Handler()

    private var mToast: Toast? = null

    private val r = Runnable {
        mToast?.cancel()
    }

    fun toast(context: Context, message: String) {
        if (TextUtils.isEmpty(message)) return
        mHandler.removeCallbacks(r)
        if (mToast != null) {
            mToast?.setText(message)
        } else {
            mToast = Toast.makeText(context, message, Toast.LENGTH_LONG)
        }
        mHandler.postDelayed(r, 2000)
        mToast?.show()
    }
}