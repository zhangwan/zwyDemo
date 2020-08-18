package com.tiger.zwy.module.login


import com.tiger.zwy.base.MyApplication
import com.tiger.zwy.bean.LoginResp
import com.tiger.zwy.http.HttpConstants
import com.tiger.zwy.http.HttpLoadingCallback
import com.tiger.zwy.http.HttpRequestUtil
import com.tiger.zwy.module.login.LoginBasePresenter


//import io.branch.referral.util.BranchEvent

class LoginPresenter : LoginBasePresenter() {


    fun loginByCode(phone: String, verifyCode: String) {
        val hashMap =mapOf("phone" to phone,"verification_code" to verifyCode)
        HttpRequestUtil.onPost(HttpConstants.Auth.MSG_CODE,hashMap,object : HttpLoadingCallback<LoginResp>(){
            override fun onResponse(any: LoginResp) {
                super.onResponse(any)

                mvpView?.finishActivity()
            }

            override fun onFailure(errorCode: String, errorMsg: String) {
                super.onFailure(errorCode, errorMsg)
            }
        })
    }


}