package com.tiger.zwy.module.download.filedowanload

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.liulishuo.filedownloader.BaseDownloadTask
import com.tiger.zwy.R
import kotlinx.android.synthetic.main.activity_file_download.*

class FileDownloadActivity :AppCompatActivity(){
    var wechatUrl = "http://dldir1.qq.com/weixin/android/weixin703android1400.apk"
    var savePath=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_download)
        tv_download.setOnClickListener {
            FileDownloadUtils.getInstance().startDownLoadFileSingle(wechatUrl,savePath,object :FileDownloadUtils.FileDownLoaderCallBack{
                override fun downLoadError(task: BaseDownloadTask?, e: Throwable?) {
                    tv_status.text="错误"
                }

                override fun downLoadProgress(task: BaseDownloadTask?, soFarBytes: Int, totalBytes: Int) {
                    tv_status.text="soFarBytes:"+soFarBytes+"totalBytes:"+totalBytes
                }

                override fun downLoadCompleted(task: BaseDownloadTask?) {
                    tv_status.text="完成"
                }

            })
        }
    }
}