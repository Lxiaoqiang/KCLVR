package com.zcsmart.kclvr.vo

/**
 * @Date 2019/7/4 16:38
 * @auth lihuiqiang
 * @discription
 *
 */
data class Loadingve(val MS: LoadingMS): Action {

    companion object{
       val REFRESH_SHOW = LoadingMS.REFRESH_SHOW
       val HIDE = LoadingMS.HIDE
       val LOAD_MORE_SHOW = LoadingMS.LOAD_MORE_SHOW
       val DIALOG_SHOW = LoadingMS.DIALOG_SHOW

        fun createLoadingRefreshShow() = Loadingve(LoadingMS.REFRESH_SHOW)
        fun createLoadingHide() = Loadingve(LoadingMS.HIDE)
        fun createLoadingLoadMoreShow() = Loadingve(LoadingMS.LOAD_MORE_SHOW)
        fun createLoadingDialogShow() = Loadingve(LoadingMS.DIALOG_SHOW)
    }
}