package com.tiger.zwy.module;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tiger.zwy.R;
import com.tiger.zwy.adapter.ImageAdapter;
import com.tiger.zwy.bean.DataBean;
import com.youth.banner.Banner;
import com.youth.banner.config.BannerConfig;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.indicator.RectangleIndicator;
import com.youth.banner.transformer.ScaleInTransformer;
import com.youth.banner.util.BannerUtils;

import java.util.ArrayList;
import java.util.List;

public class TestBannerActivity extends AppCompatActivity {
    Banner banner;
    List<DataBean> mData=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_banner);
        banner=findViewById(R.id.banner);
        for(int i=0;i<5;i++){
            mData.add(new DataBean("https://cdn.tinytiger.cn/FjcNo0pC8jjLp4tx1196yYiy_45f"));
        }
        useBanner();

    }
    public void useBanner() {
        //--------------------------简单使用-------------------------------
        banner.addBannerLifecycleObserver(this)//添加生命周期观察者
                .setAdapter(new ImageAdapter(this,mData))
                .setIndicator(new CircleIndicator(this));
        banner.setIndicator(new RectangleIndicator(this));
        banner.setIndicator(new CircleIndicator(this));
        banner.setIndicatorGravity(IndicatorConfig.Direction.CENTER);
        banner.setIndicatorMargins(new IndicatorConfig.Margins(0, 0,
                BannerConfig.INDICATOR_MARGIN, (int) BannerUtils.dp2px(12)));
        banner.setPageTransformer(new ScaleInTransformer());


    }
}
