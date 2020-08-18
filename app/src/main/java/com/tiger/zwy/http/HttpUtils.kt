package com.tiger.zwy.http

import android.annotation.SuppressLint
import android.util.Log
import com.alibaba.fastjson.JSON
import com.tiger.zwy.http.downloadFile.JsDownloadInterceptor
import com.tiger.zwy.http.downloadFile.JsDownloadListener
import com.tiger.zwy.http.response.BaseResp
import com.tiger.zwy.utils.FileUtil
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import java.io.File
import java.io.InputStream

/**
 * Created by huiT on 2019/12/25.
 */
object HttpUtils {
    val CONNECT_TIMEOUT = "CONNECT_TIMEOUT"
    val READ_TIMEOUT = "READ_TIMEOUT"
    val WRITE_TIMEOUT = "WRITE_TIMEOUT"
    fun <T> handleFailure(errorCode: String, errorMsg: String, listener: HttpCallback<T>) {
        if (errorCode == HttpConstants.Code.LOGOUT || errorCode == HttpConstants.Code.CUSTOMIZE_CODE_401) {
//            UserUtils.removeCache()
//            IntentConstants.startLoginActivity(LoanApp.instance.activity!!)
            return
        }
        listener.onFailure(errorCode, errorMsg ?: "")
    }

    fun <T> handleResponse(any: T, listener: HttpCallback<T>) {
        when (any) {
            is BaseResp<*> -> {
                if (any.status == true && (any.code == HttpConstants.Code.SUCCESS || any.code == HttpConstants.Code.SUCCESS1))
                    listener.onResponse(any)
                else
                    handleFailure(any.code ?: "", any.msg ?: "", listener)
            }
            else -> listener.onResponse(any)
        }
    }

    @SuppressLint("CheckResult")
    fun <T> http(observable: Observable<ResponseBody>, callback: HttpCallback<T>): Disposable {
        var isResult = false
        callback.onStart()
        return observable
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .map {
                var content = it.string()
                return@map JSON.parseObject(content, callback.getEntry()) as T
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                isResult = true
                handleResponse(result, callback)
            }, { error ->
                error.printStackTrace()
                if (isResult) handleFailure(HttpConstants.Code.CODE_700, error.message.toString(), callback)
                else handleFailure(HttpConstants.Code.TIME_OUT, error.message.toString(), callback)
            })
    }

    @SuppressLint("CheckResult")
    fun downLoadFile(url: String, file: File, listener: JsDownloadListener): Disposable {
        val mInterceptor = JsDownloadInterceptor(listener)
        return RetrofitBuilder()
            .initTimeOut(HttpConstants.TIME_OUT)
            .initBaseUrl(HttpConstants.URL_BASE)
            .addInterceptor(mInterceptor).build(Api::class.java)
            .download(url)
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .map(fun(responseBody: ResponseBody): InputStream {
                return responseBody.byteStream()
            })
            .observeOn(Schedulers.computation()) // 用于计算任务
            .doOnNext {
                FileUtil.writeFile(it, file)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
            }, { error ->
                Log.e("error", "error==" + error.cause?.printStackTrace() + "message==" + error.message + " error==" + error)
                listener.onFail(error.message)
            }, {
                listener.onFinishDownload()
            }
            )
    }
}