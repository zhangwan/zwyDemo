package com.tiger.zwy.http

/**
 * Created by huiT on 2019/12/25.
 */
interface HttpModelListener<T> {
    fun onSuccess(baseResp: T)
    fun onError(errorCode: String, errorMsg: String)
}