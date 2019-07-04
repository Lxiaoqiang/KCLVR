package com.zcsmart.kclvr

import androidx.lifecycle.AndroidViewModel
import com.zcsmart.kclvr.model.bean.Article
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

/**
 * @Date 2019/6/27 10:22
 * @auth lihuiqiang
 * @discription
 *
 */

//Lambda表达式总是被大括号括着
//其参数(如果存在)在 -> 之前声明(参数类型可以省略)
//函数体(如果存在)在 -> 后面。
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

//    val a = test(1,2)
//    val b = test(1, num(1,2))
//    val c =  test(10) { num1: Int, num2: Int ->  num1 + num2 }
//    println("a : $a, b: $b, c: $c")


    //1.变量存储lamda
    //(类型)->返回值 = {代码块}
    var a: (x:Int,y:Int)-> Int = {x, y ->  x + y}
    //自动推导，变量 = {类型... -> 代码块}
    var a1 = {x:Int,y: Int -> x + y}

    var a3 = { println("sd")}

    request(object :CB{
        override fun getSth() {
        }
    })

    request1(1000, Runnable { })

    request2(1000) {}

    var c = with(StringBuffer()){
        append("c")
    }
    println(c)

    var d = StringBuffer().apply {
        append("d")
    }

    println(d)

    nb(10) {10}

    nb1 { runBlocking {  } }

    var module = Module()
    module.abc = 10
    println(module.abc)
}


fun tesv(block: Module.() ->Unit){

}

var Module.abc: Int
    get (){

        return 1
    }
    set(value) {
        value
    }

class Module{

}
fun nb1(call: suspend CoroutineScope.() -> Unit){

}

fun nb(a:Int,b:(x:Int) -> Int){
    var c = a + b.invoke(a)
    println(c)
}

fun request2(delay: Int, b:(runnable: Runnable) -> Unit){

}

fun request1(delay: Int,runnable: Runnable){

}
fun request(cb: CB){

}

interface CB{
    fun getSth()
}

//参数名：（参数类型...) -> 表达式返回值类型
fun lamFun(a: Int,b: (x: Int) -> Int): Int{
    return a + b.invoke(5)
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