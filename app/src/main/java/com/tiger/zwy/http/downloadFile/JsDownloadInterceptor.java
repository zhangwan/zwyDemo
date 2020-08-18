package com.tiger.zwy.http.downloadFile;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;


/**
 * Created By HuiT
 * On 2019/2/15
 */
public class JsDownloadInterceptor implements Interceptor {
    private JsDownloadListener downloadListener;

    public JsDownloadInterceptor(JsDownloadListener downloadListener) {
        this.downloadListener = downloadListener;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        return response.newBuilder().body(new JsResponseBody(response.body(), downloadListener)).build();
    }
}
