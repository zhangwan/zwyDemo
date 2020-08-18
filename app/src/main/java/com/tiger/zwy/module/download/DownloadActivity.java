package com.tiger.zwy.module.download;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tiger.zwy.R;

public class DownloadActivity extends AppCompatActivity {
    private static final String TAG="DownloadActivity";
    TextView mTvShow;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_load);
        mTvShow=findViewById(R.id.tv_show);
        findViewById(R.id.tv_into).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              downLoad();
            }
        });

    }
    public void downLoad(){
        new HooDownloadManager(this,"https://qd.myapp.com/myapp/qqteam/AndroidQQ/mobileqq_android.apk")
        .setListener(new DownloadManagerListener(){

            @Override
            public void onPrepare() {
                mTvShow.setText("准备");
                Log.d(TAG,"onPrepare");
            }

            @Override
            public void onSuccess(String path) {
                mTvShow.setText("下载成功");
                Log.d(TAG,"onSuccess >>>>"+path);
            }

            @Override
            public void onFailed(Throwable throwable) {
                mTvShow.setText("下载失败");
                Log.d(TAG,"onFailed",throwable);
            }
        });
    }
}
