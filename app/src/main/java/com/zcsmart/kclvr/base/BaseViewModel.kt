package com.zcsmart.kclvr.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zcsmart.kclvr.ActionLiveData
import com.zcsmart.kclvr.model.bean.WanandroidBaseResponse
import com.zcsmart.kclvr.vo.Action
import com.zcsmart.kclvr.vo.Loadingve
import com.zcsmart.kclvr.vo.Tip
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * @Date 2019/7/3 13:52
 * @auth lihuiqiang
 * @discription
 *
 */
open class BaseViewModel: ViewModel() {

    private val mLoading = ActionLiveData<Loadingve>()

    private val mTip = ActionLiveData<Tip>()

    fun getMLoading() = mLoading

    fun getMTip() = mTip

    fun launch(block: suspend CoroutineScope.() -> Unit) {
        launchOnUI{
            tryCatch(block,{
                when (it) {
                    is HttpException -> {
                        mTip.value = Tip("网络异常，请稍后再试")
                    }
                    is UnknownHostException -> {
                        mTip.value = Tip("请检查您的网络连接")
                    }
                    is SocketException -> {
                        mTip.value = Tip("网络异常")
                    }
                    is SocketTimeoutException -> {
                        mTip.value = Tip("请求超时")
                    }
                    is ConnectException -> {
                        mTip.value = Tip("连接超时，请稍后再试")
                    }
                }
                getMLoading().value = Loadingve.createLoadingHide()
            },{},true)
        }
    }

    private fun launchOnUI(block: suspend CoroutineScope.() -> Unit){
        viewModelScope.launch { block() }
    }


    suspend fun excuteResponse(response: WanandroidBaseResponse<Any>,successBlock:suspend CoroutineScope.() -> Unit,
                       errorBlock:suspend CoroutineScope.() -> Unit){
        coroutineScope {
            if (response.errorCode == -1) errorBlock() else successBlock()
        }
    }

    private suspend fun tryCatch(
        tryBlock: suspend CoroutineScope.() -> Unit,
        catchBlock: suspend CoroutineScope.(Throwable) -> Unit,
        finallyBlock: suspend CoroutineScope.() -> Unit,
        handleCancellationExceptionManually: Boolean = false) {
        coroutineScope {
            try {
                tryBlock()
            } catch (e: Exception) {
                if (e !is CancellationException || handleCancellationExceptionManually) {
                    catchBlock(e)
                } else {
                    throw e
                }
            } finally {
                finallyBlock()
            }
        }
    }

}