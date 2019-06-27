package com.zcsmart.kclvr

import kotlinx.coroutines.*
import org.junit.Test
import kotlin.concurrent.thread

/**
 * @Date 2019/6/26 16:25
 * @auth lihuiqiang
 * @discription
 *
 */

fun main() {
    runBlocking {
        val job = launch {
            repeat(1000){
                println("the count : $it")
                delay(500L)
            }
        }
        delay(1300L)
        println("main: I'm tired of waiting!")
        job.cancel()
        job.join()
        println("main: Now I can quit.")

        var inc = async {
            delay(1000L)
            return@async 133
        }
        println("inc : ${inc.await()}")
    }


}

suspend fun doWorld(){
    delay(2000L)
    println("world")
}
