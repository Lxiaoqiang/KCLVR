package com.zcsmart.kclvr.model.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zcsmart.kclvr.model.bean.ArticleList
import com.zcsmart.kclvr.model.bean.BannerBean
import com.zcsmart.kclvr.model.bean.WanandroidBaseResponse
import com.zcsmart.kclvr.model.repository.HomeRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @Date 2019/6/27 11:43
 * @auth lihuiqiang
 * @discription
 *
 */
class HomeViewModel() : ViewModel(){

    private val banners = MutableLiveData<List<BannerBean>>()

    private val articleList = MutableLiveData<ArticleList>()

    private val repository by lazy { HomeRepository() }

    fun banners():MutableLiveData<List<BannerBean>>{
        return banners
    }

    fun articleList() = articleList

    fun getBanners(){
        viewModelScope.launch {
            banners.value = repository.getBanner().data
        }
    }

    fun getArticles(page: Int){
        viewModelScope.launch {
            articleList.value = repository.getArticles(page).data
        }
    }


}