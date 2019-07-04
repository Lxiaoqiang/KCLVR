package com.zcsmart.kclvr

/**
 * @Date 2019/6/28 17:27
 * @auth lihuiqiang
 * @discription
 *
 */

fun <T> ArrayList<T>.arrayListOfNulls(size: Int): ArrayList<T>{
    var result = arrayListOf<T>()
    for (i in 0 until  size){
        result.add(null as T)
    }
    return result
}