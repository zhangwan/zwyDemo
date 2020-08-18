package com.tiger.zwy.http

import com.alibaba.fastjson.JSON
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


/**
 * Created by huiT on 2019/12/25.
 */
interface HttpCallback<T> {
    fun onStart() {

    }

    fun onResponse(any: T)
    fun onFailure(errorCode: String, errorMsg: String)

    fun getEntry(): Type? {
        val type = javaClass.genericSuperclass
        var result: Type? = null
        if (type is ParameterizedType) {
            result = type.actualTypeArguments[0]
        }
        return result
    }
}