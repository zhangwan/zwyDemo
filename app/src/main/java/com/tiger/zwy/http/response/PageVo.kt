package com.tiger.zwy.http.response

/**
 * Created By zwy
 * On 2020/6/5
 */
open class PageVo<T> {
    var datas: ArrayList<T>? = null //列表

    var page: Int? = null// 当前页数

    var size: Int? = null//  每页条数

    var total: Long? = null// 总数

    fun isHaveModeData(): Boolean {
        if (datas.isNullOrEmpty()) {
            return false
        }
        if (datas!!.size < 10) {
            return false
        }
        return true
    }
}