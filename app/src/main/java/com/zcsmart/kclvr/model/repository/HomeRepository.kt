package com.zcsmart.kclvr.model.repository

import com.zcsmart.kclvr.model.bean.ArticleList
import com.zcsmart.kclvr.model.bean.BannerBean
import com.zcsmart.kclvr.model.bean.WanandroidBaseResponse
import com.zcsmart.kclvr.model.http.RetrofitClient

/**
 * @Date 2019/6/26 18:19
 * @auth lihuiqiang
 * @discription
 *
 */
class HomeRepository :BaseRepository(){

    suspend fun getBanner(): WanandroidBaseResponse<List<BannerBean>>{
        return apiCall { RetrofitClient.service.getBanner() }
    }

    suspend fun getArticles(page: Int): WanandroidBaseResponse<ArticleList>{
        return apiCall{ RetrofitClient.service.getHomeArticles(page)}
    }
}