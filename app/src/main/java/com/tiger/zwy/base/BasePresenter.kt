package com.tiger.zwy.base



/**
 * BasePresenter
 *
 * @author:zhoululu
 * @date:2019/12/23
 */
open class BasePresenter<V : BaseView> {

    var mvpView: V? = null

    open fun sendReq() {
    }

    fun attachView(mvpView: BaseView) {
        this.mvpView = mvpView as V
    }

    fun detachView() {
        this.mvpView = null
    }

    fun isViewAttached(): Boolean {
        return mvpView != null
    }

    fun getView(): V? {
        return mvpView
    }

    fun savePoint(map: Map<String,String>){

    }
}