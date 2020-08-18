package com.tiger.zwy.java

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.log

/**
 * @author zwy
 * create at 2020/7/1 0001
 * description:
 */
suspend fun main() {
    GlobalScope.launch(MyContinuationInterceptor()) {
        print("1")
        val job = async {
            print("2")
            delay(1000)
            print("3")
            "Hello"
        }
        print("4")
        val result = job.await()
        print("5. $result")
    }.join()
    print("6")
}
