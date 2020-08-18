package com.tiger.zwy.base

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import java.lang.reflect.ParameterizedType

/**
 * BaseActivity
 *
 * @author:zhoululu
 * @date:2019/12/23
 */
 abstract class BaseActivity<T : BasePresenter<*>> :AppCompatActivity(),BaseView {

    var basePresenter: T? = null

    override fun onDestroy() {
        super.onDestroy()

        if (basePresenter != null) {
            basePresenter?.detachView()
        }
    }

    private fun getEntry(): Class<T>? {
        val type = javaClass.genericSuperclass
        var result: Class<T>? = null
        if (type is ParameterizedType) {
            result = type.actualTypeArguments[0] as Class<T>
        }
        return result
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
    }

    private fun initPresenter() {
        var presenterClass = getEntry()
        basePresenter = presenterClass?.newInstance()
        basePresenter?.attachView(this)
    }

    override fun refresh() {

    }



    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showToast(msg: Int) {
        showToast(getString(msg))
    }

    override fun showError(errorView: View?) {

    }

    override fun showEmpty(emptyView: View?) {

    }

    override fun hideEmpty() {

    }

    override fun hideError() {

    }


    override fun getMyContext(): Context {
        return this
    }


}