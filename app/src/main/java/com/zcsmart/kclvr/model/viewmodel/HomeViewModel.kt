package com.zcsmart.kclvr.model.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zcsmart.kclvr.base.BaseViewModel
import com.zcsmart.kclvr.model.bean.ArticleList
import com.zcsmart.kclvr.model.bean.BannerBean
import com.zcsmart.kclvr.model.bean.WanandroidBaseResponse
import com.zcsmart.kclvr.model.repository.HomeRepository
import com.zcsmart.kclvr.vo.Loadingve
import com.zcsmart.kclvr.vo.Tip
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * @Date 2019/6/27 11:43
 * @auth lihuiqiang
 * @discription
 *
 */
class HomeViewModel : BaseViewModel() {

    private val banners = MutableLiveData<List<BannerBean>>()

    private val articleList = MutableLiveData<ArticleList>()

    private val repository by lazy { HomeRepository() }

    fun banners(): MutableLiveData<List<BannerBean>> {
        return banners
    }

    fun articleList() = articleList

    fun getBanners() {
        launch {
            var result = withContext(Dispatchers.IO) { repository.getBanner() }
        }
    }

    fun getArticles(refresh: Boolean, page: Int) {
        getMLoading().value = Loadingve.run { if (refresh) createLoadingRefreshShow() else createLoadingLoadMoreShow() }
        launch {
            var result = withContext(Dispatchers.IO) { repository.getArticles(page) }
            excuteResponse(result, {
                articleList.value = result.data
                getMLoading().value = Loadingve.createLoadingHide()
            }, {
                getMTip().value = Tip.createTip(result.errorMsg)
                getMLoading().value = Loadingve.createLoadingHide()
            })
        }
    }


}