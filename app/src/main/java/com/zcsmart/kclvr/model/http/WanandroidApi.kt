package com.zcsmart.kclvr.model.http

import com.zcsmart.kclvr.model.bean.ArticleList
import com.zcsmart.kclvr.model.bean.BannerBean
import com.zcsmart.kclvr.model.bean.WanandroidBaseResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @Date 2019/6/26 15:54
 * @auth lihuiqiang
 * @discription
 *
 */
interface WanandroidApi {


    companion object{
        const val BASE_URL = "https://www.wanandroid.com"
    }


    @GET("/banner/json")
    suspend fun getBanner(): WanandroidBaseResponse<List<BannerBean>>



    @GET("/article/list/{page}/json")
    suspend fun getHomeArticles(@Path("page") page: Int): WanandroidBaseResponse<ArticleList>
}