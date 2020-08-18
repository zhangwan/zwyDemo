package com.tiger.zwy.bean

/**
 * Created by moos on 2018/4/20.
 */
class CommentBean {
    var code = 0
    var message: String? = null
    var data: Data? = null

    inner class Data {
        var total = 0
        var list: List<CommentDetailBean>? = null

    }
}