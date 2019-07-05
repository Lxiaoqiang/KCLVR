package com.zcsmart.kclvr.model.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @Date 2019/6/26 15:41
 * @auth lihuiqiang
 * @discription
 *
 */
object RetrofitClient {

    val service by lazy { getService(WanandroidApi.BASE_URL,WanandroidApi::class.java) }

    private const val CONNECT_TIME_OUT = 5

    private val okHttpClient: OkHttpClient
        get(){
            var loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            var builder = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(CONNECT_TIME_OUT.toLong(),TimeUnit.SECONDS)

            return builder.build()
        }

    private fun <T> getService(baseUrl: String, clz: Class<T>): T{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build().create(clz)
    }
}