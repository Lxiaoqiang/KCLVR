package com.zcsmart.kclvr.model.bean

/**
 * @Date 2019/6/26 15:56
 * @auth lihuiqiang
 * @discription
 *
 */

//"desc":"一起来做个App吧",
//"id":10,
//"imagePath":"https://www.wanandroid.com/blogimgs/50c115c2-cf6c-4802-aa7b-a4334de444cd.png",
//"isVisible":1,
//"order":2,
//"title":"一起来做个App吧",
//"type":0,
//"url":"http://www.wanandroid.com/blog/show/2"
data class BannerBean(val desc: String,
                      val id: Int,
                      val imagePath: String,
                      val isVisible: Int,
                      val order: Int,
                      val title: String,
                      val type: Int,
                      val url: String){


    override fun toString(): String {
        return "desc: $desc, id:$id, imagePath:$imagePath,isVisible: $isVisible, order: $order, title: $title,type: $type, url: $url"
    }
}