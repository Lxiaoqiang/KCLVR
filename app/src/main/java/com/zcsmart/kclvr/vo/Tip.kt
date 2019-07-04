package com.zcsmart.kclvr.vo

/**
 * @Date 2019/7/4 16:29
 * @auth lihuiqiang
 * @discription
 *
 */
data class Tip(val message: String) : Action{

    companion object{
        fun createTip(message: String) = Tip(message)
    }
}