package com.tiger.zwy.http.downloadFile;

/**
 * Created By HuiT
 * On 2019/2/15
 */
public interface JsDownloadListener {
    void onStartDownload(long length);

    void onProgress(int progress);

    void onFail(String errorInfo);

    void onFinishDownload();
}
