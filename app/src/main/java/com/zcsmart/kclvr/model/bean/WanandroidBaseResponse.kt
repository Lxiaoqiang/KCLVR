package com.zcsmart.kclvr.model.bean

/**
 * @Date 2019/6/26 16:02
 * @auth lihuiqiang
 * @discription
 *
 */
data class WanandroidBaseResponse<out T>(val errorCode: Int, val errorMsg: String, val data: T)