package com.tiger.zwy.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.tiger.zwy.utils.ToastUtils

abstract class BaseFragment : Fragment() {
    protected var context:FragmentActivity?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context=activity
        initView()
    }


    /**
     * 加载布局
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    /**
     * 初始化 View
     */
    abstract fun initView()


    /**
     * 加载数据,需要页面做处理
     */
    abstract fun start()


    protected fun showToast(content: String) {
        ToastUtils.toshort(activity, content)
    }
}