package com.zcsmart.kclvr.model.bean

import java.io.Serializable

/**
 * @Date 2019/6/27 17:03
 * @auth lihuiqiang
 * @discription
 *
 */
data class ArticleList( val offset: Int,
                        val size: Int,
                        val total: Int,
                        val pageCount: Int,
                        val curPage: Int,
                        val over: Boolean,
                        val datas: List<Article>): Serializable