package com.tiger.zwy.http

/**
 * Created by huiT on 2019/12/25.
 */
class RetrofitManager {
    val api = RetrofitBuilder()
            .initTimeOut(HttpConstants.TIME_OUT)
            .initBaseUrl(HttpConstants.URL_BASE)
            .build(Api::class.java)

    private object RetrofitHolder {
        val holder = RetrofitManager()
    }

    companion object {
        val retrofitInstance = RetrofitHolder.holder
    }
}