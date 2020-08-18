package com.tiger.zwy.module.download.page;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtil {
   private OkHttpClient mOKHttpClient;
   private final static long CONNECT_TIMEOUT = 60;//超时时间，秒
    private final static long READ_TIMEOUT = 60;//读取时间，秒
    private final static long WRITE_TIMEOUT = 60;//写入时间，秒

    public void downloadFileByRange(String url, long startIndex, long endIndex, Callback callback)throws IOException {
          //创建一个Request
          //设置分段下载的头信息，range:做分段数据请求，断点续传指示下载的区间。格式: Range bytes=0-1024或者bytes:0-1024
        Request.Builder builder = new Request.Builder();
//        builder.head("RANGE", "bytes=" + startIndex + "-" + endIndex);
        builder.url(url);
        Request request= builder
                .build();
    }
}
