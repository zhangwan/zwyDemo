package com.tiger.zwy.java

import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext
import kotlin.math.log

/**
 * @author zwy
 * create at 2020/7/1 0001
 * description:
 */
class MyContinuationInterceptor:ContinuationInterceptor{
    override val key = ContinuationInterceptor
    override fun <T> interceptContinuation(continuation: Continuation<T>) = MyContinuation(continuation)

}

class MyContinuation<T>(val continuation: Continuation<T>): Continuation<T> {
    override val context = continuation.context
    override fun resumeWith(result: Result<T>) {
        print("<MyContinuation> $result" )
        continuation.resumeWith(result)
    }
}
