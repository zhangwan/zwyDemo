package com.tiger.zwy.java

import android.util.Log
import kotlinx.coroutines.*
import java.util.logging.Logger
import kotlin.coroutines.coroutineContext
import kotlin.math.log


/**
 * @author zwy
 * create at 2020/7/1 0001
 * description:
 */

//suspend fun main() {
//    println("1"+ coroutineContext)
//    val job = GlobalScope.launch(start = CoroutineStart.ATOMIC) {
//        println("2"+coroutineContext)
//        delay(1000)
//        println(3)
//    }
//    job.cancel()
//    println("4"+coroutineContext)
//    job.join()
//
//}

fun main()= runBlocking {
    val myJob=GlobalScope.launch {
        delay(1000)
        println("Kotlin Coroutines")
    }
//    launch {
//        delay(1000)
//        println("Kotlin Coroutines")
//    }
    println("Hello")
    myJob.join()
    Thread.sleep(500)
    println("Word")
}