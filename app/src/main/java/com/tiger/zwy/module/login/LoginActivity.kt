package com.tiger.zwy.module.login

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import com.tiger.zwy.MainActivity
import com.tiger.zwy.R
import com.tiger.zwy.base.BaseActivity
import kotlinx.android.synthetic.main.login_fragment_login.*


/*
 * @author zwy
 * create at 2020/6/4 0004
 * description:
 */
class LoginActivity : BaseActivity<LoginPresenter>(), LoginView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_fragment_login)
        initListener()

    }

    private fun initListener() {
        tv_get_code.setOnClickListener {
            var edtPhone = et_phone.text.toString().trim()
            basePresenter?.sendMsg(edtPhone)
        }
        btn_login.setOnClickListener {
            var edtPhone = et_phone.text.toString().trim()
            var edtCode = et_code.text.toString().trim()
            basePresenter?.loginByCode(edtPhone, edtCode)
        }
    }

    override fun setVerificationCode(bitmap: Bitmap) {

    }

    override fun startCountDown() {

    }

    override fun finishActivity() {
        startActivity(Intent(this,MainActivity::class.java))
        this.finish()
    }


}