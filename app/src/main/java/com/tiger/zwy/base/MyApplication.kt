package com.tiger.zwy.base

import android.app.Activity
import android.app.Application
import android.widget.Toast
import com.liulishuo.filedownloader.FileDownloader
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard

/*
 * @author zwy
 * create at 2020/5/21 0021
 * description:
 */
class MyApplication :Application(){
    var VideoPlaying: JCVideoPlayerStandard? = null
    var activity: Activity? = null
    companion object {
        lateinit var instance: MyApplication
    }
    override fun onCreate() {
        super.onCreate()
        instance=this
        //Hawk存储初始化
        //不耗时，做一些简单初始化准备工作，不会启动下载进程
        FileDownloader.init(this,null,2)
    }
    fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}