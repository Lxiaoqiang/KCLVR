package com.zcsmart.kclvr.model.repository

import com.zcsmart.kclvr.model.bean.WanandroidBaseResponse

/**
 * @Date 2019/6/26 18:23
 * @auth lihuiqiang
 * @discription
 *
 */
open class BaseRepository {

    suspend fun <T> apiCall(call: suspend () -> WanandroidBaseResponse<T>): WanandroidBaseResponse<T> {
        return call.invoke()
    }

}