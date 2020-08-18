package com.tiger.zwy.http



/**
 * HttpBaseCallBack
 *
 * @author:zhoululu
 * @date:2019-12-31
 */
open class HttpBaseCallBack<T>:HttpCallback<T> {

    override fun onResponse(resp: T) {

    }

    override fun onFailure(errorCode: String, errorMsg: String) {

    }
}