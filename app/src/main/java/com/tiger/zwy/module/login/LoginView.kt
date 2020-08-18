package com.tiger.zwy.module.login

import android.graphics.Bitmap
import com.tiger.zwy.base.BaseView


interface LoginView : BaseView {
    fun setVerificationCode(bitmap: Bitmap)

    fun startCountDown()

    fun finishActivity()

}