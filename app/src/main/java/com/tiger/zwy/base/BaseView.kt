package com.tiger.zwy.base

import android.content.Context
import android.view.View

/**
 * BaseView
 *
 * @author:zhoululu
 * @date:2019/12/23
 */
interface BaseView {

    fun refresh()

    fun showLoading()

    fun hideLoading()

    fun showToast(msg: String)

    fun showToast(msg: Int)

    fun showError(errorView: View?)

    fun showEmpty(emptyView: View?)

    fun hideEmpty()

    fun hideError()

    fun getMyContext(): Context
}