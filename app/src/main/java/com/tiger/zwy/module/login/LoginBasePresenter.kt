package com.tiger.zwy.module.login



import com.tiger.zwy.base.BasePresenter
import com.tiger.zwy.base.MyApplication
import com.tiger.zwy.bean.LoginResp
import com.tiger.zwy.http.HttpConstants
import com.tiger.zwy.http.HttpLoadingCallback
import com.tiger.zwy.http.HttpRequestUtil
import com.tiger.zwy.http.response.StringResp

open class LoginBasePresenter: BasePresenter<LoginView>(){
    var imgKey: String? = null
    fun sendMsg(phone:String){
        val hashMap =mapOf("phone" to phone)
        HttpRequestUtil.onPost(HttpConstants.Auth.MSG_CODE,hashMap,object : HttpLoadingCallback<StringResp>(){
            override fun onResponse(any: StringResp) {
                super.onResponse(any)
                MyApplication.instance.showToast("发送成功")
            }

            override fun onFailure(errorCode: String, errorMsg: String) {
                super.onFailure(errorCode, errorMsg)
            }
        })
    }

    fun getImageCode() {
//        HttpRequestUtil.onGet(HttpConstants.Auth.VERIFY_CODE, object : HttpLoadingCallback<VerifyCodeResp>() {
//            override fun onResponse(any:VerifyCodeResp) {
//                super.onResponse(any)
//                imgKey = any?.data?.imgKey
//                val base64decodedBytes = Base64.decode(any?.data?.imgCode, Base64.DEFAULT)
//                base64decodedBytes?.let {
//                    var bitmap =
//                        BitmapFactory.decodeByteArray(base64decodedBytes, 0, base64decodedBytes.size)
//                    mvpView?.setVerificationCode(bitmap)
//                }
//            }
//        })
    }

    //useType（用途类型: 1-注册；2-登录；3-找回密码）
    fun getMsgCode(phone: String, imageCode: String, useType: String) {
//        if (TextUtils.isEmpty(phone)) {
//            mvpView?.showToast(R.string.register_input_phone_hint)
//            return
//        }
//        if (TextUtils.isEmpty(imageCode)) {
//            mvpView?.showToast(R.string.register_input_img_hint)
//            return
//        }
//
//        var map = mapOf("phoneCode" to "91", "phone" to phone,  "useType" to useType)
//        HttpRequestUtil.onBody(HttpConstants.Auth.MSG_CODE, map, object : HttpLoadingCallback<StringResp>() {
//            override fun onResponse(any: StringResp) {
//                super.onResponse(any)
//                mvpView?.showToast(R.string.register_code_success)
//                mvpView?.startCountDown()
//            }
//        })
    }
}