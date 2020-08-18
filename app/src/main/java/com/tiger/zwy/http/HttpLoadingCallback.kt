package com.tiger.zwy.http




/**
 * Created by huiT on 2019/12/25.
 */
abstract class HttpLoadingCallback<T> : HttpCallback<T> {
    override fun onStart() {
        super.onStart()
//        LoadingUtil.showLoading()
    }

    override fun onFailure(errorCode: String, errorMsg: String) {
//        LoadingUtil.dismissLoading()

    }

    override fun onResponse(any: T) {
//        LoadingUtil.dismissLoading()
    }
}