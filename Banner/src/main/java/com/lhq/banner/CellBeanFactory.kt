package com.lhq.banner

/**
 * @Date 2019/7/5 17:41
 * @auth lihuiqiang
 * @discription
 *
 */
object CellBeanFactory {

    fun create(size: Int): ArrayList<CellBean>{
        return ArrayList<CellBean>().arrayListOfNulls(size)
    }
}