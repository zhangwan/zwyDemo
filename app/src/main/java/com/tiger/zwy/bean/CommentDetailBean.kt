package com.tiger.zwy.bean


/**
 * @author zwy
 * create at 2020/7/2 0002
 * description:
 */
class CommentDetailBean(nickName: String?, content: String?, createDate: String?) {
     var id = 0
     var nickName=nickName
     var userLogo: String? = null
     var content=content
     var imgId: String? = null
     var replyTotal = 0
     var createDate=createDate
     var replyList: ArrayList<ReplyDetailBean>? = null



}