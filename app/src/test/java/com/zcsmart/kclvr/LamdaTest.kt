package com.zcsmart.kclvr

import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.yield

/**
 * @Date 2019/6/27 10:22
 * @auth lihuiqiang
 * @discription
 *
 */


fun main(){
//    var a = 1
//    var b = 2
//    val x = {a + b}
//    println(x) //Function0<java.lang.Integer>
//
//    val sum = {c: Int, d: Int -> c + d}
//    println(sum(1,3))
//
//    var z = {"sdfsdf"}
//    println(z)

//    var a = {x: Int, y: Int -> x + y}
//    var b : (Int, Int) -> Int = {x,y -> x + y}
//    println(b(1,3))

    val a = test(1,2)
    val b = test(1, num(1,2))
    val c =  test(10) { num1: Int, num2: Int ->  num1 + num2 }
    println("a : $a, b: $b, c: $c")


}

fun test(a : Int , b : (num1 : Int , num2 : Int) -> Int) : Int{
    return a + b.invoke(3,5)
}

fun test(x: Int, y: Int): Int{
    return x + y
}

fun num(num1: Int, num2: Int): Int{
    return num1 + num2
}

fun a(callback: Callback){
    callback.test()
}

interface Callback{
    fun test()
}