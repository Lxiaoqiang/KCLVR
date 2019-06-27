package com.zcsmart.kclvr.adapter

import android.text.Html
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.zcsmart.kclvr.R
import com.zcsmart.kclvr.model.bean.Article

/**
 * @Date 2019/6/27 17:17
 * @auth lihuiqiang
 * @discription
 *
 */
class HomeArticleAdapter(layoutResId: Int = R.layout.item_home_article_layout): BaseQuickAdapter<Article,BaseViewHolder>(layoutResId) {
    override fun convert(helper: BaseViewHolder, item: Article) {
        helper.setText(R.id.articleTitle, Html.fromHtml(item.title))
            .setText(R.id.articleAuthor, item.author)
            .setText(R.id.articleTag, "${item.superChapterName ?: ""} ${item.chapterName}")
            .setText(R.id.articleTime, item.niceDate)
            .addOnClickListener(R.id.articleStar)
    }
}