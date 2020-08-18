package com.tiger.zwy.module.download;

public interface DownloadManagerListener {
    void onPrepare();
    void onSuccess(String path);
    void onFailed(Throwable throwable);
}
